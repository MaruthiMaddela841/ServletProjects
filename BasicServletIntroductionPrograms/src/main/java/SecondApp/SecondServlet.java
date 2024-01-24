import java.io.*;
import javax.servlet.*;
//set path=C:\Program Files\Java\jdk-19\bin
//set classpath=;.;C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar

public class  SecondServlet implements Servlet
{
	static
	{
		System.out.println("SecondServlet .class file is loading..");
	}

	public SecondServlet()
	{
		System.out.println("Second Servlet Object is Instantiated...");
	}
	//For servlet intialization container calls this method
	public void init(ServletConfig  config) throws ServletException
	{
		System.out.println("Service Initialization");
	}

	public ServletConfig getServletConfig()
	{
		return null;
	}
	//Request Processing Logic
	public void service(ServletRequest request, ServletResponse response) throws ServletException,
	IOException{
		System.out.println("Servlet Request Processing...");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body>");
		out.println("<h1 style='color:red;'><marquee> Welcome 2 Advanced Java...</marquee>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	public String getServletInfo()
	{
		return null;
	}
	//Servlet Deinstantiation logic
	public void destroy()
	{

	}

}
