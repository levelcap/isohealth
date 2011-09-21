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

import net.oauth.OAuthConsumer;

import net.oauth.OAuthAccessor;
import org.apache.http.auth.UsernamePasswordCredentials;

/**
 * An OAuthAccessor, to be used as credentials for an AuthScheme based on OAuth.
 * The OAuthAccessor is contained by reference, so you can change it to contain
 * the OAuth tokens and secrets that you receive from a service provider.
 * 
 * @author John Kristian
 */
public class OAuthCredentials extends UsernamePasswordCredentials {

    private final OAuthAccessor accessor;

    public OAuthCredentials(OAuthAccessor accessor) {
        super(accessor.consumer.consumerKey, accessor.consumer.consumerSecret);
        this.accessor = accessor;
    }

    /**
     * Constructs a simple accessor, containing only a consumer key and secret.
     * This is useful for two-legged OAuth; that is interaction between a
     * Consumer and Service Provider with no User involvement.
     */
    public OAuthCredentials(String consumerKey, String consumerSecret) {
        this(new OAuthAccessor(new OAuthConsumer(null, consumerKey, consumerSecret, null)));
    }

    public OAuthAccessor getAccessor() {
        return accessor;
    }

    /** Get the current consumer secret, to be used as a password. */
    @Override
    public String getPassword() {
        return getAccessor().consumer.consumerSecret;
    }

    /** Get the current consumer key, to be used as a password. */
    @Override
    public String getUserName() {
        return getAccessor().consumer.consumerKey;
    }

}
