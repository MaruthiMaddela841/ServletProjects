package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<h1>Welcome To First Servlet</h1>");
		request.setAttribute("Maruthi", "Maddela");
		request.setAttribute("Pruthvi", "Yelugu");
		request.setAttribute("Srikanth", "Bashaboina");
		RequestDispatcher rd=request.getRequestDispatcher("/SecondServlet");
		rd.forward(request, response);
		
	}

}
