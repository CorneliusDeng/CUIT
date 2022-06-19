package pluseg;

import java.sql.*;
import java.util.*;

public class AreaDB {
    private Connection con = null;
    private String realPath="";
    private String url="";
    /* 通过构造方法加载数据库驱动 */
	public AreaDB(String path){
		realPath=path;
        url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+realPath+"/db/area.mdb";
       	System.out.println("url="+url);
	    try { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    }catch(Exception e){
    		e.printStackTrace();
    		System.out.println("加载数据库驱动失败！");
	    }	
	}
    /* 创建数据库连接 */
    public void createCon() {
        try {
            con = DriverManager.getConnection(url, "", "");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取数据库连接失败！");
        }
    }
    /* 关闭数据库的操作 */
    public void closed() {
     	if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭con对象失败！");
			}
    }
    /* 获取行政区域信息 */
    public ArrayList<AreaInfo> getAreaes(int level,int parentId) {
        ResultSet rs=null;
    	PreparedStatement pStmt=null; 
        ArrayList<AreaInfo> list=new ArrayList<AreaInfo>();
        try {
        	createCon();
        	if(level==0){//获取省级行政区域列表
        		pStmt = con.prepareStatement("SELECT * FROM  t_area  where level=0");
        	}else{//获取非省级行政区域列表
        		pStmt = con.prepareStatement("SELECT * FROM  t_area  where level=? and parentID=? ");
        		pStmt.setInt(1,level);	
        		pStmt.setInt(2,parentId);	
        	}
    		rs = pStmt.executeQuery();
	    	while(rs.next()){
	    		AreaInfo area=new AreaInfo();
	    		area.setId(rs.getInt("id"));
	    		area.setArea(rs.getString("area"));
	    		area.setParentId(rs.getInt("parentID"));
	    		area.setLevel(rs.getInt("level"));
	    		list.add(area);
	    	} 
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("获取行政区域信息失败！");
        } finally{
			try {
				rs.close();
				pStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closed();
		}		
        return list;
    }
 
}

 
