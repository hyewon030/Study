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
			, url: "./test04_ok"
			, data: {}
			, dataType: "json"
			, success: function( res ) {
				console.log("AJAX 성공")
				
				//응답 JSON 데이터 확인
				console.log( res )
				
				console.log( res.rd.data1 )
				console.log( res.rd.data2 )
				
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

<h1>AJAX 테스트 04</h1>
<hr>

<button id="ajax">AJAX 요청 보내기</button>

</body>
</html>












