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
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.server.OAuthServlet;

/**
 * An OAuth callback handler.
 * 
 * @author John Kristian
 */
public class Callback extends HttpServlet {

    public static final String PATH = "/OAuth/Callback";

    protected final Logger log = Logger.getLogger(getClass().getName());

    /**
     * Exchange an OAuth request token for an access token, and store the latter
     * in cookies.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        OAuthConsumer consumer = null;
        try {
            final OAuthMessage requestMessage = OAuthServlet.getMessage(
                    request, null);
            requestMessage.requireParameters("consumer");
            final String consumerName = requestMessage.getParameter("consumer");
            consumer = CookieConsumer.getConsumer(consumerName, null);
            final CookieMap cookies = new CookieMap(request, response);
            final OAuthAccessor accessor = CookieConsumer.newAccessor(consumer,
                    cookies);
            final String expectedToken = accessor.requestToken;
            String requestToken = requestMessage.getParameter(OAuth.OAUTH_TOKEN);
            if (requestToken == null || requestToken.length() <= 0) {
                log.warning(request.getMethod() + " "
                        + OAuthServlet.getRequestURL(request));
                requestToken = expectedToken;
                if (requestToken == null) {
                    OAuthProblemException problem = new OAuthProblemException(OAuth.Problems.PARAMETER_ABSENT);
                    problem.setParameter(OAuth.Problems.OAUTH_PARAMETERS_ABSENT, OAuth.OAUTH_TOKEN);
                    throw problem;
                }
            } else if (!requestToken.equals(expectedToken)) {
                OAuthProblemException problem = new OAuthProblemException("token_rejected");
                problem.setParameter("oauth_rejected_token", requestToken);
                problem.setParameter("oauth_expected_token", expectedToken);
                throw problem;
            }
            List<OAuth.Parameter> parameters = null;
            String verifier = requestMessage.getParameter(OAuth.OAUTH_VERIFIER);
            if (verifier != null) {
                parameters = OAuth.newList(OAuth.OAUTH_VERIFIER, verifier);
            }
            OAuthMessage result = CookieConsumer.CLIENT.getAccessToken(accessor, null, parameters);
            if (accessor.accessToken != null) {
                String returnTo = requestMessage.getParameter("returnTo");
                if (returnTo == null) {
                    returnTo = request.getContextPath(); // home page
                }
                cookies.remove(consumerName + ".requestToken");
                cookies
                        .put(consumerName + ".accessToken",
                                accessor.accessToken);
                cookies
                        .put(consumerName + ".tokenSecret",
                                accessor.tokenSecret);
                throw new RedirectException(returnTo);
            }
            OAuthProblemException problem = new OAuthProblemException(OAuth.Problems.PARAMETER_ABSENT);
            problem.setParameter(OAuth.Problems.OAUTH_PARAMETERS_ABSENT, OAuth.OAUTH_TOKEN);
            problem.getParameters().putAll(result.getDump());
            throw problem;
        } catch (Exception e) {
            CookieConsumer.handleException(e, request, response, consumer);
        }
    }

    private static final long serialVersionUID = 1L;

}
