package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dto.Board;
import web.service.face.BoardService;
import web.util.Paging;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired BoardService boardService;
	
	@RequestMapping("/list")
	public void list( Paging param, Model model ) {
		
		//페이징 계산
		Paging paging = boardService.getPaging( param );
		logger.info("{}", paging);
		
		//게시글 목록 조회
		List<Board> list = boardService.list( paging );
		
		model.addAttribute("paging", paging);
		model.addAttribute("list", list);
	}	
	
	@RequestMapping("/view")
	public String view(Board viewBoard, Model model) {
		
		if( viewBoard.getBoardNo() < 1 ) {
			return "redirect:./list";
		}
		
		
		//상세보기 게시글 조회
		viewBoard = boardService.view(viewBoard);
		
		//모델값 전달
		model.addAttribute("viewBoard", viewBoard);
		
		return "board/view";
	}
	
}














