package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.util.Paging;

public interface BoardDao {

	/**
	 * 게시글 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return 게시글 목록
	 */
	public List<Board> selectAll(Paging paging);

	/**
	 * 전체 게시글 수를 조회한다
	 * 
	 * @return 총 게시글 수
	 */
	public int selectCntAll();

	/**
	 * 조회하려는 게시글의 조회수를 1 증가 시킨다
	 * 
	 * @param viewBoard - 게시글 번호 객체
	 */
	public void updateHit(Board viewBoard);

	/**
	 * 게시글 번호를 이용하여 게시글을 조회한다
	 * 
	 * @param viewBoard - 조회하려는 게시글의 번호 객체
	 * @return 조회된 게시글 정보
	 */
	public Board selectByBoardNo(Board viewBoard);

	
	/**
	 * 게시글을 새로 작성한다
	 * 
	 * @param writeBoard
	 * @return
	 */
	public Board insert(Board writeBoard);

}










