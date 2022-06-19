package commodity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import common.DBConnection;

public class CommodityDB
{
    private Connection con = null;

    //获取所有商品信息
    public ArrayList<CommodityInfo> getAll()
    {
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<CommodityInfo> commodityList = new ArrayList<CommodityInfo>();
        try
        {
            con=DBConnection.getConnection();
            sql=con.createStatement();
            rs=sql.executeQuery("SELECT * FROM td_commodity");
            while(rs.next())
            {
                CommodityInfo commodity =new CommodityInfo();
                commodity.setCom_id(rs.getString("com_id"));
                commodity.setCom_name(rs.getString("com_name"));
                commodity.setUser_id(rs.getString("user_id"));
                commodity.setCom_description(rs.getString("com_description"));
                commodity.setCom_money(rs.getString("com_money"));
                commodity.setSort_id(rs.getInt("sort_id"));
                commodity.setCom_status(rs.getString("com_status"));
                commodity.setCom_img1(rs.getString("com_img1"));
                commodity.setCom_img2(rs.getString("com_img2"));
                commodity.setCom_img3(rs.getString("com_img3"));
                commodity.setCom_time(rs.getString("com_time"));
                commodityList.add(commodity);
            }
            rs.close();
            sql.close();
        }
        catch (Exception e)
        {
            System.out.println("获取所有商品信息失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return commodityList;
    }

    //添加商品信息
    public int insert(CommodityInfo commodity)
    {
        PreparedStatement pStmt = null;
        int count = 0;
        try
        {
            con = DBConnection.getConnection();
            String sql = "insert into td_commodity (com_id,com_name,user_id,com_description,com_money,sort_id,com_status,com_img1,com_img2,com_img3,com_time) values (?,?,?,?,?,?,?,?,?,?,?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setString(1,commodity.getCom_id());
            pStmt.setString(2,commodity.getCom_name());
            pStmt.setString(3,commodity.getUser_id());
            pStmt.setString(4,commodity.getCom_description());
            pStmt.setString(5,commodity.getCom_money());
            pStmt.setInt(6,commodity.getSort_id());
            pStmt.setString(7,commodity.getCom_status());
            pStmt.setString(8,commodity.getCom_img1());
            pStmt.setString(9,commodity.getCom_img2());
            pStmt.setString(10,commodity.getCom_img3());
            pStmt.setString(11,commodity.getCom_time());

            count = pStmt.executeUpdate();
            pStmt.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("添加商品失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return count;
    }

    //更新商品信息各项内容
    public int update(CommodityInfo commodity)
    {
        PreparedStatement pStmt = null;
        int count = 0;
        try
        {
            con = DBConnection.getConnection();
            String sql = "update td_commodity set com_name=?,user_id=?,com_description=?,com_money=?,sort_id=?,com_status=?,com_img1=?,com_img2=?,com_img3=?,com_time=? where com_id = ?";
            pStmt = con.prepareStatement(sql);

            pStmt.setString(1,commodity.getCom_name());
            pStmt.setString(2,commodity.getUser_id());
            pStmt.setString(3,commodity.getCom_description());
            pStmt.setString(4,commodity.getCom_money());
            pStmt.setInt(5,commodity.getSort_id());
            pStmt.setString(6,commodity.getCom_status());
            pStmt.setString(7,commodity.getCom_img1());
            pStmt.setString(8,commodity.getCom_img2());
            pStmt.setString(9,commodity.getCom_img3());
            pStmt.setString(10,commodity.getCom_time());
            pStmt.setString(11,commodity.getCom_id());

            count = pStmt.executeUpdate();
            pStmt.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("修改指定商品信息失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return count;
    }

    //通过指定商品号查询某商品的所有信息
    public CommodityInfo getCommodityById(String id)
    {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        CommodityInfo commodity = null;
        try
        {
            con = DBConnection.getConnection();
            pStmt = con.prepareStatement("SELECT * FROM td_commodity where com_id=?");
            pStmt.setString(1,id);
            rs = pStmt.executeQuery();
            if(rs.next())
            {
                commodity = new CommodityInfo();
                commodity.setCom_id(rs.getString("com_id"));
                commodity.setCom_name(rs.getString("com_name"));
                commodity.setUser_id(rs.getString("user_id"));
                commodity.setCom_description(rs.getString("com_description"));
                commodity.setCom_money(rs.getString("com_money"));
                commodity.setSort_id(rs.getInt("sort_id"));
                commodity.setCom_status(rs.getString("com_status"));
                commodity.setCom_img1(rs.getString("com_img1"));
                commodity.setCom_img2(rs.getString("com_img2"));
                commodity.setCom_img3(rs.getString("com_img3"));
                commodity.setCom_time(rs.getString("com_time"));
            }
            rs.close();
            pStmt.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("获取指定商品信息失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return commodity;
    }

    //通过商品号号删除指定商品信息
    public int delete(String id)
    {
        PreparedStatement pStmt=null;
        int count=0;
        try
        {
            con=DBConnection.getConnection();
            pStmt = con.prepareStatement("delete from td_commodity where com_id=?");
            pStmt.setString(1,id);
            count = pStmt.executeUpdate();
            pStmt.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("删除指定商品失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return count;
    }

    //通过商品号更新指定商品信息
    public String UpdategetCommodityById(String id)
    {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        CommodityInfo commodity = null;
        try
        {
            con = DBConnection.getConnection();
            pStmt = con.prepareStatement("SELECT * FROM td_commodity where com_id=?");
            pStmt.setString(1,id);
            rs = pStmt.executeQuery();
            if(rs.next())
            {
                commodity = new CommodityInfo();
                commodity.setCom_id(rs.getString("com_id"));
                commodity.setCom_name(rs.getString("com_name"));
                commodity.setUser_id(rs.getString("user_id"));
                commodity.setCom_description(rs.getString("com_description"));
                commodity.setCom_money(rs.getString("com_money"));
                commodity.setSort_id(rs.getInt("sort_id"));
                commodity.setCom_status(rs.getString("com_status"));
                commodity.setCom_img1(rs.getString("com_img1"));
                commodity.setCom_img2(rs.getString("com_img2"));
                commodity.setCom_img3(rs.getString("com_img3"));
                commodity.setCom_time(rs.getString("com_time"));
            }
            rs.close();
            pStmt.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("获取指定商品信息失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        String json;
        json = "{\"comid\":\""+commodity.getCom_id()+"\", \"name\":\""+commodity.getCom_name()+"\", \"userid\":\""+commodity.getUser_id()+"\",\"description\":\""+commodity.getCom_description()+"\",\"money\":\""+commodity.getCom_money()+"\",\"sortid\":\""+commodity.getSort_id()+"\",\"status\":\""+commodity.getCom_status()+"\",\"img1\":\""+commodity.getCom_img1()+"\",\"img2\":\""+commodity.getCom_img2()+"\",\"img3\":\""+commodity.getCom_img3()+"\",\"time\":\""+commodity.getCom_time()+"\"}";
        return json;
    }
}
