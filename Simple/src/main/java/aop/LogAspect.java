package aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component	//스프링 빈(컴포넌트)으로 등록하기 [component-scan 등록 필요, <annotation-driven /> 태그 필요]
@Aspect		//AspectJ의 관리를 받도록 설정하기
public class LogAspect {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	
	//List<Dept> dept.service.impl.DeptServiceImpl.list()
	
//	//포인트컷 설정
//	@Pointcut("execution(* dept.service.impl.*ServiceImpl.*(..))")
//	private static void logPointCut() {}
//	
//	//어드바이스 코드 작성
////	@Before("logPointCut()")
//	@After("logPointCut()")
//	public void logPrint() {
//		logger.debug("!!! AOP 테스트 !!!");
//		
//	}
	
	//--------------------------------------------------------------------
	
	//포인트컷 + 어드바이스 코드 작성
	@Before("execution(* dept.service.impl.*ServiceImpl.*(..))")
	public void logPrint() {
		logger.debug("!!! AOP 테스트 !!!");
	}
	
	//--------------------------------------------------------------------
	
//	@Before("execution(void dept.controller.DeptController.list(org.springframework.ui.Model))")
//	@After("execution(* *..controller..*.*(..))")
//	@Before("execution(* *..service..*.*(..))")
	@Before("execution(* *..controller..*.*(..)) || execution(* *..service..*.*(..))")
	public void log() {
//		logger.debug("***** Controller AOP Log *****");
//		logger.debug("***** Service AOP Log *****");
		
		logger.debug("***** Controller, Service AOP Log *****");
		
	}
	//--------------------------------------------------------------------
	
	@Before("execution(* *..controller..*.*(..)) || execution(* *..service..*.*(..))")
	public void logMessage(JoinPoint joinPoint) {

//		logger.debug("##### {}", joinPoint);
//		logger.debug("##### {}", joinPoint.getSignature());
		
		Signature sign = joinPoint.getSignature();
		
		logger.debug(">>>>> getName : {}", sign.getName());
		logger.debug(">>>>> toString : {}", sign.toString());
		logger.debug(">>>>> toShortString : {}", sign.toShortString());
		logger.debug(">>>>> toLongString : {}", sign.toLongString());
		
	}
	
	//--------------------------------------------------------------------
	
	@Around("execution(* *..controller..*.*(..))")
	public Object aroundTest(ProceedingJoinPoint pjp) {
		
		logger.debug("***** 수행 전, Before *****");
		
		Object returnVal = null;
		try {
			
			//타겟 메소드(Target Method)를 실행한다
			returnVal = pjp.proceed();
			
		} catch (Throwable e) {
			logger.debug("***** 예외 발생, After Throwing *****");
			e.printStackTrace();
		}
		
		logger.debug("***** 수행 후, After *****");
		logger.debug("***** proceed 결과 : {} *****", returnVal);
		
		if(returnVal != null) {
			logger.debug("***** 성공적인 리턴 발생 시, After Returning *****");
		}
		
		return returnVal;
	}
	
	//--------------------------------------------------------------------
	
	@After("bean(*Controller) || bean(*ServiceImpl)")
	public void beanTest(JoinPoint jp) {
		logger.debug("+++++ {}", jp.getSignature().toShortString());
	}	

	//--------------------------------------------------------------------
	
	@Autowired HttpServletRequest req;
	@Before("bean(*Controller)")
	public void defaultControllerLog(JoinPoint jp) {
		logger.info("{} [{}]", req.getRequestURI(), req.getMethod());
	}	
	
	@Before("bean(*ServiceImpl)")
	public void defaultServiceLog(JoinPoint jp) {
		logger.info("{}", jp.getSignature().toShortString());
	}	
	
}
















