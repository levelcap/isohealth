/*
 * Copyright 2008 Google, Inc.
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

import junit.framework.TestCase;

/**
 * @author Dirk Balfanz
 * @author John Kristian
 */
public class OAuthValidatorTest extends TestCase {

    private long currentTimeMsec;
    private SimpleOAuthValidator validator;

    @Override
    protected void setUp() throws Exception {
        currentTimeMsec = (System.currentTimeMillis() / 1000) * 1000;
        validator = new SimpleOAuthValidator() {
            @Override
            protected long currentTimeMsec() {return currentTimeMsec;}
        };
    }

    public void testDuplicateParameters() throws Exception {
        validator.checkSingleParameters(new OAuthMessage("", "", OAuth.decodeForm("x=y&x=y")));
        String parameters = "oauth_version=1.0&oauth_version=1.0";
        OAuthMessage msg = new OAuthMessage("", "", OAuth.decodeForm(parameters));
        try {
            validator.checkSingleParameters(msg);
            fail("repeated parameter");
        } catch (OAuthProblemException expected) {
            assertEquals(OAuth.Problems.PARAMETER_REJECTED, expected.getProblem());
            assertEquals(parameters, expected.getParameters().get(OAuth.Problems.OAUTH_PARAMETERS_REJECTED));
        }
    }

    public void testNonceUsed() throws Exception {
        final long currentTime = currentTimeMsec / 1000;
        final String[] values = { null, "",  currentTime + "", (currentTime - 1) + "" };
        // Using the same set of values for all parameters tests that
        // the validator keeps the parameters separate.
        for (String timestamp : values)
            for (String nonce : values)
                for (String consumerKey : values)
                    for (String token : values)
                        if (timestamp == null || nonce == null)
                            try {
                                tryNonce(timestamp, nonce, consumerKey, token);
                                fail("timestamp " + timestamp + ", nonce " + nonce);
                            } catch (OAuthProblemException e) {
                                assertEquals(OAuth.Problems.PARAMETER_ABSENT, e.getProblem());
                            }
                        else if (timestamp.length() > 0)
                            // The consumerKey or token may be absent (null).
                            tryNonce(timestamp, nonce, consumerKey, token);

        for (String timestamp : values)
            for (String nonce : values)
                for (String consumerKey : values)
                    for (String token : values)
                        if (timestamp == null || nonce == null)
                            try {
                                tryNonce(timestamp, nonce, consumerKey, token);
                                fail("timestamp " + timestamp + ", nonce " + nonce);
                            } catch (OAuthProblemException e) {
                                assertEquals(OAuth.Problems.PARAMETER_ABSENT, e.getProblem());
                            }
                        else if (timestamp.length() > 0)
                            try {
                                tryNonce(timestamp, nonce, consumerKey, token);
                                fail("repeated timestamp " + timestamp + ", nonce " + nonce);
                            } catch (OAuthProblemException e) {
                                assertEquals(OAuth.Problems.NONCE_USED, e.getProblem());
                            }
    }

    private void tryNonce(String timestamp, String nonce, String consumerKey, String token) throws Exception {
        OAuthMessage message = new OAuthMessage("", "", null);
        addParameter(message, OAuth.OAUTH_TIMESTAMP, timestamp);
        addParameter(message, OAuth.OAUTH_NONCE, nonce);
        addParameter(message, OAuth.OAUTH_CONSUMER_KEY, consumerKey);
        addParameter(message, OAuth.OAUTH_TOKEN, token);
        validator.validateTimestampAndNonce(message);
    }

    private void addParameter(OAuthMessage message, String name, String value) {
        if (value != null)
            message.addParameter(name, value);
    }

    public void testTimeRange() throws Exception {
        final long window = SimpleOAuthValidator.DEFAULT_TIMESTAMP_WINDOW;
        tryTime(currentTimeMsec - window - 500); // round up
        tryTime(currentTimeMsec + window + 499); // round down
        try {
            tryTime(currentTimeMsec - window - 501);
            fail("validator should have rejected timestamp, but didn't");
        } catch (OAuthProblemException expected) {
        }
        try {
            tryTime(currentTimeMsec + window + 500);
            fail("validator should have rejected timestamp, but didn't");
        } catch (OAuthProblemException expected) {
        }
    }

    private void tryTime(long timestamp) throws Exception {
        OAuthMessage msg = new OAuthMessage("", "", OAuth.newList(
                "oauth_timestamp", ((timestamp + 500) / 1000) + "",
                "oauth_nonce", "lsfksdklfjfg"));
        validator.validateTimestampAndNonce(msg);
    }

    public void testVersionRange() throws Exception {
        tryVersion(1.0);
        try {
            tryVersion(0.9);
            fail("validator should have rejected version, but didn't");
        } catch (OAuthProblemException expected) {
        }
        try {
            tryVersion(1.2);
            fail("validator should have rejected version, but didn't");
        } catch (OAuthProblemException expected) {
        }
        try {
            tryVersion(2.0);
            fail("validator should have rejected version, but didn't");
        } catch (OAuthProblemException expected) {
        }
    }

    private void tryVersion(double version) throws Exception {
        OAuthMessage msg = new OAuthMessage("", "", OAuth.newList(
                "oauth_version", version + ""));
        validator.validateVersion(msg);
    }

}
