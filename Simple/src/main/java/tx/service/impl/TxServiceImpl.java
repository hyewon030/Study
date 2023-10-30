package tx.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tx.dao.face.TxDao;
import tx.service.face.TxService;

@Service
public class TxServiceImpl implements TxService {

	//로그 객체
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired TxDao txDao;
	
	
	@Override
	@Transactional
	public void test(int deptno) {
		logger.info("test() - {}", deptno);
		
		txDao.insertDeptPlusOne(deptno);
		txDao.insertDept(deptno);
		
	}
	
	@Override
	public void test2(int deptno) {
		logger.info("test2() - {}", deptno);
		
		txDao.insertDept(deptno);
	}
}












