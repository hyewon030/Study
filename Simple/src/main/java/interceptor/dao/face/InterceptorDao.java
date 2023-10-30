package interceptor.dao.face;

import interceptor.dto.User;

public interface InterceptorDao {

	public int selectCntByIdPw(User user);

	public User selectById(User user);

}
















