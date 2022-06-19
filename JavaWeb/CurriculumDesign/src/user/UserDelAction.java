package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDelAction extends HttpServlet 
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
		int id=Integer.parseInt(request.getParameter("id"));		//获取客户端提交数据
		//2、进行数据处理
	 	int count=userdb.deleteUser(id);					//调用业务处理Bean的方法处理数据
	 	//3、向客户端做出响应
		response.setContentType("text/html;charset=UTF-8");	//返回text 
		PrintWriter out = response.getWriter();
	    if(count != 0)
	    {
	    	out.print("1");//out.println("1");  
	    	//用于直接比较的简单数据不能用out.println，包含隐藏的换行符
	    }
	    else
	    {
	    	out.print("0");
	    }	
	}

}
