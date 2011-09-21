/*
 * Copyright 2009 Paul Austin
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

package net.oauth.client.httpclient4;

import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.params.HttpParams;

/**
 * An implementation of the <a
 * href="http://oauth.net/core/1.0#auth_header">OAuth HTTP authorization
 * scheme</a>. This is somewhat limited: it can only sign a request URL by
 * adding an Authorization header. It can't change the request URL query string,
 * it can't handle OAuth parameters in the URL query and it can't sign
 * parameters from the request body.
 * 
 * @author Paul Austin
 * @author John Kristian
 */
public class OAuthSchemeFactory implements AuthSchemeFactory {

    /** The name of this authorization scheme. */
    public static final String SCHEME_NAME = "OAuth";

    /**
     * The name of an HttpClient param whose value is the realm to send in
     * Authorization headers, if no realm was previously received in a
     * WWW-Authenticate challenge. This is useful for preemptive authorization;
     * that is sending an Authorization header without any need for a challenge.
     */
    public static final String DEFAULT_REALM = "defaultRealm";

    public AuthScheme newInstance(final HttpParams params) {
        return new OAuthScheme((String) params.getParameter(DEFAULT_REALM));
    }

}
