package com.isobar.isohealth.wrappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.GeneralMeasurement;
import com.isobar.isohealth.models.GeneralMeasurementFeed;
import com.isobar.isohealth.models.NewGeneralMeasurement;
import com.isobar.isohealth.models.User;

public class GeneralMeasurementWrapper {

	private String authToken;

	public GeneralMeasurementWrapper(String authToken) {
		super();
		this.authToken = authToken;
	}

	public GeneralMeasurementFeed getGeneralMeasurementFeed() throws Exception {
		User user = new UserWrapper(authToken).getUser();
		ObjectMapper mapper = new ObjectMapper();
		String url = GraphConstants.REST_URL + user.getGeneral_measurements();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestProperty("Accept",
				GraphConstants.MEDIA_GENERAL_MEASUREMENT_FEED);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		GeneralMeasurementFeed generalMeasurementFeed = mapper.readValue(rd,
				GeneralMeasurementFeed.class);
		conn.disconnect();
		return generalMeasurementFeed;
	}

	public GeneralMeasurement getGeneralMeasurement(String url)
			throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		url = GraphConstants.REST_URL + url;
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestProperty("Accept",
				GraphConstants.MEDIA_GENERAL_MEASUREMENT);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		GeneralMeasurement generalMeasurement = mapper.readValue(rd,
				GeneralMeasurement.class);
		conn.disconnect();
		return generalMeasurement;
	}

	public GeneralMeasurement updateGeneralMeasurement(
			GeneralMeasurement generalMeasurement) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String url = GraphConstants.REST_URL + generalMeasurement.getUri();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_GENERAL_MEASUREMENT);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);
		conn.setRequestProperty("Content-Length", "nnn");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		mapper.writeValue(conn.getOutputStream(), generalMeasurement);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		generalMeasurement = mapper.readValue(rd, GeneralMeasurement.class);
		conn.disconnect();
		return generalMeasurement;
	}

	public void createGeneralMeasurement(
			NewGeneralMeasurement generalMeasurement) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		User user = new UserWrapper(authToken).getUser();
		String url = GraphConstants.REST_URL + user.getGeneral_measurements();
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				GraphConstants.MEDIA_NEW_GENERAL_MEASUREMENT);
		conn.setRequestProperty("Authorization", "Bearer " + authToken);
		conn.setRequestProperty("Content-Length", "nnn");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		mapper.writeValue(conn.getOutputStream(), generalMeasurement);
		
		if (conn.getResponseCode() != 201) {
			throw new IOException(conn.getResponseMessage());
		}
		conn.disconnect();
	}
}
