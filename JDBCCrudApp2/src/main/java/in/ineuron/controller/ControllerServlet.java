package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd=null;
		IStudentService stdService=StudentServiceFactory.getStudentService();
		System.out.println("Request URI:"+request.getRequestURI());
		System.out.println("Path Info:"+request.getPathInfo());
		if(request.getRequestURI().endsWith("addform")) {
			String sage=request.getParameter("sage");
			String sname=request.getParameter("sname");
			String saddr=request.getParameter("saddr");
			Student student = new Student();
			student.setSage((Integer.parseInt(sage)));
			student.setSname(sname);
			student.setAddress(saddr);
			String status=stdService.addStudent(student);
			PrintWriter out=response.getWriter();
			if(status.equals("success")) {
				rd=request.getRequestDispatcher("../success.html");
				rd.forward(request, response);
			}
			else {
				rd=request.getRequestDispatcher("../failure.html");
				rd.forward(request, response);
			}
			out.close();
		}
		else if(request.getRequestURI().endsWith("searchform")) {
			PrintWriter out=response.getWriter();
			String sid=request.getParameter("sid");
			Student student=stdService.searchStudent(Integer.parseInt(sid));
			out.println("<table border=1>");
			out.println("<tr><th>Parameter</th><th>Value</th></tr>");
			out.println("<tr><th>Name</th><th>"+student.getSname()+"</th></tr>");
			out.println("<tr><th>Age</th><th>"+student.getSage()+"</th></tr>");
			out.println("<tr><th>Address</th><th>"+student.getAddress()+"</th></tr>");
			out.println("</table>");
			
		}
		else if(request.getRequestURI().endsWith("editform")) {
			String sid=request.getParameter("sid");
			Student student=stdService.searchStudent(Integer.parseInt(sid));
			PrintWriter out=response.getWriter();
			if(student!=null) {
				out.println("<body>");
				out.println("<center>");
				out.println("<form method='POST' action='./controller/updateform'>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>"+student.getSid()+"</td></tr>");
				out.println("<input type='hidden' name='sid' value='"+student.getSid()+"'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='"+student.getSname()+"'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='"+student.getSage()+"'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddr' value='"+student.getAddress()+"'/></td></tr>");
				out.println("<tr><th></th><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			}
			else {
				out.println("<h1 style='color:red; text-align:center'> Record Not Found</h1>");
			}
			out.close();
		}
			else if(request.getRequestURI().endsWith("updateform")) {
				PrintWriter out=response.getWriter();
				String sid=request.getParameter("sid");
				String sage=request.getParameter("sage");
				String sname=request.getParameter("sname");
				String saddr=request.getParameter("saddr");
				Student student = new Student();
				student.setSid(Integer.parseInt(sid));
				student.setSage(Integer.parseInt(sage));
				student.setSname(sname);
				student.setAddress(saddr);
				String status=stdService.updateStudent(student);
				if(status.equals("success")) {
					rd=request.getRequestDispatcher("../../updateSuccess.html");
					rd.forward(request, response);
				}
				else {
					rd=request.getRequestDispatcher("../../updateFailure.html");
					rd.forward(request, response);
				}
				out.close();
			}
		else if(request.getRequestURI().endsWith("deleteform")) {
			String sid=request.getParameter("sid");
			String status=stdService.deleteStudent(Integer.parseInt(sid));
			PrintWriter out=response.getWriter();
			if(status.equals("success")) {
				rd=request.getRequestDispatcher("../deleteSuccess.html");
				rd.forward(request, response);
			}
			else {
				rd=request.getRequestDispatcher("../deleteFailure.html");
				rd.forward(request, response);
			}
			out.close();
		}
	}

}
