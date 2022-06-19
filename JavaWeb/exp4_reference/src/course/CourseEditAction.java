package course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class CourseEditAction
 */
@WebServlet("/CourseEditAction")
public class CourseEditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseEditAction() {
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
		//1、获取客户端提交数据
		CourseInfo course=new CourseInfo();			
		course.setCourseID(MyTools.strToint(request.getParameter("id")));
		course.setName(MyTools.toChinese(request.getParameter("name")));
		course.setType(MyTools.strToint(request.getParameter("Properties")));
		course.setCredit(MyTools.strToFloat(request.getParameter("Credits")));
		course.setGrade(MyTools.strToint(request.getParameter("grade")));
		course.setMajor(MyTools.strToint(request.getParameter("Professional")));
		course.setDetail(MyTools.toChinese(request.getParameter("detail")));
		//2、进行数据处理
		//调用业务处理Bean的方法处理数据
		CourseDB coursedb = new CourseDB();
		coursedb.edit(course);
		System.out.println(course.getCourseID());
		//3、向客户端做出响应 
		//TODO 3 重定向到查询显示课程信息列表的servlet
		response.sendRedirect(request.getContextPath()+"/CourseListAction");
	}

}
