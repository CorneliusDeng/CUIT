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
		doPost(request,response); //����doPost����
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1����ȡ�ͻ����ύ����
		TeacherInfo teacher=new TeacherInfo();
		int teacherId = MyTools.strToint(request.getParameter("teacherId"));
		teacher.setName(MyTools.toChinese(request.getParameter("name")));
		//TODO 1 ��ȡ�¿γ̵�������Ϣ�����浽course��				
		teacher.setSex(MyTools.strToint(request.getParameter("sex")));
		teacher.setBirthday(MyTools.toChinese(request.getParameter("birthday")));
		teacher.setEducation(MyTools.toChinese(request.getParameter("education")));
		teacher.setDepartment(MyTools.toChinese(request.getParameter("department")));
		teacher.setTitle(MyTools.toChinese(request.getParameter("title")));
		teacher.setDetail(MyTools.toChinese(request.getParameter("detail")));
		//2������ͻ����ύ����
		//TODO 2 ����CourseDB�����¶���ķ���ʵ���¿γ̵����
		TeacherDB beanDB=new TeacherDB();
		beanDB.modify(teacherId,teacher);
		//3����ͻ���������Ӧ 
		//TODO 3 �ض��򵽲�ѯ��ʾ�γ���Ϣ�б��servlet
		response.sendRedirect(request.getContextPath()+"/TeacherListAction");
	}

}

