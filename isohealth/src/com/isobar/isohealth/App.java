package com.isobar.isohealth;

import net.smartam.leeloo.client.OAuthClient;
import net.smartam.leeloo.client.URLConnectionClient;
import net.smartam.leeloo.client.request.OAuthClientRequest;
import net.smartam.leeloo.client.response.OAuthJSONAccessTokenResponse;
import net.smartam.leeloo.common.exception.OAuthProblemException;
import net.smartam.leeloo.common.exception.OAuthSystemException;
import net.smartam.leeloo.common.message.types.GrantType;

/**
 * Hello world!
 * 
 */
public class App {
	
	public static void main(String[] args) {
		try {
			OAuthClientRequest request = OAuthClientRequest
					.authorizationLocation(GraphConstants.AUTH_URL)
					.setClientId(GraphConstants.CLIENT_ID)
					.setRedirectURI(GraphConstants.REDIRECT_URI)
					.buildQueryMessage();

			String url = request.getLocationUri() + "&response_type=code";

			String code = "ce68e782da374cd4b90cf005eba5e0cf";

			System.out.println(url);

			request = OAuthClientRequest
					.tokenLocation(
							GraphConstants.ACCESS_URL)
					.setGrantType(GrantType.AUTHORIZATION_CODE)
					.setClientId(GraphConstants.CLIENT_ID)
					.setClientSecret(GraphConstants.CLIENT_SECRET)
					.setRedirectURI(GraphConstants.REDIRECT_URI)
					.setCode(code).buildBodyMessage();

			// create OAuth client that uses custom http client under the hood
			OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
			
			OAuthJSONAccessTokenResponse response = oAuthClient.accessToken(request);
			
            String accessToken = response.getAccessToken();
            String expiresIn = response.getExpiresIn();
            
            System.out.println("Access Token: " + accessToken + " will expire in " + expiresIn);
			
		} catch (OAuthSystemException e) {
			System.out.print("NOOOOO: " + e.getMessage());
		} catch (OAuthProblemException e) {
			e.printStackTrace();
		}

	}
}
