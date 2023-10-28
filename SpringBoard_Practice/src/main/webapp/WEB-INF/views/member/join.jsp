<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(() => {
	$("#id").focus()
})
</script>

<div class="container">
<h1>회원가입</h1>
<hr>

<div class="col-6 mx-auto my-5">
<form action="./join" method="post">

	<div class="row mb-3">
		<label for="id" class="col-2 col-form-label">ID</label>
		<div class="col-10">
			<input type="text" class="form-control" id="id" name="id">
		</div>
	</div>
	
	<div class="row mb-3">
		<label for="pw" class="col-2 col-form-label">PASS</label>
		<div class="col-10">
			<input type="text" class="form-control" id="pw" name="pw">
		</div>
	</div>
	
	<div class="row mb-3">
		<label for="nick" class="col-2 col-form-label">NICK</label>
		<div class="col-10">
			<input type="text" class="form-control" id="nick" name="nick">
		</div>
	</div>
	
	<div class="row mb-3 justify-content-center">
		<button class="col-3 btn btn-primary">회원가입</button>
	</div>	
	
</form>
</div>

</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />











