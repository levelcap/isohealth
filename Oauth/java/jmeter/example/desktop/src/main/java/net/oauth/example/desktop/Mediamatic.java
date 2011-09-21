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

package net.oauth.example.desktop;

import java.util.Date;
import net.oauth.OAuth;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.OAuthServiceProvider;
import net.oauth.client.OAuthClient;
import net.oauth.client.httpclient4.HttpClient4;

/**
 * An OAuth application that edits a <a
 * href="http://oauth-sandbox.mediamatic.nl/article-117.html">protected
 * resource</a> at <a href="http://oauth-sandbox.mediamatic.nl/">Mediamatic</a>
 * and then reads it back. As applications go this is very crude: it has no GUI,
 * takes no inputs and simply writes results to the standard output stream. It
 * merely illustrates how a desktop application can use a browser to obtain
 * authorization from its user.
 * <p>
 * A big problem with this or any purely desktop consumer is that it contains
 * the consumer key and secret. Consequently an attacker who has access to the
 * application code can extract the key and secret and abuse them. To prevent
 * this, one could make the desktop application communicate with the service
 * provider via a proxy, controlled by the consumer, which holds the consumer
 * secret. Of course, the proxy must be able to determine that its client is an
 * authorized desktop application (not an attacker).
 * 
 * @author John Kristian
 */
public class Mediamatic {
    public static void main(String[] args) throws Exception {
        final OAuthServiceProvider provider = new OAuthServiceProvider(
                "http://oauth-sandbox.mediamatic.nl/module/OAuth/request_token",
                "http://oauth-sandbox.mediamatic.nl/module/OAuth/authorize",
                "http://oauth-sandbox.mediamatic.nl/module/OAuth/access_token");
        final OAuthConsumer consumer = new OAuthConsumer(null // callback URL
                , "e388e4f4d6f4cc10ff6dc0fd1637da370478e49e2" // consumer key
                , "0b062293b6e29ec91a23b2002abf88e9" // consumer secret
                , provider);
        final String serviceURL = "http://oauth-sandbox.mediamatic.nl/services/rest/";
        final String objectId = "117";
        final DesktopClient client = new DesktopClient(consumer);
        client.setOAuthClient(new OAuthClient(new HttpClient4()));
        OAuthMessage result = client.access(OAuthMessage.GET, serviceURL //
                , OAuth.newList("method", "anymeta.predicates.get" //
                        // or anymeta.test.echo
                        , "id", objectId //
                        , "field", "text.title" //
                ));
        System.out.println(result.readBodyAsString());
        client.access(OAuthMessage.POST, serviceURL //
                , OAuth.newList("method", "anymeta.predicates.set" //
                        , "id", objectId //
                        , "field", "text.body" //
                        , "value", "edited " + new Date() + " via Java desktop application" //
                ));
        result = client.access(OAuthMessage.GET, serviceURL //
                , OAuth.newList("method", "anymeta.predicates.get" //
                        , "id", objectId //
                        , "field", "text.body" //
                ));
        System.out.println(result.readBodyAsString());
    }
}
