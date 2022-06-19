package SingleUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.xml.internal.bind.v2.model.core.ID;
import SingleUser.*;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String userid = (String)request.getSession().getAttribute("change-userid");
		SingleUserInfo user = new SingleUserDB().GetUserbyId(userid);
		SingleUserDB userdb = new SingleUserDB();
		String oddpassword = request.getParameter("oldPassword"); 
		String newpassword1 = request.getParameter("newPassword1");
		String newpassword2 = request.getParameter("newPassword2");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (!oddpassword.equals(user.getPassword()) || oddpassword.equals(""))
		{
			out.println("<script>alert('原密码输入有误或为空！请求失败'); window.location='admin.jsp?externalPage=userInfo.jsp'</script>");
		}
		else 
		{
			if (!newpassword1.equals(newpassword2))
			{
				out.println("<script>alert('两次密码输入不一致！请求失败'); window.location='admin.jsp?externalPage=userInfo.jsp'</script>");
			}
			else if (newpassword1.equals("") || newpassword2.equals("")) 
			{
				out.println("<script>alert('请确认密码，不能为空！'); window.location='admin.jsp?externalPage=userInfo.jsp'</script>");
			}
			else 
			{
				user.setPassword(newpassword2);
				int count = userdb.updateUserPassowrd(user);
				out.println("<script>alert('密码修改成功！请重新登陆！'); window.location='login.jsp'</script>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
