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
		String depName=request.getParameter("depName");
		String depAmount=request.getParameter("depAmount");
		HttpSession session= request.getSession(false);
		session.setAttribute("depName", depName);
		session.setAttribute("depAmount", depAmount);
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>First Page</title></head><body bgcolor=\"pink\">");
		out.println("<center>");
		out.println("<h1>Details About Transaction</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>Name</th><th>Value</th></tr>");
		Enumeration<String> enumerations=session.getAttributeNames();
		while(enumerations.hasMoreElements()) {
			String attributeName=(String)enumerations.nextElement();
			Object attributeValue=session.getAttribute(attributeName);
			out.println("<tr><td>"+attributeName+"</td><td>"+attributeValue+"</td></tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body></html>");
		out.close();
	}

}
