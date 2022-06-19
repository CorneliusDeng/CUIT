package temporary;

import commodity.CommodityDB;
import commodity.CommodityInfo;
import common.MyTools;
import common.MyTools.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CommodityInsertAction")
public class CommodityInsertAction extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CommodityInfo commodity = new CommodityInfo();
        commodity.setCom_id(request.getParameter("id"));
        commodity.setCom_name(request.getParameter("name"));
        commodity.setUser_id(request.getParameter("userid"));
        commodity.setCom_description(request.getParameter("description"));
        commodity.setCom_money(request.getParameter("money"));
        commodity.setSort_id(MyTools.strToint(request.getParameter("sortid")));
        commodity.setCom_status(request.getParameter("status"));
        commodity.setCom_img1(request.getParameter("com_img1"));
        commodity.setCom_img2(request.getParameter("com_img2"));
        commodity.setCom_img3(request.getParameter("com_img3"));
        CommodityDB commodityDB = new CommodityDB();
        commodityDB.insert(commodity);
        response.sendRedirect(request.getContextPath()+"/TemCommodityListAction");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
}
