<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<!-- <body> -->

<!-- PRELOADER -->
<img id="preloader" src="resources/images/preloader.gif" alt="" />  <!-- 로딩 이미지 -->

<!-- //PRELOADER -->
<div class="preloader_hide">

<!-- PAGE -->
<div id="page">
		
		<!-- HOME -->
		<section id="home" class="padbot0">
				
			<!-- TOP SLIDER -->
			<div class="flexslider top_slider">
				<ul class="slides">
					<li class="slide1">
						<div class="flex_caption1">
							<p class="title1 captionDelay2 FromTop">Creative</p>
							<p class="title2 captionDelay4 FromTop">White</p>
							<p class="title3 captionDelay6 FromTop">Templates</p>
							<p class="title4 captionDelay7 FromBottom">The template is suitable for any company and the direction that appreciates style, purity and quality of the web site.</p>
						</div>
						<a class="slide_btn FromRight" href="javascript:void(0);" >Read More</a>
					<li class="slide2">
						<div class="flex_caption1">
							<p class="title1 captionDelay6 FromLeft">Responsive</p>
							<p class="title2 captionDelay4 FromLeft">Design</p>
							<p class="title3 captionDelay2 FromLeft">Theme</p>
							<p class="title4 captionDelay7 FromLeft">The template is suitable for any company and the direction that appreciates style, purity and quality of the web site.</p>
						</div>
						<a class="slide_btn FromRight" href="javascript:void(0);" >Read More</a>
					</li>
					<li class="slide3">
						<div class="flex_caption1">
							<p class="title1 captionDelay1 FromBottom">Amazing</p>
							<p class="title2 captionDelay2 FromBottom">Video</p>
							<p class="title3 captionDelay3 FromBottom">Background</p>
							<p class="title4 captionDelay5 FromBottom">The template is suitable for any company and the direction that appreciates style, purity and quality of the web site.</p>
						</div>
						<a class="slide_btn FromRight" href="javascript:void(0);" >Read More</a>
						
						<!-- VIDEO BACKGROUND -->
						<a id="P2" class="player" data-property="{videoURL:'tDvBwPzJ7dY',containment:'.top_slider .slide3',autoPlay:true, mute:true, startAt:0, opacity:1}" ></a>
						<!-- //VIDEO BACKGROUND -->
					</li>
				</ul>
			</div>
			<div id="carousel">
				<ul class="slides">
					<li><img src="resources/images/slider/slide1_bg.jpg" alt="" /></li>
					<li><img src="resources/images/slider/slide2_bg.jpg" alt="" /></li>
					<li><img src="resources/images/slider/slide3_bg.jpg" alt="" /></li>
				</ul>
			</div><!-- //TOP SLIDER -->
		</section><!-- //HOME -->
		
		
		<!-- ABOUT -->
		<section id="about">
			
			<!-- SERVICES -->
			<div class="services_block padbot40" data-appear-top-offset="-200" data-animated="fadeInUp">
				
				<!-- CONTAINER -->
				<div class="container">
				
					<!-- ROW -->
					<div class="row">
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-ss-12 margbot30">
							<a class="services_item" href="javascript:void(0);" >
								<p><b>Step One</b> 막연함</p>
								<span>생업을 위해, 미래를 위해 창업을 해야할 때 어디서부터 어떻게 준비를 해야 하는지 막연하다.</span>
							</a>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-ss-12 margbot30">
							<a class="services_item" href="javascript:void(0);" >
								<p><b>Step Two</b> 불안감</p>
								<span>창업을 시작하고 성공을 할 수 있을지에 대한 불안감.</span>
							</a>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-ss-12 margbot30">
							<a class="services_item" href="javascript:void(0);" >
								<p><b>Step Three</b> 정보부재</p>
								<span>처음 창업을 시작하는 것 이라면 모든 것에 서툴러 창업에 대한 정보가 부족할 수 있다.</span>
							</a>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-ss-12 margbot30">
							<a class="services_item" href="javascript:void(0);" >
								<p><b>Step Four</b> 불확실성</p>
								<span>창업이 실패할 것인지 성공할 것인지 수익은 얼마나 낼 수 있을지 모든것이 불확실하다.</span>
							</a>
						</div>
					</div><!-- //ROW -->
				</div><!-- //CONTAINER -->
			</div><!-- //SERVICES -->
			
			<!-- CLEAN CODE -->
			<div class="cleancode_block">
				
				<!-- CONTAINER -->
				<div class="container" data-appear-top-offset="-200" data-animated="fadeInUp">
				
					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a class="i5" href="#tab1" data-toggle="tab" ><i></i><span>Information</span></a></li>
						<li><a class="i3" href="#tab3" data-toggle="tab" ><i></i><span>Simulator</span></a></li>
						<li><a class="i4" href="#tab4" data-toggle="tab" ><i></i><span>Community</span></a></li>
						<li><a class="i6" href="#tab6" data-toggle="tab" ><i></i><span>Consulting</span></a></li>
					</ul><!-- CASTOM TAB -->
					<br>
					<!-- CASTOM TAB -->
					<div id="myTabContent" class="tab-content">						
						<div class="tab-pane fade in active clearfix" id="tab1">
							<p class="title"><b>Information</b></p>
							<table style="margin-top: -20px">
								<tr>
									<td style="width:400px; height:400px;"><img src="resources/images/logo/site.jpg"></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td><span>We tried to make very high-quality product and so our code is very neat and clean. Whatever anyone could improve and modify the template to your liking.</span></td>
								</tr>
							</table>
						</div>
						<div class="tab-pane fade clearfix" id="tab3">
							<p class="title"><b>Simulator</b></p>
							<table style="margin-top: -20px">
								<tr>
									<td style="width:400px; height:400px;"><img src="resources/images/logo/site1.jpg"></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td><span>We tried to make very high-quality product and so our code is very neat and clean. Whatever anyone could improve and modify the template to your liking.</span></td>
								</tr>
							</table>
						</div>
						<div class="tab-pane fade clearfix" id="tab4">
							<p class="title"><b>Community</b></p>
							<table style="margin-top: -20px">
								<tr>
									<td style="width:400px; height:400px;"><img src="resources/images/logo/site3.png"></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td><span>We tried to make very high-quality product and so our code is very neat and clean. Whatever anyone could improve and modify the template to your liking.</span></td>
								</tr>
							</table>
						</div>
						<div class="tab-pane fade clearfix" id="tab6">
							<p class="title"><b>Consulting</b></p>
							<table style="margin-top: -20px">
								<tr>
									<td style="width:400px; height:400px;"><img src="resources/images/logo/site2.png"></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td><span>We tried to make very high-quality product and so our code is very neat and clean. Whatever anyone could improve and modify the template to your liking.</span></td>
								</tr>
							</table>
						</div>						
					</div>
										
				</div><!-- //CONTAINER -->
			</div><!-- //CLEAN CODE -->
			
	</div><!-- //PAGE -->
	
	<!-- MAP -->
	<section id="contacts">
		<div id="map">
			<a class="map_hide" href="javascript:void(0);" ><i class="fa fa-angle-right"></i><i class="fa fa-angle-left"></i></a>
			<iframe src="http://maps.google.com/maps?f=q&amp;give%20a%20hand=s_q&amp;hl=en&amp;geocode=&amp;q=london&amp;sll=37.0625,-95.677068&amp;sspn=42.631141,90.263672&amp;ie=UTF8&amp;hq=&amp;hnear=London,+United+Kingdom&amp;ll=51.500141,-0.126257&amp;spn=0.026448,0.039396&amp;z=14&amp;output=embed" ></iframe>
		</div><!-- //MAP -->
	</section>

</div>
<!-- </body> -->