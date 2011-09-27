package com.isobar.isohealth.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.NewStrengthTrainingActivity;
import com.isobar.isohealth.models.StrengthTrainingActivity;
import com.isobar.isohealth.models.StrengthTrainingActivityFeed;
import com.isobar.isohealth.models.User;

public class StrengthTrainingActivityService {
	public static StrengthTrainingActivityFeed getStrengthTrainingActivityFeed(
			String code) throws Exception {
		// User object contains URLs
		User user = UserService.getUser(code);
		ObjectMapper mapper = new ObjectMapper();
		String url = GraphConstants.REST_URL
				+ user.getStrength_training_activities();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestProperty("Accept",
				GraphConstants.MEDIA_STRENGTH_TRAINING_ACTIVITY_FEED);
		conn.setRequestProperty("Authorization", "Bearer " + code);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		StrengthTrainingActivityFeed strengthTrainingActivityFeed = mapper
				.readValue(rd, StrengthTrainingActivityFeed.class);
		conn.disconnect();
		return strengthTrainingActivityFeed;
	}

	public static StrengthTrainingActivity getStrengthTrainingActivity(
			String url, String code) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		url = GraphConstants.REST_URL + url;
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestProperty("Accept",
				GraphConstants.MEDIA_STRENGTH_TRAINING_ACTIVITY);
		conn.setRequestProperty("Authorization", "Bearer " + code);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		StrengthTrainingActivity strengthTrainingActivity = mapper.readValue(
				rd, StrengthTrainingActivity.class);
		conn.disconnect();
		return strengthTrainingActivity;
	}

	public static StrengthTrainingActivity updateStrengthTrainingActivity(StrengthTrainingActivity activity, String code) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String url = GraphConstants.REST_URL + activity.getUri();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_STRENGTH_TRAINING_ACTIVITY);
		conn.setRequestProperty("Authorization", "Bearer " + code);
		conn.setRequestProperty("Content-Length", "nnn");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);;

		mapper.writeValue(conn.getOutputStream(), activity);
		
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		activity = mapper.readValue(rd, StrengthTrainingActivity.class);
		conn.disconnect();
		return activity;
	}
	
	public static void createStrengthTrainingActivity(
			NewStrengthTrainingActivity activity, String code) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		User user = UserService.getUser(code);
		String url = GraphConstants.REST_URL
				+ user.getStrength_training_activities();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_NEW_STRENGTH_TRAINING_ACTIVITY);
		conn.setRequestProperty("Authorization", "Bearer " + code);
		conn.setRequestProperty("Content-Length", "nnn");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);;

		mapper.writeValue(conn.getOutputStream(), activity);
		
		if (conn.getResponseCode() != 201) {
			throw new IOException(conn.getResponseMessage());
		}
		conn.disconnect();
	}
	
	public static void deleteStrengthTrainingActivity(String url, String code) throws Exception {
		url = GraphConstants.REST_URL + url;
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Authorization", "Bearer " + code);
		
		if (conn.getResponseCode() != 204) {
			throw new IOException(conn.getResponseMessage());
		}
		conn.disconnect();
	}
}
