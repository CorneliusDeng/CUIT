<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>管理平台</title>
	<meta charset="utf-8">
	<!-- jQuery -->
	<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
	<script src="js/utility.js" charset="utf-8"></script>
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<%
	String externalpage = request.getParameter("externalPage");
%>
<body onload="loadExternalPage('<%=externalpage==null?"Commodity/Commodity.jsp" : externalpage%>')">
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2 sidebar">
			<ul class="nav sidebar-nav">
				<li class="nav-item"><h4 id="header">二手商城管理平台</h4></li>

				<li class="nav-item"><a href="#" class="nav-text" onclick="loadExternalPage('PublishReview/Publish_Review.jsp')">
					<span class="glyphicon glyphicon-zoom-in">  发布审核</span></a></li>
				<hr class="sidebar-divider">

				<li class="nav-item"><a href="#" class="nav-text" onclick="loadExternalPage('Commodity/Commodity.jsp')">
					<span class="glyphicon glyphicon-list-alt">  商品管理</span></a></li>
				<hr class="sidebar-divider">

				<li class="nav-item"><a href="#" class="nav-text" onclick="loadExternalPage('DailyMessage/Daily_Message.jsp')">
					<span class="glyphicon glyphicon-send">  今日推送</span></a></li>
				<hr class="sidebar-divider">

				<li class="nav-item"><a href="#" class="nav-text" onclick="loadExternalPage('DealRecord/Deal_Record.jsp')">
					<span class="glyphicon glyphicon-shopping-cart">  交易记录</span></a></li>
				<hr class="sidebar-divider">

				<li class="nav-item"><a href="login/login.jsp" class="nav-text">
					<span class="glyphicon glyphicon-off">  注销</span></a></li>
			</ul>
		</div>

		<!--  外部页面接口 -->
		<div class="col-md-9" id="main">

		</div>
	</div>
</div>

</body>
<style>
	.sidebar{background-color:#4e73df; height:1500px;}
	.nav-item{padding:10px;}
	.nav-text{color:white;}
	#header{color:white;}
	.sidebar-divider{margin:0px; border-top:1px solid rgba(255,255,255,.15)}
	body{background-color:#efecec;}
	#main{background-color:white; margin:20px; padding:20px;
		border-radius:10px 10px 10px 10px;}
</style>
</html>