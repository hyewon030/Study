package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.BoardDao;
import web.dto.Board;
import web.service.face.BoardService;
import web.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired BoardDao boardDao;

	
	@Override
	public List<Board> list(Paging paging) {
		return boardDao.selectAll( paging );
	}
	
	@Override
	public Paging getPaging(Paging param) {

		//총 게시글 수 조회
		int totalCount = boardDao.selectCntAll();
		
		//페이징 객체 생성(페이징 계산)
		Paging paging = new Paging( totalCount, param.getCurPage() );
		
		return paging;
	}

	@Override
	public Board view(Board viewBoard) {
		
		//조회수 증가
		boardDao.updateHit(viewBoard);
		
		return boardDao.selectByBoardNo(viewBoard);
	}

	@Override
	public Board write(Board writeBoard, HttpSession session) {
		
		writeBoard.setWriterId((String) session.getAttribute("id"));
		writeBoard.setWriterNick((String) session.getAttribute("nick"));
		
		return boardDao.insert(writeBoard);
	}

}













