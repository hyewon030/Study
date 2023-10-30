package interceptor.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import interceptor.dao.face.InterceptorDao;
import interceptor.dto.User;
import interceptor.service.face.InterceptorService;

@Service
public class InterceptorServiceImpl implements InterceptorService {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );

	@Autowired InterceptorDao interceptorDao;

	@Override
	public boolean login(User user) {
		
		if( interceptorDao.selectCntByIdPw(user) > 0 ) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public User info(User user) {
		return interceptorDao.selectById(user);
	}
	
}














