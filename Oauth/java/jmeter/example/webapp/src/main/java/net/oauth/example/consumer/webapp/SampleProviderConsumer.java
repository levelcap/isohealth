/*
 * Copyright 2007 AOL, LLC.
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

package net.oauth.example.consumer.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.ParameterStyle;
import net.oauth.server.HttpRequestMessage;

/**
 * Consumer for Sample OAuth Provider
 * 
 * @author Praveen Alavilli
 */
public class SampleProviderConsumer extends HttpServlet {
    private static final String NAME = "sample";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        OAuthConsumer consumer = null;
        try {
            consumer = CookieConsumer.getConsumer(NAME, getServletContext());
            OAuthAccessor accessor = CookieConsumer.getAccessor(request,
                    response, consumer);
            Collection<OAuth.Parameter> parameters = HttpRequestMessage.getParameters(request);
            if (!OAuth.newMap(parameters).containsKey("echo")) {
                parameters.add(new OAuth.Parameter("echo", "Hello."));
            }
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("Sample Provider said:");
            // Try it twice:
            out.println(invoke(accessor, parameters));
            out.println(invoke(accessor, parameters));
        } catch (Exception e) {
            CookieConsumer.handleException(e, request, response, consumer);
        }
    }

    private String invoke(OAuthAccessor accessor,
            Collection<? extends Map.Entry> parameters)
    throws OAuthException, IOException, URISyntaxException {
        URL baseURL = (URL) accessor.consumer
                .getProperty("serviceProvider.baseURL");
        if (baseURL == null) {
            baseURL = new URL("http://localhost/oauth-provider/");
        }
        OAuthMessage request = accessor.newRequestMessage("POST", (new URL(
                baseURL, "echo")).toExternalForm(), parameters);
        OAuthMessage response = CookieConsumer.CLIENT.invoke(request,
                ParameterStyle.AUTHORIZATION_HEADER);
        String responseBody = response.readBodyAsString();
        return responseBody;
    }

    private static final long serialVersionUID = 1L;

}
