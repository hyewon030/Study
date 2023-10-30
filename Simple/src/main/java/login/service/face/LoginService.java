package login.service.face;

import login.dto.Login;

public interface LoginService {

	public void join(Login login);

	public boolean login(Login login);

	public Login info(String loginid);

}


















