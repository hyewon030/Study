package tx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tx.service.face.TxService;

@Controller
public class TxController {
	
	//로그 객체
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );

	@Autowired TxService txService;
	
	
	@RequestMapping("/tx/test")
	public void txTest( int deptno ) {
		logger.info("/tx/test");
		
		txService.test( deptno );
		
	}
	
	@RequestMapping("/tx/noTxTest")
	public void noTxTest( int deptno ) {
		logger.info("/tx/noTxTest");
		
		txService.test2( deptno );
		
	}
}

















