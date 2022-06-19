package temporary;

import commodity.CommodityDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "CommodityGetAction")
public class TemCommodityGetAction extends HttpServlet
{
    private TemporaryDB temporaryDB = new TemporaryDB();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String temcommodityid = request.getParameter("temcommodityid");
        String json = temporaryDB.UpdategetTemCommodityById(temcommodityid);
        System.out.println(json);
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(json);
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
}
