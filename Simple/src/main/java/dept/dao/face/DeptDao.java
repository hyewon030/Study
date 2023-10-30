package dept.dao.face;

import java.util.List;

import dept.dto.Dept;

public interface DeptDao {

	/**
	 * 전체 부서 정보 조회
	 * 
	 * @return 조회된 부서 목록
	 */
	public List<Dept> selectAll();
	
}











