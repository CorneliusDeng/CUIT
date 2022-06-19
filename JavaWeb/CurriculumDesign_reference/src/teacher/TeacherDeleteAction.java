package teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class CourseDeleteAction
 */
@WebServlet("/TeacherDeleteAction")
public class TeacherDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDB beanDB=new TeacherDB();
		//1、获取客户端请求
		int TeacherId = MyTools.strToint(request.getParameter("TeacherId"));            //获取客户端提交数据	
		//2、进行数据处理
		beanDB.delete(TeacherId);							//调用业务处理Bean的方法处理数据
	 	//3、向客户端做出响应
		response.sendRedirect(request.getContextPath()+"/TeacherListAction");//重定向
	}

}