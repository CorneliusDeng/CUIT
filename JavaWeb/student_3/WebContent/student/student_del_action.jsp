<%@ page contentType="text/html;charset=GB18030" import="java.util.*,student.*,common.*" %>
<%
StudentDB beanDB=new StudentDB();
//1、获取客户端请求
int id=Integer.parseInt(request.getParameter("id"));		//获取客户端提交数据
//2、进行数据处理
int count=beanDB.deleteStudent(id);							//调用业务处理Bean的方法处理数据
//3、向客户端做出响应
response.sendRedirect(request.getContextPath()+"/student/student_list_action.jsp");
%>

