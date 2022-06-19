<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    
<%@ page import="java.util.*,java.text.*"%> <!-- ÒÑ¾­ÊÇÉîÒ¹,×¢ÒâÐÝÏ¢! -->
<%
 Date nowday=new Date(); // »ñÈ¡µ±Ç°ÈÕÆÚ
 int hour=nowday.getHours(); // »ñÈ¡ÈÕÆÚÖÐµÄÐ¡Ê±
 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // ¶¨ÒåÈÕÆÚ¸ñÊ½»¯¶ÔÏó
 String time = format.format(nowday); // ½«Ö¸¶¨ÈÕÆÚ¸ñÊ½»¯Îª
%>
<!DOCTYPE html>
<html>
	<head> <meta charset="ISO-8859-1"><title>HelloWorld</title> </head>
	<body>
		<div align="center">
 			<table border="1" width="300">
			<tr height="30"><td align="center">ÎÂÜ°ÌáÊ¾!</td></tr>
			<tr height="80"><td align="center">ÏÖÔÚÊ±¼äÎª:<%=time%></td></tr>
 			<tr height="70">
 				<td align="center">
				<!--ÒÔÏÂÎªÇ¶Èëµ½HTMLÖÐµÄJava´úÂë,ÓÃÀ´Éú³É¶¯Ì¬µÄÄÚÈÝ-->
				<%
 					if(hour>=24&&hour<5)
 						out.print("ÏÖÔÚÊÇÁè³¿Ê±¼ä»¹ºÜÔç,ÔÙË¯»á°É!");
 					else if(hour>=5&&hour<10)
 						out.print("ÔçÉÏºÃÐÂµÄÒ»Ìì¼´½«¿ªÊ¼,Äú×¼±¸ºÃÁËÂð?");
 					else if(hour>=10&&hour<13)
 						out.print("ÎçÊ±¼äÕýÎçºÃÊ±¹â!");
 					else if(hour>=13&&hour<18)
 						out.print("ÏÂÎç¼ÌÐøÅ¬Á¦¹¤×÷°É!");
 					else if(hour>=18&&hour<21)
 						out.print("ÍíÉÏºÃ×ÔÓÉÊ±¼ä!");
 					else if(hour>=21&&hour<24)
 						out.print("ÒÑ¾­ÊÇÉîÒ¹,×¢ÒâÐÝÏ¢!");
				%>
				</td>
 			</tr>
 			</table>
 		</div>
 		
	</body>
</html>