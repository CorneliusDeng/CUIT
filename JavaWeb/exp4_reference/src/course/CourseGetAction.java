package course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CourseGetAction
 */
@WebServlet("/CourseGetAction")
public class CourseGetAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseGetAction() {
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
		CourseDB beanDB=new CourseDB();
		//1、获取客户端请求
		int id=Integer.parseInt(request.getParameter("id"));
		//2、进行数据处理
		CourseInfo course=beanDB.getCourseById(id);
		request.getSession().setAttribute("courseinfo", course);
	 	//3、向客户端做出响应
		response.sendRedirect(request.getContextPath()+"/course/course_edit.jsp" );//重定向
	}

}
