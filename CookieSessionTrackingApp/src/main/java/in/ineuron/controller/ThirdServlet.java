package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcategory=request.getParameter("pcategory");
		String pmanufacturer=request.getParameter("pmanufacturer");
		Cookie[] cookies=request.getCookies();
		String pname=cookies[0].getValue();
		String pcost=cookies[1].getValue();
		String pbrand=cookies[2].getValue();
		String pqty=cookies[3].getValue();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<h1> Hi Welcome</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		out.println("<tr><td>PNAME</th><th>"+pname+"</td></tr>");
		out.println("<tr><td>PCOST</th><th>"+pcost+"</td></tr>");
		out.println("<tr><td>PBRAND</th><th>"+pbrand+"</td></tr>");
		out.println("<tr><td>PQTY</th><th>"+pqty+"</td></tr>");
		out.println("<tr><td>PCATEGORY</th><th>"+pcategory+"</td></tr>");
		out.println("<tr><td>PMANUFACTURER</th><th>"+pmanufacturer+"</td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.close();
		System.out.println(request.getRequestedSessionId());
	}

}
