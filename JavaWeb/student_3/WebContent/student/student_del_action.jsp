<%@ page contentType="text/html;charset=GB18030" import="java.util.*,student.*,common.*" %>
<%
StudentDB beanDB=new StudentDB();
//1����ȡ�ͻ�������
int id=Integer.parseInt(request.getParameter("id"));		//��ȡ�ͻ����ύ����
//2���������ݴ���
int count=beanDB.deleteStudent(id);							//����ҵ����Bean�ķ�����������
//3����ͻ���������Ӧ
response.sendRedirect(request.getContextPath()+"/student/student_list_action.jsp");
%>

