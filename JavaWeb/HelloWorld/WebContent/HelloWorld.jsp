<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    
<%@ page import="java.util.*,java.text.*"%> <!-- 已经是深夜,注意休息! -->
<%
 Date nowday=new Date(); // 获取当前日期
 int hour=nowday.getHours(); // 获取日期中的小时
 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 定义日期格式化对象
 String time = format.format(nowday); // 将指定日期格式化为
%>
<!DOCTYPE html>
<html>
	<head> <meta charset="ISO-8859-1"><title>HelloWorld</title> </head>
	<body>
		<div align="center">
 			<table border="1" width="300">
			<tr height="30"><td align="center">温馨提示!</td></tr>
			<tr height="80"><td align="center">现在时间为:<%=time%></td></tr>
 			<tr height="70">
 				<td align="center">
				<!--以下为嵌入到HTML中的Java代码,用来生成动态的内容-->
				<%
 					if(hour>=24&&hour<5)
 						out.print("现在是凌晨时间还很早,再睡会吧!");
 					else if(hour>=5&&hour<10)
 						out.print("早上好新的一天即将开始,您准备好了吗?");
 					else if(hour>=10&&hour<13)
 						out.print("午时间正午好时光!");
 					else if(hour>=13&&hour<18)
 						out.print("下午继续努力工作吧!");
 					else if(hour>=18&&hour<21)
 						out.print("晚上好自由时间!");
 					else if(hour>=21&&hour<24)
 						out.print("已经是深夜,注意休息!");
				%>
				</td>
 			</tr>
 			</table>
 		</div>
 		
	</body>
</html>