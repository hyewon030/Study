package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dao.face.BoardDao;
import web.dto.Board;
import web.service.face.BoardService;
import web.util.Paging;


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
	public void list( Paging param, Model model ) {
	
	//페이징 계산
	Paging paging = boardService.getPaging( param );
	logger.info("{}", paging);
		
	//list 조회
	List<Board> list = boardService.list( paging );
	
	model.addAttribute("paging", paging);
	model.addAttribute("list", list);

	
	}
	
	
}
