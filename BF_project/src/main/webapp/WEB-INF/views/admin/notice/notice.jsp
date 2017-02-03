<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<style>
 		.table-hover>tbody>#hoverId:hover{ 
 			background-color: #BEEFFF; 
 		} 		
	</style>
	<!-- 검색버튼 css -->
	<link href="<%=request.getContextPath()%>/resources/admin/css/search.css" rel="stylesheet">
	<script>
		function detail(noticeNum){
			$.ajax({
				url : "<%=request.getContextPath()%>/admin/noticeDetail",
				type : "post",
				dataType : "text",
				data : ({
					noticeNum : noticeNum
				}),
				success:function(){
					location='<%=request.getContextPath()%>/admin/noticeDetailView?page=${page}'
				},
				error:function(error){
					alert('error');
				}
			});
		}
	</script>
</head>
<body>
	
	<c:if test="${!empty sessionScope.noticeInsertOK}">
		<script>
			alert('공지사항을 등록했습니다.');
		</script>
		<c:remove var="noticeInsertOK" scope="session" />
	</c:if>
	
	<c:if test="${!empty sessionScope.delete }">
		<script>
			alert('공지사항을 삭제했습니다.');
		</script>
		<c:remove var="delete" scope="session"/>
	</c:if>
	
	<div id="wrapper">                       
		<div id="page-wrapper" style="text-align: center; height: 906.5px;">
			<div class="row">
				<br><br>        
				<h1><b>공지사항</b></h1>
				<br>
				<div class="table-responsive">
					<center>
					<table class="table table-hover" style="width:1300px; text-align: center;">
						<thead>
							<tr style="font-size: 20px">
								<th style="text-align:center; width:100px">글번호</th>
								<th style="text-align:center; width:700px">제목</th>
								<th style="text-align:center; width:200px">작성자</th>
								<th style="text-align:center; width:200px">게시날짜</th>
								<th style="text-align:center; width:100px">조회수</th>
							</tr>
						</thead>
						<c:choose>
							<c:when test="${noticeListSize<=0}">
								<tbody>
									<tr>
										<td colspan="5" align="center">등록된 공지사항이 없습니다.</td>
									</tr>
								</tbody>
							</c:when>
							<c:otherwise>
								<tbody>
									<c:forEach items="${noticeList}" var="NoticeVO" varStatus="count" >
<!-- 										<form name="noticeForm"> -->
										<tr id="hoverId" onclick="detail(${NoticeVO.notice_num})">
											<td id="noticeNum">${NoticeVO.notice_num}</td>
											<td>${NoticeVO.notice_title}</td>
											<td>${NoticeVO.admin_id}</td>
											<td>${NoticeVO.notice_date}</td>
											<td>${NoticeVO.notice_cnt}</td>
										</tr>
<!-- 										</form> -->
									</c:forEach>
								</tbody>
							</c:otherwise>
						</c:choose>
						<tr>
						</tr>				
					</table>
					</center>
						<span style="text-aling:center;"> ${paging} </span>
						<!-- 검색 -->
						<div id="search-form">
							<form method="get" action="notice">
								<input type="text" id="search" name="search" value="Search" style="font-size: 16px;" 
								onFocus="if (this.value == 'Search') this.value = '';" onBlur="if (this.value == '') this.value = 'Search';" />
							</form>
						</div>
						<!-- 검색 : end -->
						
						<!-- 글쓰기  -->
						<button type="button" class="btn btn-default" onclick="location.href='write?page=${page}'" 
						style="padding:8px; margin-left: 1000px; margin-top:-110px; position:relative; z-index:0">
							<b style="font-size:14px">글쓰기</b>&nbsp;<i class="fa fa-edit spaceLeft"></i>
						</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<!-- 글쓰기 :end -->
				</div>
			</div>
		</div>
	</div>
</body>