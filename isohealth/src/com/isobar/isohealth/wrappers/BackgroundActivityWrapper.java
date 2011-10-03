package com.isobar.isohealth.wrappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.BackgroundActivity;
import com.isobar.isohealth.models.BackgroundActivityFeed;
import com.isobar.isohealth.models.NewBackgroundActivity;
import com.isobar.isohealth.models.User;

public class BackgroundActivityWrapper {
	private String authToken;

	public BackgroundActivityWrapper(String authToken) {
		this.authToken = authToken;
	}

	public BackgroundActivityFeed getBackgroundActivityFeed() throws Exception {
		// User object contains URLs
		User user = new UserWrapper(authToken).getUser();
		ObjectMapper mapper = new ObjectMapper();
		String url = GraphConstants.REST_URL + user.getBackground_activities();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestProperty("Accept",
				GraphConstants.MEDIA_BACKGROUND_ACTIVITY_FEED);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		BackgroundActivityFeed backgroundActivityFeed = mapper.readValue(rd,
				BackgroundActivityFeed.class);
		conn.disconnect();
		return backgroundActivityFeed;
	}

	public BackgroundActivity getBackgroundActivity(String url)
			throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		url = GraphConstants.REST_URL + url;
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestProperty("Accept",
				GraphConstants.MEDIA_BACKGROUND_ACTIVITY);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		BackgroundActivity backgroundActivity = mapper.readValue(rd,
				BackgroundActivity.class);
		conn.disconnect();
		return backgroundActivity;
	}

	public BackgroundActivity updateBackgroundActivity(BackgroundActivity activity) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String url = GraphConstants.REST_URL + activity.getUri();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_BACKGROUND_ACTIVITY);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);
		conn.setRequestProperty("Content-Length", "nnn");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		;

		mapper.writeValue(conn.getOutputStream(), activity);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		activity = mapper.readValue(rd, BackgroundActivity.class);
		conn.disconnect();
		return activity;
	}

	public void createBackgroundActivity(NewBackgroundActivity activity)
			throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		User user = new UserWrapper(authToken).getUser();
		String url = GraphConstants.REST_URL + user.getBackground_activities();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_NEW_BACKGROUND_ACTIVITY);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);
		conn.setRequestProperty("Content-Length", "nnn");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		;

		mapper.writeValue(conn.getOutputStream(), activity);

		if (conn.getResponseCode() != 201) {
			throw new IOException(conn.getResponseMessage());
		}
		conn.disconnect();
	}
}
