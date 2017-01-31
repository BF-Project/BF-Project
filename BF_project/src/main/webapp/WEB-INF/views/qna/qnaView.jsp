<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<script>
	function goUpdate(qna_num) {
		document.formm.action = "update?qna_num=" + qna_num;
		document.formm.submit();
	}
	
	/*삭제  */
	function goDelete(qna_num){
		document.formm.action="delete?qna_num="+qna_num;
		document.formm.submit();
	}
</script>

</head>
<body>

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
		<form name="formm" method="post"  action="qnaView">
			<table id="notice" border="1">
				<tr>
					<th>제목</th>
					<td>${qnaVO.qna_title}</td>
				</tr>

				<tr>
					<th>내용</th>
					<td>${qnaVO.qna_content}</td>
				</tr>

				<tr>
					<th>작성자</th>
					<td>${qnaVO.mbr_id}</td>
				</tr>

				<tr>
					<th>게시날짜</th>
					<td>${qnaVO.qna_date} </td>
				</tr>
			</table>
			<%-- <input type="button" value="수정하기" onclick="goUpdate('${qnaVO.qna_num}')"> --%>
			<input type="button" value="목록" onclick="location.href='qnaList'">

			<!--삭제  -->
			<input type="button" value="삭제"  onclick="goDelete('${qnaVO.qna_num}')" >
			
			<!--수정  -->
			<input type="button" value="수정"  onclick="goUpdate('${qnaVO.qna_num}')" >
			
			
		</form>
	</div>
</body>
</html>