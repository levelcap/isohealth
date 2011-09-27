package com.isobar.isohealth.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.FitnessActivity;
import com.isobar.isohealth.models.FitnessActivityFeed;
import com.isobar.isohealth.models.NewFitnessActivity;
import com.isobar.isohealth.models.User;

public class FitnessActivityService {
	public static FitnessActivityFeed getFitnessActivityFeed(String code) throws Exception {
		//User object contains URLs
		User user = UserService.getUser(code);
		ObjectMapper mapper = new ObjectMapper(); 
		String url = GraphConstants.REST_URL + user.getFitness_activities();
		HttpURLConnection conn  = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestProperty("Accept", GraphConstants.MEDIA_FITNESS_ACTIVITY_FEED);
		conn.setRequestProperty("Authorization", "Bearer " + code);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		FitnessActivityFeed fitnessActivityFeed = mapper.readValue(rd, FitnessActivityFeed.class);
		conn.disconnect();
		return fitnessActivityFeed;
	}
	
	public static FitnessActivity getFitnessActivity(String url, String code) throws Exception {
		ObjectMapper mapper = new ObjectMapper(); 
		url = GraphConstants.REST_URL + url;
		HttpURLConnection conn  = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestProperty("Accept", GraphConstants.MEDIA_FITNESS_ACTIVITY);
		conn.setRequestProperty("Authorization", "Bearer " + code);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		FitnessActivity fitnessActivity = mapper.readValue(rd, FitnessActivity.class);
		conn.disconnect();
		return fitnessActivity;
	}	
	
	public static FitnessActivity updateFitnessActivity(FitnessActivity activity, String code) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String url = GraphConstants.REST_URL + activity.getUri();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_FITNESS_ACTIVITY);
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
		activity = mapper.readValue(rd, FitnessActivity.class);
		conn.disconnect();
		return activity;
	}
	
	public static void createFitnessActivity(
			NewFitnessActivity activity, String code) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		User user = UserService.getUser(code);
		String url = GraphConstants.REST_URL
				+ user.getFitness_activities();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_NEW_FITNESS_ACTIVITY);
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
	
	public static void deleteFitnessActivity(String url, String code) throws Exception {
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
