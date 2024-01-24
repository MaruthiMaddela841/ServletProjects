package in.ineuron.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import in.ineuron.customizedrequest.CustomizedRequest;

public class AlterWordFilter implements Filter {
       
    public AlterWordFilter() {
       
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hr=(HttpServletRequest)request;
		CustomizedRequest cr= new CustomizedRequest(hr);
		chain.doFilter(cr, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
