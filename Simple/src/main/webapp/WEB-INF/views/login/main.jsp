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

<h1>메인</h1>
<hr>

<%-- isLogin : ${isLogin } --%>

<c:if test="${empty isLogin }">
<a href="./login"><button>로그인</button></a>
<a href="./join"><button>회원가입</button></a>
</c:if>

<c:if test="${not empty isLogin and isLogin }">
<a href="./mypage"><button>마이페이지</button></a>
<a href="./logout"><button>로그아웃</button></a>
</c:if>

</body>
</html>












