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

package net.oauth.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.ParameterStyle;
import net.oauth.client.httpclient4.HttpClient4;
import net.oauth.http.HttpMessage;
import net.oauth.http.HttpMessageDecoder;
import net.oauth.http.HttpResponseMessage;
import net.oauth.signature.Echo;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.servlet.GzipFilter;
import org.mortbay.thread.BoundedThreadPool;

public class OAuthClientTest extends TestCase {

    public void testRedirect() throws Exception {
        final OAuthMessage request = new OAuthMessage("GET",
                "http://google.com/search", OAuth.newList("q", "Java"));
        final Integer expectedStatus = Integer.valueOf(301);
        final String expectedLocation = "http://www.google.com/search?q=Java";
        for (OAuthClient client : clients) {
            try {
                OAuthMessage response = client.invoke(request, ParameterStyle.BODY);
                fail(client.getHttpClient() + " response: " + response);
            } catch (OAuthProblemException e) {
                Map<String, Object> parameters = e.getParameters();
                assertEquals("status", expectedStatus, parameters.get(HttpMessage.STATUS_CODE));
                assertEquals("Location", expectedLocation, parameters.get(HttpResponseMessage.LOCATION));
            }
        }
    }

    public void testInvokeMessage() throws Exception {
        final String echo = "http://localhost:" + port + "/Echo";
        final String data = new String(new char[] { 0, 1, ' ', 'a', 127, 128,
                0xFF, 0x3000, 0x4E00 });
        final byte[] utf8 = data.getBytes("UTF-8");
        List<OAuth.Parameter> parameters = OAuth.newList("x", "y",
                "oauth_token", "t");
        String parametersForm = "oauth_token=t&x=y";
        final Object[][] messages = new Object[][] {
                { new OAuthMessage("GET", echo, parameters),
                        "GET\n" + parametersForm + "\n" + "null\n", null },
                {
                        new OAuthMessage("POST", echo, parameters),
                        "POST\n" + parametersForm + "\n"
                                + parametersForm.length() + "\n",
                        OAuth.FORM_ENCODED },
                {
                        new MessageWithBody("PUT", echo, parameters,
                                "text/OAuthClientTest; charset=\"UTF-8\"", utf8),
                        "PUT\n" + parametersForm + "\n"
                                + utf8.length + "\n" + data,
                        "text/OAuthClientTest; charset=UTF-8" },
                {
                        new MessageWithBody("PUT", echo, parameters,
                                "application/octet-stream", utf8),
                        "PUT\n" + parametersForm + "\n"
                                + utf8.length + "\n"
                                + new String(utf8, "ISO-8859-1"),
                        "application/octet-stream" },
                { new OAuthMessage("DELETE", echo, parameters),
                        "DELETE\n" + parametersForm + "\n" + "null\n", null } };
        final ParameterStyle[] styles = new ParameterStyle[] {
                ParameterStyle.BODY, ParameterStyle.AUTHORIZATION_HEADER };
        final long startTime = System.nanoTime();
        for (OAuthClient client : clients) {
            for (Object[] testCase : messages) {
                for (ParameterStyle style : styles) {
                    OAuthMessage request = (OAuthMessage) testCase[0];
                    final String id = client + " " + request.method + " " + style;
                    OAuthMessage response = null;
                    // System.out.println(id + " ...");
                    try {
                        response = client.invoke(request, style);
                    } catch (Exception e) {
                        AssertionError failure = new AssertionError(id);
                        failure.initCause(e);
                        throw failure;
                    }
                    // System.out.println(response.getDump()
                    // .get(OAuthMessage.HTTP_REQUEST));
                    String expectedBody = (String) testCase[1];
                    if ("POST".equalsIgnoreCase(request.method)
                            && style == ParameterStyle.AUTHORIZATION_HEADER) {
                        // Only the non-oauth parameters went in the body.
                        expectedBody = expectedBody.replace("\n" + parametersForm.length()
                                + "\n", "\n3\n");
                    }
                    String body = response.readBodyAsString();
                    assertEquals(id, expectedBody, body);
                    assertEquals(id, testCase[2], response.getHeader(HttpMessage.CONTENT_TYPE));
                }
            }
        }
        final long endTime = System.nanoTime();
        final float elapsedSec = ((float) (endTime - startTime)) / 1000000000L;
        if (elapsedSec > 10) {
            fail("elapsed time = " + elapsedSec + " sec");
            // This often means the client isn't re-using TCP connections,
            // and consequently all the Jetty server threads are occupied
            // waiting for data on the wasted connections.
        }
    }

    public void testAccess() throws Exception {
        final String echo = "http://localhost:" + port + "/Echo";
        final List<OAuth.Parameter> parameters = OAuth.newList("n", "v");
        final String contentType = "text/fred; charset=" + OAuth.ENCODING;
        final byte[] content = "1234".getBytes(OAuth.ENCODING);
        for (OAuthClient client : clients) {
            String id = client.getHttpClient().toString();
            OAuthMessage request = new OAuthMessage(OAuthMessage.POST, echo, parameters, new ByteArrayInputStream(content));
            request.getHeaders().add(new OAuth.Parameter("Content-Type", contentType));
            OAuthMessage response = client.access(request, ParameterStyle.QUERY_STRING);
            String expectedBody = (client.getHttpClient() instanceof HttpClient4) //
                    ? "POST\nn=v\nnull\n1234" // no Content-Length
                    : "POST\nn=v\n4\n1234";
            String body = response.readBodyAsString();
            assertEquals(id, contentType, response.getHeader(HttpMessage.CONTENT_TYPE));
            assertEquals(id, expectedBody, body);
        }
    }

    public void testGzip() throws Exception
    {
        final OAuthConsumer consumer = new OAuthConsumer(null, null, null, null);
        consumer.setProperty(OAuthConsumer.ACCEPT_ENCODING, HttpMessageDecoder.ACCEPTED);
        consumer.setProperty(OAuth.OAUTH_SIGNATURE_METHOD, "PLAINTEXT");
        final OAuthAccessor accessor = new OAuthAccessor(consumer);
        final String url = "http://localhost:" + port + "/Echo";
        final List<OAuth.Parameter> parameters = OAuth.newList("echoData", "21",
                OAuth.OAUTH_NONCE, "n", OAuth.OAUTH_TIMESTAMP, "1");
        final String expected = "POST\n"
                + "echoData=21&oauth_consumer_key=&oauth_nonce=n&oauth_signature_method=PLAINTEXT&oauth_timestamp=1&oauth_version=1.0\n"
                + "abcdefghi1abcdefghi2\n\n" // 21 bytes of data
                + "134\n" // content-length
                ;
        for (OAuthClient client : clients) {
            try {
                OAuthMessage response = client.invoke(accessor, "POST", url, parameters);
                System.out.println(response.getDump().get(HttpMessage.REQUEST));
                System.out.println(response.getDump().get(HttpMessage.RESPONSE));
                String id = client.getClass().getName();
                assertNull(id, response.getHeader(HttpMessage.CONTENT_ENCODING));
                assertNull(id, response.getHeader(HttpMessage.CONTENT_LENGTH));
                assertEquals(id, expected, response.readBodyAsString());
                // assertEqual(id, OAuth.decodeForm(expected), response.getParameters());
            } catch (OAuthProblemException e) {
                Map<String, Object> p = e.getParameters();
                System.out.println(p.get(HttpMessage.REQUEST));
                System.err.println(p.get(HttpMessage.RESPONSE));
                throw e;
            } catch(Exception e) {
                AssertionError a = new AssertionError(client.getClass().getName());
                a.initCause(e);
                throw a;
            }
            System.out.println();
        }
    }

    public void testUpload() throws IOException, OAuthProblemException {
        final String echo = "http://localhost:" + port + "/Echo";
        final Class myClass = getClass();
        final String sourceName = "/" + myClass.getPackage().getName().replace('.', '/') + "/flower.jpg";
        final URL source = myClass.getResource(sourceName);
        assertNotNull(sourceName, source);
        for (OAuthClient client : clients) {
            for (ParameterStyle style : new ParameterStyle[] { ParameterStyle.AUTHORIZATION_HEADER, ParameterStyle.QUERY_STRING }) {
                final String id = client + " POST " + style;
                OAuthMessage response = null;
                InputStream input = source.openStream();
                try {
                    OAuthMessage request = new OAuthMessage(OAuthMessage.PUT, echo, null, input);
                    request.addParameter(new OAuth.Parameter("oauth_token", "t"));
                    request.getHeaders().add(new OAuth.Parameter("Content-Type", "image/jpeg"));
                    response = client.invoke(request, style);
                } catch (OAuthProblemException e) {
                    System.err.println(e.getParameters().get(HttpMessage.REQUEST));
                    System.err.println(e.getParameters().get(HttpMessage.RESPONSE));
                    throw e;
                } catch (Exception e) {
                    AssertionError failure = new AssertionError();
                    failure.initCause(e);
                    throw failure;
                } finally {
                    input.close();
                }
                assertEquals(id, "image/jpeg", response.getHeader("Content-Type"));
                byte[] data = readAll(source.openStream());
                Integer contentLength = (client.getHttpClient() instanceof HttpClient4) ? null : new Integer(
                        data.length);
                byte[] expected = concatenate((OAuthMessage.PUT + "\noauth_token=t\n" + contentLength + "\n")
                        .getBytes(), data);
                byte[] actual = readAll(response.getBodyAsStream());
                StreamTest.assertEqual(id, expected, actual);
            }
        }
    }

    static byte[] readAll(InputStream from) throws IOException {
        ByteArrayOutputStream into = new ByteArrayOutputStream();
        try {
            byte[] buf = new byte[1024];
            for (int n; 0 < (n = from.read(buf));) {
                into.write(buf, 0, n);
            }
        } finally {
            from.close();
        }
        into.close();
        return into.toByteArray();
    }

    static byte[] concatenate(byte[] x, byte[] y) {
        byte[] z = new byte[x.length + y.length];
        System.arraycopy(x, 0, z, 0, x.length);
        System.arraycopy(y, 0, z, x.length, y.length);
        return z;
    }

    private OAuthClient[] clients;
    private int port = 1025;
    private Server server;

    @Override
    public void setUp() throws Exception {
        clients = new OAuthClient[] { new OAuthClient(new URLConnectionClient()),
                new OAuthClient(new net.oauth.client.httpclient3.HttpClient3()),
                new OAuthClient(new net.oauth.client.httpclient4.HttpClient4()) };
        { // Get an ephemeral local port number:
            Socket s = new Socket();
            s.bind(null);
            port = s.getLocalPort();
            s.close();
        }
        server = new Server(port);
        Context context = new Context(server, "/", Context.SESSIONS);
        context.addFilter(GzipFilter.class, "/*", 1);
        context.addServlet(new ServletHolder(new Echo()), "/Echo/*");
        BoundedThreadPool pool = new BoundedThreadPool();
        pool.setMaxThreads(4);
        server.setThreadPool(pool);
        server.start();
    }

    @Override
    public void tearDown() throws Exception {
        server.stop();
    }

    private static class MessageWithBody extends OAuthMessage {

        public MessageWithBody(String method, String URL,
                Collection<OAuth.Parameter> parameters,
                String contentType, byte[] body) {
            super(method, URL, parameters);
            this.body = body;
            Collection<Map.Entry<String, String>> headers = getHeaders();
            headers.add(new OAuth.Parameter(HttpMessage.ACCEPT_ENCODING, HttpMessageDecoder.ACCEPTED));
            if (body != null) {
                headers.add(new OAuth.Parameter(HttpMessage.CONTENT_LENGTH, String.valueOf(body.length)));
            }
            if (contentType != null) {
                headers.add(new OAuth.Parameter(HttpMessage.CONTENT_TYPE, contentType));
            }
        }

        private final byte[] body;

        @Override
        public InputStream getBodyAsStream() {
            return (body == null) ? null : new ByteArrayInputStream(body);
        }
    }

}
