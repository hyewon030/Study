package interceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class BoardInterceptor implements HandlerInterceptor {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info(" + + BoardInterceptor + +");
		
		//세션 객체
		HttpSession session = request.getSession();
		
		if( session.getAttribute("login") == null ) {
			logger.info(" >> 접속 불가 : 비로그인 상태");
			response.sendRedirect("./noLogin");
			return false;
		}
		
		logger.info(" >> 접속 허용 : 로그인 상태");
		return true;
	}

}















