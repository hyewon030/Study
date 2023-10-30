package login.dao.face;

import login.dto.Login;

public interface LoginDao {

	public void insert(Login login);

	public int selectCntByIdPw(Login login);

	public Login selectById(String loginid);

}
