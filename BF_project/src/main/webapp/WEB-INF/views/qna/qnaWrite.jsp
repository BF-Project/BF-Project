<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	function goList() {
		document.form2.action = "qnaWriteForm";
		document.form2.method = "post";
		document.form2.submit();
	}
</script>

<style>
#write {
	margin-left: 380px;
}

#writeBtn {
	margin-left: 442px;
}
</style>

</head>
<body>
	<!-- PRELOADER -->
	<img id="preloader"
		src="<%=request.getContextPath()%>/resources/images/preloader.gif"
		alt="" />
	<!-- 로딩 이미지 -->

	<!-- //PRELOADER -->
	<div class="preloader_hide">
		<div class="qnaHeader">

			<!-- BREADCRUMBS -->
			<section class="breadcrumbs_block clearfix parallax">
				<div class="container center">
					<h2>
						<b>Q & A</b> 고객 게시판
					</h2>
					<br> <br>
					<p>'Q & A 게시판' 페이지 입니다.</p>
				</div>
			</section>
			<!-- //BREADCRUMBS -->
			<br>
			<div class="container">
				<form name="form2" method="post" action="qnaWriteForm" id="write" enctype="multipart/form-data">
					<div class="form-group">
						<label for="usr">Title</label> <input type="text" name="qna_title"
							class="form-control" id="usr" style="width: 30%;">
					</div>
					<div class="form-group">
						<label for="comment">Comment</label>
						<textarea class="form-control" rows="5" name="qna_content"
							id="comment" style="width: 50%; height: 300px;"></textarea>
					</div>
			
			
				<input type="file" name="file">
	
			
				</form>
			</div>
			<button type="button" id="writeBtn" class="btn" onclick="goList()"
				style="color: white; background-color: black;" id="reg">등록</button>
		</div>
	</div>

</body>
</html>