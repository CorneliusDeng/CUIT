<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>实时显示聊天内容</title>
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() 
	{
		$("#send").click(function() 
		{
			if ($("#user").val() == "") 
			{//判断昵称是否为空
				alert("请输入您的昵称！");
			}
			if ($("#speak").val() == "") 
			{//判断说话内容是否为空
				alert("说话内容不可以为空！");
				$("speak").focus();	//让说话内容文本框获得焦点
			}
			$.post("../ChatServletText?action=send", 
				{
				user : $("#user").val(),
				speak : $("#speak").val()
			});	//发送POST请求
			$("#speak").val(""); //清空说话内容文本框的值
			$("#speak").focus(); //让说话内容文本框获得焦点
		});
		getContent();
		window.setInterval("getContent();", 100);	//每隔0.1秒钟获取一次聊天内容
	});
	//读取聊天内容
	function getContent() {
		$.get("../ChatServletText?action=get&nocache=" + new Date().getTime(),
				function(data) {
					$("#content").html(data);	//显示读取到的聊天内容
				});
	}
</script>
<style type="text/css">
<!--
body {
	font-size: 12px; /*设置文字的大小*/
	margin:0px;
}
header{
	background-image:url(../images/top.jpg);		/*设置背景图片*/
	height:148px;		/*设置高度*/
}
section{
	width:689px;		/*设置宽度*/
	margin:0 auto auto auto;			/*设置居中显示*/
	clear:both;		/*设置两侧均不显示任何元素*/
}
#main{
	padding: 10px;		/*设置内边距*/
	height:217px;		/*设置高度*/
	background-color:#EAF7FD;	/*设置背景颜色*/
	}
footer{
	height:56px;		/*设置高度*/
	background-image:url(../images/bg_bottom.jpg);	/*设置背景图片*/
	padding-top:30px;	/*设置右内边距*/
	padding-left:50px;	/*设置左内边距*/
}
-->
</style>
</head>
<body>
<body>
<section>
	<header></header>
    <div id="main">
   	 	<div id="content" style="height: 206px; overflow: hidden;">欢迎光临碧海聆音聊天室！</div>
    </div>
    <footer>
    <form name="form1" method="post" action="">
		<input name="user" type="text" id="user" size="20"> 说：
        <input name="speak" type="text" id="speak" size="50">
		&nbsp; <input id="send" type="button" value="发送">
	</form>
    </footer>
</section>
</body>
</html>