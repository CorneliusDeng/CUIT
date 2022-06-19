<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import ="course.*, java.util.*"%>

<%
	//���մ�C�㷢�͵Ŀγ���Ϣ��������
	String path = request.getContextPath();
	ArrayList<CourseInfo> testlist=(ArrayList<CourseInfo>)session.getAttribute("courseList");
%>
<!DOCTYPE html>
<html>
 
<head>
<title>�γ���Ϣ�б�</title>
<link rel=stylesheet type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/datacheck.js"></script>
</head>

<body>
<!-- �γ���Ϣ��ѯ��ʾ����V�� -->
<div align="center">
	<table border="0" width="80%" cellpadding="0" cellspacing="0" >
		<tr>
			<td height="25" colspan="8" class="tb_showall" align="center">
				�γ���Ϣ�б�
			</td>
		</tr>
		<tr class="td_header" align="center">
			<td width="5%">�γ�ID</td>
	        <td width="10%">����</td>
	        <td width="8%">����</td>
	        <td width="5%">ѧ��</td>
	        <td width="5%">�����꼶</td>
	        <td width="8%">����רҵ</td>
	        <td width="4%"></td>
	        <td width="4%"></td>
	    </tr>
		<%
			for (int i = 0; i < testlist.size(); i++)
			{
				//ѭ�������γ���Ϣ�б��������
				CourseInfo testcourse = testlist.get(i);
				
				int flag1 = testcourse.getType();
				String type = "";
				if (flag1 == 1)
				{
					type = "�����������޿�";
				}
				else if (flag1 == 2)
				{
					type = "����ѡ�޿�";
				}
				else if (flag1 == 3)
				{
					type = "ѧ�ƻ�����";
				}
				else if (flag1 == 4)
				{
					type = "רҵ���޿�";
				}
				else if (flag1 == 5)
				{
					type = "רҵѡ�޿�";
				}
				else
				{
					type = "�����Խ�ѧʵ������";
				}
				
				int flag2 = testcourse.getMajor();
				String major = "";
				if (flag2 == 1)
				{
					major = "�������";
				}
				else if (flag2 == 2)
				{
					major = "�ռ���Ϣ";
				}
				else
				{
					major = "������";
				}
		%>
		<tr class="td" align="center">
	       	<td><%=testcourse.getCourseID() %></td>
	        <td><%=testcourse.getName() %></td>
	   		<td><%=type %></td>
	        <td><%=testcourse.getCredit() %></td>
	        <td><%=testcourse.getGrade() %></td>
	        <td><%=major %></td>
	        <td align="left"><a href="<%=path %>/CourseGetAction?id=<%=testcourse.getCourseID()%>">�༭</a></td>
	        <td align="left"><a href="<%=path %>/CourseDelAction?id=<%=testcourse.getCourseID()%>">ɾ��</a></td>
	    </tr>
		<%	
			}
		%>
		<tr>
			<td colspan="4"><a href="<%=path %>/course/course_add.jsp">���</a>
			<td colspan="4"><a href="<%=path %>/CourseListAction">ˢ�������б�</a>
		</tr>
		
	</table>
</div>
</body>
</html>