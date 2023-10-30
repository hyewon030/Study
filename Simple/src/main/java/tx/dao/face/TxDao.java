package tx.dao.face;

public interface TxDao {

	/**
	 * 전달된 deptno값을 dept테이블에 삽입한다
	 * 
	 * @param deptno
	 */
	public void insertDept(int deptno);
	
	/**
	 * 전달된 deptno+1값을 dept테이블에 삽입한다
	 * 
	 * @param deptno
	 */
	public void insertDeptPlusOne(int deptno);
	
}
