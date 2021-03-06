package com.isobar.isohealth.wrappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.NewNutritionMeasurement;
import com.isobar.isohealth.models.NutritionMeasurement;
import com.isobar.isohealth.models.NutritionMeasurementFeed;
import com.isobar.isohealth.models.User;

public class NutritionMeasurementWrapper {
	private String authToken;

	public NutritionMeasurementWrapper(String authToken) {
		super();
		this.authToken = authToken;
	}
	
	public NutritionMeasurementFeed getNutritionMeasurementFeed() throws Exception {
		User user = new UserWrapper(authToken).getUser();
		ObjectMapper mapper = new ObjectMapper(); 
		String url = GraphConstants.REST_URL + user.getNutrition();
		HttpURLConnection conn  = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestProperty("Accept", GraphConstants.MEDIA_NUTRITION_MEASUREMENT_FEED);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		NutritionMeasurementFeed nutritionMeasurementFeed = mapper.readValue(rd, NutritionMeasurementFeed.class);
		conn.disconnect();
		return nutritionMeasurementFeed;
	}

	public NutritionMeasurement getNutritionMeasurement(String url) throws Exception {
		ObjectMapper mapper = new ObjectMapper(); 
		url = GraphConstants.REST_URL + url;
		HttpURLConnection conn  = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestProperty("Accept", GraphConstants.MEDIA_NUTRITION_MEASUREMENT);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		NutritionMeasurement nutritionMeasurement = mapper.readValue(rd, NutritionMeasurement.class);
		conn.disconnect();
		return nutritionMeasurement;
	}	

	public NutritionMeasurement updateNutritionMeasurement(NutritionMeasurement nutritionMeasurement) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String url = GraphConstants.REST_URL + nutritionMeasurement.getUri();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_NUTRITION_MEASUREMENT);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);
		conn.setRequestProperty("Content-Length", "nnn");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		mapper.writeValue(conn.getOutputStream(), nutritionMeasurement);
		
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		nutritionMeasurement = mapper.readValue(rd, NutritionMeasurement.class);
		conn.disconnect();
		return nutritionMeasurement;
	}
	
	public void createNutritionMeasurement(
			NewNutritionMeasurement nutritionMeasurement) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		User user = new UserWrapper(authToken).getUser();
		String url = GraphConstants.REST_URL
				+ user.getNutrition();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_NEW_NUTRITION_MEASUREMENT);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);
		conn.setRequestProperty("Content-Length", "nnn");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		mapper.writeValue(conn.getOutputStream(), nutritionMeasurement);
		
		if (conn.getResponseCode() != 201) {
			throw new IOException(conn.getResponseMessage());
		}
		conn.disconnect();
	}
}
