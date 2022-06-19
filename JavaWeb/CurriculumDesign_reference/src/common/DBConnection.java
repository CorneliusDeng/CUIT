package common;
import java.sql.*;

public class DBConnection {
	static Connection con=null;
	
	public static Connection getConnection(){
		if(con==null){
			try { 
				Class.forName("com.mysql.cj.jdbc.Driver");
		    }catch(Exception e){ 
	    		e.printStackTrace();
	    		System.out.println("数据库连接失败！");
		    }
		    try { 
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_student?useSSL=false&serverTimezone=UTC","root","CorneliusDeng7");
		    }catch(Exception e){
	            e.printStackTrace();
	            System.out.println("数据库连接失败！");
		    }
		}
	    return con;
	}

	public static void closeConnection() {
     	if(con!=null)
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("数据库连接失败！");
			}
    }

}