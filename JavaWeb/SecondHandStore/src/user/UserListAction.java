package user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		ArrayList<UserInfo> userList = userdb.GetAllUsers();
		response.setContentType("application/json;charset=UTF-8");	//设置响应的内容类型及编码方式
		PrintWriter out = response.getWriter();	//获取输出流对象
		out.println("[");
		/*********************获取用户信息****************************/
		String jsonData="";
		for(int i = 0; i < userList.size(); i++)
		{
			UserInfo user = userList.get(i);
			jsonData+="{\"userid\":\""+user.getUsername()+"\",\"userpassword\":\""+user.getTt()+"\"},";
		}
		out.println(jsonData.substring(0, jsonData.length()-1));	//去除最后一个逗号
		out.println("]");
		System.out.println(jsonData);	//测试
		out.flush();
		out.close();//关闭输出流对象
	}

}
