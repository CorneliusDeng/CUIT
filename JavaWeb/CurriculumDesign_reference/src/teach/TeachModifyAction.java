package teach;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class CourseModifyAction
 */
@WebServlet("/TeachModifyAction")
public class TeachModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachModifyAction() {
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
		TeachInfo teach=new TeachInfo();
		int teachId = MyTools.strToint(request.getParameter("TeachId"));				
		teach.setTeacherId(MyTools.strToint(request.getParameter("teacherId")));
		teach.setCourseId(MyTools.strToint(request.getParameter("courseId")));
		//2、处理客户端提交数据
		//TODO 2 调用TeachDB插入新对象的方法实现新课程的添加
		TeachDB beanDB=new TeachDB();
		beanDB.modify(teachId,teach);
		//3、向客户端做出响应 
		//TODO 3 重定向到查询显示课程信息列表的servlet
		response.sendRedirect(request.getContextPath()+"/TeachListAction");
	}

}

