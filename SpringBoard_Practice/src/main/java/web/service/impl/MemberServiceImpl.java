package web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MemberDao;
import web.dto.Member;
import web.service.face.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired private MemberDao memberDao;
	
	
	@Override
	public boolean login(Member loginParam) {
		
		int loginChk = memberDao.selectCntMember(loginParam);
		
		if( loginChk > 0 )
			return true;
		
		return false;
	}

	@Override
	public String getNick(Member loginParam) {
		return memberDao.selectNickById(loginParam);
	}
	
	@Override
	public boolean join(Member joinParam) {
		
		//중복 ID인지 확인
		if( memberDao.selectCntById(joinParam) > 0 ) {
			return false;
		}
		
		//회원 정보 삽입
		memberDao.insert(joinParam);
		
		//가입 결과 확인
		if( memberDao.selectCntById(joinParam) > 0 ) {
			return true;
		}
		
		return false;
	}
	
}
















