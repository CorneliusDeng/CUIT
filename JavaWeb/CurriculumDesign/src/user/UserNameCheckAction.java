package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

public class UserNameCheckAction extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
	
	public UserNameCheckAction() 
	{
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		int id = MyTools.strToint(request.getParameter("id"));
		String name =request.getParameter("name");
		UserDB userdb = new UserDB();
		int count = userdb.getUserNameById(name, id);
		response.setContentType("text/html;charset=UTF-8");	//返回text 
		PrintWriter out = response.getWriter();
	    if(count!=0)
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
