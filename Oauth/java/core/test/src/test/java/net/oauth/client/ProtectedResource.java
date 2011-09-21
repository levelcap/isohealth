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

package net.oauth.client;

import net.oauth.client.httpclient4.OAuthSchemeFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.SimpleOAuthValidator;
import net.oauth.server.OAuthServlet;

/**
 * A servlet that echoes highlights of each request.
 * 
 * @author John Kristian
 */
public class ProtectedResource extends HttpServlet {

    public static final String REALM = "Narnia";

    private static final OAuthConsumer consumer = new OAuthConsumer(null, "consumer key", "consumer secret", null);
    public static final OAuthAccessor ACCESSOR = new OAuthAccessor(consumer);
    static {
        ProtectedResource.ACCESSOR.accessToken = "access token";
        ProtectedResource.ACCESSOR.tokenSecret = "token secret";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        echo(request);
        response.setHeader("Cache-Control", "no-cache");
        String challenge = OAuthSchemeFactory.SCHEME_NAME + " realm=\"" + REALM + "\"";
        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith(challenge)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.addHeader("WWW-Authenticate", challenge);
            return;
        }
        if ("true".equalsIgnoreCase(request.getParameter("redirect"))) {
            String location = request.getRequestURL().toString();
            for (Enumeration names = request.getParameterNames(); names.hasMoreElements();) {
                final String name = names.nextElement().toString();
                if (!"redirect".equals(name)) {
                    for (String value : request.getParameterValues(name)) {
                        location = OAuth.addParameters(location, name, value);
                    }
                }
            }
            response.sendRedirect(location);
            return;
        }
        final OAuthMessage msg = OAuthServlet.getMessage(request, null);
        try {
            (new SimpleOAuthValidator()).validateMessage(msg, ACCESSOR);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (OAuthProblemException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String contentType = request.getContentType();
        if (contentType != null) {
            response.setContentType(contentType);
        }
        doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        final String contentType = request.getContentType();
        if (contentType != null) {
            response.setContentType(contentType);
        }
        doGet(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doGet(request, response);
    }

    private static void echo(HttpServletRequest request) throws IOException {
        final PrintStream out = System.out;
        if ("true".equalsIgnoreCase(request.getParameter("echoHeader"))) {
            {
                String path = new URL(request.getRequestURL().toString()).getPath();
                String queryString = request.getQueryString();
                if (queryString != null) {
                    path += ("?" + queryString);
                }
                out.println(request.getMethod() + " " + path);
            }
            for (Enumeration names = request.getHeaderNames(); names.hasMoreElements();) {
                final String name = names.nextElement().toString();
                for (Enumeration values = request.getHeaders(name); values.hasMoreElements();) {
                    out.println(name + ": " + values.nextElement());
                }
            }
            out.println();
        }
        if ("true".equalsIgnoreCase(request.getParameter("echoParameters"))) {
            for (Enumeration names = request.getParameterNames(); names.hasMoreElements();) {
                final String name = names.nextElement().toString();
                for (String value : request.getParameterValues(name)) {
                    out.println(name + ": " + value);
                }
            }
            out.println();
        }
        if ("true".equalsIgnoreCase(request.getParameter("echoBody"))) {
            InputStream in = request.getInputStream();
            byte[] body = readAll(in);
            out.write(body);
        }
    }

    private static byte[] readAll(InputStream from) throws IOException {
        ByteArrayOutputStream into = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int n; 0 < (n = from.read(buf));) {
            into.write(buf, 0, n);
        }
        into.close();
        return into.toByteArray();
    }

    private static final long serialVersionUID = 1L;

}
