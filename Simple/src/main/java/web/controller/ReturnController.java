package web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnController {

	//로그 객체
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	
	@RequestMapping("/return/test")
	public void returnTest1( Model model ) {
		logger.info("/return/test 접속");
		
		//viewName:		"return/test"
		//View:			/WEB-INF/views/return/test.jsp
		
		//모델값 전달 ( req.setAttribute("name", value); )
		model.addAttribute("title", "void반환타입");
		model.addAttribute("data", "MODEL DATA");
		
	}
	
	@RequestMapping("/return/test2")
	public String returnTest2(Model model) {
		logger.info("/return/test2 접속");
		//--------------------------------------------
		
		//모델값 지정
		model.addAttribute("title", "String반환");
		model.addAttribute("data", "MODEL DATA 2");
		//--------------------------------------------
		
		//void반환과 같은 방식으로 처리된다
//		return null;
		
		//viewName을 ""빈문자열로 사용한다
//		return "";
		
		//viewName을 직접 지정한다
//		return "apple";
		return "return/test";

	}
	
	@RequestMapping("/return/test3")
	public ModelAndView returnTest3(ModelAndView mav) {
		logger.info("/return/test3 접속");
		//-------------------------------------------
		
		//ViewResolver가 동작하지 않는다
//		return null;
		//-------------------------------------------
		
		//객체를 생성하지 않고 매개변수로 선언만해도 된다
//		ModelAndView mav = new ModelAndView();
		
		//viewName 지정하기
//		mav.setViewName(null); //void리턴과 동일하게 동작
		mav.setViewName("return/test");
		
		//모델값 지정하기
		mav.addObject("title", "ModelAndView 반환");
		mav.addObject("data", "MODEL DATA 3");
		
		//ModelAndView 객체 반환
		return mav;
		
	}
	
}

















