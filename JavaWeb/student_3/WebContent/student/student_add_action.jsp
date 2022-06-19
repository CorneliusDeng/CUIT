<%@ page contentType="text/html;charset=GB18030" import="java.util.*,student.*,common.*" %>
<%
StudentDB beanDB=new StudentDB();
//1、获取客户端提交数据
StudentInfo student=new StudentInfo();
student.setStCode(request.getParameter("code"));
student.setStName(MyTools.toChinese(request.getParameter("name")));
student.setSex(MyTools.strToint(request.getParameter("sex")));
student.setGrade(MyTools.strToint(request.getParameter("grade")));
student.setMajor(MyTools.strToint(request.getParameter("major")));
student.setDetail(MyTools.toChinese(request.getParameter("detail")));
//2、处理客户端提交数据
beanDB.insertStudent(student);		    
//3、向客户端做出响应 
response.sendRedirect(request.getContextPath()+"/student/student_list_action.jsp");
%>
