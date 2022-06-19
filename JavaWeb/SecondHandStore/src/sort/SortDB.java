package sort;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import common.DBConnection;

public class SortDB
{
    private Connection con = null;

    //通过指定类别编号查询类别的所有信息
    public SortInfo getSortById(int id)
    {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        SortInfo sort = null;
        try
        {
            con = DBConnection.getConnection();
            pStmt = con.prepareStatement("SELECT * FROM td_sort where sort_id=?");
            pStmt.setInt(1,id);
            rs = pStmt.executeQuery();
            if(rs.next())
            {
                sort = new SortInfo();
                sort.setSort_id(rs.getInt("sort_id"));
                sort.setSort_name(rs.getString("sort_name"));
            }
            rs.close();
            pStmt.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("获取指定类别信息失败！");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return sort;
    }
}
