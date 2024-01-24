package in.ineuron.filters;

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
		System.out.println("DemoFilter .class is loading....");
	}
    public DemoFilter() {
        System.out.println("DemoFilter Object is Instantiated....");
        
    }

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Demo Filter is Initialized...");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		out.println("<h1>Before Processing the Request</h1>");
		chain.doFilter(request, response);
		out.println("<h1>After Processing the Request</h1>");
		out.close();
	}
	public void destroy() {
		System.out.println("Demo Filter is De-Instantiated...");
	}

}
