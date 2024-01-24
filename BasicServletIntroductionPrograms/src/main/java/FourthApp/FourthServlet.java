import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
//set path=C:\Program Files\Java\jdk-19\bin
//set classpath=;.;C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar

@WebServlet(urlPatterns={"/demo"})
public class  FourthServlet extends GenericServlet
{
	public void service(ServletRequest request, ServletResponse response)throws 
		ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<h1 style='color:blue;'> Generic Servlet</h1>");
		out.close();
	}
}