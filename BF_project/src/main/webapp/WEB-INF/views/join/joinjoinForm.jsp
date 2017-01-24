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

<!-- checkbox를 꾸미기 위함 -->
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<style>
.checks {
	position: relative;
}

.checks input[type="checkbox"] { /* 실제 체크박스는 화면에서 숨김 */
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0
}

.checks input[type="checkbox"]+label {
	display: inline-block;
	position: relative;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
}

.checks input[type="checkbox"]+label:before { /* 가짜 체크박스 */
	content: ' ';
	display: inline-block;
	width: 21px; /* 체크박스의 너비를 지정 */
	height: 21px; /* 체크박스의 높이를 지정 */
	line-height: 21px; /* 세로정렬을 위해 높이값과 일치 */
	margin: -2px 8px 0 0;
	text-align: center;
	vertical-align: middle;
	background: white;
	border: 1px solid #000000;
	border-radius: 3px;
	box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05), inset 0px -15px 10px -12px
		rgba(0, 0, 0, 0.05);
}

.checks input[type="checkbox"]+label:active:before, .checks input[type="checkbox"]:checked+label:active:before
	{
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05), inset 0px 1px 3px
		rgba(0, 0, 0, 0.1);
}

.checks input[type="checkbox"]:checked+label:before { /* 체크박스를 체크했을때 */
	content: '\2714'; /* 체크표시 유니코드 사용 */
	color: #FF0000;
	text-shadow: 1px 1px #FF0000;
	background: white;
	border-color: #000000; /* 검정 */
	box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05), inset 0px -15px 10px -12px
		rgba(0, 0, 0, 0.05), inset 15px 10px -12px rgba(255, 255, 255, 0.1);
}
</style>

<script>
	// 체크박스를 라디오 버튼처럼 사용하기 : 라디오버튼이 css때문에 안먹힘...
	$(function(){
		$('input[type="checkbox"][name="check"]').click(function(){
			// click 이벤트가 발생했는지 체크
			if($(this).prop('checked')){
				// checkbox 전체를 checked 해제 후 click한 요소만 true 지정
				$('input[type="checkbox"][name="check"]').prop('checked', false);
				$(this).prop('checked', true);
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
					<a href="<%=request.getContextPath()%>/start"> 
						<img src="<%=request.getContextPath()%>/resources/images/logo/logo.jpg"	style="z-index: 0; width: 590px; height: 170px">
					</a> 
					<br> <br> <br>
					<br>
					<h2>
						<b>Join</b> membership
					</h2>
					<p>'성공하는 사람들 회원가입' 페이지 입니다.</p>
				</div>
			</section>

			<!-- 회원가입 form -->

			<article class="container">
				<div class="page-header">
				</div>
				<div class="col-md-6 col-md-offset-3">
					<form role="form">
						<div class="form-group">
							<label for="InputId">아이디</label> 
								<input type="email" class="form-control" name="InputId" placeholder="아이디를 입력해주세요">
						</div>
						<div class="form-group">
							<label for="InputPassword1">비밀번호</label>
								<input type="password" class="form-control" name="InputPassword1" placeholder="비밀번호를 입력해주세요">
						</div>
						<div class="form-group">
							<label for="InputPassword2">비밀번호 확인</label> 
								<input type="password" class="form-control" name="InputPassword2" placeholder="비밀번호 재확인">
							<p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>
						</div>
						<div class="form-group">
							<label for="username">이름</label> 
								<input type="email" class="form-control" name="username" placeholder="이름을 입력해 주세요">
						</div>
						<div class="form-group">
							<label for="usernumber">휴대폰 번호</label>
							<div class="input-group">
								<input type="tel" class="form-control" name="usernumber" placeholder=" - 없이 입력해 주세요">
							</div>
						</div>
						<div class="form-group">
							<label for="InputEmail">이메일</label> 
								<input type="email" class="form-control" name="InputEmail" placeholder="이메일 주소를 입력해 주세요">
						</div>
						
						<!-- 주소 -->
						<div class="form-group">
							<label for="InputAddr">주소</label>
								<input type="email" class="form-control" name="InputAddr1" placeholder="검색해주세요" style="width:400px" readonly>
								<input type="button" value="Search" style="position:absolute; left:420px; bottom:368.1px; background-color:#000000; color=#FFF0F0; height:35px; width:75px; margin:0; padding:0;" class="btn btn-info">
								<input type="email" class="form-control" name="InputAddr2" placeholder="상세주소를 입력해주세요" style="width:400px; margin-top: 8px">
						</div>
						
						<!-- 생년월일 -->
						<div class="form-group">
							<label for="InputBirth">생년월일</label>
							<div class="input-group">
								<input type="tel" class="form-control" name="InputBirth" placeholder="ex : 19910505">
								<p class="help-block">숫자로만 생년월일을 입력해주세요</p>
							</div>
						</div>
						
						<!-- 성별 -->
						<label for="InputGender">성별</label><br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="checks">
							<input type="checkbox" id="agree-one" name="check" value="남자"> 남자
							<label for="agree-one"></label>
						</span>
						&nbsp;
						<span class="checks">
							<input type="checkbox" id="agree-two" name="check" value="여자"> 여자
							<label for="agree-two"></label>
						</span>
						
						<br><br><br><br><br><br>
						<div class="form-group text-center">
							<button type="submit" class="btn btn-info">
								회원가입&nbsp;<i class="fa fa-check spaceLeft"></i>
							</button>
							<button type="submit" class="btn btn-warning">
								가입취소&nbsp;<i class="fa fa-times spaceLeft"></i>
							</button>
						</div>
					</form>
				</div>
			</article>
			<!--  -->

		</div>
	</div>	
</body>
</html>