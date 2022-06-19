package Bayes;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BayesGetAction")
/*Servlet，读前端界面输入的测试集数据，并返回给BayesGetList处理*/
public class BayesGetAction extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String[] InputResult = new String[6];

        if (request.getParameter("color").equals("1"))
        {
            InputResult[0] = "青绿";
        }
        if (request.getParameter("color").equals("2"))
        {
            InputResult[0] = "乌黑";
        }
        if (request.getParameter("color").equals("3"))
        {
            InputResult[0] = "浅白";
        }

        if (request.getParameter("root").equals("1"))
        {
            InputResult[1] = "蜷缩";
        }
        if (request.getParameter("root").equals("2"))
        {
            InputResult[1] = "稍蜷";
        }
        if (request.getParameter("root").equals("3"))
        {
            InputResult[1] = "硬挺";
        }

        if (request.getParameter("sound").equals("1"))
        {
            InputResult[2] = "浊响";
        }
        if (request.getParameter("sound").equals("2"))
        {
            InputResult[2] = "沉闷";
        }
        if (request.getParameter("sound").equals("3"))
        {
            InputResult[2] = "清脆";
        }

        if (request.getParameter("vein").equals("1"))
        {
            InputResult[3] = "清晰";
        }
        if (request.getParameter("vein").equals("2"))
        {
            InputResult[3] = "稍糊";
        }
        if (request.getParameter("vein").equals("3"))
        {
            InputResult[3] = "模糊";
        }

        if (request.getParameter("navel").equals("1"))
        {
            InputResult[4] = "凹陷";
        }
        if (request.getParameter("navel").equals("2"))
        {
            InputResult[4] = "稍凹";
        }
        if (request.getParameter("navel").equals("3"))
        {
            InputResult[4] = "平坦";
        }

        if (request.getParameter("touch").equals("1"))
        {
            InputResult[5] = "硬滑";
        }
        if (request.getParameter("touch").equals("2"))
        {
            InputResult[5] = "软粘";
        }

        request.getSession().setAttribute("InputList",InputResult);
        response.sendRedirect(request.getContextPath()+"/BayesGetList");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }
}