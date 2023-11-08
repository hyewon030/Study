package web.dao.face;

import java.util.List;

import web.dto.BoardTb;
import web.dto.GroupTb;
import web.util.Paging;

public interface GroupDao {

	public int selectCntAll(Paging param);

	public List<BoardTb> selectBoardList(Paging paging);

	public void updateHit(BoardTb viewBoard);

	public BoardTb selectByBoardNo(BoardTb viewBoard);

	

}
