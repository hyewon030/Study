package file.dao.face;

import java.util.List;

import file.dto.Filetest;

public interface FileDao {

	/**
	 * 전달된 파일 정보 삽입하기
	 * 
	 * @param filetest - 업로드된 파일 정보
	 */
	public void insertFile(Filetest filetest);

	/**
	 * 업로드된 전체 파일 정보 조회하기
	 * 
	 * @return 업로드된 파일 목록
	 */
	public List<Filetest> selectAll();

	/**
	 * 파일 번호를 이용하여 업로드 파일 정보 조회하기
	 * 
	 * @param fileno - 조회할 파일 번호
	 * @return 조회된 파일 정보
	 */
	public Filetest selectByFileno(int fileno);

}
















