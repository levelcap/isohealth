package com.isobar.runkeeper.healthgraph;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class UserInfoServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";

    public void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, 
		      IOException {
	response.setContentType(CONTENT_TYPE);

	URL		 url;
	URLConnection    urlConn;
	DataOutputStream cgiInput;

	// URL of target page script.
//	url = new URL("http://localhost:8086/servlet/Target");
	url = new URL("http://api.runkeeper.com/user \"Accept: application/vnd.com.runkeeper.User+json\" \"Authorization: Bearer 2558adf5d4e54e92afa7c628f1e45535\"");
	urlConn = url.openConnection();

	urlConn.setDoInput(true);
	urlConn.setDoOutput(true);
	urlConn.setUseCaches(false);
	
//	urlConn.setRequestProperty("Authorization", 
//			   "Bearer 2558adf5d4e54e92afa7c628f1e45535");//2558adf5d4e54e92afa7c628f1e45535
	urlConn.setRequestProperty("Content-Type", 
			   "application/vnd.com.runkeeper.User+json");

	// Send POST output.
//	cgiInput = new DataOutputStream(urlConn.getOutputStream());
//
//	String content = "token_type=" + URLEncoder.encode("Bearer", "UTF-8") 
//			 + "&access_token=" 
//			 + URLEncoder.encode("2558adf5d4e54e92afa7c628f1e45535", "UTF-8");
//
//	cgiInput.writeBytes(content);
//	cgiInput.flush();
//	cgiInput.close();

	// reads the CGI response and print it inside the servlet content
	BufferedReader cgiOutput = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
	PrintWriter    servletOutput = response.getWriter();        
	servletOutput.print("<html><body><h1>This is the User Servlet</h1><p />");
	String line = null;
	while (null != (line = cgiOutput.readLine())){
	    servletOutput.println(line);
	    System.out.println(line);
	}
	cgiOutput.close();
	servletOutput.print("</body></html>");
	servletOutput.close();
    }
}
