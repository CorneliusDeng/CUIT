package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserGetAction extends HttpServlet 
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
		int id = Integer.parseInt(request.getParameter("id"));
		//2、进行数据处理
		UserInfo user = userdb.getUserById(id) ;
	 	//3、向客户端做出响应
		response.setContentType("application/json;charset=UTF-8");	//设置响应的内容类型及编码方式
		PrintWriter out = response.getWriter();	//获取输出流对象
		/*********************获取用户信息****************************/
		String jsonData="";	
		jsonData="{\"userid\":"+user.getUserid()+",\"username\":\""+user.getUsername()+"\",\"userpassword\":\""+user.getPassword()+"\"}";
		System.out.println(jsonData);	
		out.println(jsonData);	
		out.flush();
		out.close();	//关闭输出流对象	
	}
}
