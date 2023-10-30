package interceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminInterceptor implements HandlerInterceptor {
	
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("+ + + 인터셉터 시작 + + +");
		
		//세션에서 등급 정보 꺼내기
		String grade = (String) request.getSession().getAttribute("grade");
		logger.info("grade : {}", grade);
		
		if( null == grade ) {
			logger.info("비 로그인 상태");
			
			//다른 URL로 리다이렉트
			response.sendRedirect("./fail");
			
			return false; //컨트롤러 접근 차단
			
		} else if( "G".equals(grade) ) {
			logger.info("일반 사용자 로그인 상태");
			
			//다른 URL로 리다이렉트
			response.sendRedirect("./fail");
			
			return false; //컨트롤러 접근 차단
			
		} else if( "A".equals(grade) ) {
			logger.info("관리자 로그인 상태");
			
			return true; //컨트롤러 접근 허용
		}

		return true; //컨트롤러 접근 허용
//		return false; //컨트롤러 접근 차단
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("+ + + 인터셉터 종료 + + +");
		
	}
	
}








