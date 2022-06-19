package temporary;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TemporaryDelAction")
public class TemporaryDelAction extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        TemporaryDB temporaryDB = new TemporaryDB();
        String id = request.getParameter("temcommodityid");
        int count = temporaryDB.delete(id);
        response.sendRedirect(request.getContextPath()+"/TemCommodityListAction");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request,response);
    }
}
