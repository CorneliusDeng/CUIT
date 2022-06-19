package student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

//import login.UserInfo;

public class StudentGetAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDB beanDB=new StudentDB();
		//1����ȡ�ͻ�������
		int id=Integer.parseInt(request.getParameter("id"));
		//2���������ݴ���
		StudentInfo student=beanDB.getStudentById(id);
	 	//3����ͻ���������Ӧ
		response.setContentType("application/json;charset=UTF-8");	//������Ӧ���������ͼ����뷽ʽ
		PrintWriter out = response.getWriter();	//��ȡ���������
		/*********************��ȡѧ����Ϣ****************************/
		String jsonData="";	
		jsonData="{\"id\":"+student.getStID()+",\"code\":\""+student.getStCode()+"\",\"name\":\""+student.getStName()+"\",\"sex\":"+student.getSex()+",\"grade\":"+student.getGrade()+",\"major\":\""+student.getMajor()+"\",\"detail\":\""+student.getDetail()+"\"}";
		//System.out.println(jsonData);	
		out.println(jsonData);	
		out.flush();
		out.close();	//�ر����������	
	}
}
