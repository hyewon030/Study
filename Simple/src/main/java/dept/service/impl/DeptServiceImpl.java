package dept.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dept.dao.face.DeptDao;
import dept.dto.Dept;
import dept.service.face.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	//로그 객체
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	//DAO객체
	@Autowired DeptDao deptDao;
	
	@Override
	public List<Dept> list() {
		logger.info("list()");
		
		return deptDao.selectAll();
	}
	
}













