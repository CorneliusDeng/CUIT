package temporary;
import common.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TemporaryDB
{
    private Connection con = null;

    //获取所有待审核商品信息
    public ArrayList<TemporaryInfo> getAll()
    {
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<TemporaryInfo> TemcommodityList = new ArrayList<TemporaryInfo>();
        try
        {
            con= DBConnection.getConnection();
            sql=con.createStatement();
            rs=sql.executeQuery("SELECT * FROM td_temporary");
            while(rs.next())
            {
                TemporaryInfo temcommodity =new TemporaryInfo();
                temcommodity.setTem_id(rs.getString("tem_id"));
                temcommodity.setTem_name(rs.getString("tem_name"));
                temcommodity.setUser_id(rs.getString("tem_id"));
                temcommodity.setTem_description(rs.getString("tem_description"));
                temcommodity.setTem_money(rs.getString("tem_money"));
                temcommodity.setSort_id(rs.getInt("sort_id"));
                temcommodity.setTem_status(rs.getString("tem_status"));
                temcommodity.setTem_img1(rs.getString("tem_img1"));
                temcommodity.setTem_img2(rs.getString("tem_img2"));
                temcommodity.setTem_img3(rs.getString("tem_img3"));
                TemcommodityList.add(temcommodity);
            }
            rs.close();
            sql.close();
        }
        catch (Exception e)
        {
            System.out.println("获取所有暂存商品信息失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return TemcommodityList;
    }

    //通过指定暂存商品号查询某暂存商品的所有信息
    public TemporaryInfo getTemCommodityById(String id)
    {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        TemporaryInfo temcommodity = null;
        try
        {
            con = DBConnection.getConnection();
            pStmt = con.prepareStatement("SELECT * FROM td_temporary where tem_id=?");
            pStmt.setString(1,id);
            rs = pStmt.executeQuery();
            if(rs.next())
            {
                temcommodity = new TemporaryInfo();
                temcommodity.setTem_id(rs.getString("tem_id"));
                temcommodity.setTem_name(rs.getString("tem_name"));
                temcommodity.setUser_id(rs.getString("user_id"));
                temcommodity.setTem_description(rs.getString("tem_description"));
                temcommodity.setTem_money(rs.getString("tem_money"));
                temcommodity.setSort_id(rs.getInt("sort_id"));
                temcommodity.setTem_status(rs.getString("tem_status"));
                temcommodity.setTem_img1(rs.getString("tem_img1"));
                temcommodity.setTem_img2(rs.getString("tem_img2"));
                temcommodity.setTem_img3(rs.getString("tem_img3"));
            }
            rs.close();
            pStmt.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("获取指定暂存商品信息失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return temcommodity;
    }

    //通过暂存商品号号删除指定商品信息
    public int delete(String id)
    {
        PreparedStatement pStmt=null;
        int count=0;
        try
        {
            con=DBConnection.getConnection();
            pStmt = con.prepareStatement("delete from td_temporary where tem_id=?");
            pStmt.setString(1,id);
            count = pStmt.executeUpdate();
            pStmt.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("删除指定暂存商品失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return count;
    }

    //通过暂存商品号更新指定商品信息
    public String UpdategetTemCommodityById(String id)
    {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        TemporaryInfo temcommodity = null;
        try
        {
            con = DBConnection.getConnection();
            pStmt = con.prepareStatement("SELECT * FROM td_temporary where tem_id=?");
            pStmt.setString(1,id);
            rs = pStmt.executeQuery();
            if(rs.next())
            {
                temcommodity = new TemporaryInfo();
                temcommodity.setTem_id(rs.getString("tem_id"));
                temcommodity.setTem_name(rs.getString("tem_name"));
                temcommodity.setUser_id(rs.getString("user_id"));
                temcommodity.setTem_description(rs.getString("tem_description"));
                temcommodity.setTem_money(rs.getString("tem_money"));
                temcommodity.setSort_id(rs.getInt("sort_id"));
                temcommodity.setTem_status(rs.getString("tem_status"));
                temcommodity.setTem_img1(rs.getString("tem_img1"));
                temcommodity.setTem_img2(rs.getString("tem_img2"));
                temcommodity.setTem_img3(rs.getString("tem_img3"));
            }
            rs.close();
            pStmt.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("获取指定暂存商品信息失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        String json;
        json = "{\"temid\":\""+temcommodity.getTem_id()+"\", \"name\":\""+temcommodity.getTem_name()+"\", \"userid\":\""+temcommodity.getUser_id()+"\",\"description\":\""+temcommodity.getTem_description()+"\",\"money\":\""+temcommodity.getTem_money()+"\",\"sortid\":\""+temcommodity.getSort_id()+"\",\"status\":\""+temcommodity.getTem_status()+"\",\"img1\":\""+temcommodity.getTem_img1()+"\",\"img2\":\""+temcommodity.getTem_img2()+"\",\"img3\":\""+temcommodity.getTem_img3()+"\"}";
        return json;
    }
}
