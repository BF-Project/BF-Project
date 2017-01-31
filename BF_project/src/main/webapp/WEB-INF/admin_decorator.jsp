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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/resources/admin/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/resources/admin/css/ss-admin.css" rel="stylesheet">
    
	<!-- Morris Charts CSS -->
    <link href="<%=request.getContextPath()%>/resources/admin/css/plugins/morris.css" rel="stylesheet">
    
    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/resources/admin/css/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
    
	<!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/admin/js/jquery.js"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/admin/js/bootstrap.min.js"></script>
    
    <!-- Morris Charts JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/admin/js/plugins/raphael.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/admin/js/plugins/morris.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/admin/js/plugins/morris-data.js"></script>
    <decorator:head />
    
<title>'성공하는 사람들' 관리자 화면</title>
</head>
<body>
<div id="wrapper">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="navbar-header" style="height: 70px; vertical-align: middle;">
			<a class="navbar-brand" href="index.html" style="font-size: 24px; padding: 7px;">
			<br>&nbsp;&nbsp;&nbsp;Administrator screen</a>
		</div>
		<!-- 상단메뉴 -->
		<ul class="nav navbar-right top-nav" style="margin-top: 10px; margin-bottom: 15px;">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle"	data-toggle="dropdown">
					<i class="fa fa-envelope"></i>
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu message-dropdown">
					<li class="message-preview">
						<a href="#">
							<div class="media">
								<span class="pull-left">
									<img class="media-object" src="http://placehold.it/50x50" alt="">
								</span>
								<div class="media-body">
									<h5 class="media-heading">
										<strong>John Smith</strong>
									</h5>
									<p class="small text-muted">
										<i class="fa fa-clock-o">
										</i> Yesterday at 4:32 PM
									</p>
									<p>Lorem ipsum dolor sit amet, consectetur...</p>
								</div>
							</div>
						</a>
					</li>
					<li class="message-preview">
						<a href="#">
							<div class="media">
								<span class="pull-left">
									<img class="media-object" src="http://placehold.it/50x50" alt="">
								</span>
								<div class="media-body">
									<h5 class="media-heading">
										<strong>John Smith</strong>
									</h5>
									<p class="small text-muted">
										<i class="fa fa-clock-o">
										</i> Yesterday at 4:32 PM
									</p>
									<p>Lorem ipsum dolor sit amet, consectetur...</p>
								</div>
							</div>
						</a>
					</li>
					<li class="message-preview">
						<a href="#">
							<div class="media">
								<span class="pull-left"> 
									<img class="media-object" src="http://placehold.it/50x50" alt="">
								</span>
								<div class="media-body">
									<h5 class="media-heading">
										<strong>John Smith</strong>
									</h5>
									<p class="small text-muted">
										<i class="fa fa-clock-o">
										</i> Yesterday at 4:32 PM
									</p>
									<p>Lorem ipsum dolor sit amet, consectetur...</p>
								</div>
							</div>
						</a>
					</li>
					<li class="message-footer">
						<a href="#">Read All New Messages</a>
					</li>
				</ul>
			</li>
			
			<li class="dropdown">
				<a href="#" class="dropdown-toggle"	data-toggle="dropdown">
					<i class="fa fa-bell">
					</i>
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu alert-dropdown">
					<li>
						<a href="#">Alert Name
							<span class="label label-default">Alert Badge</span>
						</a>
					</li>
					<li>
						<a href="#">Alert Name
							<span class="label label-primary">Alert Badge</span>
						</a>
					</li>
					<li>
						<a href="#">Alert Name
							<span class="label label-success">Alert Badge</span>
						</a>
					</li>
					<li>
						<a href="#">Alert Name
							<span class="label label-info">Alert Badge</span>
						</a>
					</li>
					<li>
						<a href="#">Alert Name
							<span class="label label-warning">Alert Badge</span>
						</a>
					</li>
					<li>
						<a href="#">Alert Name
							<span class="label label-danger">Alert Badge</span>
						</a>
					</li>
					<li class="divider">
					</li>
					<li>
						<a href="#">View All</a>
					</li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle"	data-toggle="dropdown">
					<i class="fa fa-user"> </i>
					John Smith <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li>
						<a href="#"><i class="fa fa-fw fa-user"></i> Profile X</a>
					</li>
					<li>
						<a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox X</a>
					</li>
					<li>
						<a href="#"><i class="fa fa-fw fa-gear"></i> Settings X</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#"><i class="fa fa-fw fa-power-off"></i> LogOut X</a>
					</li>
				</ul>
			</li>
		</ul>
		<!-- 상단메뉴 : end -->
		
		<!-- 사이드 메뉴 -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav" style="margin-top: 60px;">
				<li class="aaaa" style="font-size: 16px;"><a href="index.html">
					<i class="fa fa-fw fa-dashboard"></i> Main X</a>
				</li>
				<li class="bbbb" style="font-size: 16px; margin-top: 10px"><a href="charts.html">
					<i class="fa fa-fw fa-bar-chart-o"></i> 회원관리 X</a>
				</li>
				<li class="cccc" style="font-size: 16px; margin-top: 10px"><a href="tables.html">
					<i class="fa fa-fw fa-table"></i> 시뮬레이터 X</a>
				</li>
				<li class="dddd" style="font-size: 16px; margin-top: 10px"><a href="forms.html">
					<i class="fa fa-fw fa-edit"></i> Forms X</a>
				</li>
				<li class="eeee" style="font-size: 16px; margin-top: 10px"><a href="bootstrap-elements.html">
					<i class="fa fa-fw fa-desktop"></i> Bootstrap Elements X</a>
				</li>
				<li class="ffff" style="font-size: 16px; margin-top: 10px"><a href="bootstrap-grid.html">
					<i class="fa fa-fw fa-wrench"></i> Bootstrap Grid X</a>
				</li>
				<li class="gggg" style="font-size: 16px; margin-top: 10px">
					<a href="javascript:;" data-toggle="collapse" data-target="#demo">
						<i class="fa fa-fw fa-arrows-v"></i> Dropdown X<i class="fa fa-fw fa-caret-down"></i>
					</a>
					<ul id="demo" class="collapse">
						<li><a href="#">Dropdown Item X</a></li>
						<li><a href="#">Dropdown Item X</a></li>
					</ul>
				</li>
				<li class="hhhh" style="font-size: 16px; margin-top: 10px">
					<a href="blank-page.html">
						<i class="fa fa-fw fa-file"></i> Blank Page X
					</a>
				</li>
				<li class="iiii" style="font-size: 16px; margin-top: 10px"><a href="bootstrap-grid.html">
					<i class="fa fa-fw fa-wrench"></i> Bootstrap Grid X</a>
				</li>
				<li class="jjjj" style="font-size: 16px; margin-top: 10px"><a href="bootstrap-grid.html">
					<i class="fa fa-fw fa-wrench"></i> Bootstrap Grid X</a>
				</li>
				<li class="kkkk" style="font-size: 16px; margin-top: 10px"><a href="bootstrap-grid.html">
					<i class="fa fa-fw fa-wrench"></i> Bootstrap Grid X</a>
				</li>
				<li class="llll" style="font-size: 16px; margin-top: 10px">
					<a href="index-rtl.html"><i class="fa fa-fw fa-dashboard"></i> Home(관리자모드 종료) X</a>
				</li>
			</ul>
		</div>
		<!-- 사이드 메뉴 : end -->
	</nav>
</div>
	<decorator:body />
</body>
</html>