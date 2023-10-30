<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>맵 모델값 전달 테스트</h1>
<hr>

${m }
<hr>

<%-- .addAttribute("m", paramMap); --%>
data1 : ${m.data1 }<br>
data2 : ${m.data2 }<br>
data3 : ${m.data3 }<br>
data4 : ${m.data4 }<br><br>

username : ${m.username }<br>
userage : ${m.userage }
<hr>

<%-- .addAllAttribute(paramMap); --%>
data1 : ${data1 }<br>
data2 : ${data2 }<br>
data3 : ${data3 }<br>
data4 : ${data4 }<br><br>

username : ${username }<br>
userage : ${userage }
<hr>

<a href="./map">폼으로</a>

</body>
</html>















