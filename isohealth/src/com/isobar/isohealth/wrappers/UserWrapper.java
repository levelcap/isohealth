package com.isobar.isohealth.wrappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.User;

public class UserWrapper {
	private String authToken;
	
	public UserWrapper(String authToken) {
		this.authToken = authToken;
	}
	
	public User getUser() throws Exception {
		ObjectMapper mapper = new ObjectMapper(); 
		String url = GraphConstants.REST_URL + "/user";
		HttpURLConnection conn  = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestProperty("Accept", GraphConstants.MEDIA_USER);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		User user = mapper.readValue(rd, User.class);
		conn.disconnect();
		return user;
	}
}