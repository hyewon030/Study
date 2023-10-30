package login.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.dao.face.LoginDao;
import login.dto.Login;
import login.service.face.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	//로그 객체
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired LoginDao loginDao;
	
	@Override
	public void join(Login login) {
		loginDao.insert( login );
	}

	@Override
	public boolean login(Login login) {
		
		int result = loginDao.selectCntByIdPw( login );
		
		if( result > 0 )
			return true; //로그인 인증 성공
		
		return false; //로그인 인증 실패
	}
	
	@Override
	public Login info(String loginid) {
		return loginDao.selectById(loginid);
	}
}













