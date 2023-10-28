<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(() => {
	$("#title").focus()
})
</script>

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
</style>
<!-- 스타일 적용 끝 -->

<div class="container">
<h1 style="color: deeppink">글 작성</h1>
<hr>

<div class="col-10 mx-auto">
<form action="./write" method="post" enctype="multipart/form-data">

<div class="form-group mb-3">
	<label class="form-label">작성자</label>
	<input type="text" class="form-control" readonly="readonly" value="${nick }">
</div>

<div class="form-group mb-3">
	<label class="form-label" for="title">제목</label>
	<input type="text" class="form-control" name="title" id="title"><br>
</div>
	
<div class="form-group mb-3">	
	<label class="form-label" for="content">본문</label>
	<textarea class="form-control" name="content" id="content"></textarea>
</div>

<div class="form-group mb-3">	
	<label class="form-label" for="file">첨부파일</label>
	<input type="file" class="form-control" name="file" id="file">
</div>

<div class="text-center">
	<button class="btn btn-primary" id="btnWrite">작성</button>
	<button type="reset" class="btn btn-danger" id="btnCancel">취소</button>	
</div>

</form>
</div>


</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />