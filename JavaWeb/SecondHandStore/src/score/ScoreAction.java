package score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/ScoreAction")
public class ScoreAction extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ScoreDB beanDB=null;  
	
    public ScoreAction() 
    {
        super();
        beanDB=new ScoreDB();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String action=request.getParameter("Action");
		if(action==null)
		{
			return;
		}
		else if(action.equals("GetStudentScoresByAjax"))
		{//ͨ获取学生分数信息
			getStudentScoresByAjax(request,response);	
		}
		else if(action.equals("GetGradesByAjax"))
		{//ͨ获取指定专业的年级信息

		}
		else if(action.equals("GetCoursesByAjax"))
		{//ͨ获取指定专业指定年级的课程信息

		}
		else if(action.equals("GetCourseScoresByAjax"))
		{//ͨ获取课程成绩信息

		}
		else if(action.equals("GetCourseAllScoresByAjax"))
		{//ͨ获取指定课程所有成绩信息

		}
		else if(action.equals("UpdateCourseScores"))
		{//删除指定课程所有成绩信息

		}
	}
	
	private void getStudentScoresByAjax(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		int stCode = Integer.parseInt(request.getParameter("code"));

		ArrayList<ScoreInfo> list=beanDB.getStudentScoresByAjax(stCode);
		response.setContentType("text/xml;charset=UTF-8");	
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    ScoreInfo score=null;

	    for(int i = 0; i < list.size(); i++)
	    {
	    	score=list.get(i);
	    	out.println("<score><n>"+score.getStID()+"</n><s>"+score.getStName()+"</s><s>"+score.getCourseID()+"</s><s>"+score.getCourseName()+"</s></score>");
	    }
	    out.println("</data>");	
	    out.flush();
	}
	
	/*private void getGradesByAjax(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		int major = Integer.parseInt(request.getParameter("major"));
		ArrayList<ScoreInfo> list = beanDB.getGradesByAjax(major);
		response.setContentType("text/xml;charset=UTF-8");	
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    ScoreInfo score=null;
	    for(int i=0;i<list.size();i++)
	    {
	    	score=list.get(i);
	    	out.println("<grade><n>"+score.getGrade()+"</n></grade>");
	    }
	    out.println("</data>");	
	    out.flush();

	}
	
	private void getCoursesByAjax(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		int major = Integer.parseInt(request.getParameter("major"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		ArrayList<ScoreInfo> list=beanDB.getCoursesByAjax(major,grade);
		response.setContentType("text/xml;charset=UTF-8");	
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    ScoreInfo score=null;
	    for(int i = 0; i < list.size(); i++)
	    {
	    	score=list.get(i);
	    	out.println("<course><n>"+score.getCourseID()+"</n><s>"+score.getCourseName()+"</s></course>");
	    }
	    out.println("</data>");	
	    out.flush();

	}
	
	private void getCourseScoresByAjax(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		int courseID=Integer.parseInt(request.getParameter("courseID"));
		ArrayList<ScoreInfo> list=beanDB.getCourseScoresByAjax(courseID);
		response.setContentType("text/xml;charset=UTF-8");	
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    ScoreInfo score=null;
	    for(int i = 0; i < list.size(); i++)
	    {
	    	score=list.get(i);
	    	out.println("<score><n>"+score.getStCode()+"</n><c>"+score.getStName()+"</c><s>"+score.getScore()+"</s></score>");
	    }
	    out.println("</data>");	
	    out.flush();

	}
	
	private void getCourseAllScoresByAjax(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		int courseID=Integer.parseInt(request.getParameter("courseID"));
		ArrayList<ScoreInfo> list=beanDB.getCourseAllScoresByAjax(courseID);
		response.setContentType("text/xml;charset=UTF-8");	
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    ScoreInfo score=null;
	    for(int i = 0; i < list.size(); i++)
	    {
	    	score=list.get(i);
	    	out.println("<score><n>"+score.getStCode()+"</n><c>"+score.getStName()+"</c><s>"+score.getScore()+"</s><stid>"+score.getStID()+"</stid><cID>"+score.getCourseID()+"</cID></score>");
	    }
	    out.println("</data>");	
	    out.flush();

	}
	private void updateCourseScores(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		int courseID=Integer.parseInt(request.getParameter("cID"));
		String stIDs[] = request.getParameterValues("stID");
		String scores[] = request.getParameterValues("score");
		if(stIDs != null) 
		{
			beanDB.delCourseAllScores(courseID);
			ScoreInfo score=new ScoreInfo();
			score.setCourseID(courseID);
			for(int i = 0; i < stIDs.length ; i++) 
			{
				score.setStID(MyTools.strToint(stIDs[i]));
				score.setScore(Float.parseFloat(scores[i]));
				beanDB.insertCourseAllScores(score);
			}
		}
		response.sendRedirect(request.getContextPath()+"/score/score_query_course.jsp");
	}*/
}
