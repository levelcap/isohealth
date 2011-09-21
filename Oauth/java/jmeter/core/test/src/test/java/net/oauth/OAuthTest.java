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

package net.oauth;

import java.util.List;

import junit.framework.TestCase;

public class OAuthTest extends TestCase {

    private static final String[] STANDARD =
    // label, input, expected result
    { "ALPHA", "abcABC", "abcABC" //
            , "DIGIT", "123", "123" //
            , "unreserved", "-._~", "-._~" //
            , "percent", "%", "%25" //
            , "plus", "+", "%2B" //
            , "not unreserved", "&=*", "%26%3D%2A" //
            , "LF", "\n", "%0A" //
            , "SP", " ", "%20" //
            , "DEL", "\u007F", "%7F" //
            , "Latin", "\u0080", "%C2%80" //
            , "CJK", "\u3001", "%E3%80%81" //
    };

    private static final String[] FLEXIBLE =
    // label, input, expected result
    { "SP", " ", "+" //
            , "slash", "/", "%2F" //
            , "not unreserved", "&=*", "%26%3D%2A" //
            , "lower case hex", "/=*\u3001", "%2f%3d%2a%e3%80%81" //
    };

    public void testEncode() {
        StringBuffer errors = new StringBuffer();
        for (int c = 0; c < STANDARD.length; c += 3) {
            String label = STANDARD[c];
            String input = STANDARD[c + 1];
            String expected = STANDARD[c + 2];
            String actual = OAuth.percentEncode(input);
            if (!expected.equals(actual)) {
                if (errors.length() > 0)
                    errors.append(", ");
                errors.append(label).append(" ").append(actual);
            }
        }
        if (errors.length() > 0)
            fail(errors.toString());
    }

    public void testDecodeStandard() {
        testDecode(STANDARD);
    }

    public void testDecodeFlexible() {
        testDecode(FLEXIBLE);
    }

    public void testDecodeFormCornerCases() throws Exception {

	List<OAuth.Parameter> msgParams = OAuth.decodeForm("foo=bar");
	assertEquals(1, msgParams.size());
	assertEquals("foo", msgParams.get(0).getKey());
	assertEquals("bar", msgParams.get(0).getValue());

	msgParams = OAuth.decodeForm("foo");
	assertEquals(1, msgParams.size());
	assertEquals("foo", msgParams.get(0).getKey());
	assertNull(msgParams.get(0).getValue());

	msgParams = OAuth.decodeForm(null);
	assertNotNull(msgParams);
	assertEquals(0, msgParams.size());

	msgParams = OAuth.decodeForm("");
	assertNotNull(msgParams);
	assertEquals(0, msgParams.size());

	msgParams = OAuth.decodeForm("   ");
	assertEquals(1, msgParams.size());
	assertEquals("   ", msgParams.get(0).getKey());
	assertNull(msgParams.get(0).getValue());

	msgParams = OAuth.decodeForm("=");
	assertEquals(1, msgParams.size());
	assertEquals("", msgParams.get(0).getKey());
	assertEquals("", msgParams.get(0).getValue());

	msgParams = OAuth.decodeForm("= ");
	assertEquals(1, msgParams.size());
	assertEquals("", msgParams.get(0).getKey());
	assertEquals(" ", msgParams.get(0).getValue());

	msgParams = OAuth.decodeForm(" =");
	assertEquals(1, msgParams.size());
	assertEquals(" ", msgParams.get(0).getKey());
	assertEquals("", msgParams.get(0).getValue());
    }

    private static void testDecode(String[] cases) {
        StringBuffer errors = new StringBuffer();
        for (int c = 0; c < cases.length; c += 3) {
            String label = cases[c];
            String input = cases[c + 2];
            String expected = cases[c + 1];
            String actual = OAuth.decodePercent(input);
            if (!expected.equals(actual)) {
                if (errors.length() > 0)
                    errors.append(", ");
                errors.append(label).append(" ").append(actual);
            }
        }
        if (errors.length() > 0)
            fail(errors.toString());
    }

}
