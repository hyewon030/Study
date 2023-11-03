package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.util.Paging;

public interface BoardDao {

	public List<Board> selectAll(Paging paging);

	public int selectCntAll();

	public void updateHit(Board viewBoard);

	public Board selectByBoardNo(Board viewBoard);

	
}
