package score;

import common.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreDB 
{
    private Connection con = null;
    /*��ȡѧ��������Ϣ*/
    public ArrayList<ScoreInfo> getStudentScoresByAjax(int stCode)
    {
        ResultSet rs=null;
        Statement stmt=null;
        ArrayList<ScoreInfo> list = new ArrayList<ScoreInfo>();
        try 
        {
        	con = DBConnection.getConnection();
            stmt = con.createStatement();
            String sql="select order_id,com_id,user_id,order_status,order_time ";
            sql+="from td_order ";
            sql+="where com_id = "+stCode;
	    	rs = stmt.executeQuery(sql);
	    	while(rs.next())
	    	{
	    		ScoreInfo score=new ScoreInfo();
	    		score.setStID(rs.getInt("order_id"));
	    		score.setStCode(rs.getInt("com_id"));
	    		score.setStName(rs.getInt("user_id"));
	    		score.setCourseID(rs.getString("order_status"));
	    		score.setCourseName(rs.getString("order_time"));
	    		list.add(score);
	    	}

			rs.close();
			stmt.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("��ȡѧ��������Ϣʧ�ܣ�");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return list;
    }
    
    /*��ȡָ��רҵ���꼶��Ϣ*/
    /*public ArrayList<ScoreInfo> getGradesByAjax(int major)
    {
        ResultSet rs=null;
        Statement stmt=null;
        ArrayList<ScoreInfo> list=new ArrayList<ScoreInfo>();
        try 
        {
        	con=DBConnection.getConnection();
            stmt=con.createStatement();
            String sql="select distinct N_GRADE  from  t_course where N_MAJOR="+major;	
	    	rs=stmt.executeQuery(sql);
	    	while(rs.next())
	    	{
	    		ScoreInfo score=new ScoreInfo();
	    		score.setGrade(rs.getInt("N_GRADE"));
	    		list.add(score);	    		
	    	}  
			rs.close();
			stmt.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("��ȡָ��רҵ���꼶��Ϣʧ�ܣ�");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return list;
    }
    
    /*��ȡָ��רҵָ���꼶�Ŀγ���Ϣ*/
    /*public ArrayList<ScoreInfo> getCoursesByAjax(int major,int grade)
    {
        ResultSet rs=null;
        Statement stmt=null;
        ArrayList<ScoreInfo> list=new ArrayList<ScoreInfo>();
        try 
        {
        	con=DBConnection.getConnection();
            stmt=con.createStatement();
            String sql="select distinct N_COURSE_ID,VC_COURSE_NAME  from  t_course where N_MAJOR="+major +" and N_GRADE="+grade;	
	    	rs=stmt.executeQuery(sql);
	    	while(rs.next())
	    	{
	    		ScoreInfo score=new ScoreInfo();
	    		score.setCourseID(rs.getInt("N_COURSE_ID"));
	    		score.setCourseName(rs.getString("VC_COURSE_NAME"));
	    		list.add(score);	    		
	    	}  
			rs.close();
			stmt.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("��ȡָ��רҵָ���꼶�Ŀγ���Ϣʧ�ܣ�");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return list;
    }
    
    /*��ȡ�γ̳ɼ���Ϣ*/
    /*public ArrayList<ScoreInfo> getCourseScoresByAjax(int courseID)
    {
        ResultSet rs=null;
        Statement stmt=null;
        ArrayList<ScoreInfo> list=new ArrayList<ScoreInfo>();
        try 
        {
        	con=DBConnection.getConnection();
            stmt=con.createStatement();
            String sql="select a.N_STUDENT_ID,b.VC_STUDENT_CODE,b.VC_STUDENT_NAME,a.N_COURSE_ID,a.F_SCORE from t_score a,t_student b ";
            sql+="where a.N_COURSE_ID="+courseID+" and a.N_STUDENT_ID=b.N_STUDENT_ID ";	
            System.out.println("sql="+sql);
	    	rs=stmt.executeQuery(sql);
	    	while(rs.next())
	    	{
	    		ScoreInfo score=new ScoreInfo();
	    		score.setStID(rs.getInt("N_STUDENT_ID"));
	    		score.setStCode(rs.getString("VC_STUDENT_CODE"));
	    		score.setStName(rs.getString("VC_STUDENT_NAME"));
	    		score.setCourseID(rs.getInt("N_COURSE_ID"));
	    		score.setScore(rs.getFloat("F_SCORE"));
	    		list.add(score);	    		
	    	}  
			rs.close();
			stmt.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("��ȡ�γ̳ɼ���Ϣʧ�ܣ�");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return list;
    }
    
    /*��ȡָ���γ����гɼ���Ϣ*/
    /*public ArrayList<ScoreInfo> getCourseAllScoresByAjax(int courseID)
    {
        ResultSet rs=null;
        Statement stmt=null;
        ArrayList<ScoreInfo> list=new ArrayList<ScoreInfo>();
        try 
        {
        	con=DBConnection.getConnection();
            stmt=con.createStatement();
            String sql="select a.N_STUDENT_ID,a.VC_STUDENT_CODE,a.VC_STUDENT_NAME,b.N_COURSE_ID, "; 
            sql+="(select F_SCORE from t_score where N_COURSE_ID=b.N_COURSE_ID and N_STUDENT_ID=a.N_STUDENT_ID) F_SCORE ";
            sql+="from t_student a,t_course b ";
            sql+="where b.N_COURSE_ID="+courseID+" and a.N_MAJOR =b.N_MAJOR and a.N_GRADE =b.N_GRADE  ";	
            //System.out.println("sql="+sql);
	    	rs=stmt.executeQuery(sql);
	    	while(rs.next())
	    	{
	    		ScoreInfo score=new ScoreInfo();
	    		score.setStID(rs.getInt("N_STUDENT_ID"));
	    		score.setStCode(rs.getString("VC_STUDENT_CODE"));
	    		score.setStName(rs.getString("VC_STUDENT_NAME"));
	    		score.setCourseID(rs.getInt("N_COURSE_ID"));
	    		score.setScore(rs.getFloat("F_SCORE"));
	    		list.add(score);	    		
	    	}  
			rs.close();
			stmt.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("��ȡ�γ����гɼ���Ϣʧ�ܣ�");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return list;
    }
    
    /*ɾ��ָ���γ����гɼ���Ϣ*/
    /*public int delCourseAllScores(int courseID)
    {
        int count=0;
        Statement stmt=null;
        try 
        {
        	con=DBConnection.getConnection();
            stmt=con.createStatement();
            String sql="delete from t_score where  N_COURSE_ID="+courseID;	
            count=stmt.executeUpdate(sql);	    	
			stmt.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("ɾ���γ����гɼ���Ϣʧ�ܣ�");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
    }
    
    /*��ӳɼ���Ϣ*/
    /*public int insertCourseAllScores(ScoreInfo score)
    {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try 
        {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("INSERT INTO t_score (N_STUDENT_ID,N_COURSE_ID,F_SCORE) VALUES (?,?,?)");
    		pStmt.setInt(1,score.getStID());		
    		pStmt.setInt(2,score.getCourseID());		
    		pStmt.setFloat(3,score.getScore());		
     		count=pStmt.executeUpdate();  
			pStmt.close();
        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("��ӳɼ���Ϣʧ�ܣ�");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
    }*/
}
