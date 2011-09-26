package com.isobar.runkeeper.healthgraph;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.smartam.leeloo.client.request.OAuthClientRequest;

public class RegisterUser extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html";
	private static final String RESPONSE_TYPE = "code";


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
		OAuthClientRequest oRequest = OAuthClientRequest
				.authorizationLocation(GraphConstants.AUTH_URL)
				.setClientId(GraphConstants.CLIENT_ID)
				.setRedirectURI(GraphConstants.REDIRECT_URI)
				.buildQueryMessage();

		response.setContentType(CONTENT_TYPE);

		URL url;
		URLConnection urlConn;
		DataOutputStream cgiInput;

		String urlText = oRequest.getLocationUri();
		url = new URL(urlText);
		System.out.println(urlText);
		urlConn = url.openConnection();

		urlConn.setDoInput(true);
		urlConn.setDoOutput(true);
		urlConn.setUseCaches(false);
		urlConn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		// reads the CGI response and print it inside the servlet content
		BufferedReader cgiOutput = new BufferedReader(new InputStreamReader(
				urlConn.getInputStream()));
		PrintWriter servletOutput = response.getWriter();
		servletOutput
				.print("<html><body><h1>This is the Source Servlet</h1><p />");

		servletOutput.print("<a href='" + urlText
				+ "' target=\"_blank\">Click to authorize app</a>");
		servletOutput.print("</body></html>");
		servletOutput.close();
		}
		catch (Exception e) {
			System.out.println("ZUH OH: " + e.getMessage());
		}
	}
}
