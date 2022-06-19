package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;



public class StudentListAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDB beanDB=new StudentDB();
		//request.getSession().setAttribute("studentlist",beanDB.getAllStudents());
		//response.sendRedirect(request.getContextPath()+"/student/student_list.jsp");
		ArrayList<StudentInfo> list=beanDB.getAllStudents();
		response.setContentType("application/json;charset=UTF-8");	//������Ӧ���������ͼ����뷽ʽ
		PrintWriter out = response.getWriter();	//��ȡ���������
		out.println("[");
		/*********************��ȡѧ����Ϣ****************************/
		String jsonData="";
		for(int i=0;i<list.size();i++){
			StudentInfo student=list.get(i);
			String major=(student.getMajor()==1?"�������":"�ռ���Ϣ");
			
			jsonData+="{\"id\":"+student.getStID()+",\"code\":\""+student.getStCode()+"\",\"name\":\""+student.getStName()+"\",\"sex\":"+student.getSex()+",\"grade\":"+student.getGrade()+",\"major\":\""+major+"\"},";
		}
		out.println(jsonData.substring(0, jsonData.length()-1));	//ȥ�����һ������
		out.println("]");
		//System.out.println(jsonData);	
		out.flush();
		out.close();	//�ر����������
	
	}

}
