<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.util.*" %>
<HTML><BODY>
 <% request.setCharacterEncoding("GB2312");
 	String name=request.getParameter("peopleName");
	String title=request.getParameter("Title");
	String messages=request.getParameter("messages");
	if(name==null){name="guest"+(int)(Math.random()*10000);}
	if(title==null){  title="�ޱ���";}
	if(messages==null){messages="�ޱ���";}
	String time=new Date().toString();
	String s=name+"#"+title+"#"+time+"#"+messages; 
	synchronized(application){  
		ArrayList msgList=(ArrayList)application.getAttribute("msgList");
		if(msgList==null){msgList=new ArrayList();} 			
		msgList.add(s);
		application.setAttribute("msgList",msgList); 
	}
	out.print("�����Ϣ�Ѿ��ύ");          
%>
  <A HREF="inputmessage.jsp" >����</A>
  <A HREF="showmessage.jsp" >�鿴���԰�</A>
</BODY></HTML>
