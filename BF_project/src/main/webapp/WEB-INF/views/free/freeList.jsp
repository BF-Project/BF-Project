<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>

<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<script>
	function gowrite() {
		document.free.action = "freeWrite";
		document.free.submit();
	}
</script>

<style>
#freeList {
	margin: auto;
	width: 70%;
}

#writeBtn {
	margin-left: 75%;
}

td, th {
	text-align: center;
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
						<b>FREE</b> BOARD
					</h2>
					<br> <br>
					<p>'자유게시판' 페이지 입니다.</p>
				</div>
			</section>
			<!-- //BREADCRUMBS -->
			<br>
			<form name="free" method="post">
				<div class="container">
					<table class="table table-hover" id="freeList">
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>게시날짜</th>
							<th>조회수</th>
						</tr>

						<c:choose>
							<c:when test="${freeListSize<=0 }">
								<tr>
									<td width="100%" colspan="5" align="center" height="23">
										There are no registered Free.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${freeList }" var="freeVO">
									<tr>
										<td>${freeVO.fre_num }</td>
										<td><a href="freeView?fre_num=${freeVO.fre_num }">
												${freeVO.fre_title }</a></td>
										<td>${freeVO.mbr_id }</td>
										<td>${freeVO.fre_date }</td>
										<td>${freeVO.fre_cnt }</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
					
					<div style="margin-left:45%;">
						${paging }
					</div>
					<button type="button" id="writeBtn" class="btn" onclick="gowrite()"
						style="background-color: black;">글 작성</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>