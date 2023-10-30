package file.service.face;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import file.dto.Filetest;

public interface FileService {

	/**
	 * 전달파라미터를 처리한다
	 * 폼필드(title), 파일(file)
	 * 
	 * 파일은 upload폴더에 저장되도록 한다
	 * 
	 * DB에 폼필드 정보와 파일의 정보를 저장한다
	 * 파일 정보는 upload폴더에 저장된 이름(stored_name), 원본 파일명(origin_name)
	 * 
	 * @param title - 제목
	 * @param file - 파일
	 */
	public void filesave(String title, MultipartFile file);

	/**
	 * 업로드된 파일 목록 정보를 조회한다
	 * 
	 * @return 업로드된 파일 목록
	 */
	public List<Filetest> list();

	/**
	 * 파일번호를 이용하여 업로드된 파일의 정보를 조회한다
	 * 
	 * @param fileno - 조회하려는 파일 번호
	 * @return 조회된 파일 정보 객체
	 */
	public Filetest getFile(int fileno);

}













