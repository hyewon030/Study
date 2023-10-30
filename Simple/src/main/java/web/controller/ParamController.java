package web.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import web.dto.User;

@Controller
@RequestMapping("/param")
public class ParamController {

	//로그 객체
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );

	
	@GetMapping("/requestParam")
	public String paramForm() {
		logger.info("/param/requestParam [GET]");
		
		return "param/paramForm";
	}
	
	@PostMapping("/requestParam")
	public void paramResult(
			
			//기본 전달 파라미터 처리 변수
//			String username,
//			String userage
			
			//name속성은 파싱할 전달파라미터의 이름을 지정하는 속성이다
			//value속성은 name속성의 별칭이다
//			@RequestParam(value = "aaaaa") String username,
//			@RequestParam(name = "bbbbb") String userage
			
			//value속성은 단독으로 쓰일 때 생략 가능하다
			@RequestParam("aaaaa") String username,
			@RequestParam("bbbbb") String userage
			
			) {
		
		logger.info("/param/requestParam [POST]");

		logger.info("username : {}", username);
		logger.info("userage : {}", userage);
		
	}
	
	@RequestMapping("/test")
	public void paramTest(
			
//			String data		//data 전달 파라미터 필수 X
			
//			@RequestParam String data	//data 전달 파라미터 필수 O
			
			//data 전달 파라미터 필수 O
//			@RequestParam(required = true) String data

			//data 전달 파라미터 필수 X
			@RequestParam(required = false) String data
			
			) {
		logger.info("/param/test");
		logger.info("data : {}", data);
	}

	@GetMapping("/list")
	public void boardlist(
			
//			String curPage
			
			//curPage 파라미터가 필수가 아니기 때문에 null 또는 ""이 전달될 수 있다
			//	-> 에러 발생한다
//			int curPage
			
//			@RequestParam(required = true) int curPage
			
			//전달값이 null 또는 "" 일 경우 "0"으로 대체한다
			//	-> int형 변수이기 때문에 정수 0으로 변환하여 저장한다
			@RequestParam(defaultValue = "0") int curPage

			) {
		logger.info("/param/list");
		logger.info("curPage : {}", curPage);
	}
	
	@RequestMapping("/value/test")
	public void valueTest(
			
			String data,
			
			@RequestParam(name="data") String d1,
			@RequestParam(value="data") String d2,
			@RequestParam("data") String d3			
			
			) {
		logger.info("/param/value/test");
		
		logger.info("data : {}", data);
		logger.info("d1 : {}", d1);
		logger.info("d2 : {}", d2);
		logger.info("d3 : {}", d3);
		
	}
	
	@GetMapping("/map")
	public void paramMapForm() {
		logger.info("/param/map [GET]");
	}
	
	@PostMapping("/map")
	public String paramMapResult(
			
			//일반 해시맵 객체를 생성한다
			//	-> 전달 파라미터를 추출하지 않는다
			HashMap<String, String> map,

			//해시맵으로 전달파라미터를 추출할 수 있다
			//	-> @RequestParam 필수
			@RequestParam
			HashMap<String, String> paramMap,
			
			//모델값 전달 객체
			Model model
			
			) {
		logger.info("/param/map [POST]");
		
		logger.info("{}", map);
		logger.info("{}", paramMap);
		
		
		//모델값 전달 - 객체 자체를 모델값으로 전달한다
		model.addAttribute("m", paramMap);
		
		//모델값 전달 - 맵 객체 내부의 키=값 쌍을 각각의 모델값으로 전달한다
		model.addAllAttributes(paramMap);
		
		
		return "param/mapResult";
	}
	
	@GetMapping("/dto")
	public void paramDtoForm() {}
	
	@PostMapping("/dto")
	public String paramDtoResult(
			
			//@ModelAttribute 어노테이션
			//	-> 모델값을 지정하여 View에 전달되도록 해준다
			//	-> DTO객체의 멤버필드에 맞게 전달 파라미터를 추출한다
			
			
			//커맨드 객체, Command Object
			User user
			, @ModelAttribute User user2
			, @ModelAttribute("u3") User user3

			, Model model
			
			) {
		logger.info("/param/dto [POST]");
		
		logger.info("{}", user);
		logger.info("{}", user2);
		
		model.addAttribute("u2", user2);
		
		return "param/dtoResult";
	}
	
	@RequestMapping("/sample")
	public void paramTest(
			
			HttpServletRequest req, 
			HttpServletResponse resp,
			
//			Writer out,
//			Reader in,
			
//			OutputStream outStream,
//			InputStream inStream,
			
			HttpSession session,
			
			//세션 컨텍스트 정보를 추출하여 매개변수에 대입한다
			@SessionAttribute("name") String data,
			@SessionAttribute(value = "login", required = false) boolean login,
			@SessionAttribute(value = "loginid", required = false) String loginid
			
			) {
		
//		try {
//			req.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		req.getParameter("name");
//
//		try {
//			req.getRequestDispatcher("JSP").forward(req, resp);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		//------------------------------------------------------------------
		
//		try {
//			resp.sendRedirect("URL");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			Writer o = resp.getWriter();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//------------------------------------------------------------------
		
//		resp.setContentType("text/html; charset=utf-8");
//		
//		try {
//			out.append("HTML");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//------------------------------------------------------------------
		
		session.setAttribute("name", "value");
		
		logger.info("session : {}", session.getAttribute("name") );
		
		logger.info("data : {}", data );
		logger.info("login : {}", login );
		logger.info("loginid : {}", loginid );
	}	
	
}
















