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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author John Kristian
 */
public class Reset extends HttpServlet {

    /** Clear all the OAuth accessor cookies and redirect to another page. */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            CookieConsumer.removeAccessors(new CookieMap(request, response));
            String nextPage = request.getParameter("nextPage");
            if (nextPage == null) {
                nextPage = request.getHeader("Referer");
                if (nextPage == null) {
                    nextPage = request.getContextPath(); // home page
                }
            }
            throw new RedirectException(nextPage);
        } catch (Exception e) {
            CookieConsumer.handleException(e, request, response, null);
        }
    }

    private static final long serialVersionUID = 1L;

}
