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

import static net.oauth.OAuth.HMAC_SHA1;
import static net.oauth.OAuth.OAUTH_SIGNATURE_METHOD;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.ParameterStyle;

/**
 * A trivial consumer of <a
 * href="http://code.google.com/apis/contacts/">Contacts Data</a> from Google.
 * This isn't very useful; it merely demonstrates how to use OAuth to authorize
 * access to someone's data at Google.
 * <p>
 * If you really want to access Google, it's probably better to use one of <a
 * href="http://code.google.com/apis/contacts/docs/3.0/developers_guide.html"
 * >their libraries</a>.
 * 
 * @author John Kristian
 */
public class GoogleContactsConsumer extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        OAuthConsumer consumer = null;
        try {
            consumer = CookieConsumer.getConsumer("googleContacts", getServletContext());
            OAuthAccessor accessor = CookieConsumer.getAccessor(request, response, consumer);
            // You can switch to a different signature method:
            accessor.consumer.setProperty(OAUTH_SIGNATURE_METHOD, HMAC_SHA1);
            // HMAC uses the access token secret as a factor,
            // and it's a little less compute-intensive than RSA.
            OAuthMessage message = accessor.newRequestMessage(OAuthMessage.GET,
                    "http://www.google.com/m8/feeds/contacts/default/full", null);
            OAuthMessage result = CookieConsumer.CLIENT.invoke(message, ParameterStyle.AUTHORIZATION_HEADER);
            // Simply pass the data through to the browser:
            CookieConsumer.copyResponse(result, response);
        } catch (Exception e) {
            CookieConsumer.handleException(e, request, response, consumer);
        }
    }

    private static final long serialVersionUID = 1L;

}
