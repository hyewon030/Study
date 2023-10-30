package a.b.c;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {

	@RequestMapping(value = "/basic/test", method = RequestMethod.GET)
	public void basicMethod() {
		System.out.println("/basic/test [GET]");
		
	}
	
	@RequestMapping(value = "/basic/test2", method = RequestMethod.GET)
	public void basicMethod2() {
		System.out.println("/basic/test2 [GET]");
	}
	
	@RequestMapping(value = "/basic/test3", method = RequestMethod.GET)
	public void basicMethod3() {
		System.out.println("/basic/test3 [GET]");
	}
	
	@RequestMapping(value = "/basic/test3", method = RequestMethod.POST)
	public void basicMethod3post() {
		System.out.println("/basic/test3 [POST]");
	}
	
}














