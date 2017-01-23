<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!-- body -->

<img id="preloader"
	src="<%=request.getContextPath()%>/resources/images/preloader.gif"
	alt="" />
<!-- 로딩 이미지 -->

<div class="preloader_hide">

	<!-- PAGE -->
	<div id="page" class="single_page">

		<!-- BREADCRUMBS -->
		<section class="breadcrumbs_block clearfix parallax">
			<div class="container center">
				<img src="<%=request.getContextPath()%>/resources/images/123123.png" style="z-index: 0">
				<h2>
					<b>Join</b> membership
				</h2>
				<p>방문해주신 고객님 반갑습니다.</p>
			</div>
		</section>
		<!-- //BREADCRUMBS -->
	</div>
</div>