/*
 * Copyright 2008 Google Inc.
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;

/**
 * A trivial consumer of the 'contacts' service at Yahoo.
 * 
 * As of Oct 24, 2008 this doesn't actually work, but the errors seem to be due
 * to APIs that are still in pre-beta mode rather than OAuth specific stuff.
 * 
 * @author Brian Eaton.
 */
public class YahooConsumer extends HttpServlet {

	private static final String CONSUMER_NAME = "yahoo";
	private static final Pattern CALLBACK_PATTERN = Pattern.compile("(.*)[?&]oauth_callback=([^=&?]*)(.*)");

	private static final String TEST_URL = "http://social.yahooapis.com/v1/user/me/contacts";
	// private static final String TEST_URL = "http://social.yahooapis.com/v1/me/guid";
	
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
					TEST_URL, OAuth.newList());
			String responseBody = result.readBodyAsString();
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.println(CONSUMER_NAME + " said:");
			out.print(responseBody);
		} catch (RedirectException e) {
			// Yahoo doesn't have a callback URL associated with my testing CKS.
			// Deal with that by not sending the oauth_callback URL.  We do the
			// approval in a new window instead.
			String target = e.getTargetURL();
			Matcher m = CALLBACK_PATTERN.matcher(target);
			if (!m.matches()) {
				throw new RuntimeException("Couldn't strip callback from redirect: " +
						target);
			}
			// Pull out the callback URL.
			String callback = OAuth.decodePercent(m.group(2));
			// Create an approval URL without the oauth_callback parameter.
			String approval = m.group(1) + m.group(3);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<a href='" + approval + "' target='approval'>" +
				"Approve access</a>");
			out.println("<p>");
			out.println("<a href='" + callback +
				"'>Click here after you approve</a>");
			out.println("</body></html>");
		} catch (Exception e) {
			CookieConsumer.handleException(e, request, response, consumer);
		}
	}

	private static final long serialVersionUID = 1L;

}
