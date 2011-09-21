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
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.ParameterStyle;
import net.oauth.client.OAuthResponseMessage;
import net.oauth.http.HttpMessage;
import net.oauth.http.HttpResponseMessage;

/**
 * A trivial consumer of the 'friends_timeline' service at Twitter.
 * 
 * @author John Kristian
 */
public class TwitterConsumer extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        OAuthConsumer consumer = null;
        try {
            consumer = CookieConsumer.getConsumer("twitter", getServletContext());
            OAuthAccessor accessor = CookieConsumer.getAccessor(request, response, consumer);
            OAuthResponseMessage result = CookieConsumer.CLIENT.access(accessor.newRequestMessage(OAuthMessage.GET,
                    "http://twitter.com/statuses/friends_timeline.atom", null), ParameterStyle.AUTHORIZATION_HEADER);
            int status = result.getHttpResponse().getStatusCode();
            if (status != HttpResponseMessage.STATUS_OK) {
                OAuthProblemException problem = result.toOAuthProblemException();
                if (problem.getProblem() != null) {
                    throw problem;
                }
                Map<String, Object> dump = problem.getParameters();
                response.setContentType("text/plain");
                PrintWriter out = response.getWriter();
                out.println(dump.get(HttpMessage.REQUEST));
                out.println("----------------------");
                out.println(dump.get(HttpMessage.RESPONSE));
            } else {
                // Simply pass the data through to the browser:
                CookieConsumer.copyResponse(result, response);
            }
        } catch (Exception e) {
            CookieConsumer.handleException(e, request, response, consumer);
        }
    }

    private static final long serialVersionUID = 1L;

}
