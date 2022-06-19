package commodity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CommodityListAction")
public class CommodityListAction extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CommodityDB commodityDB = new CommodityDB();
        request.getSession().setAttribute("commodityList",commodityDB.getAll());
        PrintWriter out = response.getWriter();
        out.println("<script>window.location='admin.jsp?externalPage=/SecondHandStore/Commodity/Commodity.jsp';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }
}
