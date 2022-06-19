package SingleUser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class UserUpdateAction
 */
@WebServlet("/UserUpdateAction")
public class UserUpdateAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		SingleUserDB userdb = new SingleUserDB();
		SingleUserInfo user = new SingleUserInfo();
		user.setUser_id(request.getParameter("userid"));
		System.out.println("useridtest:"+user.getUser_id());
		
		int post = 1;
		if (request.getParameter("userpost").equals("管理员"))
		{
			post = 1;
		}
		else if (request.getParameter("userpost") == "教师")
		{
			post = 2;
		}
		user.setPost_id(post);
		System.out.println("postidtest:"+post);
		
		
		user.setName(request.getParameter("uesename"));
		System.out.println("usernametest:"+user.getName());
		
		
		user.setRealname(request.getParameter("realname"));
		System.out.println("realnametest:"+user.getRealname());
		
		
		user.setPassword(request.getParameter("userpassword"));
		System.out.println("passwordtest:"+user.getPassword());
		
		
		user.setPhone(request.getParameter("phone"));
		System.out.println("phonetest:"+user.getPhone());
		
		
		user.setEmail(request.getParameter("email"));
		System.out.println("emailtest:"+user.getEmail());
		
		
		int gender = 1;
		if (request.getParameter("gender").equals("男"))
		{
			gender = 1;
		}
		else if (request.getParameter("gender").equals("女"))
		{
			gender = 2;
		}
		user.setGender(gender);
		System.out.println("gendertest:"+gender);
		
		int status = 0;
		if (request.getParameter("status").equals("在职"))
		{
			status = 1;
		}
		else if (request.getParameter("status").equals("离职"))
		{
			status = 2;
		}
		user.setStatus(status);
		System.out.println("statustest:"+status);
		
		int count = userdb.updateUser(user);
		System.out.println("count:"+count);
		request.getSession().setAttribute("SingleUserInfoId",user.getUser_id());
		if (count != 0)
		{
			response.sendRedirect(request.getContextPath()+"/UserInfoAction");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
