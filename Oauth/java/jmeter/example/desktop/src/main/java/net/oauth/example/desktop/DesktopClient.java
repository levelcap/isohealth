/*
 * Copyright 2009 John Kristian
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.oauth.example.desktop;

import com.centerkey.utils.BareBonesBrowserLaunch;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.client.OAuthClient;
import net.oauth.client.URLConnectionClient;
import net.oauth.http.HttpMessage;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;

/**
 * An OAuth client that obtains authorization by launching a browser, via which
 * the user can authenticate to the service provider. This is annoying, because
 * it leaves a browser window open on the user's desktop. Microsoft Internet
 * Explorer will ask "Do you want to close this window?" But it doesn't close
 * the window automatically.
 * <p>
 * The implementation involves an embedded web server (Jetty). To obtain
 * authorization, {@link access} launches a browser and directs it to the
 * service provider, which eventually redirects it back to the web server in
 * this class, which causes {@link access} to proceed with getting its OAuth
 * access token and accessing the protected resource.
 * <p>
 * If the user simply closes the browser window, {@link access} won't return.
 * Perhaps this could be handled better with some JavaScript fu to notify the
 * embedded web server. {@link access} would throw an exception in this case, I
 * imagine.
 * 
 * @author John Kristian
 */
public class DesktopClient {

    public DesktopClient(OAuthConsumer consumer) {
        accessor = new OAuthAccessor(consumer);
    }

    /**
     * In addition to containing OAuth parameters, this is used as a monitor to
     * coordinate the threads executing access and the threads in the embedded
     * web server.
     */
    private final OAuthAccessor accessor;
    private String verifier = null;
    private OAuthClient oauthClient = DEFAULT_CLIENT;

    public OAuthClient getOAuthClient() {
        return oauthClient;
    }

    public void setOAuthClient(OAuthClient client) {
        this.oauthClient = client;
    }

    /**
     * Access a protected resource.
     * 
     * @return the response from the service provider
     * @throws OAuthException
     *             the OAuth protocol didn't proceed smoothly
     */
    public OAuthMessage access(String httpMethod, String resourceURL, Collection<? extends Map.Entry> parameters)
            throws Exception {
        try {
            Server server = null;
            try {
                synchronized (accessor) {
                    List<OAuth.Parameter> callback = null;
                    while (accessor.accessToken == null) {
                        if (server == null) {
                            // Start an HTTP server:
                            final int callbackPort = getEphemeralPort();
                            server = new Server(callbackPort);
                            for (Connector c : server.getConnectors()) {
                                c.setHost("localhost"); // local clients only
                            }
                            server.setHandler(newCallback());
                            server.start();
                            // Callbacks will be directed to this server:
                            callback = OAuth.newList(OAuth.OAUTH_CALLBACK, //
                                    "http://localhost:" + callbackPort + CALLBACK_PATH);
                        }
                        OAuthMessage response = getOAuthClient().getRequestTokenResponse(accessor, null, callback);
                        String authorizationURL = OAuth.addParameters(
                                accessor.consumer.serviceProvider.userAuthorizationURL //
                                , OAuth.OAUTH_TOKEN, accessor.requestToken //
                                );
                        if (response.getParameter(OAuth.OAUTH_CALLBACK_CONFIRMED) == null) {
                            // It appears the service provider implements OAuth 1.0, not 1.0a.
                            authorizationURL = OAuth.addParameters(authorizationURL, callback);
                        }
                        BareBonesBrowserLaunch.browse(authorizationURL);
                        accessor.wait();
                        if (accessor.accessToken == null) {
                            oauthClient.getAccessToken(accessor, null, //
                                    (verifier == null) ? null : //
                                            OAuth.newList(OAuth.OAUTH_VERIFIER, verifier.toString()));
                        }
                        accessor.notifyAll();
                    }
                }
            } finally {
                if (server != null) {
                    try {
                        server.stop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return getOAuthClient().invoke(accessor, httpMethod, resourceURL, parameters);
        } catch (OAuthProblemException p) {
            StringBuilder msg = new StringBuilder();
            String problem = p.getProblem();
            if (problem != null) {
                msg.append(problem);
            }
            Object response = p.getParameters().get(HttpMessage.RESPONSE);
            if (response != null) {
                String eol = System.getProperty("line.separator", "\n");
                msg.append(eol).append(response);
            }
            // for (Map.Entry e : p.getParameters().entrySet())
            // msg.append(e.getKey()).append(": ")
            // .append(e.getValue()).append(eol);
            throw new OAuthException(msg.toString(), p);
        }
    }

    private static int getEphemeralPort() throws IOException {
        Socket s = new Socket();
        s.bind(null);
        try {
            return s.getLocalPort();
        } finally {
            s.close();
        }
    }

    protected void proceed(String requestToken, String verifier) {
        synchronized (accessor) {
            if (requestToken == null || requestToken.equals(accessor.requestToken)) {
                this.verifier = verifier;
                accessor.notifyAll();
                return;
            }
        }
        System.err.println("ignored authorization of request token " + requestToken);
    }

    protected Handler newCallback() {
        return new Callback(this);
    }

    protected static class Callback extends AbstractHandler {

        protected Callback(DesktopClient client) {
            this.client = client;
        }

        protected final DesktopClient client;

        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch)
                throws IOException, ServletException {
            if (!CALLBACK_PATH.equals(target)) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            } else {
                conclude(response);
                client.proceed(request.getParameter(OAuth.OAUTH_TOKEN),
                               request.getParameter(OAuth.OAUTH_VERIFIER));
                ((Request) request).setHandled(true);
            }
        }

        protected void conclude(HttpServletResponse response) throws IOException {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("text/html");
            final PrintWriter doc = response.getWriter();
            doc.println("<HTML>");
            doc.println("<body onLoad=\"window.close();\">");
            doc.println("Thank you.  You can close this window now.");
            doc.println("</body>");
            doc.println("</HTML>");
        }

    }

    private static final OAuthClient DEFAULT_CLIENT = new OAuthClient(new URLConnectionClient());
    private static final String CALLBACK_PATH = "/oauth/callback";

    static { // suppress log output from Jetty
        try {
            Logger.getLogger("org.mortbay.log").setLevel(Level.WARNING);
        } catch (Exception ignored) {
        }
        try {
            System.setProperty("org.apache.commons.logging.simplelog.log.org.mortbay.log", "warn");
        } catch (Exception ignored) {
        }
    }

}
