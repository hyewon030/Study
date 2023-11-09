package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dao.face.GroupDao;
import web.dto.Board;
import web.dto.User;
import web.service.face.GroupService;
import web.util.Paging;

@RequestMapping("/group")
@Controller
public class GroupController {

	@Autowired GroupService groupService;
	@Autowired GroupDao groupDao;
	
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@RequestMapping("/list")
	public void groupList( Paging param, Model model ) {
	
		//페이징 계산
		Paging paging = groupService.getPaging( param );
		logger.info("{}", paging);
		
		//게시글 목록 조회
		logger.info("{}",paging.getStartNo());
		logger.info("===================");
		
		List<Map<String,Object>> map = groupService.list( paging );
		
		logger.info(map.toString());
		model.addAttribute("board", map);
		
		//UserNick 가져오기
		//1. User 객체 생성, UserNick 가져오는 코드
//		User user = new User();
//		user = groupService.getUserNick(user);
		
		model.addAttribute("paging", paging);

		
		
		
		logger.info("================");



		//------------------------------------------------------------------
		
		
		}

	@GetMapping("/view")
    public String groupView(Board board, User user, Model model, HttpSession httpSession) {
		
		if( board.getBoardNo() < 1 ) {
			return "redirect:./list";
		}
		
		//1-1. 상세보기 게시글 조회
		board = groupService.view(board);
		
		//1-2. 게시판 모델값 전달
		model.addAttribute("board", board);

		//2-1. 유저 정보 가져오기
		user.setUserId(board.getUserId());
//	    user = groupService.getNick(user);
		
		//2-2. 유저 모델값 전달
		 model.addAttribute("user", user);
		 
	
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
