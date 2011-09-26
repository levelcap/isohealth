package com.isobar.isohealth.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.FitnessActivityFeed;
import com.isobar.isohealth.models.User;

public class FitnessActivityFeedService {
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
}
