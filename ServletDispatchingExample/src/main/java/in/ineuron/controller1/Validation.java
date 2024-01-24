package in.ineuron.controller1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/valid")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller in Validate Server");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("root") && password.equals("root123")) {
			RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
		}
		else {
			ServletContext servContext=request.getServletContext();
			RequestDispatcher rd=servContext.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
	}

}
