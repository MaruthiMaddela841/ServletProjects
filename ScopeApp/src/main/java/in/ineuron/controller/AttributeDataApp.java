package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AttributeDataApp
 */
@WebServlet("/AttributeDataApp")
public class AttributeDataApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		ServletContext context=getServletContext();
		context.setAttribute("username", "root");
		context.setAttribute("password", "root123");
		out.println("<h1>Data</h1>");
		out.println("<table border=1>");
		out.println("<tr><th>AttributeName</th><th>AttributeValue</th></tr>");
		Enumeration<String> attributeNames=context.getAttributeNames();
		while(attributeNames.hasMoreElements()) {
			String attributeName=(String)attributeNames.nextElement();
			Object attributeValue=context.getAttribute(attributeName);
			out.println("<tr>");
			out.println("<td>"+attributeName+"</td>");
			out.println("<td>"+attributeValue+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

}
