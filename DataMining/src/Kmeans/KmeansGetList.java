package Kmeans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/KmeansGetList")
/*Servlet，获取训练集数据，调用K-Means聚类算法函数，向前端界面返回数据*/
public class KmeansGetList extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        KmeansDeal kmeans = new KmeansDeal();
        File file = new File("D:\\AllSourceCode\\DataMining\\K-meansData.csv");
        kmeans.ReadFile(file);

        KmeansBean bean1 = (KmeansBean) request.getSession().getAttribute("bean1");
        KmeansBean bean2 = (KmeansBean) request.getSession().getAttribute("bean2");
        KmeansBean bean3 = (KmeansBean) request.getSession().getAttribute("bean3");
        if (bean1 != null && bean2 != null && bean3 != null)
        {//前端返回的数据非空时再进行处理
            ArrayList<String> result = kmeans.KMeansCalculate(bean1, bean2, bean3);
            request.getSession().setAttribute("result",result);
        }

        //告知index界面当前需要加载的界面地址
        PrintWriter out = response.getWriter();
        out.println("<script>window.location='index.jsp?externalPage=KmeansInterface.jsp';</script>");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request,response);
    }
}
