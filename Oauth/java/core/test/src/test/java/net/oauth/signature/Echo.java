/*
 * Copyright 2008 Netflix, Inc.
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

package net.oauth.signature;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuthMessage;
import net.oauth.server.OAuthServlet;

/**
 * A servlet that echoes highlights of each request.
 * 
 * @author John Kristian
 */
public class Echo extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        final String contentType = request.getContentType();
        if (contentType != null) {
            response.setContentType(contentType);
        }
        doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        final String contentType = request.getContentType();
        if (contentType != null) {
            response.setContentType(contentType);
        }
        doGet(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache");
        final OAuthMessage msg = OAuthServlet.getMessage(request, null);
        // System.out.print(Thread.currentThread().getName() + " " + msg.method + " ...");
        // System.out.flush();
        response.setCharacterEncoding(msg.getBodyEncoding());
        final ServletOutputStream out = response.getOutputStream();
        out.print(msg.method + "\n");
        out.print(OAuthSignatureMethod.normalizeParameters(msg.getParameters())
                + "\n");
        if ("true".equalsIgnoreCase(msg.getParameter("echoHeader"))) {
            {
                URL url = new URL(msg.URL);
                String path = url.getPath();
                String queryString = request.getQueryString();
                if (queryString != null) {
                    path += ("?" + queryString);
                }
                out.println(msg.method + " " + path);
            }
            for (Enumeration<String> names = request.getHeaderNames(); names
                    .hasMoreElements();) {
                final String name = names.nextElement();
                for (Enumeration<String> values = request.getHeaders(name); values
                        .hasMoreElements();) {
                    final String value = values.nextElement();
                    out.println(name + ": " + value);
                }
            }
            out.println();
        }
        if ("true".equalsIgnoreCase(msg.getParameter("echoParameters"))) {
            final List<Map.Entry<String, String>> parameters = msg
                    .getParameters();
            for (Map.Entry<String, String> parameter : parameters) {
                out.println(parameter.getKey() + ": " + parameter.getValue());
            }
            out.println();
        }
        final String echoData = msg.getParameter("echoData");
        if (echoData != null) {
            int n = Integer.parseInt(echoData);
            for (; n > 0; n -= (DATA.length + 1)) {
                int len = Math.min(n - 1, DATA.length);
                out.write(DATA, 0, len);
                out.write('\n');
            }
            out.write('\n');
        }
        if (!"false".equalsIgnoreCase(msg.getParameter("echoBody"))) {
            out.print(request.getHeader("Content-Length") + "\n");
            InputStream in = msg.getBodyAsStream();
            byte[] body = readAll(in);
            out.write(body);
        }
        // out.close();
        // System.out.println("... done");
    }

    static byte[] readAll(InputStream from) throws IOException {
        ByteArrayOutputStream into = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int n; 0 < (n = from.read(buf));) {
            into.write(buf, 0, n);
        }
        into.close();
        return into.toByteArray();
    }

    private static final byte[] DATA = getData();

    private static byte[] getData() {
        try {
            return "abcdefghi1abcdefghi2abcdefghi3abcdefghi4abcdefghi"
                    .getBytes("UTF-8");
        } catch (UnsupportedEncodingException wow) {
            wow.printStackTrace();
        }
        final byte[] data = new byte[49];
        Arrays.fill(data, (byte) 'x');
        return data;
    }

    private static final long serialVersionUID = 1L;

}
