<%@ page contentType="text/html;charset=GB18030" import="java.util.*,student.*,common.*" %>
<%
StudentDB beanDB=new StudentDB();
//1����ȡ�ͻ�������
StudentInfo student=new StudentInfo();
student.setStID(MyTools.strToint(request.getParameter("id")));
student.setStCode(request.getParameter("code"));

student.setStName(MyTools.toChinese(request.getParameter("name")));

student.setSex(MyTools.strToint(request.getParameter("sex")));
student.setGrade(MyTools.strToint(request.getParameter("grade")));
student.setMajor(MyTools.strToint(request.getParameter("major")));
student.setDetail(MyTools.toChinese(request.getParameter("detail")));
//2���������ݴ���
int count=beanDB.updateStudent(student);			//����ҵ����Bean�ķ�����������
//3����ͻ���������Ӧ
response.sendRedirect(request.getContextPath()+"/student/student_list_action.jsp");
%>
>