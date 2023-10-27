package web.service.face;

import web.dto.Member;

public interface MemberService {

	/**
	 * 로그인 인증 처리
	 * 
	 * @param loginParam - 입력한 ID/PW 정보
	 * @return 로그인 인증 결과
	 * 	true - 로그인 인증 성공
	 * 	false - 로그인 인증 실패
	 */
	public boolean login(Member loginParam);

	/**
	 * 회원의 닉네임 조회
	 * 
	 * @param loginParam - 닉네임을 조회하려는 사용자 정보
	 * @return 사용자의 닉네임
	 */
	public String getNick(Member loginParam);

	/**
	 * 신규 회원 가입
	 * 
	 * @param joinParam - 신규 회원 정보
	 * @return 회원가입 결과
	 */
	public boolean join(Member joinParam);

}














