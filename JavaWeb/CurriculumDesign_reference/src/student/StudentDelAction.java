package student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

//import login.UserInfo;

public class StudentDelAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDB beanDB=new StudentDB();
		//1����ȡ�ͻ�������
		int id=Integer.parseInt(request.getParameter("id"));		//��ȡ�ͻ����ύ����
		//2���������ݴ���
	 	int count=beanDB.deleteStudent(id);							//����ҵ����Bean�ķ�����������
	 	//3����ͻ���������Ӧ
		response.sendRedirect(request.getContextPath()+"/servlet/StudentListAction" );//�ض���
	}
}
