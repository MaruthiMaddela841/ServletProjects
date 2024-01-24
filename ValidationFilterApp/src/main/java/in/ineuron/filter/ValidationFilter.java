package in.ineuron.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidationFilter implements Filter {
	
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String eid_error="",ename_error="",eage_error="",email_error="",mobile_error="";
		boolean flag=true;
		PrintWriter out= response.getWriter();
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		System.out.println("Ename:"+ename);
		String eage=request.getParameter("eage");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		if(eid.equals("") || eid==null) {
			eid_error="Employee ID is required";
			flag=false;
		}
		else {
			if(!eid.startsWith("iNeuron-")) {
				eid_error="Employee ID should start with iNeuron";
				flag=false;
			}
			else {
				flag=true;
			}
		}
		
		if(ename.equals("") || ename==null) {
			ename_error="Employee Name is required";
			flag=false;
		}
		else {
			if(ename.length()<3) {
				ename_error="Employee Name length should not be less than 3";
				flag=false;
			}
			else {
				flag=true;
			}
		}
		
		
		if(eage.equals("") || eage==null) {
			eage_error="Employee Age is required";
			flag=false;
		}
		else {
			if(Integer.parseInt(eage)>20 && Integer.parseInt(eage)<30) {
				eage_error="Employee Age should not be more than 30";
				flag=false;
			}
			else {
				flag=true;
			}
		}
		if(email.equals("") || email==null) {
			email_error="Employee Email is required";
			flag=false;
		}
		else {
			if(!email.endsWith("@gmail.com")) {
				email_error="Employee Email should end with @gmail.com";
				flag=false;
			}
			else {
				flag=true;
			}
		}
		if(mobile.equals("") || mobile==null) {
			mobile_error="Employee Mobile is required";
			flag=false;
		}
		else {
			if(!mobile.startsWith("+91")) {
				mobile_error="Employee Mobile should start with +91";
				flag=false;
			}
			else {
				flag=true;
			}
		}
		
		if(flag) {
			chain.doFilter(request, response);
		}
		else {
			out.println("<html><head><title>Registration Output</title></head>");
			out.println("<body>");
			out.println("<h1 style='color: blue; text-align: center;'>Registration Details</h1>");
			out.println("<form method='POST' action='./reg'>");
			out.println("<table>");
			out.println("<tr><td>EID</td><td><input type='text' name='eid' value='"+eid+"'/></td><td>"+eid_error+"</td></tr><tr>");
			out.println("<tr><td>ENAME</td><td><input type='text' name='ename' value='"+ename+"'/></td><td>"+ename_error+"</td></tr><tr>");
			out.println("<tr><td>EAGE</td><td><input type='text' name='eage' value='"+eage+"'/></td><td>"+eage_error+"</td></tr><tr>");
			out.println("<tr><td>EMAIL</td><td><input type='text' name='email' value='"+email+"'/></td><td>"+email_error+"</td></tr><tr>");
			out.println("<tr><td>MOBILE</td><td><input type='text' name='mobile' value='"+mobile+"'/></td><td>"+mobile_error+"</td></tr><tr>");
			out.println("<tr><td></td><td><input type='submit' value='reg'/></td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
		out.close();
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
