package common;
import java.sql.*;

public class DBConnection {
	static Connection con=null;
	/**��ȡ���ݿ�����*/
	public static Connection getConnection(){
		if(con==null){
			try { //������������
				Class.forName("com.mysql.jdbc.Driver");
		    }catch(Exception e){ 
	    		e.printStackTrace();
	    		System.out.println("����MYSQL���ݿ�����ʧ�ܣ�");
		    }
		    try { //ͨ�����������������ȡ���ݿ�����
		    	//mysql�������ַ���û�����ã�����û�����úõĻ���Ĭ����latin1
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_student?useUnicode=true&characterEncoding=UTF-8","root","rootpassword");
		    }catch(Exception e){
	            e.printStackTrace();
	            System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
		    }
		}
	    return con;
	}
    /** �ر����ݿ�Ĳ��� */
    public static void closeConnection() {
     	if(con!=null)
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�ر�con����ʧ�ܣ�");
			}
    }

}