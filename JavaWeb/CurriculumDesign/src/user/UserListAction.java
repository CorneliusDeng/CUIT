package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListAction extends HttpServlet 
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
		ArrayList<UserInfo> userList = userdb.getAllUsers();
		response.setContentType("application/json;charset=UTF-8");	//设置响应的内容类型及编码方式
		PrintWriter out = response.getWriter();	//获取输出流对象
		out.println("[");
		/*********************获取用户信息****************************/
		String jsonData="";
		for(int i = 0; i < userList.size(); i++)
		{
			UserInfo user = userList.get(i);
			jsonData+="{\"userid\":"+user.getUserid()+",\"username\":\""+user.getUsername()+"\",\"userpassword\":\""+user.getPassword()+"\"},";
		}
		out.println(jsonData.substring(0, jsonData.length()-1));	//去除最后一个逗号
		out.println("]");
		System.out.println("测试"+jsonData);	//测试
		out.flush();
		out.close();//关闭输出流对象
	}

}
