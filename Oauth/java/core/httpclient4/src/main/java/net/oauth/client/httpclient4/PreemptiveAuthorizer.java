/*
 * Copyright 2009 John Kristian
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

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

/**
 * An interceptor that initiates authorization without waiting for a challenge
 * from the server. This avoids a response/request exchange (for the challenge),
 * but it doesn't give the server a chance to select the authorization scheme or
 * realm.
 * <p>
 * To make this work:
 * <ul>
 * <li>In your HttpContext attributes, set a list of preferred auth scheme
 * names.
 * <li>In your HttpClient auth schemes, register an AuthSchemeFactory for at
 * least one of those schemes.
 * <li>In your HttpClient credentials provider, set Credentials for an AuthScope
 * that will match your request.
 * <li>In your HttpClient params, register any parameters the AuthSchemeFactory
 * requires.
 * <li>In your HttpClient, add an instance of this interceptor.
 * </ul>
 * Here's an example using OAuth:
 * <pre>
 * context = new BasicHttpContext();
 * context.setAttribute(ClientContext.AUTH_SCHEME_PREF, Arrays.asList(OAuthSchemeFactory.SCHEME_NAME));
 * client = new DefaultHttpClient();
 * client.getAuthSchemes().register(OAuthSchemeFactory.SCHEME_NAME, new OAuthSchemeFactory());
 * client.getCredentialsProvider().setCredentials(new AuthScope(&quot;server.com&quot;, 80), new OAuthCredentials(accessor));
 * client.getParams().setParameter(OAuthSchemeFactory.DEFAULT_REALM, ProtectedResource.REALM);
 * client.addRequestInterceptor(new PreemptiveAuthorizer(), 0);
 * </pre>
 * 
 * @author John Kristian
 */
public class PreemptiveAuthorizer implements HttpRequestInterceptor {

    /**
     * If no auth scheme has been selected for the given context, consider each
     * of the preferred auth schemes and select the first one for which an
     * AuthScheme and matching Credentials are available.
     */
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        AuthState authState = (AuthState) context.getAttribute(ClientContext.TARGET_AUTH_STATE);
        if (authState != null && authState.getAuthScheme() != null) {
            return;
        }
        HttpHost target = (HttpHost) context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
        CredentialsProvider creds = (CredentialsProvider) context.getAttribute(ClientContext.CREDS_PROVIDER);
        AuthSchemeRegistry schemes = (AuthSchemeRegistry) context.getAttribute(ClientContext.AUTHSCHEME_REGISTRY);
        for (Object schemeName : (Iterable) context.getAttribute(ClientContext.AUTH_SCHEME_PREF)) {
            AuthScheme scheme = schemes.getAuthScheme(schemeName.toString(), request.getParams());
            if (scheme != null) {
                AuthScope targetScope = new AuthScope(target.getHostName(), target.getPort(), scheme.getRealm(), scheme
                        .getSchemeName());
                Credentials cred = creds.getCredentials(targetScope);
                if (cred != null) {
                    authState.setAuthScheme(scheme);
                    authState.setCredentials(cred);
                    return;
                }
            }
        }
    }
}