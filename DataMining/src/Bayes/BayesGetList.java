package Bayes;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BayesGetList")
/*Servlet，获取训练集数据，调用贝叶斯算法函数，向前端界面返回数据*/
public class BayesGetList extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //读训练集数据
        BayesDeal bd = new BayesDeal();
        File file = new File("D:\\AllSourceCode\\DataMining\\BayesData.txt");
        bd.ReadFile(file);
        //向前端界面返回训练集信息
        request.getSession().setAttribute("BayesDataList",bd.list);

        //读测试集数据
        String[] TestData = (String[])request.getSession().getAttribute("InputList");
        //只有用户在界面上选择了需要计算的属性组合，才计算分类结果，并向前端界面返回结果
        if (TestData != null && TestData.length > 0)
        {
            double[] result = bd.TrainBayes(TestData);
            request.getSession().setAttribute("Result",result);
            request.getSession().setAttribute("TestData",TestData);
        }

        //告知index界面当前需要加载的界面地址
        PrintWriter out = response.getWriter();
        out.println("<script>window.location='index.jsp?externalPage=BayesInterface.jsp';</script>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }
}
