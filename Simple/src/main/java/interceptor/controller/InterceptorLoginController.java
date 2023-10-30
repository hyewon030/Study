package interceptor.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import interceptor.dto.User;
import interceptor.service.face.InterceptorService;

@Controller
public class InterceptorLoginController {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );

	@Autowired InterceptorService interceptorService;
	
	@GetMapping("/interceptor/login")
	public void loginForm() {
		logger.info("/interceptor/login [GET]");
	}

	@PostMapping("/interceptor/login")
	public String loginProc( User user, HttpSession session ) {
		logger.info("/interceptor/login [POST]");
		logger.info("param : {}", user);
		
		//로그인 인증
		boolean isLogin = interceptorService.login( user );
		logger.info("isLogin : {}", isLogin);
		
		if( isLogin ) {
			logger.info("로그인 성공");
			
			//no, id, nick 조회하기
			user = interceptorService.info( user ); 
			logger.info("{}", user);
			
			session.setAttribute("login", true); //로그인 상태
			session.setAttribute("loginno", user.getUserno()); //사용자 식별값
			session.setAttribute("nick", user.getUsernick()); //사용자 닉네임
			
			if( "관리자".equals( user.getUsernick() ) ) {
				//관리자 ( admin )
				session.setAttribute("grade", "A");
			} else {
				//일반 사용자 ( apple, banana )
				session.setAttribute("grade", "G");
			}
			
		} else {
			logger.info("로그인 실패");
			
			session.invalidate(); //세션 정보 지우기 (강제 로그아웃)
		}
		
		return "redirect:./main";
	}
	
	@RequestMapping("/interceptor/main")
	public void main() {}
	
	@RequestMapping("/interceptor/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:./main";
	}
	
	
	@RequestMapping("/interceptor/admin/main")
	public void adminMain() {
		logger.info("/interceptor/admin/main");
	}

	@RequestMapping("/interceptor/admin/fail")
	public void adminFail() {
		logger.info("/interceptor/admin/fail");
	}
	
}



















