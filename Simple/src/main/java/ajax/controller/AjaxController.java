package ajax.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ajax.dto.ResultData;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	//----------------------------------------------------------------------------
	
	// 1. 응답 출력 스트림으로 JSON Text를 직접 응답하기
	
	@RequestMapping("/test01")
	public void ajaxTest01() {}

	@RequestMapping("/test01_ok")
	public void ajaxTest01_ok( Writer out ) {
		
		try {
			out.append("{\"result\":\"HI\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//----------------------------------------------------------------------------
	
	// 2. @ResponseBody 를 이용하여 객체를 JSON Text로 응답하기
	
	//@ResponseBody 어노테이션
	//	응답 데이터를 자바 데이터 형식으로 출력하도록 설정하는 어노테이션
	//	ViewResolver의 도움을 받지않고 컨트롤러 메소드에서 직접 응답 출력한다
	//	메소드의 리턴 데이터타입에 적용한다
	
	//	** JSON으로 마샬링을 위해서 Jackson Databind 라이브러리가 필요하다
	
	//** Jackson 프로젝트
	//	자바 객체 <-> JSON 텍스트 변환을 도와주는 라이브러리 모음
	
	
	@RequestMapping("/test02")
	public void ajaxTest02() {}
	
//	@RequestMapping("/test02_ok")
//	public @ResponseBody String ajaxTest02_ok() {
//		//응답 데이터로 Apple 문자열을 이용한다
////		return "Apple";
//		
//		//JSON Text형식의 문자열을 응답한다
//		return "{\"data\":\"Apple\"}";
//	}
	@RequestMapping("/test02_ok")
	public @ResponseBody ResultData ajaxTest02_ok() {
		
		//DTO를 이용하여 응답하기 (마샬링 필요)
		return new ResultData("Banana", 12345);
		
	}
	
	//----------------------------------------------------------------------------
	
	//3. AJAX의 응답으로 JSP응답을 활용하기
	//	완성된 HTML코드로 AJAX 응답 데이터를 전달한다
	
	//	모델값을 JSP로 전달하면서 응답 화면을 구성할 수 있다
	
	@RequestMapping("/test03")
	public void ajaxTest03() {}
	
	@RequestMapping("/test03_ok")
	public void ajaxTest03_ok( Model model ) {
		model.addAttribute("rd", new ResultData("Cherry", 6894));
	}
	
	//----------------------------------------------------------------------------
	
	// 4. JSON 응답을 생성하는 AJAX전용 View객체 사용하기
	//	"jsonView" 로 등록된 스프링 빈을 사용한다
	//	BeanNameViewResolver가 동작한다
	
	//	** Jackson-Databind 라이브러리 필요
	
	@RequestMapping("/test04")
	public void ajaxTest04() {}
	
	@RequestMapping("/test04_ok")
	public String ajaxTest04_ok( Model model ) {
		model.addAttribute("rd", new ResultData("Durian", 9887));

		return "jsonView";
	}

	
}
















