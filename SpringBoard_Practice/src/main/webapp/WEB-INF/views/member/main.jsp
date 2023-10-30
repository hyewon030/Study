<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

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

<div class="container">
<h1>메인</h1>
<hr>

<div class="text-center">
<c:choose>
	<%-- 비로그인 --%>
	<c:when test="${empty login or not login}">
		<a class="btn btn-info" href="/member/join">회원가입</a>
		|
		<a class="btn btn-primary" href="/member/login">로그인</a>
	</c:when>
	
	<%-- 로그인 --%>
	<c:when test="${not empty login and login}">
		<a class="btn btn-warning" href="/member/logout">로그아웃</a>
	</c:when>
</c:choose>
</div>

<hr>

<a class="btn btn-success" href="/board/list">게시글 목록</a>

</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />















