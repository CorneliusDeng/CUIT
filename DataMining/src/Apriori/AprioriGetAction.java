package Apriori;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AprioriGetAction")
/*Servlet，读前端界面输入的最小支持度、置信度数据，并返回给AprioriGetList处理*/
public class AprioriGetAction extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        float[] InputResult = new float[2];
        InputResult[0] = Float.parseFloat(request.getParameter("min_support"));
        InputResult[1] = Float.parseFloat(request.getParameter("min_confidence"));
        request.getSession().setAttribute("InputResult", InputResult);
        response.sendRedirect(request.getContextPath()+"/AprioriGetList");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request,response);
    }
}
