package question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Course.CourseInfo;
import common.DBConnection;
import question.questionInfo;

//业务处理Bean
public class questionDB
{
	private Connection con = null;
  
	//获取所有题目信息
	public ArrayList<questionInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<questionInfo> questionList=new ArrayList<questionInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        //TODO 1 执行查询语句获取所有课程信息
	        rs=sql.executeQuery("SELECT * FROM zyyj_question");
	        //TODO 2 循环遍历题目信息结果集，将每条记录保存为一个课程信息对象，并添加到数组中
	        while(rs.next())
	        {
	        	questionInfo question =new questionInfo();
	        	question.setQuestion_id(rs.getString("question_id"));
	        	question.setCourse_id(rs.getString("course_id"));
	        	question.setProgramme_id(rs.getString("programme_id"));
	        	question.setExam_id(rs.getString("exam_id"));
	        	question.setQuestion_type(rs.getString("question_type"));
	        	question.setLevel(rs.getInt("level"));
	        	question.setQuestion(rs.getString("question"));
	        	question.setAnswer1(rs.getString("answer1"));
	        	question.setAnswer2(rs.getString("answer2"));
	        	question.setAnswer3(rs.getString("answer3"));
	        	question.setAnswer4(rs.getString("answer4"));
	        	question.setRightanswer(rs.getString("rightanswer"));
	        	question.setComment(rs.getString("comment"));
	        	questionList.add(question);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("获取所有题目信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return questionList;
	 }
  
  //添加题目信息
	public int questioninsert(questionInfo question) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	      	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_question (question_id,course_id,programme_id,exam_id,question_type,level,question,answer1,answer2,answer3,answer4,rightanswer,comment) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,question.getQuestion_id());		
	  		pStmt.setString(2,question.getCourse_id());		
	  		pStmt.setString(3,question.getProgramme_id());	
	  		pStmt.setString(4,question.getExam_id());
	  		pStmt.setString(5,question.getQuestion_type());
	  		pStmt.setInt(6,question.getLevel());
	  		pStmt.setString(7,question.getQuestion());
	  		pStmt.setString(8,question.getAnswer1());
	  		pStmt.setString(9,question.getAnswer2());
	  		pStmt.setString(10,question.getAnswer3());
	  		pStmt.setString(11,question.getAnswer4());
	  		pStmt.setString(12,question.getRightanswer());
	  		pStmt.setString(13,question.getComment());
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("添加题目失败！");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
  
	//更新题目信息各项内容
	public int update(questionInfo question) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_question set course_id=?,programme_id=?,exam_id=?,question_type=?,level=?,question=?,answer1=?,answer2=?,answer3=?,answer4=?,rightanswer=?,comment=? where question_id = ?";	
	  		pStmt = con.prepareStatement(sql);	
	  		pStmt.setString(1,question.getCourse_id());		
	  		pStmt.setString(2,question.getProgramme_id());	
	  		pStmt.setString(3,question.getExam_id());
	  		pStmt.setString(4,question.getQuestion_type());
	  		pStmt.setInt(5,question.getLevel());
	  		pStmt.setString(6,question.getQuestion());
	  		pStmt.setString(7,question.getAnswer1());
	  		pStmt.setString(8,question.getAnswer2());
	  		pStmt.setString(9,question.getAnswer3());
	  		pStmt.setString(10,question.getAnswer4());
	  		pStmt.setString(11,question.getRightanswer());
	  		pStmt.setString(12,question.getComment());
	  		pStmt.setString(13,question.getQuestion_id());	
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("修改指定题目信息失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }
  
	//通过指定题目号查询该题目的所有信息
	public questionInfo getQuestionById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	questionInfo question = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_question where question_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	question = new questionInfo();
		    	questionInfo question1 =new questionInfo();
	        	question1.setQuestion_id(rs.getString("question_id"));
	        	question1.setCourse_id(rs.getString("course_id"));
	        	question1.setProgramme_id(rs.getString("programme_id"));
	        	question1.setExam_id(rs.getString("exam_id"));
	        	question1.setQuestion_type(rs.getString("question_type"));
	        	question1.setLevel(rs.getInt("level"));
	        	question1.setQuestion(rs.getString("question"));
	        	question1.setAnswer1(rs.getString("answer1"));
	        	question1.setAnswer2(rs.getString("answer2"));
	        	question1.setAnswer3(rs.getString("answer3"));
	        	question1.setAnswer4(rs.getString("answer4"));
	        	question1.setRightanswer(rs.getString("rightanswer"));
	        	question1.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定题目信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return question;
	  }
  
  //通过题号删除指定题目信息
  public int deleteQuestion(String id) 
  {
	  PreparedStatement pStmt=null; 
	  int count=0;
      try 
      {
      	con=DBConnection.getConnection();
  		pStmt = con.prepareStatement("delete from zyyj_question where question_id=?");
  		pStmt.setString(1,id);		
  		count = pStmt.executeUpdate();
  		pStmt.close();    		
      } 
      catch (Exception e) 
      {
         	e.printStackTrace();
          System.out.println("删除指定题目失败！");
      } 
      finally
      {
    	  DBConnection.closeConnection();
      }		
      return count;
  }

  
  public String UpdategetQuestionById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	questionInfo question = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_question where question_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	question = new questionInfo();
	        	question.setQuestion_id(rs.getString("question_id"));
	        	question.setCourse_id(rs.getString("course_id"));
	        	question.setProgramme_id(rs.getString("programme_id"));
	        	question.setExam_id(rs.getString("exam_id"));
	        	question.setQuestion_type(rs.getString("question_type"));
	        	question.setLevel(rs.getInt("level"));
	        	question.setQuestion(rs.getString("question"));
	        	question.setAnswer1(rs.getString("answer1"));
	        	question.setAnswer2(rs.getString("answer2"));
	        	question.setAnswer3(rs.getString("answer3"));
	        	question.setAnswer4(rs.getString("answer4"));
	        	question.setRightanswer(rs.getString("rightanswer"));
	        	question.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定科目信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    String json;
	    json = "{\"question_id\":\""+question.getQuestion_id()+"\", \"course_id\":\""+question.getCourse_id()+"\", \"programme_id\":\""+question.getProgramme_id()+"\",\"exam_id\":\""+question.getExam_id()+"\", \"question_type\":\""+question.getQuestion_type()+"\", "
	    		+ "\"level\":"+question.getLevel()+", \"question\":\""+question.getQuestion()+"\", \"answer1\":\""+question.getAnswer1()+"\", \"answer2\":\""+question.getAnswer2()+"\", \"answer3\":\""+question.getAnswer3()+"\", \"answer4\":\""+question.getAnswer4()+"\", \"rightanswer\":\""+question.getRightanswer()+"\", \"comment\":\""+question.getComment()+"\"}";
	    return json;
	  }
}