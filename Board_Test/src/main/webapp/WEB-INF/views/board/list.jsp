<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">
table, th {
	text-align: center;
}

/* 게시글 제목 */
td:nth-child(2) {
	text-align: left;
}

</style>

<div class="container">
<h1 style="color:#04883C">자유게시판</h1>
<h6 style="color: #2ECC71">캠핑 관련 게시글을 작성하고 조회할 수 있습니다.</h6>
<hr>

<table class="table table-boarded table-hover">
	<thead class="table-success">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>작성일</th>
	</tr>
	</thead>

<colgroup>
	<col style="width: 10%;">
	<col style="width: 45%;">
	<col style="width: 15%;">
	<col style="width: 10%;">
	<col style="width: 20%;">
</colgroup>	

	<tbody>
	<c:forEach var="board" items="${list }">
	<tr>
		<td>${board.boardNo }</td>
		<td>${board.title }</td>
		<td>${board.writerId }</td>
		<td>${board.hit }</td>
		<td> <fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>

</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/pagination.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />