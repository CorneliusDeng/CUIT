<%@ page contentType="text/html;charset=GB2312" import="java.util.*" %>
<%
String path = request.getContextPath();
request.setCharacterEncoding("GB18030");
//1����ȡ�ͻ����ύ����
String studentinfo=request.getParameter("code");
studentinfo+=";"+request.getParameter("name");
studentinfo+=";"+request.getParameter("sex");
studentinfo+=";"+request.getParameter("grade");
studentinfo+=";"+request.getParameter("major");
studentinfo+=";"+request.getParameter("detail");
ArrayList<String> reclist=(ArrayList<String>)session.getAttribute("studentlist");
if(reclist==null){//�������ݻ�δ����
	reclist=new ArrayList<String>();
}
reclist.add(studentinfo);
session.setAttribute("studentlist",reclist);
response.sendRedirect(request.getContextPath()+"/student/student_list.jsp");
%>
