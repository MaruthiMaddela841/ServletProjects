package in.ineuron.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter {

	static {
		System.out.println("DemoFilter .class file is loading...");
	}
	
	public DemoFilter() {
		System.out.println("DemoFilter object is Instantiated...");
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("DemoFilter object is Initialized...");
	}
	
	public void destroy() {
		System.out.println("DemoFilter is De-Initialized...");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		out.println("<h1>Demo Filter Before Processing</h1>");
		chain.doFilter(request, response);
		out.println("<h1>Demo Filter After Processing</h1>");
	}

	
	

}
