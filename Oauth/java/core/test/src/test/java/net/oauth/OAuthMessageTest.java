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

package net.oauth;

import java.util.List;
import junit.framework.TestCase;

public class OAuthMessageTest extends TestCase
{
    private static final String[][] AUTH_HEADERS =
    // label, inputs, expected result
    { { "realm", "x y", "oauth_token=a b&scope=c", "OAuth realm=\"x%20y\", oauth_token=\"a%20b\"" } //
            , { "no realm", null, "oauth_token=a b&scope=c", "OAuth oauth_token=\"a%20b\"" } //
    };

    public void testAuthorizationHeader() throws Exception
    {
        for (String[] testCase : AUTH_HEADERS) {
            String label = testCase[0];
            String realm = testCase[1];
            List<OAuth.Parameter> parameters = OAuth.decodeForm(testCase[2]);
            String expected = testCase[3];
            OAuthMessage message = new OAuthMessage("METHOD", "URL", parameters);
            assertEquals(label, expected, message.getAuthorizationHeader(realm));
        }
    }
}
