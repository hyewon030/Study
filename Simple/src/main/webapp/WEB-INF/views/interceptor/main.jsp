<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>인터셉터 테스트</h1>
<h3>메인 페이지</h3>
<hr>

<c:if test="${empty login }">
<a href="./login"><button>로그인</button></a>
</c:if>

<c:if test="${not empty login and login}">
<h3>${nick } 님, 환영합니다</h3>
<a href="./logout"><button>로그아웃</button></a>
</c:if>
<hr>

<!-- <a href="./admin/main">관리자 페이지로</a> -->

<c:if test="${not empty login and grade eq 'A' }">
<a href="./admin/main">관리자 페이지로</a>
<hr>
</c:if>

<a href="./board/list"><button>목록</button></a>

</body>
</html>


















