package course;

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
@WebServlet("/CourseModifyAction")
public class CourseModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response); //����doPost����
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1����ȡ�ͻ����ύ����
		CourseInfo course=new CourseInfo();
		int courseId = MyTools.strToint(request.getParameter("courseId"));
		course.setName(MyTools.toChinese(request.getParameter("name")));
		//TODO 1 ��ȡ�¿γ̵�������Ϣ�����浽course��				
		course.setType(MyTools.strToint(request.getParameter("type")));
		course.setCredit(MyTools.strToFloat(request.getParameter("credit")));
		course.setGrade(MyTools.strToint(request.getParameter("grade")));
		course.setMajor(MyTools.strToint(request.getParameter("major")));
		course.setDetail(MyTools.toChinese(request.getParameter("detail")));
		//2������ͻ����ύ����
		//TODO 2 ����CourseDB�����¶���ķ���ʵ���¿γ̵����
		CourseDB beanDB=new CourseDB();
		beanDB.modify(courseId,course);
		//3����ͻ���������Ӧ 
		//TODO 3 �ض��򵽲�ѯ��ʾ�γ���Ϣ�б��servlet
		response.sendRedirect(request.getContextPath()+"/CourseListAction");
	}

}

