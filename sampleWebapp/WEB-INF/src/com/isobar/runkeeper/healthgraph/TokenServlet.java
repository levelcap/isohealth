package com.isobar.runkeeper.healthgraph;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class TokenServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";

    public void doPost(HttpServletRequest request,
		       HttpServletResponse response) throws ServletException,
		       IOException {
	response.setContentType(CONTENT_TYPE);
	PrintWriter out = response.getWriter();
	out.print("<h2>Target's output</h2><p /><pre><code>");

	Enumeration<String> e = request.getParameterNames();
	while (e.hasMoreElements()){
	    String param = e.nextElement();
	    String value = request.getParameter(param);
	    out.println("param=" + param + " value=" + value);
	}
	out.print("</code></pre>");
    }
}
