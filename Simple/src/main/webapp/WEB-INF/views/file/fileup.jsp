<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>스프링 파일업로드 테스트</h1>
<hr>

<form action="./fileup" method="post" enctype="multipart/form-data">

<label for="title">제목</label>
<input type="text" name="title" id="title"><br>

<label for="file">첨부파일</label>
<input type="file" name="file" id="file"><br><br>

<label for="data1">테스트</label>
<input type="text" name="data1" id="data1"><br>

<label for="data2">테스트</label>
<input type="text" name="data2" id="data2"><br>

<label for="data3">테스트</label>
<input type="text" name="data3" id="data3"><br><br>

<button>전송</button>

</form>

</body>
</html>














