package in.ineuron.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListenerDemo implements ServletRequestAttributeListener {

	
	static {
		System.out.println("RequestAttributeListenerDemo .class file is loading.....");
	}
    public RequestAttributeListenerDemo() {
        System.out.println("RequestAttributeListenerDemo object is created....");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println(srae.getName()+": is removed");
    }


    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         System.out.println(srae.getName()+": is added");
    }

	
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println(srae.getName()+": is replaced");
    }
	
}
