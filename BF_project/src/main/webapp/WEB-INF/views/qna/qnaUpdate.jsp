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
		document.form2.action = "qnaUpdateForm";
		document.form2.method = "post";
		document.form2.submit();
	}
</script>

</head>
<body>
	<div>
		<form name="form2" method="post" action="qnaUpdateForm"  enctype="multipart/form-data">
			<input type="text" name="qna_num" hidden="hidden" value="${param.qna_num}">
			<label>title</label><br> 
			<input type="text" name="qna_title" size="30" value="${qnaVO.qna_title}" readonly><br> 
			<label>content</label><br>
			<textarea rows="8" cols="65" id="content1" name="qna_content" >${qnaVO.qna_content}</textarea>
			<br>
		
		<!--사진수정  -->
			<input type="hidden" name="nofile" value="${qnaVO.qna_pict_afat}">
			<img src="<%=request.getContextPath() %>/upload/${qnaVO.qna_pict_afat}" width="200pt"> 
							
			<input type="file" name="file">
			
		
		</form>
		<input type="button" value="등록" onclick="goList()">
	</div>
</body>
</html>