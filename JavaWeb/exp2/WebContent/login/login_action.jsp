<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import ="java.util.*" %>
<title>��¼�������</title>
</head>

<body>
<%
	//request.setCharacterEncoding("gb2312");//post�����ύ�����ñ����ʽ
	String path = request.getContextPath();
	
	// 1����ȡ�û��������룬�����浽����
	String username = request.getParameter("username");
	String pwd = request.getParameter("password");
	
	// 2���������ָ���˺ź����룬��ʾ����Ա��¼�ɹ�
	if(username.equals("admin") && pwd.equals("Abc123#")) 
	{
		out.println("����Ա��¼�ɹ�");
	}
	
	// 3������û�����������ͬ�����µ�ҳ����ʾ����ͨ�û�XXX�ɹ���¼��(XXXʹ���û������)
	else if (username.equals(pwd))
	{
		session.setAttribute("username", username);
		response.sendRedirect(path+"/login/user_info.jsp");
	
	}
	
	// 4�� ��¼���ɹ����ص�¼����
	else 
	{
		response.sendRedirect(path+"/login/login.jsp");
	} 
%>
	



	
</body>
</html>