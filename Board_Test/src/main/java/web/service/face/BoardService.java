package web.service.face;

import java.util.List;

import web.dto.Board;
import web.util.Paging;

public interface BoardService {

	List<Board> list(Paging paging);

	Paging getPaging(Paging param);


}
