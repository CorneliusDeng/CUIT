package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class UserInsertAction
 */
@WebServlet("/UserInsertAction")
public class UserInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInfo use = new UserInfo();
		use.setUserName(MyTools.toChinese(request.getParameter("name")));
		use.setUserPwd(MyTools.toChinese(request.getParameter("password")));
		UserDB bean = new UserDB();
		bean.insert(use);
		response.sendRedirect(request.getContextPath()+"/UserListAction");
	}

}
