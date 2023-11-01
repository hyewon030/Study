# 자주 발생하는 오류 및 해결방안 제시

1.
오류 내용
Request processing failed; nested exception is org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): web.dao.face.BoardDao.deleteFileByBoardNo

💡오류 원인 및 해결 방법
- 원인은 다양하겠지만, 내 경우 Dao와 Mapper에서 'deleteFileByBoardNo'를 동일하게 작성하지 않아서 이러한 오류가 생겼다. 

2. 
오류 내용
Error creating bean with name 'SqlSessionFactory' defined in ServletContext resource [/WEB-INF/spring/root-context.xml]: Invocation of init method failed; nested exception is java.io.IOException: Failed to parse mapping resource: 'file [E:\Program\Spring_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board_Test\WEB-INF\classes\web\dao\mapper\BoardMapper.xml]'

💡오류 원인 및 해결 방법
- 매퍼에 sql을 연결하는 코드를 작성하지 않아서 이러한 오류가 발생했다.
