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

.content {
	min-height: 300px;
}
</style>
<!-- 스타일 적용 끝 -->

<div class="container">
<h1 style="color: deeppink">🎀게시글 상세보기🎀</h1>
<hr>

<table class="table table-bordered">

<colgroup>
	<col style="width: 15%;">
	<col style="width: 35%;">
	<col style="width: 15%;">
	<col style="width: 35%;">
</colgroup>

<tr>
	<td class="table-info">글번호</td><td colspan="3">${viewBoard.boardNo }</td>
</tr>
<tr>
	<td class="table-info">아이디</td><td>${viewBoard.writerId }</td>
	<td class="table-info">닉네임</td><td>${viewBoard.writerNick }</td>
</tr>
<tr>
	<td class="table-info">조회수</td><td>${viewBoard.hit }</td>
	<td class="table-info">작성일</td>
	<td><fmt:formatDate value="${viewBoard.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
</tr>
<tr>
	<td class="table-info">제목</td><td colspan="3">${viewBoard.title }</td>
</tr>
<tr>
	<td class="table-info" colspan="4">본문</td>
</tr>
<tr>
	<td colspan="4">
		<div class="content">
		${viewBoard.content }
		</div>
	</td>
</tr>
</table>

<div class="text-center">
	<a href="./list" class="btn btn-secondary">목록</a>
	
	<c:if test="${id eq viewBoard.writerId }">
		<a href="./update?boardNo=${viewBoard.boardNo }" class="btn btn-primary">수정</a>
		<a href="./delete?boardNo=${viewBoard.boardNo }" class="btn btn-danger">삭제</a>
	</c:if>
</div>

</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />