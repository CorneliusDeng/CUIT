﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>使用load()方法请求动态页面</title>
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
<script>
$(document).ready(function(){
	window.setInterval("$('#getTime').load('getTime.jsp',{});",1000);
	//$('#getTime').load('getTime.jsp',{});
});
</script>
</head>
<body>
<body>
<div id="getTime">正在获取时间...</div>
</body>
</html>