package interceptor.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor/board")
public class BoardInterceptorController {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@RequestMapping("/list")
	public void list() {
		logger.info("/interceptor/board/list");
	}
	
	@RequestMapping("/write")
	public void write() {
		logger.info("/interceptor/board/write");
	}
	
	@RequestMapping("/update")
	public void update() {
		logger.info("/interceptor/board/update");
	}
	
	@RequestMapping("/noLogin")
	public void noLogin() {
		logger.info("/interceptor/board/noLogin");
	}
	
}
















