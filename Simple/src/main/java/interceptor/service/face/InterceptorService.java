package interceptor.service.face;

import interceptor.dto.User;

public interface InterceptorService {

	/**
	 * 로그인 처리
	 * 
	 * @param user - 로그인 id, pw
	 * @return true - 로그인 인증 성공, false - 로그인 인증 실패
	 */
	public boolean login(User user);

	/**
	 * 사용자 정보 조회
	 * 
	 * @param user - 조회할 사용자의 id
	 * @return no, id, nick 조회된 객체
	 */
	public User info(User user);

}












