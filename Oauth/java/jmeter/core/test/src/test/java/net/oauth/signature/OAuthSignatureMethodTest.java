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

package net.oauth.signature;

import java.util.List;
import junit.framework.TestCase;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;

public class OAuthSignatureMethodTest extends TestCase {

    public static void main(String[] args) throws Exception {
        (new OAuthSignatureMethodTest()).testSign();
    }

    private static final String[][] NORMALS = //
    { { "no parameters", null, "" } //
            , { "absent value", "name", "name=" } //
            , { "one parameter", "a=b", "a=b" } //
            , { "two parameters", "a=b&c=d", "a=b&c=d" } //
            , { "sort names", "x!y=a&x=a", "x=a&x%21y=a" } //
            , { "sort values", "a=x!y&a=x+y", "a=x%20y&a=x%21y" } //
            , { "sort encoded", "a=b&a=B&a={}&a=.&a=/", "a=%2F&a=%7B%7D&a=.&a=B&a=b" } //
    };

    public void testNormalizeParameters() throws Exception {
        for (int c = 0; c < NORMALS.length;) {
            String[] normal = NORMALS[c++];
            int n = 0;
            String label = normal[n++];
            List<OAuth.Parameter> parameters = OAuth.decodeForm(normal[n++]);
            String expected = normal[n++];
            String actual = OAuthSignatureMethod
                    .normalizeParameters(parameters);
            assertEquals(label, expected, actual);
        }
    }

    private static final String OAUTH_A_BASE_STRING = "GET&http%3A%2F%2Fphotos.example.net%2Fphotos&"
            + "file%3Dvacation.jpg%26oauth_consumer_key%3Ddpf43f3p2l4k3l03%26oauth_nonce%3Dkllo9940pd9333jh%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D1191242096%26oauth_token%3Dnnch734d00sl2jdk%26oauth_version%3D1.0%26size%3Doriginal";

    private static final String[][] BASES = //
    // label, signature method, HTTP method, URL, parameters,
    // consumer secret, token secret, expected
    {
            { "simple", "HMAC-SHA1", "GET", "http://example.com/", "n=v", "cs",
                    "ts", "GET&http%3A%2F%2Fexample.com%2F&n%3Dv" },
            { "no path", "HMAC-SHA1", "GET", "http://example.com", "n=v", "cs",
                    "ts", "GET&http%3A%2F%2Fexample.com%2F&n%3Dv" },
            {
                    "OAuth A request",
                    "HMAC-SHA1",
                    "POST",
                    "https://photos.example.net/request_token",
                    "oauth_version=1.0&oauth_consumer_key=dpf43f3p2l4k3l03&oauth_timestamp=1191242090&oauth_nonce=hsu94j3884jdopsl&oauth_signature_method=PLAINTEXT&oauth_signature=ignored",
                    "kd94hf93k423kf44",
                    null,
                    "POST&https%3A%2F%2Fphotos.example.net%2Frequest_token&"
                            + "oauth_consumer_key%3Ddpf43f3p2l4k3l03%26oauth_nonce%3Dhsu94j3884jdopsl%26oauth_signature_method%3DPLAINTEXT%26oauth_timestamp%3D1191242090%26oauth_version%3D1.0" },
            {
                    "OAuth A access",
                    "HMAC-SHA1",
                    "GET",
                    "http://photos.example.net/photos",
                    "file=vacation.jpg&size=original&oauth_version=1.0&oauth_consumer_key=dpf43f3p2l4k3l03&oauth_token=nnch734d00sl2jdk&oauth_timestamp=1191242096&oauth_nonce=kllo9940pd9333jh&oauth_signature=ignored&oauth_signature_method=HMAC-SHA1",
                    "kd94hf93k423kf44", "pfkkdhi9sl3r4s00", OAUTH_A_BASE_STRING } };

    public void testGetBaseString() throws Exception {
        for (int c = 0; c < BASES.length;) {
            String[] base = BASES[c++];
            int b = 0;
            String label = base[b++];
            String methodName = base[b++];
            String httpMethod = base[b++];
            String URL = base[b++];
            String form = base[b++];
            String consumerSecret = base[b++];
            String tokenSecret = base[b++];
            String expected = base[b++];
            OAuthSignatureMethod method = OAuthSignatureMethod.newMethod(
                    methodName, new OAuthAccessor(new OAuthConsumer(null, null,
                            consumerSecret, null)));
            method.setTokenSecret(tokenSecret);
            List<OAuth.Parameter> parameters = OAuth.decodeForm(form);
            String actual = OAuthSignatureMethod
                    .getBaseString(new OAuthMessage(httpMethod, URL, parameters));
            assertEquals(label, expected, actual);
        }

        OAuthMessage message = new OAuthMessage("GET",
                "HTTP://Example.com:80/foo",
                null);
        String baseString = OAuthSignatureMethod.getBaseString(message);
        assertEquals("GET&http%3A%2F%2Fexample.com%2Ffoo&", baseString);

        message = new OAuthMessage("GET",
                "HTTP://Example.com:444/foo",
                null);
        baseString = OAuthSignatureMethod.getBaseString(message);
        assertEquals("GET&http%3A%2F%2Fexample.com%3A444%2Ffoo&", baseString);

        message = new OAuthMessage("GET",
                "HTTPS://Example.com:443/foo",
                null);
        baseString = OAuthSignatureMethod.getBaseString(message);
        assertEquals("GET&https%3A%2F%2Fexample.com%2Ffoo&", baseString);

        message = new OAuthMessage("GET",
                "hTtp://Example.com/Foo",
                null);
        baseString = OAuthSignatureMethod.getBaseString(message);
        assertEquals("GET&http%3A%2F%2Fexample.com%2FFoo&", baseString);

        message = new OAuthMessage("GET",
                "http://Example.com:443/foo",
                null);
        baseString = OAuthSignatureMethod.getBaseString(message);
        assertEquals("GET&http%3A%2F%2Fexample.com%3A443%2Ffoo&", baseString);

        message = new OAuthMessage("GET",
                "https://Example.com:80/foo",
                null);
        baseString = OAuthSignatureMethod.getBaseString(message);
        assertEquals("GET&https%3A%2F%2Fexample.com%3A80%2Ffoo&", baseString);

        message = new OAuthMessage("GET",
                "http://Example.com/email+with+plus@example.com",
                null);
        baseString = OAuthSignatureMethod.getBaseString(message);
        assertEquals("GET&http%3A%2F%2Fexample.com%2Femail%2Bwith%2Bplus%40example.com&", baseString);

        message = new OAuthMessage("GET",
            "http://Example.com/email%2Bwith%2Bplus%40example.com",
                null);
        baseString = OAuthSignatureMethod.getBaseString(message);
        assertEquals("GET&http%3A%2F%2Fexample.com%2Femail%252Bwith%252Bplus%2540example.com&", baseString);
    }

    private static final String[][] SIGNATURES = //
    // label, method, consumer secret, token secret, base string, expected
    {
            { "PLAINTEXT", "PLAINTEXT", "cs", "ts", "bs", "cs&ts" },
            { "HMAC-SHA1", "HMAC-SHA1", "cs", null, "bs",
                    "egQqG5AJep5sJ7anhXju1unge2I=" },
            { "HMAC-SHA1", "HMAC-SHA1", "cs", "ts", "bs",
                    "VZVjXceV7JgPq/dOTnNmEfO0Fv8=" },
            { "OAuth A request", "PLAINTEXT", "kd94hf93k423kf44", null, null,
                    "kd94hf93k423kf44&" },
            { "OAuth A access", "HMAC-SHA1", "kd94hf93k423kf44",
                    "pfkkdhi9sl3r4s00", OAUTH_A_BASE_STRING,
                    "tR3+Ty81lMeYAr/Fid0kMTYa/WM=" } };

    public void testSign() throws Exception {
        StringBuffer errors = new StringBuffer();
        for (int c = 0; c < SIGNATURES.length;) {
            String[] signature = SIGNATURES[c++];
            int s = 0;
            String label = signature[s++];
            String methodName = signature[s++];
            String consumerSecret = signature[s++];
            String tokenSecret = signature[s++];
            String baseString = signature[s++];
            String expected = signature[s++];
            String accessorSecret = "wrong";
            OAuthConsumer consumer = new OAuthConsumer(null, null,
                    consumerSecret, null);
            consumer.setProperty(OAuthConsumer.ACCESSOR_SECRET, accessorSecret);
            OAuthSignatureMethod method = OAuthSignatureMethod.newMethod(
                    methodName, new OAuthAccessor(consumer));
            method.setTokenSecret(tokenSecret);
            String actual = method.getSignature(baseString);
            if (!expected.equals(actual)) {
                if (errors.length() > 0)
                    errors.append(", ");
                errors.append(label).append(" ").append(actual);
            }
            label += OAuthSignatureMethod._ACCESSOR;
            methodName += OAuthSignatureMethod._ACCESSOR;
            consumer = new OAuthConsumer(null, null, accessorSecret, null);
            consumer.setProperty(OAuthConsumer.ACCESSOR_SECRET, consumerSecret);
            method = OAuthSignatureMethod.newMethod(methodName,
                    new OAuthAccessor(consumer));
            method.setTokenSecret(tokenSecret);
            actual = method.getSignature(baseString);
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
