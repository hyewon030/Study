package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.dto.Boardfile;
import web.util.Paging;

public interface BoardDao {

	/**
	 * 게시글 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return 게시글 목록
	 */
	public List<Board> selectAll(Paging paging);

	/**
	 * 전체 게시글 수를 조회한다
	 * 
	 * @return 총 게시글 수
	 */
	public int selectCntAll();

	/**
	 * 조회하려는 게시글의 조회수를 1 증가 시킨다
	 * 
	 * @param viewBoard - 게시글 번호 객체
	 */
	public void updateHit(Board viewBoard);

	/**
	 * 게시글 번호를 이용하여 게시글을 조회한다
	 * 
	 * @param viewBoard - 조회하려는 게시글 번호 객체
	 * @return 조회된 게시글 정보
	 */
	public Board selectByBoardNo(Board viewBoard);

	/**
	 * 게시글 정보를 삽입한다
	 * 
	 * @param writeParam - 삽입할 게시글 정보
	 */
	public void insert(Board writeParam);

	/**
	 * 첨부파일 정보를 삽입한다
	 * 
	 * @param boardfile - 삽입할 첨부파일 정보
	 */
	public void insertFile(Boardfile boardfile);

	/**
	 * 게시글 번호를 이용하여 첨부파일 정보를 조회한다
	 * 
	 * @param viewBoard - 조회할 게시글 번호 객체
	 * @return 조회된 첨부파일 정보
	 */
	public List<Boardfile> selectBoardfileByBoardNo(Board viewBoard);
	
	/**
	 * 파일 번호를 이용하여 첨부파일 정보를 조회한다
	 * 
	 * @param viewBoard - 조회할 파일 번호 객체
	 * @return 조회된 첨부파일 정보
	 */
	public Boardfile selectBoardfileByFileNo(Boardfile boardfile);

	/**
	 * 게시글 내용을 수정한다
	 * 제목, 본문을 주어진 게시글 번호를 이용하여 수정한다
	 * 
	 * @param updateParam - 수정할 내용이 담긴 객체
	 */
	public void update(Board updateParam);

	/**
	 * 기존의 첨부파일을 삭제한다
	 * 
	 * @param delFileno - 삭제하려는 파일 번호들
	 */
	public void deleteFiles(int[] delFileno);

}


















