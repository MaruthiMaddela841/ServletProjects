package in.ineuron.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter  implements Filter {
       
	private FilterConfig fConfig=null;
	static {
		System.out.println("LogFilter .class file is loading...");
	}
	
	public LogFilter() {
		System.out.println("LogFilter object is Instantiated...");
	}
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig=fConfig;
		System.out.println("LogFilter object is Initialized...");
	}
	
	public void destroy() {
		System.out.println("LogFilter is De-Initialized...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		out.println("<h1>Log Filter Before Processing</h1>");
		ServletContext context=fConfig.getServletContext();
		HttpServletRequest req=(HttpServletRequest)request;
		context.log("A request is coming from: "+request.getRemoteHost()+" for URL: "+req.getRequestURL()+" at "+new Date());
		chain.doFilter(request, response);
		out.println("<h1>Log Filter After Processing</h1>");
	}

}
