<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<style>
 		.table-hover>tbody>#hoverId:hover{ 
 			background-color: #cdcdcd; 
 		} 		
	</style>
</head>
<body>
	<div id="wrapper">
		<div id="page-wrapper" style="text-align: center; padding: 55px 80px 30% 80px">
			<div class="row">
				<h1><b>공지사항</b></h1>
				<br>
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th style="text-align:center"></th>
								<th style="text-align:center">제목</th>
								<th style="text-align:center">작성자</th>
								<th style="text-align:center">게시날짜</th>
								<th style="text-align:center">조회수</th>
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
									<c:forEach items="${noticeList}" var="NoticeVO" varStatus="count">
										<tr id="hoverId">
											<td>${count.index+1}</td>
											<td>${NoticeVO.notice_title}</td>
											<td>${NoticeVO.admin_id}</td>
											<td>${NoticeVO.notice_date}</td>
											<td>${NoticeVO.notice_cnt}</td>
										</tr>
									</c:forEach>
								</tbody>
							</c:otherwise>
						</c:choose>
						<tr>
						</tr>				
					</table>
						<span style="text-aling:center;"> ${page} </span>
				</div>
			</div>
		</div>
	</div>
</body>
