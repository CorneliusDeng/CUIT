package teacher;

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
@WebServlet("/TeacherModifyAction")
public class TeacherModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherModifyAction() {
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
		TeacherInfo teacher=new TeacherInfo();
		int teacherId = MyTools.strToint(request.getParameter("teacherId"));
		teacher.setName(MyTools.toChinese(request.getParameter("name")));
		//TODO 1 获取新课程的其他信息并保存到course中				
		teacher.setSex(MyTools.strToint(request.getParameter("sex")));
		teacher.setBirthday(MyTools.toChinese(request.getParameter("birthday")));
		teacher.setEducation(MyTools.toChinese(request.getParameter("education")));
		teacher.setDepartment(MyTools.toChinese(request.getParameter("department")));
		teacher.setTitle(MyTools.toChinese(request.getParameter("title")));
		teacher.setDetail(MyTools.toChinese(request.getParameter("detail")));
		//2、处理客户端提交数据
		//TODO 2 调用CourseDB插入新对象的方法实现新课程的添加
		TeacherDB beanDB=new TeacherDB();
		beanDB.modify(teacherId,teacher);
		//3、向客户端做出响应 
		//TODO 3 重定向到查询显示课程信息列表的servlet
		response.sendRedirect(request.getContextPath()+"/TeacherListAction");
	}

}

