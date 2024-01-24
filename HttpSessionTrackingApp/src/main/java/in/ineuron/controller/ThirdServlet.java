package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String smobile=request.getParameter("smobile");
		String semail=request.getParameter("semail");
		HttpSession session=request.getSession(false);
		session.setAttribute("smobile", smobile);
		session.setAttribute("semail", semail);
		out.println("<h1> Hi Welcome</h1>");
		out.println("<table border='1'>");
		Enumeration<String> attributeNames=session.getAttributeNames();
		while(attributeNames.hasMoreElements()) {
			String attributeName=attributeNames.nextElement();
			Object attributeValue=session.getAttribute(attributeName);
			out.println("<tr><td>"+attributeName+"</td><td>"+attributeValue+"</td></tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.close();
		System.out.println(request.getRequestedSessionId());
		
	}

}
