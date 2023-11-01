package web.dao.face;

import java.util.List;

import web.dto.Board;

public interface BoardDao {

	/**
	 * 게시글 조회
	 * @return
	 */
	List<Board> selectAll();

	
}
