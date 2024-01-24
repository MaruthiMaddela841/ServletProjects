package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.listener.RequestDemoListener;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  static {
	    	System.out.println("TestServlet .class file loading....");
	    }
		
		public TestServlet() {
			System.out.println("TestServlet object is instantiated....");
	    }
		
		

	@Override
		public void init() throws ServletException {
		System.out.println("TestServlet object is initialized....");
		}



	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<h1>This is Request Listener TestServelt");
		System.out.println("<h1>The number of hits for the application is:"+RequestDemoListener.count+"</h1>");
		System.in.read();
		out.close();
	}

}
