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

import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.OAuthServiceProvider;
import net.oauth.client.OAuthClient;
import net.oauth.client.httpclient4.HttpClient4;

/**
 * An OAuth application that gets tweets from Twitter. This isn't very useful;
 * it's merely a simple example of using OAuth to access a Twitter API.
 * 
 * @author John Kristian
 */
public class Twitter {
    public static void main(String[] args) throws Exception {
        DesktopClient client = new DesktopClient(new OAuthConsumer(null //
                , "7y0Wxw7B9kLIVNdPAEv47g" // consumer key
                , "F34HyfNIvLTXJNgUpLSyRRdQBYYllWIMXyim6NzPQ" // consumer secret
                , new OAuthServiceProvider( //
                        "http://twitter.com/oauth/request_token", //
                        "http://twitter.com/oauth/authorize", //
                        "http://twitter.com/oauth/access_token")));
        client.setOAuthClient(new OAuthClient(new HttpClient4()));
        OAuthMessage response = client.access(OAuthMessage.GET,
                "http://twitter.com/statuses/friends_timeline.xml", null);
        // That is, the 20 most recent statuses posted by the authenticating
        // user and that user's friends.
        // http://apiwiki.twitter.com/Twitter-REST-API-Method%3A-statuses-friends_timeline
        System.out.println(response.readBodyAsString());
    }
}
