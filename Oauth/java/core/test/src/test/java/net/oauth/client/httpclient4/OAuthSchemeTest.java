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

package net.oauth.client.httpclient4;

import net.oauth.client.ProtectedResource;

import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import javax.servlet.http.HttpServletResponse;
import junit.framework.TestCase;
import net.oauth.client.httpclient4.OAuthCredentials;
import net.oauth.client.httpclient4.OAuthSchemeFactory;
import net.oauth.client.httpclient4.PreemptiveAuthorizer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

public class OAuthSchemeTest extends TestCase {

    public void testChallenge() throws IOException {
        final String resource = "http://localhost:" + port + "/Resource?echoHeader=true";
        get(resource);
        get(resource + "&redirect=true");
        /*
         * A lot goes on inside there. We send the request, the server sends
         * WWW-Authenticate, we send an Authorization header, the server sends a
         * redirect, we follow the redirect and finally the server sends OK.
         */
    }

    public void testPreemptive() throws IOException {
        client.getParams().setParameter(OAuthSchemeFactory.DEFAULT_REALM, ProtectedResource.REALM);
        client.addRequestInterceptor(new PreemptiveAuthorizer(), 0);
        testChallenge();
    }

    private void get(String URL) throws IOException {
        HttpResponse response = client.execute(new HttpGet(URL), context);
        assertEquals(HttpServletResponse.SC_OK, response.getStatusLine().getStatusCode());
        release(response);
    }

    private static void release(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            entity.getContent().close();
        }
    }

    private int port = 1025;
    private Server server;
    DefaultHttpClient client;
    HttpContext context;

    @Override
    public void setUp() throws Exception {
        { // Get an ephemeral local port number:
            Socket s = new Socket();
            s.bind(null);
            port = s.getLocalPort();
            s.close();
        }
        server = new Server(port);
        Context servletContext = new Context(server, "/", Context.SESSIONS);
        servletContext.addServlet(new ServletHolder(new ProtectedResource()), "/Resource/*");
        server.start();
        context = new BasicHttpContext();
        context.setAttribute(ClientContext.AUTH_SCHEME_PREF, Arrays.asList(OAuthSchemeFactory.SCHEME_NAME));
        client = new DefaultHttpClient();
        client.getAuthSchemes().register(OAuthSchemeFactory.SCHEME_NAME, new OAuthSchemeFactory());
        client.getCredentialsProvider().setCredentials(new AuthScope("localhost", port),
                new OAuthCredentials(ProtectedResource.ACCESSOR));
    }

    @Override
    public void tearDown() throws Exception {
        server.stop();
    }

}
