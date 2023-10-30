<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<script type="text/javascript">
$(function() {
	$("#ajax").click(function() {
		$.ajax({
			type: "get"
			, url: "./test03_ok"
			, data: {}
			, dataType: "html"
			, success: function( res ) {
				console.log("AJAX 성공")
				
				//JS 코드
// 				result.innerHTML = res

				//jQuery 코드
				$("#result").html(res)
				
			}
			, error: function() {
				console.log("AJAX 실패")
			}		
		})
	})
})
</script>

</head>
<body>

<h1>AJAX 테스트 03</h1>
<hr>

<button id="ajax">AJAX 요청 보내기</button>

<div id="result"></div>

</body>
</html>














