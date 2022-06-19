package temporary;

import temporary.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TemCommodityListAction")
public class TemCommodityListAction extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        TemporaryDB temporaryDB = new TemporaryDB();
        request.getSession().setAttribute("TemcommodityList",temporaryDB.getAll());
        PrintWriter out = response.getWriter();
        out.println("<script>window.location='admin.jsp?externalPage=/SecondHandStore/PublishReview/Publish_Review.jsp';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }
}
