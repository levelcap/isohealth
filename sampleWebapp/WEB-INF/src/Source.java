import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Source extends HttpServlet {
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
	url = new URL("http://localhost:8080/sampleWebapp/target.html");
	urlConn = url.openConnection();

	urlConn.setDoInput(true);
	urlConn.setDoOutput(true);
	urlConn.setUseCaches(false);
	urlConn.setRequestProperty("Content-Type", 
				   "application/x-www-form-urlencoded");

	// Send POST output.
	cgiInput = new DataOutputStream(urlConn.getOutputStream());

//	String content = "param1=" + URLEncoder.encode("first parameter") 
//			 + "&param2=" 
//			 + URLEncoder.encode("the second one...");
	
	String content = "param1=" + URLEncoder.encode("first parameter", "UTF-8") 
			 + "&param2=" 
			 + URLEncoder.encode("the second one...", "UTF-8");

	cgiInput.writeBytes(content);
	cgiInput.flush();
	cgiInput.close();

	// reads the CGI response and print it inside the servlet content
	BufferedReader cgiOutput = 
	    new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
	PrintWriter    servletOutput = response.getWriter();        
	servletOutput.print("<html><body><h1>This is the Source Servlet</h1><p />");
	String line = null;
	while (null != (line = cgiOutput.readLine())){
	    servletOutput.println(line);
	}
	cgiOutput.close();
	servletOutput.print("</body></html>");
	servletOutput.close();
    }
}
