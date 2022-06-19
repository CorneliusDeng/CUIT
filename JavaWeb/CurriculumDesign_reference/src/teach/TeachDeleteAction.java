package teach;

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
@WebServlet("/TeachDeleteAction")
public class TeachDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachDeleteAction() {
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
		TeachDB beanDB=new TeachDB();
		//1����ȡ�ͻ�������
		int teachId = MyTools.strToint(request.getParameter("TeachId"));            //��ȡ�ͻ����ύ����	
		//2���������ݴ���
		beanDB.delete(teachId);							//����ҵ����Bean�ķ�����������
	 	//3����ͻ���������Ӧ
		response.sendRedirect(request.getContextPath()+"/TeachListAction");//�ض���
	}

}