package com.isobar.isohealth.wrappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.Profile;
import com.isobar.isohealth.models.User;

public class ProfileWrapper {
	private String authToken;
	
	public ProfileWrapper(String authToken) {
		this.authToken = authToken;
	}

	public Profile getProfile() throws Exception {
		//User object contains URLs
		User user = new UserWrapper(authToken).getUser();
		ObjectMapper mapper = new ObjectMapper(); 
		String url = GraphConstants.REST_URL + user.getProfile();
		HttpURLConnection conn  = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestProperty("Accept", GraphConstants.MEDIA_PROFILE);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		Profile profile = mapper.readValue(rd, Profile.class);
		conn.disconnect();
		return profile;
	}
	
	public Profile updateProfile(Profile profile) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		User user = new UserWrapper(authToken).getUser();
		String url = GraphConstants.REST_URL + user.getProfile();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_PROFILE);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);
		conn.setRequestProperty("Content-Length", "nnn");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);;

		mapper.writeValue(conn.getOutputStream(), profile);
		
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		profile = mapper.readValue(rd, Profile.class);
		conn.disconnect();
		return profile;
	}	
}
