<%@ page contentType="text/html;charset=GB18030" import="java.util.*,student.*,common.*" %>
<%

StudentDB beanDB=new StudentDB();
//1����ȡ�ͻ�������
int id=Integer.parseInt(request.getParameter("id"));
//2���������ݴ���
StudentInfo student=beanDB.getStudentById(id);
request.getSession().setAttribute("studentinfo", student);
//3����ͻ���������Ӧ
response.sendRedirect(request.getContextPath()+"/student/student_edit.jsp" );//�ض���

%>
