<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    
<%@ page import="java.util.*,java.text.*"%> <!-- �Ѿ�����ҹ,ע����Ϣ! -->
<%
 Date nowday=new Date(); // ��ȡ��ǰ����
 int hour=nowday.getHours(); // ��ȡ�����е�Сʱ
 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // �������ڸ�ʽ������
 String time = format.format(nowday); // ��ָ�����ڸ�ʽ��Ϊ
%>
<!DOCTYPE html>
<html>
	<head> <meta charset="ISO-8859-1"><title>HelloWorld</title> </head>
	<body>
		<div align="center">
 			<table border="1" width="300">
			<tr height="30"><td align="center">��ܰ��ʾ!</td></tr>
			<tr height="80"><td align="center">����ʱ��Ϊ:<%=time%></td></tr>
 			<tr height="70">
 				<td align="center">
				<!--����ΪǶ�뵽HTML�е�Java����,�������ɶ�̬������-->
				<%
 					if(hour>=24&&hour<5)
 						out.print("�������賿ʱ�仹����,��˯���!");
 					else if(hour>=5&&hour<10)
 						out.print("���Ϻ��µ�һ�켴����ʼ,��׼��������?");
 					else if(hour>=10&&hour<13)
 						out.print("��ʱ�������ʱ��!");
 					else if(hour>=13&&hour<18)
 						out.print("�������Ŭ��������!");
 					else if(hour>=18&&hour<21)
 						out.print("���Ϻ�����ʱ��!");
 					else if(hour>=21&&hour<24)
 						out.print("�Ѿ�����ҹ,ע����Ϣ!");
				%>
				</td>
 			</tr>
 			</table>
 		</div>
 		
	</body>
</html>