package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("TargetServlet .class file is loading...");
	}
	public TargetServlet() {
		System.out.println("TargetServlet object is Instantiated...");
	}
	
	@Override
	public void init() throws ServletException{
		System.out.println("TargetServlet object is Initialized...");
	}
	
	@Override
	public void destroy() {
		System.out.println("TargetServlet is De-Initialized...");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<h1>Target Servlet</h1>");
	}

}
