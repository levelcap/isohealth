package com.isobar.isohealth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.isobar.isohealth.models.User;

public class UserService {
	public static User getUser(String code) throws Exception {
		ObjectMapper mapper = new ObjectMapper(); 
		code = "75fe669b6c1b4486ae35ffb15768ed43";
		HttpURLConnection conn  = (HttpURLConnection) new URL("https://api.runkeeper.com/user").openConnection();
		conn.setRequestProperty("Accept", "application/vnd.com.runkeeper.User+json");
		conn.setRequestProperty("Authorization", "Bearer " + code);

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		User user = mapper.readValue(rd, User.class);
		rd.close();
		conn.disconnect();
		return user;
	}
	
	public static void main(String[] args) throws Exception {
		getUser("75fe669b6c1b4486ae35ffb15768ed43");
	}
}