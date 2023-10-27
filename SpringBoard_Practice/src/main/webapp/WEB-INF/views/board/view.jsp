<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>🎀게시글 리스트🎀</title>

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

</head>
<body>

<h1 style="color: deeppink">🎀게시판 상세보기🎀</h1>
<hr>

제목 : ${board.title }<br>
본문 : ${board.content }<br>
작성자 : ${board.writerNick }


</body>
</html>