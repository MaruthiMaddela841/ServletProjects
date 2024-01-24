package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname=request.getParameter("sname");
		String sage=request.getParameter("sage");
		String sgen=request.getParameter("sgen");
		String saddr=request.getParameter("saddr");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Third Page</title></head><body bgcolor=\"pink\">");
		out.println("<center>");
		out.println("<h1>Student Details</h1>");
		out.println("<form method='post' action='./third'>");
		out.println("<input type='hidden' name='sname' value='"+sname+"' />");
		out.println("<input type='hidden' name='sage' value='"+sage+"' />");
		out.println("<input type='hidden' name='sgen' value='"+sgen+"' />");
		out.println("<input type='hidden' name='saddr' value='"+saddr+"' />");
		out.println("<table border='1'>");
		out.println("<tr><th>Marks</th><td><input type='text' name='smarks'/></td></tr>");
		out.println("<tr><th>Branch</th><td><input type='text' name='sbranch'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body></html>");
		out.close();
	}

}
