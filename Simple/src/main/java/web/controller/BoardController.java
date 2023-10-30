package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public void list() {
		System.out.println("/board/list [GET]");
	}

	@RequestMapping(value = "/board/list", method = RequestMethod.POST)
	public void list_post() {
	}

	
	
	
	
	//method속성을 지정하지 않으면 모든 요청 메소드 방식을 처리할 수 있다
	// 같은 URL Pattern으로 지정한 메소드 처리 방식이 있으면
	//해당 방식을 제외한 나머지 요청 메소드들을 처리한다
	@RequestMapping(value = "/board/write")
	public void write() {}
	
	//POST요청 메소드일 경우에만 동작한다
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public void writeProcess() {}
	
	
	
	
	// value="속성값" 형태로 value속성을 단독으로 정의한 경우라면
	//value=를 생략하고 "속성값"만 적용할 수 있다
	//	** 다른 속성을 설정할 수 없다 (method속성)
//	@RequestMapping(value = "/board/update")
	@RequestMapping("/board/update")
	public void update() {}
	
	
	
	
	@RequestMapping("/board/delete")
	public void delete() {}
	
}














