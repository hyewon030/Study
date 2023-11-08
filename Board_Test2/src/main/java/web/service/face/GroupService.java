package web.service.face;

import java.util.List;
import java.util.Map;

import web.dto.BoardTb;
import web.util.Paging;

public interface GroupService {

	public Paging getPaging(Paging param);

	public Map<String, Object> list(Paging paging);

	public BoardTb view(BoardTb viewBoard);

}
