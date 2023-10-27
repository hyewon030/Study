package web.dao.face;

import web.dto.Member;

public interface MemberDao {

	/**
	 * id/pw로 조회된 사용자의 수를 반환한다
	 * 
	 * @param loginParam - 조회할 id/pw를 가진 객체
	 * @return 조회된 행 수
	 */
	public int selectCntMember(Member loginParam);

	/**
	 * id를 이용하여 nick을 조회한다
	 * 
	 * @param loginParam - 조회하려는 회원의 id를 가진 객체
	 * @return 조회된 nick
	 */
	public String selectNickById(Member loginParam);

	/**
	 * id가 존재하는 지 확인한다
	 * 
	 * @param joinParam - 조회하려는 id를 가진 객체
	 * @return id 존재 여부 ( 0 - 없음, 1 - 있음 )
	 */
	public int selectCntById(Member joinParam);

	/**
	 * 회원 정보를 새롭게 삽입한다
	 * 
	 * @param joinParam - 삽입하려는 신규 회원 정보
	 */
	public void insert(Member joinParam);

}











