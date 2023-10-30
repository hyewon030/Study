package login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import login.dto.Login;
import login.service.face.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	//로그 객체
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );

	@Autowired LoginService loginService;
	
	
	@RequestMapping("/main")
	public void main() {}

	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public String joinProc( Login login ) {
		logger.info("param : {}", login);
		
		loginService.join( login );
		
		return "redirect:./main";
	}
	
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String loginProc( Login login, HttpSession session ) {
		logger.info("param : {}", login);

		boolean isLogin = loginService.login( login );
		
		if( isLogin ) { //로그인 성공
			session.setAttribute("isLogin", isLogin);
			session.setAttribute("loginid", login.getId());
			
		} else { //로그인 실패
			session.invalidate();
			
		}
		
		return "redirect:./main";
	}

	
	@GetMapping("/mypage")
	public void mypage(
			@SessionAttribute("loginid") String loginid
			, Model model ) {
		logger.info("loginid : {}", loginid);
		
		Login login = loginService.info( loginid );
		
		model.addAttribute("login", login);		
	}
	

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:./main";
	}
	
}

















