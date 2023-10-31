# 자주 발생하는 오류 및 해결방안 제시

1. 
Request processing failed; nested exception is org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): web.dao.face.BoardDao.deleteFileByBoardNo

💡왜 발생했을까?
- 원인은 다양하겠지만, 내 경우 Dao와 Mapper에서 'deleteFileByBoardNo'를 동일하게 작성하지 않아서 이러한 오류가 생겼다. 

