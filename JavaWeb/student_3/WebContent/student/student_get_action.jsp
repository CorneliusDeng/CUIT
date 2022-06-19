<%@ page contentType="text/html;charset=GB18030" import="java.util.*,student.*,common.*" %>
<%

StudentDB beanDB=new StudentDB();
//1、获取客户端请求
int id=Integer.parseInt(request.getParameter("id"));
//2、进行数据处理
StudentInfo student=beanDB.getStudentById(id);
request.getSession().setAttribute("studentinfo", student);
//3、向客户端做出响应
response.sendRedirect(request.getContextPath()+"/student/student_edit.jsp" );//重定向

%>
