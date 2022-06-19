package Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import common.DBConnection;

public class StudentDB 
{
	private Connection con = null;
	
	//获取所有学生信息
	public ArrayList<StudentInfo> getAll() 
	{
		ResultSet rs=null;
		Statement sql=null;
		ArrayList<StudentInfo> studentList = new ArrayList<StudentInfo>();
		try 
		{
			con=DBConnection.getConnection();
	        sql=con.createStatement();
	        rs=sql.executeQuery("SELECT * FROM zyyj_student");
	        while(rs.next())
	        {
	        	StudentInfo student = new StudentInfo(); 
	        	student.setStuid(rs.getString("stu_id"));
	        	student.setCalssid(rs.getString("class_id"));
	        	student.setName(rs.getString("name"));
	        	student.setPassword(rs.getString("password"));
	        	student.setGender(rs.getInt("gender"));
	        	student.setEmail(rs.getString("email"));
	        	student.setPhone(rs.getString("phone"));
	        	student.setAccount(rs.getString("account"));
	        	studentList.add(student);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("获取所有学生信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return studentList;
	 }
	
	//添加学生信息
	public int Studentinsert(StudentInfo student) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	      	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_student (stu_id,class_id,name,gender,email,phone,account,password) values (?,?,?,?,?,?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	      	pStmt.setString(1, student.getStuid());
	      	pStmt.setString(2,student.getCalssid());
	  		pStmt.setString(3,student.getName());		
	  		pStmt.setInt(4,student.getGender());	
	  		pStmt.setString(5, student.getEmail());
	  		pStmt.setString(6, student.getPhone());
	  		pStmt.setString(7, student.getAccount());
	  		pStmt.setString(8, student.getPassword());
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("添加学生失败！");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
	
	//更新学生信息各项内容
	public int update(StudentInfo student) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_student set class_id=?,name=?,gender=?,email=?,phone=?,account=?, password=? where stu_id = ?";	
	  		pStmt = con.prepareStatement(sql);
	      	pStmt.setString(1,student.getCalssid());
	  		pStmt.setString(2,student.getName());		
	  		pStmt.setInt(3,student.getGender());	
	  		pStmt.setString(4, student.getEmail());
	  		pStmt.setString(5, student.getPhone());
	  		pStmt.setString(6, student.getAccount());
	  		pStmt.setString(7, student.getPassword());
	  		pStmt.setString(8, student.getStuid());
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("修改指定学生信息失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	}
	
	//通过指定学生遍号查询某学生的所有信息
	public StudentInfo getStudentById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	StudentInfo student = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_student where stu_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	student = new StudentInfo();
		    	student.setStuid(rs.getString("stu_id"));
	        	student.setCalssid(rs.getString("class_id"));
	        	student.setName(rs.getString("name"));
	        	student.setGender(rs.getInt("gender"));
	        	student.setEmail(rs.getString("email"));
	        	student.setPhone(rs.getString("phone"));
	        	student.setAccount(rs.getString("account"));
	        	student.setPassword(rs.getString("password"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定学生信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return student;
	}
	
	//通过学生编号删除指定学生信息
	public int deleteStudent(String id) 
	{
		PreparedStatement pStmt=null; 
		int count=0;
		try 
		{
			con=DBConnection.getConnection();
			pStmt = con.prepareStatement("delete from zyyj_student where stu_id=?");
			pStmt.setString(1,id);		
			count = pStmt.executeUpdate();
			pStmt.close();    		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("删除指定学生失败！");
		} 
		finally
		{
			DBConnection.closeConnection();
		}		
		return count;
	}   
	
	//通过学生编号更新指定学生信息
	public String UpdategetStudentById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	StudentInfo student = null;
	  	
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_student where stu_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	student = new StudentInfo();
		    	student.setStuid(rs.getString("stu_id"));
	        	student.setCalssid(rs.getString("class_id"));
	        	student.setName(rs.getString("name"));
	        	student.setGender(rs.getInt("gender"));
	        	student.setEmail(rs.getString("email"));
	        	student.setPhone(rs.getString("phone"));
	        	student.setAccount(rs.getString("account"));
	        	student.setPassword(rs.getString("password"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定学生信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    String json;
	    json = "{\"studentid\":\""+student.getStuid()+"\", \"classid\":\""+student.getCalssid()+"\", \"name\":\""+student.getName()+"\", \"gender\":\""+student.getGender()+"\", \"email\":\""+student.getEmail()+"\", \"phone\":\""+student.getPhone()+"\", \"account\":\""+student.getAccount()+"\", \"password\":\""+student.getPassword()+"\"}";
	    return json;
	  }
	
	//通过指定班级名称查询某学生的所有信息
	public StudentInfo getStudentByClassId(String classname) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	StudentInfo student = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("select * from zyyj_student \r\n" + 
	  				"where class_id in (select class_id from zyyj_class where name like \"'?\"');");
	  		pStmt.setString(1,classname);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	student = new StudentInfo();
		    	student.setStuid(rs.getString("stu_id"));
	        	student.setCalssid(rs.getString("class_id"));
	        	student.setName(rs.getString("name"));
	        	student.setGender(rs.getInt("gender"));
	        	student.setEmail(rs.getString("email"));
	        	student.setPhone(rs.getString("phone"));
	        	student.setAccount(rs.getString("account"));
	        	student.setPassword(rs.getString("password"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定学生信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return student;
	}
	
	//通过关键字搜索学生信息
	public ArrayList<SearchStudentInfo> getSearchStuInfo(String input, String option)
	{
		
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	ArrayList<SearchStudentInfo> studentList = new ArrayList<SearchStudentInfo>();
	  	
	  	try 
	    {
	      	con = DBConnection.getConnection();
	      	if (option.equals("1"))
	      	{//班级名称搜索
	      		pStmt = con.prepareStatement("select stu.stu_id stuid, stu.account account, class.name classname,  grade.name gradename, major.name majorname, col.name colname, stu.name stuname, stu.gender gender, stu.email email, stu.phone phoner\n" + 
	      				"from zyyj_student as stu, zyyj_class as class, zyyj_grade as grade, zyyj_major as major, zyyj_college as col\r\n" + 
	      				"where stu.class_id in (select class_id from zyyj_class where name like ?)\r\n" + 
	      				"and \r\n" + 
	      				"stu.class_id=class.class_id and class.grade_id=grade.grade_id and grade.major_id=major.major_id and major.college_id = col.college_id;");
	      		
	      	}
	      	else if (option.equals("2"))
	      	{//年级名搜索
	      		pStmt = con.prepareStatement("select stu.stu_id stuid, stu.account account, class.name classname,  grade.name gradename, major.name majorname, col.name colname, stu.name stuname, stu.gender gender, stu.email email, stu.phone phone\r\n" + 
	      				"from zyyj_student as stu, zyyj_class as class, zyyj_grade as grade, zyyj_major as major, zyyj_college as col\r\n" + 
	      				"where  \r\n" + 
	      				"stu.class_id=class.class_id and\r\n" + 
	      				"class.grade_id in (select grade_id from zyyj_grade where name like ?) and class.grade_id=grade.grade_id and grade.major_id=major.major_id and major.college_id = col.college_id;");
	      	}
	      	else if (option.equals("3"))
	      	{//专业名搜索
	      		pStmt = con.prepareStatement("select stu.stu_id stuid, stu.account account, class.name classname,  grade.name gradename, major.name majorname, col.name colname, stu.name stuname, stu.gender gender, stu.email email, stu.phone phone\r\n" + 
	      				"from zyyj_student as stu, zyyj_class as class, zyyj_grade as grade, zyyj_major as major, zyyj_college as col\r\n" + 
	      				"where  \r\n" + 
	      				"stu.class_id=class.class_id and\r\n" + 
	      				"class.grade_id = grade.grade_id and \r\n" + 
	      				"grade.major_id in (select major_id from zyyj_major where name like ?) and \r\n" + 
	      				"grade.major_id=major.major_id and major.college_id = col.college_id;");
	      	}
	      	else if (option.equals("4"))
	      	{//学院名搜索
	      		pStmt = con.prepareStatement("select stu.stu_id stuid, stu.account account, class.name classname,  grade.name gradename, major.name majorname, col.name colname, stu.name stuname, stu.gender gender, stu.email email, stu.phone phone\r\n" + 
	      				"from zyyj_student as stu, zyyj_class as class, zyyj_grade as grade, zyyj_major as major, zyyj_college as col\r\n" + 
	      				"where  \r\n" + 
	      				"stu.class_id=class.class_id and\r\n" + 
	      				"class.grade_id = grade.grade_id and \r\n" + 
	      				"grade.major_id = major.major_id and \r\n" + 
	      				"major.college_id in (select college_id from zyyj_college where name like ?) and\r\n" + 
	      				"major.college_id = col.college_id;");
	      	}		
	  		pStmt.setString(1,"%"+input+"%");
      		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	SearchStudentInfo student = new SearchStudentInfo();
		    	student.setStuid(rs.getString("stuid"));
	        	student.setAccount(rs.getString("account"));
	        	student.setClassname(rs.getString("classname"));
	        	student.setGradename(rs.getString("gradename"));
	        	student.setMajorname(rs.getString("majorname"));
	        	student.setCollegename(rs.getString("colname"));
	        	student.setName(rs.getString("stuname"));
	        	student.setGender(rs.getInt("gender"));
	        	student.setEmail(rs.getString("email"));
	        	student.setPhone(rs.getString("phone"));
	        	studentList.add(student);
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("搜索获取指定学生信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	  	
		return studentList;
	}
}
