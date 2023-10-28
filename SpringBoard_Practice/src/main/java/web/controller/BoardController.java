package web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import web.dto.Board;
import web.dto.Boardfile;
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
		model.addAttribute("viewBoard", viewBoard);
		
		
		//첨부파일 정보 전달
		List<Boardfile> boardfile = boardService.getAttachFile( viewBoard );
		model.addAttribute("boardfile", boardfile);
		logger.info("boardfile : {}", boardfile);
		
		return "board/view";
	}

	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String writeProc(Board writeParam, List<MultipartFile> file, HttpSession session) {
		logger.info("writeParam : {}", writeParam);
		
		writeParam.setWriterId((String) session.getAttribute("id"));
		writeParam.setWriterNick((String) session.getAttribute("nick"));
		
		boardService.write( writeParam, file );
		logger.info("writeParam : {}", writeParam);
		
//		return "redirect:./list";
		return "redirect:./view?boardNo=" + writeParam.getBoardNo();
	}

	@RequestMapping("/download")
	public String down(Boardfile boardfile, Model model) {
		
		//첨부파일 정보 조회
		boardfile = boardService.getFile( boardfile );
		model.addAttribute("downFile", boardfile);
		
		return "down";
	}
	
}


















