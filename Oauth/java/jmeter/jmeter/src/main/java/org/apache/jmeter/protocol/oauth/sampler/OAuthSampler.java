/****************************************************************************
 * Copyright (c) 1998-2010 AOL Inc. 
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
 *
 ****************************************************************************/

package org.apache.jmeter.protocol.oauth.sampler;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuth.Parameter;
import net.oauth.signature.OAuthSignatureMethod;
import net.oauth.signature.RSA_SHA1;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.HeadMethod;
import org.apache.commons.httpclient.methods.OptionsMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.TraceMethod;
import org.apache.jmeter.protocol.http.control.CacheManager;
import org.apache.jmeter.protocol.http.sampler.HTTPSampleResult;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler2;
import org.apache.jmeter.protocol.http.util.EncoderCache;
import org.apache.jmeter.protocol.http.util.HTTPArgument;
import org.apache.jmeter.testelement.property.PropertyIterator;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.jorphan.util.JOrphanUtils;
import org.apache.log.Logger;

/**
 * A sampler for OAuth request. It's based on HTTPSampler2 (HTTPClient).
 * This sampler adds OAuth signing to the request on the fly. Optionally,
 * it can also add OAuth parameters in Authorization header. 
 * 
 * <p/>It supports both HMAC-SHA1 and RSA-SHA1 algorithms. When RSA is
 * used, the private key in PEM format is needed. The file should be 
 * located in the same directory as test plan if relative directory is
 * given. PLAIN is not support since the request can be done with 
 * regular HTTP sampler.
 * 
 * <p/>This sampler supports all HTTP sampler features except multi-part
 * file post. Currently, OAuth only supports signing of form post. This 
 * may be supported in the future with OAuth body-signing extension.
 * 
 * <p/>Because OAuth returns 401 on error so it behaves like HTTP auth. 
 * There may be warinings in log file about unsupported HTTP auth schemes.
 * You can safely ignore these warnings.
 * 
 * @author zhang
 *   
 */
public class OAuthSampler extends HTTPSampler2 {

	private static final long serialVersionUID = -4557727434430190220L;
	private static final Logger log = LoggingManager.getLoggerForClass();
	
	// Parameter names
	public static final String KEY = "OAuthSampler.consumer_key"; //$NON-NLS-1$
	public static final String SECRET = "OAuthSampler.consumer_secret"; //$NON-NLS-1$
	public static final String USE_AUTH_HEADER = "OAuthSampler.use_auth_header"; //$NON-NLS-1$
	public static final String SIGNATURE_METHOD = "OAuthSampler.signature_method"; //$NON-NLS-1$
	public static final String TOKEN = "OAuthSampler.oauth_token"; //$NON-NLS-1$
	public static final String TOKEN_SECRET = "OAuthSampler.token_secret"; //$NON-NLS-1$
	public static final String URL_ENCODE = "OAuthSampler.url_encode"; //$NON-NLS-1$

	// Parameter vlaues
	public static final String HMAC = "HMAC-SHA1"; //$NON-NLS-1$
	public static final String RSA = "RSA-SHA1"; //$NON-NLS-1$	
	public static final String DEFAULT_METHOD = HMAC; 
    // Supported methods:
    public static final String [] METHODS = {
        DEFAULT_METHOD, // i.e. HMAC-SHA1
        RSA 
    };

    protected OAuthMessage message;
    protected boolean useAuthHeader;
    // When header is used, this contains remaining parameters to be sent
    protected List<Map.Entry<String, String>> nonOAuthParams = null;
 
    /**
	 * Constructor for the OAuthSampler object. The HTTP sampler factory
	 * is not used for this plugin.
     * 
	 */
	public OAuthSampler() {
		super();
	}

	/**
	 * Samples the URL passed in and stores the result in
	 * <code>HTTPSampleResult</code>, following redirects and downloading
	 * page resources as appropriate.
	 * <p>
	 * When getting a redirect target, redirects are not followed and resources
	 * are not downloaded. The caller will take care of this.
	 * 
	 * @param url
	 *            URL to sample
	 * @param method
	 *            HTTP method: GET, POST,...
	 * @param areFollowingRedirect
	 *            whether we're getting a redirect target
	 * @param frameDepth
	 *            Depth of this target in the frame structure. Used only to
	 *            prevent infinite recursion.
	 * @return results of the sampling
	 */
	protected HTTPSampleResult sample(URL url, String method, boolean areFollowingRedirect, int frameDepth) {

		String urlStr = url.toExternalForm();

		// Check if this is an entity-enclosing method
		boolean isPost = method.equals(POST) || method.equals(PUT);

		HTTPSampleResult res = new HTTPSampleResult();
		res.setMonitor(isMonitor());
        
		// Handles OAuth signing
		try {
			message = getOAuthMessage(url, method);

			urlStr = message.URL;

			if (isPost) {
				urlStr = message.URL;
			} else {
				if (useAuthHeader)
					urlStr = OAuth.addParameters(message.URL, nonOAuthParams);
				else
					urlStr = OAuth.addParameters(message.URL, message
							.getParameters());
			}
		} catch (IOException e) {
			res.sampleEnd();
			HTTPSampleResult err = errorResult(e, res);
			err.setSampleLabel("Error: " + url.toString()); //$NON-NLS-1$
			return err;		
		} catch (OAuthException e) {
			res.sampleEnd();
			HTTPSampleResult err = errorResult(e, res);
			err.setSampleLabel("Error: " + url.toString()); //$NON-NLS-1$
			return err;
		} catch (URISyntaxException e) {
			res.sampleEnd();
			HTTPSampleResult err = errorResult(e, res);
			err.setSampleLabel("Error: " + url.toString()); //$NON-NLS-1$
			return err;
		}
		
		log.debug("Start : sample " + urlStr); //$NON-NLS-1$
		log.debug("method " + method); //$NON-NLS-1$

        HttpMethodBase httpMethod = null;
		res.setSampleLabel(urlStr); // May be replaced later
        res.setHTTPMethod(method);
		res.sampleStart(); // Count the retries as well in the time
        HttpClient client = null;
        InputStream instream = null;

        try {
			// May generate IllegalArgumentException
			if (method.equals(POST)) {
			    httpMethod = new PostMethod(urlStr);
			} else if (method.equals(PUT)){
			    httpMethod = new PutMethod(urlStr);
			} else if (method.equals(HEAD)){
			    httpMethod = new HeadMethod(urlStr);
			} else if (method.equals(TRACE)){
			    httpMethod = new TraceMethod(urlStr);
			} else if (method.equals(OPTIONS)){
			    httpMethod = new OptionsMethod(urlStr);
			} else if (method.equals(DELETE)){
			    httpMethod = new DeleteMethod(urlStr);
			} else if (method.equals(GET)){
			    httpMethod = new GetMethod(urlStr);
			} else {
				log.error("Unexpected method (converted to GET): "+method); //$NON-NLS-1$
			    httpMethod = new GetMethod(urlStr);
			}
	
			// Set any default request headers
			setDefaultRequestHeaders(httpMethod);
            // Setup connection
			client = setupConnection(new URL(urlStr), httpMethod, res);
			// Handle POST and PUT
			if (isPost) {
				String postBody = sendPostData(httpMethod);
				res.setQueryString(postBody);
			}

            res.setRequestHeaders(getConnectionHeaders(httpMethod));

			int statusCode = client.executeMethod(httpMethod);

			// Request sent. Now get the response:
            instream = httpMethod.getResponseBodyAsStream();
            
            if (instream != null) {// will be null for HEAD
            
                Header responseHeader = httpMethod.getResponseHeader(HEADER_CONTENT_ENCODING);
                if (responseHeader!= null && ENCODING_GZIP.equals(responseHeader.getValue())) {
                    instream = new GZIPInputStream(instream);
                }
                res.setResponseData(readResponse(res, instream, (int) httpMethod.getResponseContentLength()));
            }
            
			res.sampleEnd();
			// Done with the sampling proper.

			// Now collect the results into the HTTPSampleResult:

			res.setSampleLabel(httpMethod.getURI().toString());
            // Pick up Actual path (after redirects)
            
			res.setResponseCode(Integer.toString(statusCode));
			res.setSuccessful(isSuccessCode(statusCode));

			res.setResponseMessage(httpMethod.getStatusText());

			String ct = null;
			org.apache.commons.httpclient.Header h 
                = httpMethod.getResponseHeader(HEADER_CONTENT_TYPE);
			if (h != null)// Can be missing, e.g. on redirect
			{
				ct = h.getValue();
				res.setContentType(ct);// e.g. text/html; charset=ISO-8859-1
                res.setEncodingAndType(ct);
			}

			res.setResponseHeaders(getResponseHeaders(httpMethod));
			if (res.isRedirect()) {
				final Header headerLocation = httpMethod.getResponseHeader(HEADER_LOCATION);
				if (headerLocation == null) { // HTTP protocol violation, but avoids NPE
					throw new IllegalArgumentException("Missing location header"); //$NON-NLS-1$
				}
				res.setRedirectLocation(headerLocation.getValue());
			}

            // If we redirected automatically, the URL may have changed
            if (getAutoRedirects()){
                res.setURL(new URL(httpMethod.getURI().toString()));
            }
            
			// Store any cookies received in the cookie manager:
			saveConnectionCookies(httpMethod, res.getURL(), getCookieManager());
			
			// Save cache information
            final CacheManager cacheManager = getCacheManager();
            if (cacheManager != null){
                cacheManager.saveDetails(httpMethod, res);
            }

			// Follow redirects and download page resources if appropriate:
			res = resultProcessing(areFollowingRedirect, frameDepth, res);

			log.debug("End : sample"); //$NON-NLS-1$
			httpMethod.releaseConnection();
			return res;
		} catch (IllegalArgumentException e)// e.g. some kinds of invalid URL
		{
			res.sampleEnd();
			HTTPSampleResult err = errorResult(e, res);
			err.setSampleLabel("Error: " + url.toString()); //$NON-NLS-1$
			return err;
		} catch (IOException e) {
			res.sampleEnd();
			HTTPSampleResult err = errorResult(e, res);
			err.setSampleLabel("Error: " + url.toString()); //$NON-NLS-1$
			return err;
		} finally {
            JOrphanUtils.closeQuietly(instream);
			if (httpMethod != null) {
				httpMethod.releaseConnection();
			}
		}
	}

	/**
	 * With OAuth, the query string has to be attached later after
	 * signing so empty string is returned here.
	 * 
	 */

	public String getQueryString(String contentEncoding) {
		return ""; //$NON-NLS-1$
	}

    
    /**
     * Add Authorization header if useAuthHeader is true.
     * 
     * @param httpMethod the HttpMethod used for the request
     */
	protected void setDefaultRequestHeaders(HttpMethod httpMethod) {

		if (!useAuthHeader)
			return;

		try {
			httpMethod.addRequestHeader("Authorization", message //$NON-NLS-1$
					.getAuthorizationHeader(null));

		} catch (IOException e) {
			log.error("Failed to set Authorization header: " + e.getMessage()); //$NON-NLS-1$
		}
	}


	
	/*
	 * Send POST data from <code>Entry</code> to the open connection.
	 * 
	 * @param connection
	 *            <code>URLConnection</code> where POST data should be sent
     * @return a String show what was posted. Will not contain actual file upload content
	 * @exception IOException
	 *                if an I/O exception occurs
	 */
	private String sendPostData(HttpMethod method) throws IOException {
 
		String form;
        
		if (useAuthHeader) {    
		    form = OAuth.formEncode(nonOAuthParams);
        } else {
        	form = OAuth.formEncode(message.getParameters());
        }

        method.addRequestHeader(HEADER_CONTENT_TYPE, OAuth.FORM_ENCODED);
        method.addRequestHeader(HEADER_CONTENT_LENGTH, form.length() + ""); //$NON-NLS-1$
       
        if (method instanceof PostMethod || method instanceof PutMethod) {

        	StringRequestEntity requestEntity = new StringRequestEntity(
            		form, OAuth.FORM_ENCODED, OAuth.ENCODING);
            
            ((EntityEnclosingMethod)method).setRequestEntity(requestEntity);
        } else {
        	log.error("Logic error, method must be POST or PUT to send body"); //$NON-NLS-1$
        }
        
        return form;     
	}
	
	/**
	 * Create OAuth message. The message contains all HTTP arguments and
	 * OAuth parameters and the signature.
	 * 
	 * @param url
	 * @param method
	 * @return
	 * @throws IOException
	 * @throws OAuthException
	 * @throws URISyntaxException
	 */
    protected OAuthMessage getOAuthMessage(URL url, String method) 
    	throws IOException, OAuthException, URISyntaxException {
 
		useAuthHeader = getPropertyAsBoolean(USE_AUTH_HEADER);
		
    	// Get OAuth accessor
	    
    	String consumerKey = getPropertyAsString(KEY);   	
    	String signatureMethod = getPropertyAsString(SIGNATURE_METHOD);
    	String secretOrKey = getPropertyAsString(SECRET);
          	
		final OAuthConsumer consumer;
    	if (RSA.equals(signatureMethod)) {  		
    		consumer = new OAuthConsumer(null, consumerKey, null, null);
    		PrivateKeyReader reader = new PrivateKeyReader(secretOrKey);
    		PrivateKey key = reader.getPrivateKey();    
    		consumer.setProperty(RSA_SHA1.PRIVATE_KEY, key);   		    
    	} else {
       		consumer = new OAuthConsumer(null, consumerKey, secretOrKey, null);
    	}
		
	    final OAuthAccessor accessor = new OAuthAccessor(consumer);
	    accessor.accessToken = getDecodedProperty(TOKEN);
	    accessor.tokenSecret = getDecodedProperty(TOKEN_SECRET);

    	// Convert arguments to OAuth parameters, URL-decoded if already encoded.
	    List<OAuth.Parameter> list = 
	    	new ArrayList<OAuth.Parameter>(getArguments().getArgumentCount());
	    
		PropertyIterator args = getArguments().iterator();
		while (args.hasNext()) {
			HTTPArgument arg = (HTTPArgument) args.next().getObjectValue();
			String parameterName = arg.getName();
			String parameterValue = arg.getValue();
			if (!arg.isAlwaysEncoded()) {
                String urlContentEncoding = getContentEncoding();
                if(urlContentEncoding == null || urlContentEncoding.length() == 0) {
                    // Use the default encoding for urls 
                    urlContentEncoding = EncoderCache.URL_ARGUMENT_ENCODING;
                }
				parameterName = URLDecoder.decode(parameterName,
						urlContentEncoding);
				parameterValue = URLDecoder.decode(parameterValue,
						urlContentEncoding);
			}
			
		   	list.add(new Parameter(parameterName, parameterValue));
		}

    	OAuthMessage message = new OAuthMessage(method, url.toExternalForm(), list);
	    
	    message.addParameter(OAuth.OAUTH_SIGNATURE_METHOD,
	    		getPropertyAsString(SIGNATURE_METHOD));
	    
	    if (accessor.accessToken != null && accessor.accessToken.length() > 0)
	    	message.addParameter(OAuth.OAUTH_TOKEN, accessor.accessToken);
	    
    	// Sign the message
    	message.addRequiredParameters(accessor);

    	if (log.isDebugEnabled()) {
    		String baseString = OAuthSignatureMethod.getBaseString(message);  
    		log.debug("OAuth base string : '" + baseString + "'");  //$NON-NLS-1$//$NON-NLS-2$
    		// It's probably ok to expose token secret 
    		log.debug("OAuth token secret : '" + accessor.tokenSecret + "'");  //$NON-NLS-1$//$NON-NLS-2$
    	}
 
    	if (useAuthHeader) {
			// Find the non-OAuth parameters:
			List<Map.Entry<String, String>> others = message.getParameters();
			if (others != null && !others.isEmpty()) {
				nonOAuthParams = new ArrayList<Map.Entry<String, String>>(
						others);
				for (Iterator<Map.Entry<String, String>> p = nonOAuthParams
						.iterator(); p.hasNext();) {
					if (p.next().getKey().startsWith("oauth_")) { //$NON-NLS-1$
						p.remove();
					}
				}
			}
    	}

    	return message;
    }
    
    /**
     * Get property as string. If "Encode?" is not checked,
     * the property is decoded to prevent double-encoding.
     * 
     * @param name Parameter name
     * @return
     */
    private String getDecodedProperty(String name) {

    	String raw = getPropertyAsString(name);
    	
    	if (getPropertyAsBoolean(URL_ENCODE))
    		return raw;
    	
    	/* 
    	 * If the parameters doesn't need URL encode, which means
    	 * it's already encoded. It should be decoded.
    	 */
 			
        String urlContentEncoding = getContentEncoding();
        if(urlContentEncoding == null || urlContentEncoding.length() == 0) {
                // Use the default encoding for urls 
                urlContentEncoding = EncoderCache.URL_ARGUMENT_ENCODING;
        }
			
        try {
			return URLDecoder.decode(raw, urlContentEncoding);
		} catch (UnsupportedEncodingException e) {
			log.error("Unsupported encoding: " + e.getMessage()); //$NON-NLS-1$
			// Just return raw string
			return raw;
		}
    }
}
