<%@ page contentType="text/html;charset=GB2312" %>
<HTML><BODY>
<br>����ְҵ�ǣ� 
<UL>
<%
//����request�����getParameterValues����,
//ȡ�ø�ѡ������ֵ,���趨��job�ַ�������
String job[] = request.getParameterValues("job");
//����forѭ�����Ⱥ����������ֵ
if(job!=null) {
for(int i = 0; i < job.length ; i++) {
byte  b[ ]=job[i].getBytes("ISO-8859-1");
     String tmp=new String(b);
out.println("<LI>" + tmp + "</LI>");
	}
}
out.println("<br>");
String str=request.getParameter("job");
if(str!=null){
	byte  b[ ]=str.getBytes("ISO-8859-1");
	str=new String(b);
}else{
	str="";
}
out.println("��һ��ְҵ�ǣ�"+str);
%>
</UL>
<a href="JavaScript:history.go(-1);">����</a>
</BODY></HTML>
