package in.ineuron.customizedrequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedRequest extends HttpServletRequestWrapper {

	public CustomizedRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name2) {
		String name=super.getParameter(name2);
		if(name.equalsIgnoreCase("java") || name.equalsIgnoreCase("jee") || name.equalsIgnoreCase("spring") || name.equalsIgnoreCase("springboot"))
			return "SLEEP";
		return name;
	}
	
	

}
