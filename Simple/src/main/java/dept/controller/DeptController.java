package dept.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dept.dto.Dept;
import dept.service.face.DeptService;

@Controller
public class DeptController {

	//로그 객체
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	//서비스객체
	@Autowired private DeptService deptService;
	
	
	@GetMapping("/dept/list")
	public void list(Model model) {
		logger.info("/dept/list [GET]");
		
		List<Dept> list = deptService.list();
		
		model.addAttribute("list", list);
	}
	
}













