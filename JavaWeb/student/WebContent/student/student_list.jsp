<%@ page contentType="text/html;charset=GB2312" import="student.*,java.util.*"%>
<%
	String path = request.getContextPath();
	ArrayList<StudentInfo> reclist=(ArrayList<StudentInfo>)session.getAttribute("studentlist");
	session.removeAttribute("studentlist");
	if(reclist==null){//�������ݻ�δ����
		reclist=new ArrayList<StudentInfo>();
	}
%>

<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/student.css">

  <body>
		<table width="100%" height="100" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td height="25" colspan="6" class="tb_showall" align="center">
					ѧ����Ϣ�б�
				</td>
			</tr>
			<tr class="td_header">
				<td>ѧ��</td>
				<td>����</td>
				<td>�Ա�</td>
				<td>�꼶</td>
				<td>רҵ</td>
				<td></td>
			</tr>
<% int count=reclist.size();
for(int i=0;i<count;i++){
	StudentInfo student=reclist.get(i);
	%>
			<tr class="td_<%=i%2+1%>">
				<td><%=student.getStCode() %></td>
				<td><%=student.getStName() %></td>
				<td><%=student.getSex()==0?"��":"Ů"  %></td>
				<td><%=student.getGrade() %></td>
				<td><%=student.getMajor()==1?"�������":"�ռ���Ϣ"  %></td>
				<td>
					<a href="<%=path %>/servlet/StudentGetAction?id=<%=student.getStID()%>">�༭</a>
					<a href="<%=path %>/servlet/StudentDelAction?id=<%=student.getStID()%>">ɾ��</a>
				</td>
			</tr>
	<%
}
 %>	
			<tr><td colspan="4"><a href="<%=path %>/student/student_add.jsp">���ѧ����Ϣ</a>
				<td colspan="4"><a href="<%=path %>/servlet/StudentListAction">ˢ�������б�</a>
			</tr>
		</table>


  </body>
</html>
