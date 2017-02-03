<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<script>
	var i=0
	window.document.onkeydown = protectKey;
	function protectKey(){
		//새로고침을 막는 스크립트.. F5 번키..
		if(event.keyCode == 116){
			event.keyCode = 0;
		    return false;
		}
		//CTRL + N 즉 새로 고침을 막는 스크립트....
		else if ((event.keyCode == 78) && (event.ctrlKey == true)){
	        event.keyCode = 0;
	        return false;
		}
	}
	</script>
	<script>
	// 이미지 원본 크기로 보기
	function showView(){ 
		if(document.all.spot.style.visibility=="hidden"){
			document.all.spot.style.visibility="visible";
			return false;
		}
		if(document.all.spot.style.visibility=="visible"){
			document.all.spot.style.visibility="hidden";
			return false;
		}
	}
	// 이미지 닫기
	function showClose(){
		if(document.all.spot.style.visibility=="visible"){
			document.all.spot.style.visibility="hidden";
			return false;
		}
	}
	</script>
	<script>
	// 제목 지우기
	function topidDelete(){
		$('#inputWarning').val("");		
	}
	
	// 내용 지우기
	function contentDelete(){
		$('#noticeContent').val("");
	}
	</script>
</head>
<body>
	<div id="wrapper">
		<div id="page-wrapper" style="text-align: center; height: 924px;">
			<br><br>
			<h1><b>공지사항(Update)</b></h1>
			<form>
				<div class="form-group">
					<div class="form-group">
						<br>
						<label class="control-label" style="font-size: 18px; margin-left: 65px">
							<span style="margin-left:0px">
								<i class="fa fa-folder-open-o"></i>
								글번호 : <input type="text" value="${noticeVo.notice_num}" style="width:240px; border: 0px" readonly>
							</span>							
							<span style="margin-left: 110px">
								<i class="fa fa-eye-slash"></i>
								조회수 : <input type="text" value="${noticeVo.notice_cnt}" style="width:170px; border: 0px" readonly>
							</span>
							<br>
							<span style="margin-left:1px">
								<i class="fa fa-user"></i>
								&nbsp;작성자 : <input type="text" value="${noticeVo.admin_id}" style="width:240px; border: 0px" readonly>
							</span>							
							<span style="margin-left: 110px">
								<i class="fa fa-clock-o"></i>
								게시일 : <input type="text" value="${noticeVo.notice_date}" style="width:170px; border: 0px" readonly>
							</span>
							<br>
						</label>
						<br>			
	                	<label class="control-label" for="inputWarning" style="font-size: 22px; margin-left: -365px; margin-top: 10px">
	                	<i class="fa fa-edit spaceLeft"></i>&nbsp;&nbsp;공지사항 제목</label> &nbsp;<a onclick="topidDelete()" href="#">제목 전체 지우기</a>
	                	<center>
	                    <input type="text" class="form-control" id="inputWarning" name="noticeTitle" style="width:650px; font-size: 20px; background-color: white;"
	                    value="${noticeVo.notice_title}">
	                    </center>
	                    <br>
	                    <label class="control-label" for="inputWarning" style="font-size: 22px; margin-left: -457px">
	                    <i class="fa fa-edit spaceLeft"></i>&nbsp;&nbsp;내용</label> &nbsp;<a onclick="contentDelete()" href="#">내용 전체 지우기</a>
	                    <c:choose>
	                    	<c:when test="${!empty noticeVo.notice_pict_afat}">
	                    		<center>
							        <textarea class="form-control" rows="16" id="noticeContent"	style="width:650px; font-size: 16px; 
							        text-align:left; background-color: white;">&nbsp;${noticeVo.notice_content}
							    	</textarea>
							    	<div style="position:relative; margin-top:13px; width:640px">
							    		<label class="control-label" style="vertical-align:top; float:left">
							    				<span><i class="fa fa-photo"></i>&nbsp;첨부파일</span><br>
							    			<a onclick="photoChange()" href="#">
							    				사진변경
							    			</a>
							    		</label>
							    		<a style="float:left" onclick="showView('#spot')">&nbsp;
							    		<img src="<%=request.getContextPath()%>/upload/${noticeVo.notice_pict_afat}" title="원본 크기로 보시려면 클릭하세요." style="width:200px; height:160px;">
							    		</a>
							    		<!-- 이미지 클릭시 원본 크기로 보게하기위한 div -->
							    		<div id="spot" style="visibility: hidden; position:absolute; bottom:50%; left:13%">
							    			<a onclick="showClose('#spot')">
							    				<img src="<%=request.getContextPath()%>/upload/${noticeVo.notice_pict_afat}" title="닫으시려면 클릭하세요.">
							    			</a>
							    		</div>
							    	</div>
								</center>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<center>
							        <textarea class="form-control" rows="16" id="noticeContent"	style="width:650px; font-size: 16px; 
							        text-align:left; background-color: white;">&nbsp;${noticeVo.notice_content}
							    	</textarea>
							    	<div style="position:relative; margin-top:13px; width:640px">
							    		<label class="control-label" style="vertical-align:top; float:left">
							    			<span><i class="fa fa-photo"></i>&nbsp;첨부파일</span>
							    		</label>
							    		<a style="float:left">&nbsp;<i class="fa fa-times spaceLeft"></i></a>
							    	</div>
								</center>
	                    	</c:otherwise>
	                    </c:choose>
	                    <center>
			            <div style="position:relative; width:650px;">
							<button type="button" class="btn btn-danger" onclick="deleteNotice()" style="padding:8px; float:right;">
								<i class="fa fa-trash"></i>&nbsp;<b style="font-size:14px">삭제</b>
							</button>
				            <button type="button" class="btn btn-success" style="padding:8px; float:right; margin-right:10px;" onclick="updateNotice()">
								<i class="fa fa-check-square-o"></i>&nbsp;<b style="font-size:14px">수정</b>
							</button>
				            <button type="button" class="btn btn-success" onclick="location.href='notice?page=${page}'"
				            style="padding:8px; background-color: gray; border: 1px solid gray; float:right; margin-right:10px;">
								<i class="fa fa-list-ul"></i>&nbsp;<b style="font-size:14px">목록</b>
							</button>
						</div>
						</center>
	                </div>
	            </div>
				<input type="hidden" id="page" name="page" value="${page}">
			</form>
		</div>
	</div>
</body>