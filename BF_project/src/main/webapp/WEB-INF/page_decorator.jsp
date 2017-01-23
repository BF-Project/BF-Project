<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

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
	<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/flexslider.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/prettyPhoto.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/animate.css" rel="stylesheet" type="text/css" media="all" />
    <link href="resources/css/owl.carousel.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
    
	<!-- FONTS -->
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500italic,700,500,700italic,900,900italic' rel='stylesheet' type='text/css'>
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">	
    
	<!-- SCRIPTS -->
	<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <!--[if IE]><html class="ie" lang="en"> <![endif]-->
	
	<script src="resources/js/jquery.min.js" type="text/javascript"></script>
	<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="resources/js/jquery.prettyPhoto.js" type="text/javascript"></script>
	<script src="resources/js/jquery.nicescroll.min.js" type="text/javascript"></script>
	<script src="resources/js/superfish.min.js" type="text/javascript"></script>
	<script src="resources/js/jquery.flexslider-min.js" type="text/javascript"></script>
	<script src="resources/js/owl.carousel.js" type="text/javascript"></script>
	<script src="resources/js/animate.js" type="text/javascript"></script>
	<script src="resources/js/jquery.BlackAndWhite.js"></script>
	<script src="resources/js/myscript.js" type="text/javascript"></script>
	
	<script>
		
		//PrettyPhoto
		jQuery(document).ready(function() {
			$("a[rel^='prettyPhoto']").prettyPhoto();
		});
		
		//BlackAndWhite
		$(window).load(function(){
			$('.client_img').BlackAndWhite({
				hoverEffect : true, // default true
				// set the path to BnWWorker.js for a superfast implementation
				webworkerPath : false,
				// for the images with a fluid width and height 
				responsive:true,
				// to invert the hover effect
				invertHoverEffect: false,
				// this option works only on the modern browsers ( on IE lower than 9 it remains always 1)
				intensity:1,
				speed: { //this property could also be just speed: value for both fadeIn and fadeOut
					fadeIn: 300, // 200ms for fadeIn animations
					fadeOut: 300 // 800ms for fadeOut animations
				},
				onImageReady:function(img) {
					// this callback gets executed anytime an image is converted
				}
			});
		});
		
	</script>
	<style>
		#logo{
			vertical-align: middle;
			margin-top: 12px;
		}
	</style>
</head>
<body>
	
		<!-- HEADER -->
		<header>
			
			<!-- MENU BLOCK -->
			<div class="menu_block">
			
				<!-- CONTAINER -->
				<div class="container clearfix">
					
					<!-- LOGO -->
					<div class="logo pull-left">
						<a href="start" ><img style="width:200px; heigth:160px" src="resources/images/logo/logo.jpg" id="logo" alt="성공하는 사람들" /></a>
					</div><!-- //LOGO -->
					
					<!-- SEARCH FORM -->
					<div id="log-in" class="pull-right">
						<form method="get" action="#">
							<a href="#"><img src="resources/images/service/login.jpg" style="width:63px"><br>
							<span style="margin-left: -20px;">login</span></a>
						</form>
					</div>
					<!-- 끝 : SEARCH FORM -->
					
					<!-- MENU -->
					<div class="pull-right">
						<nav class="navmenu center">
							<ul id="ul-menu">
								<li class="first active scroll_btn"><a href="#home" style="font-size: 14px">Home</a></li>
								<li class="scroll_btn"><a href="#about" style="font-size: 14px">Site 소개</a></li>
								<li class="sub-menu">
									<a href="javascript:void(0);" style="font-size: 14px">컨설팅</a>
									<ul>
										<li><a href="javascript:void(0);" style="font-size: 13px">전문가 컨설팅</a></li>
										<li><a href="javascript:void(0);" style="font-size: 13px">지역추천</a></li>
										<li><a href="javascript:void(0);" style="font-size: 13px">홈페이지 제작(templates)</a></li>
									</ul>
								</li>
								<li class="scroll_btn"><a href="#" style="font-size: 14px">시뮬레이터</a></li>
								
								<li class="sub-menu">
									<a href="javascript:void(0);" style="font-size: 14px">게시판</a>
									<ul>
										<li><a href="javascript:void(3);" style="font-size: 13px">자유게시판</a></li>
										<li><a href="javascript:void(0);" style="font-size: 13px">커뮤니티 게시판</a></li>
										<li><a href="javascript:void(0);" style="font-size: 13px">Q & A 게시판</a></li>
									</ul>
								</li>
								
								<li class="scroll_btn"><a href="#" style="font-size: 14px">공지사항</a></li>
								
								<!-- c 태그 사용해서 회원 로그인 일때 / 아닐때 -->
								
								<li class="scroll_btn last"><a href="#contacts" style="font-size: 14px">Contacts</a></li>
								
								<li class="?"><a href="#" style="font-size: 14px">회원가입</a></li>
								
							</ul>
						</nav>
					</div><!-- //MENU -->
				</div><!-- //MENU BLOCK -->
			</div><!-- //CONTAINER -->
		</header><!-- //HEADER -->
		
		
		<decorator:body />
		
		
		
		<footer>
			
		<!-- CONTAINER -->
		<div class="container">
			
			<!-- ROW -->
			<div class="row" data-appear-top-offset="-200" data-animated="fadeInUp">
				
				<div class="col-lg-4 col-md-4 col-sm-6 padbot30">
					<h4><b>Featured</b> posts</h4>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="resources/images/blog/1.jpg" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="blog.html" >As we have developed a unique layout template</a>
							<ul class="post_item_inf_small">
								<li>10 January 2014</li>
							</ul>
						</div>
					</div>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="resources/images/blog/2.jpg" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="blog.html" >How much is to develop a design for the game?</a>
							<ul class="post_item_inf_small">
								<li>14 January 2014</li>
							</ul>
						</div>
					</div>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="resources/images/blog/3.jpg" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="blog.html" >How to pump designer</a>
							<ul class="post_item_inf_small">
								<li>21 December 2013</li>
							</ul>
						</div>
					</div>
				</div>
				
				<div class="col-lg-4 col-md-4 col-sm-6 padbot30 foot_about_block">
					<h4><b>About</b> us</h4>
					<p>We value people over profits, quality over quantity, and keeping it real. As such, we deliver an unmatched working relationship with our clients.</p>
					<p>Our team is intentionally small, eclectic, and skilled; with our in-house expertise, we provide sharp and</p>
					<ul class="social">
						<li><a href="javascript:void(0);" ><i class="fa fa-twitter"></i></a></li>
						<li><a href="javascript:void(0);" ><i class="fa fa-facebook"></i></a></li>
						<li><a href="javascript:void(0);" ><i class="fa fa-google-plus"></i></a></li>
						<li><a href="javascript:void(0);" ><i class="fa fa-pinterest-square"></i></a></li>
						<li><a href="javascript:void(0);" ><i class="map_show fa fa-map-marker"></i></a></li>
					</ul>
				</div>
				
				<div class="respond_clear"></div>
				
				<div class="col-lg-4 col-md-4 padbot30">
					<h4><b>Contacts</b> Us</h4>
					
					<!-- CONTACT FORM -->
					<div class="span9 contact_form">
						<div id="note"></div>
						<div id="fields">
							<form id="contact-form-face" class="clearfix" action="#">
								<input type="text" name="name" value="Name" onFocus="if (this.value == 'Name') this.value = '';" onBlur="if (this.value == '') this.value = 'Name';" />
								<textarea name="message" onFocus="if (this.value == 'Message') this.value = '';" onBlur="if (this.value == '') this.value = 'Message';">Message</textarea>
								<input class="contact_btn" type="submit" value="Send message" />
							</form>
						</div>
					</div><!-- //CONTACT FORM -->
				</div>
			</div><!-- //ROW -->
			<div class="row copyright">
				<div class="col-lg-12 text-center">
				
				 <p>Crafted with <i class="fa fa-heart"></i>, <a href="http://designscrazed.org/" >Designscrazed</a></p>
				</div>
			
			</div><!-- //ROW -->
		</div><!-- //CONTAINER -->
	</footer><!-- //FOOTER -->
		
</body>
</html>