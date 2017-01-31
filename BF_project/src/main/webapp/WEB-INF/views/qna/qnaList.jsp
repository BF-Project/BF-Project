<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A 게시판</title>
<script>
	function gowrite() {
		document.form1.action = "qnaWrite";
		document.form1.submit();
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
						<b>Q & A</b> 고객 게시판
					</h2>
					<br> <br>
					<p>'Q & A 게시판' 페이지 입니다.</p>
				</div>
			</section>
			<!-- //BREADCRUMBS -->

			<form name="form1" method="post">
				<div>
					<table id="qnaList" border="1">
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>게시날짜</th>
							<th>조회수</th>
						</tr>

						<c:choose>
							<c:when test="${qnaListSize<=0}">
								<tr>
									<td width="100%" colspan="5" align="center" height="23">
										There are no registered Q&A.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${qnaList}" var="qnaVO">
									<tr>
										<td>${qnaVO.qna_num }</td>
		
										<!-- 수정1. -->
										<td><a href="qnaView?qna_num=${qnaVO.qna_num}">
												${qnaVO.qna_title }</td>
										<td>${qnaVO.mbr_id }</td>
										<td>${qnaVO.qna_date }</td>
										<td>${qnaVO.qna_cnt }</td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="5" style="text-align:center;">${paging }</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
				</div>

				<input type="button" value="글 작성" onclick="gowrite(this.form)")>

			</form>
		</div>
	</div>
</body>
</html>