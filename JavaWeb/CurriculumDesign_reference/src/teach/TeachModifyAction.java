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
		doPost(request,response); //����doPost����
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1����ȡ�ͻ����ύ����
		TeachInfo teach=new TeachInfo();
		int teachId = MyTools.strToint(request.getParameter("TeachId"));				
		teach.setTeacherId(MyTools.strToint(request.getParameter("teacherId")));
		teach.setCourseId(MyTools.strToint(request.getParameter("courseId")));
		//2������ͻ����ύ����
		//TODO 2 ����TeachDB�����¶���ķ���ʵ���¿γ̵����
		TeachDB beanDB=new TeachDB();
		beanDB.modify(teachId,teach);
		//3����ͻ���������Ӧ 
		//TODO 3 �ض��򵽲�ѯ��ʾ�γ���Ϣ�б��servlet
		response.sendRedirect(request.getContextPath()+"/TeachListAction");
	}

}

