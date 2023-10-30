package file.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import file.dao.face.FileDao;
import file.dto.Filetest;
import file.service.face.FileService;

@Service
public class FileServiceImpl implements FileService {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );

	@Autowired FileDao fileDao;
	
	@Autowired ServletContext context;
	
	@Override
	public void filesave(String title, MultipartFile file) {
		
		if( file.getSize() <= 0 ) {
			logger.info("파일의 크기가 0이다, 처리 중단!");
			
			//filesave() 메소드 중단
			return;
		}
		
		//파일이 저장될 경로 - RealPath
		String storedPath = context.getRealPath("upload");
		logger.info("storedPath : {}", storedPath);
		
		//upload폴더가 존재하지 않으면 생성하기
		File storedFolder = new File(storedPath);
		storedFolder.mkdir();
		
		//업로드된 파일이 저장될 이름
		String storedName = null;
		
		//저장될 파일 객체
		File dest = null;
		
		//저장될 파일명이 중복되지 않도록 반복
		do {
			storedName = file.getOriginalFilename(); //원본 파일명
			storedName += UUID.randomUUID().toString().split("-")[4]; //UUID 추가
			logger.info("storedName : {}", storedName);
			
			dest = new File(storedFolder, storedName);
		} while( dest.exists() );

		
		try {
			
			//업로드된 파일을 upload폴더에 저장하기
			file.transferTo(dest);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		//--------------------------------------------------------------------
		
		//DB에 기록하기
		Filetest filetest = new Filetest();
		
		filetest.setTitle(title);
		filetest.setOriginName( file.getOriginalFilename() );
		filetest.setStoredName( storedName );
		logger.info("filetest : {}", filetest);
		
		fileDao.insertFile( filetest );
		logger.info("filetest : {}", filetest);

	}
	
	@Override
	public List<Filetest> list() {
		return fileDao.selectAll();
	}
	
	@Override
	public Filetest getFile(int fileno) {
		return fileDao.selectByFileno(fileno);
	}
	
}


















