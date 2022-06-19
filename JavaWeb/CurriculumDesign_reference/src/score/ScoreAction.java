package score;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class ScoreAction
 */
@WebServlet("/ScoreAction")
public class ScoreAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScoreDB beanDB=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreAction() {
        super();
        // TODO Auto-generated constructor stub
        beanDB=new ScoreDB();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("Action");
		System.out.println("action="+action);
		if(action==null){
			return;
		}else if(action.equals("GetStudentScoresByAjax")){//ͨ��Ajax��ȡѧ���ɼ�
			getStudentScoresByAjax(request,response);	
		}else if(action.equals("GetGradesByAjax")){//ͨ��Ajax��ȡָ��רҵ���꼶��Ϣ
			getGradesByAjax(request,response);	
		}else if(action.equals("GetCoursesByAjax")){//ͨ��Ajax��ȡָ��רҵָ���꼶�Ŀγ���Ϣ
			getCoursesByAjax(request,response);	
		}else if(action.equals("GetCourseScoresByAjax")){//ͨ��Ajax��ȡָ��רҵָ���꼶�Ŀγ���Ϣ
			getCourseScoresByAjax(request,response);	
		}else if(action.equals("GetCourseAllScoresByAjax")){//ͨ��Ajax��ȡָ���γ̵ĳɼ���Ϣ
			getCourseAllScoresByAjax(request,response);	
		}else if(action.equals("UpdateCourseScores")){//����γ̵ĳɼ���Ϣ
			updateCourseScores(request,response);	
		}
	}
	private void getStudentScoresByAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stCode=new String(request.getParameter("code"));
		//System.out.println("stCode="+stCode);
		ArrayList<ScoreInfo> list=beanDB.getStudentScoresByAjax(stCode);
		response.setContentType("text/xml;charset=UTF-8");	//����xml 
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    ScoreInfo score=null;
	    for(int i=0;i<list.size();i++){
	    	score=list.get(i);
	    	out.println("<score><n>"+score.getCourseName()+"</n><s>"+score.getScore()+"</s></score>");
	    }
	    out.println("</data>");	
	    out.flush();

	}
	private void getGradesByAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int major=Integer.parseInt(request.getParameter("major"));
		//System.out.println("stCode="+stCode);
		ArrayList<ScoreInfo> list=beanDB.getGradesByAjax(major);
		response.setContentType("text/xml;charset=UTF-8");	//����xml 
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    ScoreInfo score=null;
	    for(int i=0;i<list.size();i++){
	    	score=list.get(i);
	    	out.println("<grade><n>"+score.getGrade()+"</n></grade>");
	    }
	    out.println("</data>");	
	    out.flush();

	}
	private void getCoursesByAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int major=Integer.parseInt(request.getParameter("major"));
		int grade=Integer.parseInt(request.getParameter("grade"));
		//System.out.println("stCode="+stCode);
		ArrayList<ScoreInfo> list=beanDB.getCoursesByAjax(major,grade);
		response.setContentType("text/xml;charset=UTF-8");	//����xml 
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    ScoreInfo score=null;
	    for(int i=0;i<list.size();i++){
	    	score=list.get(i);
	    	out.println("<course><n>"+score.getCourseID()+"</n><s>"+score.getCourseName()+"</s></course>");
	    }
	    out.println("</data>");	
	    out.flush();

	}
	private void getCourseScoresByAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseID=Integer.parseInt(request.getParameter("courseID"));
		//System.out.println("stCode="+stCode);
		ArrayList<ScoreInfo> list=beanDB.getCourseScoresByAjax(courseID);
		response.setContentType("text/xml;charset=UTF-8");	//����xml 
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    ScoreInfo score=null;
	    for(int i=0;i<list.size();i++){
	    	score=list.get(i);
	    	out.println("<score><n>"+score.getStCode()+"</n><c>"+score.getStName()+"</c><s>"+score.getScore()+"</s></score>");
	    }
	    out.println("</data>");	
	    out.flush();

	}
	private void getCourseAllScoresByAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseID=Integer.parseInt(request.getParameter("courseID"));
		//System.out.println("stCode="+stCode);
		ArrayList<ScoreInfo> list=beanDB.getCourseAllScoresByAjax(courseID);
		response.setContentType("text/xml;charset=UTF-8");	//����xml 
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    ScoreInfo score=null;
	    for(int i=0;i<list.size();i++){
	    	score=list.get(i);
	    	out.println("<score><n>"+score.getStCode()+"</n><c>"+score.getStName()+"</c><s>"+score.getScore()+"</s><stid>"+score.getStID()+"</stid><cID>"+score.getCourseID()+"</cID></score>");
	    }
	    out.println("</data>");	
	    out.flush();

	}
	private void updateCourseScores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   //1����ȡ�ͻ����ύ����
		int courseID=Integer.parseInt(request.getParameter("cID"));
		String stIDs[] = request.getParameterValues("stID");
		String scores[] = request.getParameterValues("score");
		 //2������ͻ����ύ����
		if(stIDs!=null) {
			beanDB.delCourseAllScores(courseID);
			ScoreInfo score=new ScoreInfo();
			score.setCourseID(courseID);
			for(int i = 0; i < stIDs.length ; i++) {
				score.setStID(MyTools.strToint(stIDs[i]));
				score.setScore(Float.parseFloat(scores[i]));
				beanDB.insertCourseAllScores(score);
			}
		}
	
	   //3����ͻ���������Ӧ 
		response.sendRedirect(request.getContextPath()+"/score/score_query_course.jsp");


	}

}
