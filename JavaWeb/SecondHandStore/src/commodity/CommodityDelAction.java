package commodity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CommodityDelAction")
public class CommodityDelAction extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CommodityDB commodityDB = new CommodityDB();
        String id = request.getParameter("commodityid");
        int count = commodityDB.delete(id);
        response.sendRedirect(request.getContextPath()+"/CommodityListAction");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request,response);
    }
}
