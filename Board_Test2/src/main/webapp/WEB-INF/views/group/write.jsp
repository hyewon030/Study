<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">
h1 {
font-weight: bold;
}

hr {
clear: both; /* 이전 요소들과 무관하게 이어지는 요소를 지정 */

}

.view {
	width: 100%;
	border: solid;
	border-radius: 5px;
 	border-style: hidden;
	box-shadow: 0 0 0 1px #C7C8C9;
}

.content {
	width: 100%;
	border: solid;
	border-radius: 5px;
 	border-style: hidden;
	box-shadow: 0 0 0 1px #C7C8C9;
}

.btn {
     background-color: #2ECC71; 
    color: white;
    border: none;
    cursor: pointer;
    font-weight: bold;
    float: right;
}

.btn:hover {
    background-color: #04883C; /* 마우스 호버 시 배경 색상 변경 */
    color: white;
}

.btn:active {
    background-color: #2ECC71; /* 버튼을 클릭할 때 배경 색상 변경 */
    color: white;
}

.buttons .btn {
	margin-top: 10px;
	margin-right: 10px;
}

.article {
	padding: 30px;
	border: solid;
	border-radius: 5px;
 	border-style: hidden;
	box-shadow: 0 0 0 1px #C7C8C9;	
}

.writer-info {
	display: flex;
	flex-direction: row;
	justify-content: flex-start;
}

</style>

<div class="container">
<h1 style="color:#2ECC71">게시글 상세보기</h1>
<h6 style="color: #A4A4A4">캠핑 관련 게시글을 작성합니다.</h6>
<hr>

<div class="article">
<div class="title">

<div>
<h5>상태 및 위치 |</h5>
<label class="status">모집 현황</label>
<select class="status">
	<option>모집 중</option>
	<option>모집 완료</option>
</select><br>

</div><!-- 선택 내역 -->

<hr>

<input type="text" class="title" style="width:600px;">

</div><!-- 작성자 정보 -->
					
</div><!-- 글 제목 + 유저 정보 -->

<hr>

<div style="padding-top: 20px;">

${writerView.CONTENT }

</div><!-- .content -->
</div><!-- .article -->

<div class="buttons">
<!-- alert [작성 중인 내용이 있습니다. 취소하시겠습니까?] -->
<a href="./list"><button class="btn">취소</button></a>
<a href="./view?boardNo="><button class="btn">작성</button></a>
</div>


</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />