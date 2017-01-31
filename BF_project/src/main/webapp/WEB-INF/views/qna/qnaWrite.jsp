<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<script>
	function goList() {
		document.form2.action="qnaWriteForm";
		document.form2.method ="post";
		document.form2.submit();
	}
</script>

</head>
<body>
	<div>
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
		<div>
			<form name="form2" method="post" action="qnaWriteForm">
				<label>title</label><br> 
				<input type="text" name="qna_title" size="30"><br>
				<label>content</label><br>
				<textarea rows="8" cols="65" id="content1" name="qna_content"></textarea>
				<br>
			</form>
			<input type="button" value="등록" onclick="goList()">
		</div>
	</div>
</body>
</html>