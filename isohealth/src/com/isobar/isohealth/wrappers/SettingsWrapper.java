package com.isobar.isohealth.wrappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.Settings;
import com.isobar.isohealth.models.User;

public class SettingsWrapper {
	private String authToken;
	
	public SettingsWrapper(String authToken) {
		this.authToken = authToken;
	}
	
	public Settings getSettings() throws Exception {
		//User object contains URLs
		User user = new UserWrapper(authToken).getUser();
		ObjectMapper mapper = new ObjectMapper(); 
		String url = GraphConstants.REST_URL + user.getSettings();
		HttpURLConnection conn  = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestProperty("Accept", GraphConstants.MEDIA_SETTINGS);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		Settings settings = mapper.readValue(rd, Settings.class);
		conn.disconnect();
		return settings;
	}
	
	public Settings updateProfile(Settings settings) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		User user = new UserWrapper(authToken).getUser();
		String url = GraphConstants.REST_URL + user.getSettings();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_SETTINGS);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);
		conn.setRequestProperty("Content-Length", "nnn");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);;

		mapper.writeValue(conn.getOutputStream(), settings);
		
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		settings = mapper.readValue(rd, Settings.class);
		conn.disconnect();
		return settings;
	}		
}
