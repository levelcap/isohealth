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

package net.oauth.example.cmdline;

import java.util.Properties;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import net.oauth.client.httpclient4.HttpClient4;
import net.oauth.client.OAuthClient;
import net.oauth.OAuthServiceProvider;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthAccessor;
import net.oauth.OAuth;
import net.oauth.OAuthMessage;
import net.oauth.OAuthException;


// See the readme.txt and manpage.txt for more information

public class OAuthHelper {
    private Properties props;
    private File propFile;

    public static void main(String[] argv) throws Exception {
        if ("help".equals(argv[0])) {
            System.err.println("Please see the readme.txt");
            return;
        } else {
            if (argv.length < 2 && (!"help".equals(argv[0]))){
                System.err.println(
                            "OAuthHelper [help | <properties> [<operation> | <url>]]");
                return;
            }
        }
        new OAuthHelper(argv[0]).execute(argv[1]);
    }


    public OAuthHelper(String fileName) throws IOException {
        props = new Properties();
        propFile = new File(fileName);
        props.load(new FileInputStream(propFile));
    }

    private OAuthAccessor createOAuthAccessor(){
        String consumerKey = props.getProperty("consumerKey");
        String callbackUrl = null;
        String consumerSecret = props.getProperty("consumerSecret");

        String reqUrl = props.getProperty("requestUrl");
        String authzUrl = props.getProperty("authorizationUrl");
        String accessUrl = props.getProperty("accessUrl");

        OAuthServiceProvider provider
                = new OAuthServiceProvider(reqUrl, authzUrl, accessUrl);
        OAuthConsumer consumer
                = new OAuthConsumer(callbackUrl, consumerKey,
                consumerSecret, provider);
        return new OAuthAccessor(consumer);
    }

    private void updateProperties(String msg) throws IOException {
        props.store(new FileOutputStream(propFile), msg);
    }

    private OAuthMessage sendRequest(Map map, String url) throws IOException,
            URISyntaxException, OAuthException
    {
        List<Map.Entry> params = new ArrayList<Map.Entry>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry p = (Map.Entry) it.next();
            params.add(new OAuth.Parameter((String)p.getKey(),
                    (String)p.getValue()));
        }
        OAuthAccessor accessor = createOAuthAccessor();
        accessor.tokenSecret = props.getProperty("tokenSecret");
        OAuthClient client = new OAuthClient(new HttpClient4());
        return client.invoke(accessor, "GET",  url, params);
    }

    public void execute(String operation) throws IOException, OAuthException,
            URISyntaxException
    {
        if ("request".equals(operation)){
            OAuthAccessor accessor = createOAuthAccessor();
	    OAuthClient client = new OAuthClient(new HttpClient4());
            client.getRequestToken(accessor);

            props.setProperty("requestToken", accessor.requestToken);
            props.setProperty("tokenSecret", accessor.tokenSecret);

            updateProperties("Last action: added requestToken");
            System.out.println(propFile.getCanonicalPath() + " updated");
        }
        else if ("access".equals(operation))
        {
            Properties paramProps = new Properties();
            paramProps.setProperty("oauth_token",
                    props.getProperty("requestToken"));

            OAuthMessage response 
		= sendRequest(paramProps, props.getProperty("accessUrl"));

            props.setProperty("accessToken",
                    response.getParameter("oauth_token"));
            props.setProperty("tokenSecret", 
			      response.getParameter("oauth_token_secret"));
            props.setProperty("userId", response.getParameter("user_id"));


            updateProperties("Last action: added accessToken");
            System.out.println(propFile.getCanonicalPath() + " updated");
        }
        else if ("authorize".equals(operation))
        {
            // just print the redirect
            Properties paramProps = new Properties();
            paramProps.setProperty("application_name",
                    props.getProperty("appName"));
            paramProps.setProperty("oauth_token",
                    props.getProperty("requestToken"));

            OAuthAccessor accessor = createOAuthAccessor();

            OAuthMessage response = sendRequest(paramProps,
                accessor.consumer.serviceProvider.userAuthorizationURL);

            System.out.println("Paste this in a browser:");
            System.out.println(response.URL);
        } else {
            // access the resource
            Properties paramProps = new Properties();
            paramProps.setProperty("oauth_token",
                    props.getProperty("accessToken"));

            OAuthMessage response = sendRequest(paramProps, operation);
            System.out.println(response.readBodyAsString());
        }

    }
}

