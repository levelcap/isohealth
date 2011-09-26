package com.isobar.isohealth;

import net.smartam.leeloo.client.request.OAuthClientRequest;
import net.smartam.leeloo.common.exception.OAuthSystemException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/oauth")
public class OAuthController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public String oauth() {
		try {
			OAuthClientRequest request = OAuthClientRequest
					.authorizationLocation(GraphConstants.AUTH_URL)
					.setClientId(GraphConstants.CLIENT_ID)
					.setRedirectURI(GraphConstants.REDIRECT_URI)
					.buildQueryMessage();
			
			String url = request.getLocationUri() + "&response_type=code";

			System.out.println(url);
		} catch (OAuthSystemException e) {
			System.out.print("NOOOOO: " + e.getMessage());
		}

		return null;
	}
}