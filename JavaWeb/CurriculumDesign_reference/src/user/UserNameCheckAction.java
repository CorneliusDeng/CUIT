package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class StudentCodeCheckAction
 */
@WebServlet("/servlet/UserNameCheckAction")
public class UserNameCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNameCheckAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId=MyTools.strToint(request.getParameter("id"));
		String userName=request.getParameter("name");
		UserDB beanDB=new UserDB();	
		int count=beanDB.getUserCountByName(userName, userId);
		response.setContentType("text/html;charset=UTF-8");	//返回text 
		PrintWriter out = response.getWriter();
	    if(count!=0){
	    	out.print("1");//out.println("1");  
	    	//用于直接比较的简单数据不能用out.println，包含隐藏的换行符
	    }else{
	    	out.print("0");
	    }	
	}

}
