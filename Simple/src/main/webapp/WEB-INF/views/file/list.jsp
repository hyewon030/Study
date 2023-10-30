<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
table, th, td {
	border: 1px solid #ccc;
	border-collapse: collapse;
}
</style>

</head>
<body>

<h1>파일 목록</h1>
<hr>

<table>
<thead>
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>파일명</th>
</tr>
</thead>

<tbody>
<c:forEach items="${list }" var="filetest">
<tr>
	<td>${filetest.fileno }</td>
	<td>${filetest.title }</td>
	<td>
		<a href="../upload/${filetest.storedName }" download="${filetest.originName }">
			${filetest.originName }
		</a>
	</td>
	<td>
		<a href="./download?fileno=${filetest.fileno }">${filetest.originName }</a>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<hr>

<a href="./fileup"><button>파일 업로드</button></a>

</body>
</html>












