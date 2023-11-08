package web.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dao.face.GroupDao;
import web.dto.BoardTb;
import web.service.face.GroupService;
import web.util.Paging;

@RequestMapping("/group")
@Controller
public class GroupController {

	@Autowired GroupService groupService;
	@Autowired GroupDao groupDao;
	
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@RequestMapping("/list")
	public void list( Paging param, Model model ) {
	
		//페이징 계산
		Paging paging = groupService.getPaging( param );
		logger.info("{}", paging);
		
		//게시글 목록 조회
//		List<Board> list = groupService.list( paging );
		logger.info("{}",paging.getStartNo());
		logger.info("====================");
		Map<String,Object> map = groupService.list( paging );
		
		model.addAttribute("paging", paging);
		
		model.addAttribute("list", map.get("list"));
//		model.addAttribute("list", list);		
	}

	@GetMapping("/view")
	public String view( Model model, BoardTb viewBoard ) {
		
		if( viewBoard.getBoardNo() < 1 ) {
			return "redirect:./list";
		}
		
		//상세보기 게시글 조회
		viewBoard = groupService.view(viewBoard);
		
		//모델값 전달
		model.addAttribute("viewBoard", viewBoard);
		
		return "group/view";
		
	}
	
	
	
	
	

//	public void boardWrite(){}
//	public String boardWriteProc(Board, BoardFile, MultipartFile, HttpSession){}
//
//	public void boardUpdate(Model, Board, BoardFile){}
//	public String boardUpdateProc(Board, BoardFile, MultipartFile) {}
//
//
//	public void boardDelete(Board) {}
//
//	public String recommend(Recommend, Model) {}
	
	
}
