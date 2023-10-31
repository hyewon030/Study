package web.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import web.dao.face.BoardDao;
import web.dto.Board;
import web.dto.Boardfile;
import web.service.face.BoardService;
import web.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired BoardDao boardDao;
	
	@Autowired ServletContext context;
	
	
	@Override
	public List<Board> list(Paging paging) {
		return boardDao.selectAll( paging );
	}
	
	@Override
	public Paging getPaging(Paging param) {

		//총 게시글 수 조회
		int totalCount = boardDao.selectCntAll();
		
		//페이징 객체 생성(페이징 계산)
		Paging paging = new Paging( totalCount, param.getCurPage() );
		
		return paging;
	}
	
	@Override
	public Board view(Board viewBoard) {
		
		//update 일 때에는 조회수가 증가되지 않는다
		if( viewBoard.getHit() != -1 ) {
			//조회수 증가
			boardDao.updateHit(viewBoard);
		}
		
		return boardDao.selectByBoardNo(viewBoard);
	}
	
	@Override
	@Transactional
	public void write(Board writeParam, List<MultipartFile> file) {
		
		if( writeParam.getTitle() == null || "".equals(writeParam.getTitle()) ) {
			writeParam.setTitle("(제목없음)");
		}
		
		boardDao.insert( writeParam );
		
		//---------------------------------------------------------------------------
		
		//첨부파일이 없을 경우 처리
		if( file.size() == 0 ) {
			return;
		}

		for(MultipartFile f : file) {
			this.fileinsert( f, writeParam.getBoardNo() );
		}

	}
	
	private void fileinsert( MultipartFile file, int boardNo ) {
		//빈 파일 처리
		if( file.getSize() <= 0 ) {
			return;
		}
		
		//파일이 저장될 경로
		String storedPath = context.getRealPath("upload");
		
		//upload 폴더 생성
		File storedFolder = new File(storedPath);
		storedFolder.mkdir();
		
		
		//저장될 파일 이름
		String originName = file.getOriginalFilename();
		String storedName = originName + UUID.randomUUID().toString().split("-")[4];
		
		
		//저장할 파일 객체
		File dest = new File(storedFolder, storedName);
	
		
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//---------------------------------------------------------------------------

		Boardfile boardfile = new Boardfile();
		boardfile.setBoardNo( boardNo );
		boardfile.setOriginName( originName );
		boardfile.setStoredName( storedName );
		
		boardDao.insertFile( boardfile );
	}
	
	@Override
	public List<Boardfile> getAttachFile(Board viewBoard) {
		return boardDao.selectBoardfileByBoardNo( viewBoard );
	}
	
	@Override
	public Boardfile getFile(Boardfile boardfile) {
		return boardDao.selectBoardfileByFileNo(boardfile);
	}
	
	@Override
	@Transactional
	public void update(Board updateParam, List<MultipartFile> file, int[] delFileno) {
	
		if( updateParam.getTitle() == null || "".equals(updateParam.getTitle()) ) {
			updateParam.setTitle("(제목없음)");
		}
		
		boardDao.update( updateParam );

		//---------------------------------------------------------------------------
		
		//첨부파일이 없을 경우 처리
		if( file.size() == 0 ) {
			return;
		}

		for(MultipartFile f : file) {
			this.fileinsert( f, updateParam.getBoardNo() );
		}

		//---------------------------------------------------------------------------

		//삭제할 첨부 파일 처리
		if( delFileno != null ) {
			boardDao.deleteFiles( delFileno );
		}
		
	}

	@Override
	@Transactional
	public void delete(Board deleteParam) {
		boardDao.deleteFileByBoardNo( deleteParam );	//첨부파일 삭제
		boardDao.deleteByBoardNo( deleteParam );		//게시글 삭제
		
	}

	
}
















