package course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.MyTools;
import java.util.*;

/**
 * Servlet implementation class CourseInsertAction
 */
@WebServlet("/CourseInsertAction")
public class CourseInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response); //调用doPost方法
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取客户端提交数据
		CourseInfo course=new CourseInfo();
		course.setName(MyTools.toChinese(request.getParameter("name")));
		//TODO 1 获取新课程的其他信息并保存到course中				
		course.setType(MyTools.strToint(request.getParameter("type")));
		course.setCredit(MyTools.strToFloat(request.getParameter("credit")));
		course.setGrade(MyTools.strToint(request.getParameter("grade")));
		course.setMajor(MyTools.strToint(request.getParameter("major")));
		course.setDetail(MyTools.toChinese(request.getParameter("detail")));
		//2、处理客户端提交数据
		//TODO 2 调用CourseDB插入新对象的方法实现新课程的添加
		CourseDB beanDB=new CourseDB();
		beanDB.insert(course);
		//3、向客户端做出响应 
		response.sendRedirect(request.getContextPath()+"/CourseListAction");//TODO 3 重定向到查询显示课程信息列表的servlet
	}

}
