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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.server.HttpRequestMessage;

/**
 * A trivial client of the <a
 * href="http://oauth-sandbox.mediamatic.nl/services/rest/#anymeta.predicates.get"
 * >predicates service</a> at <a
 * href="http://oauth-sandbox.mediamatic.nl/">Mediamatic</a>. This isn't very
 * useful; it merely illustrates how to user OAuth to access Mediamatic's API.
 * 
 * @author John Kristian
 */
public class MediamaticConsumer extends HttpServlet {

    private static final String NAME = "mediamatic";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        OAuthConsumer consumer = null;
        try {
            consumer = CookieConsumer.getConsumer(NAME, getServletContext());
            OAuthAccessor accessor = CookieConsumer.getAccessor(request, response, consumer);
            List<OAuth.Parameter> parameters = HttpRequestMessage.getParameters(request);
            response.setContentType("text/plain");
            final String serviceURL = "http://oauth-sandbox.mediamatic.nl/services/rest/";
            final String objectId = "117";
            // Store some data into the object:
            CookieConsumer.CLIENT.invoke(accessor //
                    , OAuthMessage.POST, serviceURL //
                    , OAuth.newList("method", "anymeta.predicates.set" //
                            , "id", objectId //
                            , "field", "text.body" //
                            , "value", OAuth.formEncode(parameters) //
                    ));
            // Read the data out again:
            OAuthMessage result = CookieConsumer.CLIENT.invoke(accessor //
                    , OAuthMessage.GET, serviceURL //
                    , OAuth.newList("method", "anymeta.predicates.get" //
                            , "id", objectId //
                            , "field", "text.body" //
                    ));
            response.getWriter().println(result.readBodyAsString());
        } catch (Exception e) {
            CookieConsumer.handleException(e, request, response, consumer);
        }
    }

    private static final long serialVersionUID = 1L;

}
