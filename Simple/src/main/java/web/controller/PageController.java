package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class PageController {

	//로그 객체
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );

//	@RequestMapping(value = "/forward", method = RequestMethod.GET)
	@GetMapping("/forward")
	public String forwardpage() {
		logger.info("/page/forward [GET]");
		
		// 반환시킨 "viewName"을 이용하여 InternalResourceViewResolver가
		//JSP로 포워드한다
//		return "viewName";
		
		
		//경로로 지정된 URL로 포워드한다
		//	-> 포워드 대상은 다른 컨트롤러일 수 있다
//		return "forward:경로";
		return "forward:/return/test";
		
//		return "return/test";	// /WEB-INF/views/return/test.jsp -> forward
		
	}
	
//	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	@GetMapping("/redirect")
	public String redirectpage() {
		logger.info("/page/redirect");
		
		return "redirect:/return/test2";
	}
	
	@GetMapping("/redirectMav")
	public ModelAndView redirectPageMav(ModelAndView mav) {
		
		//JSP로 forward
		mav.setViewName("viewName");
		
		//URL로 forward
		mav.setViewName("forward:/return/test3");
		
		//URL로 redirect
		mav.setViewName("redirect:/return/test3");
		
		return mav;
	}
}














