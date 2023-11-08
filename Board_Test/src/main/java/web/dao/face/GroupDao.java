package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.dto.GroupTb;
import web.util.Paging;

public interface GroupDao {

	public int selectCntAll(Paging param);

	public List<Board> selectBoardList(Paging paging);

	

}
