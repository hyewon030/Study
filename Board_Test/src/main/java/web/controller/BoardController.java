package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dao.face.BoardDao;
import web.dto.Board;
import web.service.face.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {

	//서비스와 연결
	@Autowired BoardService boardService;
	
	//DAO와 연결
	@Autowired BoardDao boardDao;
	
	//로그 객체
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	//목록 조회
	@GetMapping("/list")
	public void list() {
		
	//board/list로 접속이 되는지?
	logger.info("/board/list [GET]");
		
	//list 조회
	List<Board> list = boardService.list();
	
	
	}
	
	
}
