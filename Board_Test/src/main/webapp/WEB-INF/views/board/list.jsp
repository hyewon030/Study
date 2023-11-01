<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- 폰트 가져오는 링크 -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font.css" />">

<h1>자유게시판</h1>
<h6>캠핑 관련 게시글을 작성하고 조회할 수 있습니다.</h6>
<hr>

<table>
	<thead>
	<tr>
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
		<td>${board.title }</td>
		<td>${board.writerId }</td>
		<td>${board.hit }</td>
		<td> <fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>

<c:import url="/WEB-INF/views/layout/footer.jsp" />