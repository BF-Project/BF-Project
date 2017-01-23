<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성공하는 사람들</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="shortcut icon" href="images/favicon.ico">

<!-- CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/flexslider.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/prettyPhoto.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/animate.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="<%=request.getContextPath()%>/resources/css/owl.carousel.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" type="text/css" />

<!-- FONTS -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500italic,700,500,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">

<!-- SCRIPTS -->
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<!--[if IE]><html class="ie" lang="en"> <![endif]-->

<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery.prettyPhoto.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery.nicescroll.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/superfish.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery.flexslider-min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/owl.carousel.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/animate.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery.BlackAndWhite.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/myscript.js"
	type="text/javascript"></script>

<script>
	//PrettyPhoto
	jQuery(document).ready(function() {
		$("a[rel^='prettyPhoto']").prettyPhoto();
	});

	//BlackAndWhite
	$(window).load(function() {
		$('.client_img').BlackAndWhite({
			hoverEffect : true, // default true
			// set the path to BnWWorker.js for a superfast implementation
			webworkerPath : false,
			// for the images with a fluid width and height 
			responsive : true,
			// to invert the hover effect
			invertHoverEffect : false,
			// this option works only on the modern browsers ( on IE lower than 9 it remains always 1)
			intensity : 1,
			speed : { //this property could also be just speed: value for both fadeIn and fadeOut
				fadeIn : 300, // 200ms for fadeIn animations
				fadeOut : 300
			// 800ms for fadeOut animations
			},
			onImageReady : function(img) {
				// this callback gets executed anytime an image is converted
			}
		});
	});
</script>

</head>
<body>

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
					<img src="<%=request.getContextPath()%>/resources/images/logo/logo.jpg" 
					style="z-index:0; width:380px; height: 240px">
						<br><br>
						<br><br>
					<h2>
						<b>Join</b> membership
					</h2>
					<p>'성공하는 사람들 회원가입' 페이지 입니다.</p>
				</div>
			</section>
			<!-- //BREADCRUMBS -->
		</div>
	</div>
</body>
</html>