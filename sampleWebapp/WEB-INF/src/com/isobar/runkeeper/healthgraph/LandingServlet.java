package com.isobar.runkeeper.healthgraph;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

public class LandingServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";
    private static final String AUTHORIZATION_CODE = "authorization_code";
    private static final String ENCODING = "UTF-8";
    private static final String CLIENT_ID = "d7f3c024de2240febd9ac5b97ba4731a";
    private static final String CLIENT_SECRET = "b1c9738d8e354f9699fb17557e64470e";
//    private static final String REDIRECT_URL = "https://runkeeper.com/apps/authorize?client_id=d7f3c024de2240febd9ac5b97ba4731a&response_type=code&redirect_uri=http://localhost:8080/sampleWebapp/landing.html";
    private static final String REDIRECT_URL = "http://localhost:8080/sampleWebapp/landing.html";
    private static final String userInfoUrl = "http://localhost:8080/sampleWebapp/userInfo.html";
    
    public void doGet(HttpServletRequest request,
		       HttpServletResponse response) throws ServletException,
		       IOException {
    	String authorizationCodeValue = "";
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.print("<h2>Target's output</h2><p /><pre><code>");
	
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()){
		    String param = e.nextElement();
		    authorizationCodeValue = request.getParameter(param);
		    out.println("param=" + param + " authorizationCodeValue=" + authorizationCodeValue);
		}
		out.print("</code></pre>");
		
		/////////////////////////////////////////
		
		response.setContentType(CONTENT_TYPE);

		URL		 url;
		URLConnection    urlConn;
		DataOutputStream cgiInput;

		// URL of target page script.
//		url = new URL("http://localhost:8086/servlet/Target");
//		url = new URL("http://localhost:8080/sampleWebapp/target.html");
		String urlText = "https://runkeeper.com/apps/token";
		url = new URL(urlText);
		System.out.println(urlText);
		urlConn = url.openConnection();

		urlConn.setDoInput(true);
		urlConn.setDoOutput(true);
		urlConn.setUseCaches(false);
		urlConn.setRequestProperty("Content-Type", 
					   "application/x-www-form-urlencoded");

		// Send POST output.
		cgiInput = new DataOutputStream(urlConn.getOutputStream());

//		String content = "param1=" + URLEncoder.encode("first parameter") 
//				 + "&param2=" 
//				 + URLEncoder.encode("the second one...");
		
		String content = "grant_type=" + URLEncoder.encode(AUTHORIZATION_CODE, ENCODING) 
				 + "&code=" 
				 + URLEncoder.encode(authorizationCodeValue, ENCODING)
				 + "&client_id="
				 + URLEncoder.encode(CLIENT_ID, ENCODING)
				 + "&client_secret="
				 + URLEncoder.encode(CLIENT_SECRET, ENCODING)
				 + "&redirect_uri="
				 + URLEncoder.encode(REDIRECT_URL, ENCODING);
	
		System.out.println("Landing:"+content);
		cgiInput.writeBytes(content);
		cgiInput.flush();
		cgiInput.close();

		// reads the CGI response and print it inside the servlet content
		BufferedReader cgiOutput = 
		    new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		PrintWriter    servletOutput = response.getWriter();        
		servletOutput.print("<html><body><h1>This is the Token Servlet</h1><p />");
		String line = null;
		while (null != (line = cgiOutput.readLine())){
		    servletOutput.println(line);
		}
		cgiOutput.close();
		servletOutput.print("<a href='"+userInfoUrl+"' target=\"_blank\">Click to view user info</a>");
		servletOutput.print("</body></html>");
		servletOutput.close();
    }
    
//    public void doPost(HttpServletRequest request,
//		       HttpServletResponse response) throws ServletException,
//		       IOException {
//		response.setContentType(CONTENT_TYPE);
//		PrintWriter out = response.getWriter();
//		out.print("<h2>Target's output</h2><p /><pre><code>");
//	
//		Enumeration<String> e = request.getParameterNames();
//		while (e.hasMoreElements()){
//		    String param = e.nextElement();
//		    String value = request.getParameter(param);
//		    out.println("param=" + param + " value=" + value);
//		}
//		out.print("</code></pre>");
// 	}
}
