<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*"%>
<jsp:useBean id="upFile" scope="page" class="com.jspsmart.upload.SmartUpload" />
<%
upFile.initialize(pageContext);
upFile.upload();
long size=upFile.getFiles().getSize(); 
System.out.println("�ļ���С��"+size);
if(size>2000000){
	out.println("<script>alert('���ϴ����ļ�̫�󣬲�������ϴ���');history.back(-1);</script>");
}else{
	String getFileName=upFile.getFiles().getFile(0).getFileName();
	String sql="INSERT INTO tb_file (name,fileSize) values('"+getFileName+"',"+size+")";
	
	String driverClass="sun.jdbc.odbc.JdbcOdbcDriver";
    String path=request.getRealPath("/bookEg/01/file.mdb");
    String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+path;
    Class.forName(driverClass);	 // �������ݿ�����
    Connection conn=DriverManager.getConnection(url, "", "");
    Statement stmt=conn.createStatement();
    stmt.executeUpdate(sql);
    stmt.close();
    conn.close();
	
	out.println("<script>alert('�ļ��ϴ��ɹ���');window.close();</script>");
	try{
		upFile.save("/bookEg/01/upload");
	}catch(Exception e){
		System.out.println("�ϴ��ļ����ִ���"+e.getMessage());
	}
}
%>