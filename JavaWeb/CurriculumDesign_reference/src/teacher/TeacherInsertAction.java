package teacher;

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
@WebServlet("/TeacherInsertAction")
public class TeacherInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherInsertAction() {
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
		teacher.setTeacherID(MyTools.strToint(request.getParameter("teacherId")));
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
		beanDB.insert(teacher);
		//3����ͻ���������Ӧ 
		response.sendRedirect(request.getContextPath()+"/TeacherListAction");//TODO 3 �ض��򵽲�ѯ��ʾ�γ���Ϣ�б��servlet
	}

}
