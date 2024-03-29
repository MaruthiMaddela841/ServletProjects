package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config=getServletConfig();
		ServletContext context=getServletContext();
		System.out.println("Implementation Class of ServletConfig: "+config.getClass().getName());
		System.out.println("Implementation Class of ServletConfig: "+context.getClass().getName());
		System.out.println("Implementation Class of ServletConfig: "+request.getClass().getName());
		System.out.println("Implementation Class of ServletConfig: "+response.getClass().getName());
	}

}