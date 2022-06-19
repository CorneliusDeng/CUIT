<%@ page contentType="text/html;charset=GB18030" import="java.util.*,student.*,common.*" %>
<%

StudentDB beanDB=new StudentDB();
request.getSession().setAttribute("studentlist",beanDB.getAllStudents());
response.sendRedirect(request.getContextPath()+"/student/student_list.jsp");

%>
