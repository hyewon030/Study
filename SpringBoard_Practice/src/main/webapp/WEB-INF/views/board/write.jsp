<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- 스타일 적용 시작 -->
<style type="text/css">
@font-face {
    font-family: 'BMJUA';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/BMJUA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

* {
	font-family: 'BMJUA';
}
</style>
<!-- 스타일 적용 끝 -->

<div class="container">
<h1 style="color: deeppink">게시글 작성</h1>
<hr>

<label>아이디 | ${id }</label><br>
<label>닉네임 | ${nick }</label>

<hr>

<form action="./write" method="post" >
<label>제목<br><input type="text" name="title" style="width:600px;height:30px;font-size:20px;"></label><br>
<label>내용<br><input type="text" name="content" style="width:600px;height:600px;font-size:20px;"></label>

<div class="text-center">
	<a href="./list" class="btn btn-secondary">목록</a>
	|
	<a href="./write"><button class="btn btn-secondary">전송</button></a>
</div>
</form>

</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />