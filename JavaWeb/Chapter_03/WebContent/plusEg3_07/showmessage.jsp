<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.util.*" %>
<HTML><BODY>
<%	ArrayList msgList=(ArrayList)application.getAttribute("msgList");
	if(msgList==null) { msgList=new ArrayList();}
	out.print("<table border=2><tr>");
	out.print("<td>"+"����������"+"</td><td>"+"���Ա���"+"</td>");
    out.print("<td>"+"����ʱ��"+"</td><td>"+"��������"+"</td></tr>");
	for(int i=0;i<msgList.size();i++){
		String []message=msgList.get(i).toString().split("#");
		out.print("<tr>");
		for(int k=0;k<message.length;k++){ 
			if(k<3){
				out.print("<td>"+message[k]+"</td>");
			}else{
				out.print("<td><TextArearows=3 cols=12>"+message[k]+"</TextArea></td>");
			} 
		}
		out.print("</tr>");
	} 
	out.print("</table>");
    %>
  <A HREF="inputmessage.jsp" >����</A>

</BODY></HTML>
