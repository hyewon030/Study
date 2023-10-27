<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

table, th {
	text-align: center;
}

/* 게시글 제목 */
td:nth-child(2) {
	text-align: left;
}

hr {
color: deeppink;

}

a:link { color:hotpink; }
a:visited { color: pink; }
a:hover {color: deeppink; }
/* a:actice {color: green; } */

</style>

<div class="container">
<center><h1>게시글 리스트</h1>
<hr>

<table class="table table-striped table-hover table-sm">

<colgroup>
	<col style="width: 10%;">
	<col style="width: 45%;">
	<col style="width: 15%;">
	<col style="width: 10%;">
	<col style="width: 20%;">
</colgroup>

<thead>
	<tr class="table-danger">
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>작성일</th>
	</tr>
</thead>

<tbody>
<c:forEach var="board" items="${list }">
	<tr>
		<td>${board.boardNo }</td>
		<td>${board.title }</a></td>
		<td>${board.writerId }</td>
		<td>${board.hit }</td>
		<td>
			<fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/>		
		</td>
	</tr>
</c:forEach>
</tbody>
</table>

<small class="float-end mb-3">total: ${paging.totalCount }</small>

<div class="clearfix"></div>

</div><!-- .container -->


<c:import url="/WEB-INF/views/layout/pagination.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />















