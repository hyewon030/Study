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

}










