<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import= "login.*, common.*, java.util.*" %>

<title>��¼�������</title>
</head>

<body>
<%
	String path = request.getContextPath();
	
	// 1����ȡ�û��������е��û���������
	String username = request.getParameter("username");
	String pwd = request.getParameter("password");
	int flag = 0;
	
	// 2������ͻ����ύ�����ݡ�ʹ��UserDB�����еķ�������ȡָ���û���������
	UserInfo user = new UserDB().GetUserbyName(username);
	
	//3�� ͨ����ȡ�û���Ϣ�Ϳͻ����ύ��Ϣ���бȽϣ�����flag��ֵ����ͻ���������Ӧ
	//��½�ɹ�0���û�������1���������2
	if (user == null)
	{
		flag = 1;
	}
	else if (!user.getUserPwd().equals(pwd))
	{
		flag = 2;
	}
	
	if (flag == 0)
	{
		// ��½�ɹ������û�����Ϣ���ض�����Ϣ��ʾҳ��
		session.setAttribute("username", username);
		response.sendRedirect(path+"/login/user_info.jsp");
	}
	else
	{	// ��½���ɹ������û�����Ϣ���ض��򵽵�½ҳ��
		session.setAttribute("username", username);
		response.sendRedirect(path+"/login/login.jsp?loginflag="+flag);
	}
	
%>	
</body>
</html>