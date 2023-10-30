package web.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogTestController {

	//로그 객체
	private static final Logger logger = LoggerFactory.getLogger(LogTestController.class);
	
	@RequestMapping(value = "/log/test", method = RequestMethod.GET)
	public void logtest() {
		System.out.println("/log/test [GET] 접속");

		logger.info("로그 메시지");
		//-----------------------------------------------------------------
		System.out.println("------------------------------------");
		
		//로그 레벨 메소드
		logger.trace("트레이스");
		logger.debug("디버그");
		logger.info("인포");
		logger.warn("경고");
		logger.error("에러");
		//-----------------------------------------------------------------
		System.out.println("------------------------------------");

		Object obj = new Object();
		
		//좋은 방법이 아니다
		//로그 메소드들은 객체 타입을 바로 출력할 수 없다 
//		System.out.println( obj );
//		logger.info( obj ); //에러
//		logger.info( obj.toString() );
		//-----------------------------------------------------------------
		System.out.println("------------------------------------");

		logger.info("출력 데이터 : {}파라미터");
		logger.info("출력 데이터 : {}파라미터", 12345);
		
		logger.info("A:{}, B:{}", "aaaaa", true);
		
		//에러, {}파라미터는 2개까지만 허용한다
//		logger.info("{}, {}, {}", 1, 2, 3);
		
		logger.info("{}", obj);
		//-----------------------------------------------------------------
		System.out.println("------------------------------------");
		
		//여러 개의 {}파라미터를 사용하려면 Object[] 타입을 활용한다
		
		Object[] data = {"출력", "데이터", "여러 개", "지정하기", 123, new Date()};
		
		logger.info("{} {} {} {}, {}, {}", data);
		//-----------------------------------------------------------------
		System.out.println("------------------------------------");
		
		int idx = 0;
		logger.trace("#{}. 에러 메시지 출력", idx++);
		
		logger.trace("#{}. 메소드 시작", idx++);
		logger.trace("#{}. 주석대신 사용해도 좋을 정도", idx++);
		logger.trace("#{}. 로그 레벨에 맞게 콘솔에 출력함", idx++);
		logger.trace("#{}. 개발할 때 idx변수를 활용하여", idx++);
		logger.trace("#{}. 로그가 출력된 순서를 표현할 수 있음", idx++);
		logger.trace("#{}. 개발 상황 추적하기 좋음", idx++);
		logger.trace("#{}. 메소드 종료", idx++);
		
	}
	
}
















