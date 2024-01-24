package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dao.EmployeeDaoImpl;
import in.ineuron.dao.IEmployeeDao;
import in.ineuron.dto.Employee;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String eage=request.getParameter("eage");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		IEmployeeDao dao=new EmployeeDaoImpl();
		Employee employee=new Employee();
		employee.setEid(eid);
		employee.setEname(ename);
		employee.setEage(Integer.parseInt(eage));
		employee.setEmail(email);
		employee.setMobile(mobile);
		String msg=dao.insert(employee);
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Registration Output</title></head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<h1 style='color: blue; text-align: center;'>Registration Details</h1>");
		out.println("<tr><td>EID</td><td>"+eid+"</td></tr><tr>");
		out.println("<tr><td>ENAME</td><td>"+ename+"</td></tr><tr>");
		out.println("<tr><td>EAGE</td><td>"+eage+"</td></tr><tr>");
		out.println("<tr><td>EMAIL</td><td>"+email+"</td></tr><tr>");
		out.println("<tr><td>MOBILE</td><td>"+mobile+"</td></tr><tr>");
		out.println("<tr><td>STATUS</td><td>"+msg+"</td></tr><tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
