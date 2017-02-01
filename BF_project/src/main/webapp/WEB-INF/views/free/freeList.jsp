<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	function gowrite() {
		document.free.action = "freeWrite";
		document.free.submit();
	}
</script>

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
						<b>FREE</b> BOARD
					</h2>
					<br> <br>
					<p>'자유게시판' 페이지 입니다.</p>
				</div>
			</section>
			<!-- //BREADCRUMBS -->
			<form name="free" method="post">
			<div class="container">
				<table class="table table-hover">
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>게시날짜</th>
						<th>조회수</th>
					</tr>
					<c:forEach items="${freeList }" var="freeVO">
						<tr>
							<td>${freeVO.fre_num }</td>
							<td>${freeVO.fre_title }</td>
							<td>${freeVO.mbr_id }</td>
							<td>${freeVO.fre_date }</td>
							<td>${freeVO.fre_cnt }</td>
						</tr>
					</c:forEach>
				</table>
				<button type="button" class="btn" onclick="gowrite()" style="color:white; background-color:black;" >글 작성</button>
			</div>				
			</form>
		</div>
	</div>

</body>
</html>