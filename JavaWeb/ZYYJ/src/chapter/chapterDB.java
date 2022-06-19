package chapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;
import chapter.chapterInfo;

//业务处理Bean
public class chapterDB
{
	private Connection con = null;
  
	//获取所有章节信息
	public ArrayList<chapterInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<chapterInfo> chapterList=new ArrayList<chapterInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        //TODO 1 执行查询语句获取所有章节信息
	        rs=sql.executeQuery("SELECT * FROM zyyj_chapter");
	        //TODO 2 循环遍历章节信息结果集，将每条记录保存为一个课程信息对象，并添加到数组中
	        while(rs.next())
	        {
	        	chapterInfo chapter =new chapterInfo();
	        	chapter.setChapter_id(rs.getString("chapter_id"));
	        	chapter.setCourse_id(rs.getString("course_id"));
	        	chapter.setName(rs.getString("name"));
	        	chapter.setPhoto(rs.getString("photo"));
	        	chapter.setComment(rs.getString("comment"));
	        	chapterList.add(chapter);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("获取所有章节信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return chapterList;
	 }
  
  //添加章节信息
	public int chapterinsert(chapterInfo chapter) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	      	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_chapter (chapter_id,course_id,name,photo,comment) values (?,?,?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,chapter.getChapter_id());		
	  		pStmt.setString(2,chapter.getCourse_id());	
	  		pStmt.setString(3,chapter.getCourse_id());		
	  		pStmt.setString(4,chapter.getPhoto());	
	  		pStmt.setString(5,chapter.getComment());	
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("添加章节失败！");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
  
	//更新章节信息各项内容
	public int update(chapterInfo chapter) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_chapter set course_id=?,name=?,photo=?,comment=? where chapter_id = ?";	
	  		pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,chapter.getCourse_id());
	  		pStmt.setString(2, chapter.getName());
	  		pStmt.setString(3, chapter.getPhoto());
	  		pStmt.setString(4, chapter.getComment());
	  		pStmt.setString(5,chapter.getChapter_id());		
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("修改指定章节信息失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }
  
	//通过指定章节号查询某章节的所有信息
	public chapterInfo getChapterById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	chapterInfo chapter = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_chapter where chapter_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	chapter = new chapterInfo();
		    	chapter.setChapter_id(rs.getString("chapter_id"));
		    	chapter.setCourse_id(rs.getString("course_id"));
		    	chapter.setName(rs.getString("name"));
		    	chapter.setPhoto(rs.getString("photo"));
		    	chapter.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定章节信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return chapter;
	  }
  
  //通过章节号删除章节学院信息
  public int deleteChapter(String id) 
  {
	  PreparedStatement pStmt=null; 
	  int count=0;
      try 
      {
      	con=DBConnection.getConnection();
  		pStmt = con.prepareStatement("delete from zyyj_chapter where chapter_id=?");
  		pStmt.setString(1,id);		
  		count = pStmt.executeUpdate();
  		pStmt.close();    		
      } 
      catch (Exception e) 
      {
         	e.printStackTrace();
          System.out.println("删除指定章节失败！");
      } 
      finally
      {
    	  DBConnection.closeConnection();
      }		
      return count;
  }   
  
  public String UpdategetChapterById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	chapterInfo chapter = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_chapter where chapter_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	chapter = new chapterInfo();
		    	chapter.setChapter_id(rs.getString("chapter_id"));
		    	chapter.setCourse_id(rs.getString("course_id"));
		    	chapter.setName(rs.getString("name"));
		    	chapter.setPhoto(rs.getString("photo"));
		    	chapter.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定章节信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    String json;
	    json = "{\"chapter_id\":\""+chapter.getChapter_id()+"\", \"course_id\":\""+chapter.getCourse_id()+"\", \"name\":\""+chapter.getName()+"\",\"photo\":\""+chapter.getPhoto()+"\", \"comment\":\""+chapter.getComment()+"\"}";
	    return json;
	  }

}