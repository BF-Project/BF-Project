<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
	<script>
		function insertNotice(){
			$.ajax({
				url : "<%=request.getContextPath()%>/admin/InsertNotice",
				type : "post",
				dataType : "text",
				data : ({
					noticeTitle : $("input[name=noticeTitle]").val(),
					noticeContent : $("textarea#noticeContent").val()
				}),
				success:function(data){
					location='<%=request.getContextPath()%>/admin/notice?page=${page}'
				},
				error:function(error){
					alert('error');
				}
			});
		}
	</script>
</head>

<body>
	<div id="wrapper">
		<div id="page-wrapper" style="text-align: center; height: 906.5px;">
			<br><br>
			<h1><b>공지사항 작성</b></h1>
			<!-- 공지사항 작성 -->
			<form name="noticeForm">
				<div class="form-group">
					<div class="form-group">
						<br>					
	                	<label class="control-label" for="inputWarning" style="font-size: 22px; margin-left: -480px">
	                	<i class="fa fa-edit spaceLeft"></i>&nbsp;&nbsp;공지사항 제목</label>
	                	<center>                	
	                    <input type="text" class="form-control" id="inputWarning" name="noticeTitle" style="width:650px; font-size: 20px">
	                    </center>
	                    <br>
	                    <label class="control-label" for="inputWarning" style="font-size: 22px; margin-left: -570px">
	                    <i class="fa fa-edit spaceLeft"></i>&nbsp;&nbsp;내용</label>
	                    <center>
	                    <textarea class="form-control" rows="16" id="noticeContent" style="width:650px; font-size: 16px"></textarea>
	                    </center>
	                </div>
	            </div>
            </form>
            <!-- 공지사항 작성 : end -->
            <button type="button" class="btn btn-link" onclick="" style="padding:8px; margin-left: -6px">
				<i class="fa fa-photo"></i>&nbsp;<b style="font-size:14px">사진첨부</b>			
			</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn btn-success" onclick="insertNotice()" style="padding:8px;">
				<i class="fa fa-check-square-o"></i>&nbsp;<b style="font-size:14px">등록</b>
			</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-danger" onclick="location.href='notice?page=${page}'" style="padding:8px;">
				<i class="fa fa-times spaceLeft"></i>&nbsp;<b style="font-size:14px">취소</b>
			</button>
		</div>
	</div>
</body>