package file.controller;

import java.util.List;

import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import file.dto.FileParam;
import file.dto.Filetest;
import file.service.face.FileService;

@Controller
@RequestMapping("/file")
public class FileController {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired FileService fileService;
	
	
	@GetMapping("/fileup")
	public void fileForm() {}
	
	@PostMapping("/fileup")
	public String fileProc (
			
			String title,
			@RequestParam("title") String t,
			
			MultipartFile file,
			@RequestParam("file") MultipartFile f,
			
			FileParam param
			
			) {
		logger.info("/file/fileup [POST]");
		
		logger.info("title : {}", title);
		logger.info("t : {}", t);
		
		logger.info("file : {}", file);
		logger.info("f : {}", f);
		
		logger.info("param : {}", param);
		//------------------------------------------------------------------
		
		fileService.filesave(title, file);
		//------------------------------------------------------------------

		return "redirect:./list";
	}
	
	@RequestMapping("/list")
	public void filelist( Model model ) {
		logger.info("/file/list");
		
		List<Filetest> list = fileService.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("/download")
	public String download(int fileno, Model model) {
		
		//파일번호에 해당하는 파일 정보 가져오기
		Filetest file = fileService.getFile(fileno);
		logger.info("file {}", file);
		
		//다운로드 응답용 파일의 정보를 모델값으로 전달한다
		model.addAttribute("downFile", file);
		
		//viewName을 "down"으로 지정한다
		//	-> BeanNameViewResolver가 id가 "down"인 스프링 빈을 찾아서
		//	 응답 View로 활용하게 만든다
		return "down";
	}

}
















