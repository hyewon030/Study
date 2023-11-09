package web.dao.face;

import java.util.List;
import java.util.Map;

import web.dto.Board;
import web.dto.GroupTb;
import web.dto.User;
import web.util.Paging;

public interface GroupDao {

	//게시글 목록 조회
	public int selectCntAll(Paging param);

	/**
	 * 게시글 정보 조회
	 * @param paging
	 * @return
	 */
	public List<Board> selectBoardList(Paging paging);

	/**
	 * 유저 정보 조회
	 * @param paging
	 * @return
	 */
	public List<User> selectUserNick(Paging paging);

	/**
	 * 게시글 조회수
	 * @param board
	 */
	public void updateHit(Board board);

	public Board selectByBoardNo(Board board);


}
