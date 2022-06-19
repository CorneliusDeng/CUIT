package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

public class UserUpdateAction extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		UserDB userdb = new UserDB();
		//1、获取客户端请求
		UserInfo user = new UserInfo();
		user.setUserid(MyTools.strToint(request.getParameter("id")));
		user.setUsername(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		//2、进行数据处理
	 	int count=0;
	 	if(user.getUserid()==-1) 
	 	{
	 		count = userdb.insertUser(user);		
	 	}
	 	else 
	 	{
	 		count = userdb.updateUser(user);			//调用业务处理Bean的方法处理数据	 		
	 	}
	 	//3、向客户端做出响应
		response.setContentType("text/html;charset=UTF-8");	//返回text 
		PrintWriter out = response.getWriter();
	    if( count != 0)
	    {
	    	out.print("1");
	    	//用于直接比较的简单数据不能用out.println，包含隐藏的换行符
	    }
	    else
	    {
	    	out.print("0");
	    }	
	}
}
