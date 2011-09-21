/*
 * Copyright 2007 Netflix, Inc.
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;

/**
 * A trivial consumer of the 'tags' service at Ma.gnolia.
 * 
 * @author John Kristian
 */
public class MagnoliaConsumer extends HttpServlet {

    private static final String CONSUMER_NAME = "ma.gnolia";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        OAuthConsumer consumer = null;
        try {
            consumer = CookieConsumer.getConsumer(CONSUMER_NAME,
                    getServletContext());
            OAuthAccessor accessor = CookieConsumer.getAccessor(request,
                    response, consumer);
            OAuthMessage result = CookieConsumer.CLIENT.invoke(accessor,
                    "http://ma.gnolia.com/api/rest/2/tags_find", OAuth.newList(
                            "person", System.getProperty("user.name")));
            String responseBody = result.readBodyAsString();
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println(CONSUMER_NAME + " said:");
            out.print(responseBody);
        } catch (Exception e) {
            CookieConsumer.handleException(e, request, response, consumer);
        }
    }

    private static final long serialVersionUID = 1L;

}
