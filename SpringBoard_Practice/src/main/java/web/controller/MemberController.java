package web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dto.Member;
import web.service.face.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

   @Autowired MemberService memberService;
   
   //로그 객체
   private final Logger logger = LoggerFactory.getLogger( this.getClass() );
   
   @GetMapping("/login")
   public void login(HttpSession session) {
      session.invalidate();
   }
   
   @PostMapping("/login")
   public String loginProc(Member loginParam, HttpSession session) {
      logger.info("loginParam : {}", loginParam);
      
      //로그인 인증
      boolean loginResult = memberService.login( loginParam );
      
      //[세션] 로그인 인증 결과
      session.setAttribute("login", loginResult);
      
      if( loginResult ) {
         logger.info("로그인 성공");
          session.setAttribute("id", loginParam.getId());
           session.setAttribute("nick", memberService.getNick(loginParam));
           
//           return "redirect:./main";
           return "redirect:/";
           
      } else {
         logger.info("로그인 실패");
         
         return "redirect:./login";
      }

   }
   
   @GetMapping("/join")
   public void join() {
	  
   }
   
   @PostMapping("/join")
   public String joinProc(Member joinParam) {
 logger.info("joinParam : {}", joinParam);
	   
	   //회원가입 처리
	   boolean joinResult = memberService.join( joinParam );
	   
	   if( joinResult ) {
		   logger.info("회원가입 성공");
		   return "redirect:/";   
	   } else {
		   logger.info("회원가입 실패");
		   return "redirect:./join";
	   }
	   
   }
   
   @RequestMapping("/logout")
   public String logout(HttpSession session) {
	   session.invalidate();
	   
//	return "redirect:/member/main";
	return "redirect:/";
	
	   
   
   }
   
   @RequestMapping("/main")
   public void main() {}
   
}