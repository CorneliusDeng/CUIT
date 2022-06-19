package Apriori;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/AprioriGetList")
/*Servlet，获取训练集数据，调用Apriori算法函数，向前端界面返回数据*/
public class AprioriGetList extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        File file = new File("D:\\AllSourceCode\\DataMining\\AprioriData.txt");
        AprioriDeal apriori = new AprioriDeal();
        ArrayList<ArrayList<String>> TrainData = apriori.ReadFile(file);
        //向前端界面返回训练集信息
        request.getSession().setAttribute("AprioriDataList", TrainData);

        //读前端输入的最小支持度、置信度数据
        float[] InputData = (float[]) request.getSession().getAttribute("InputResult");
        //只有用户在界面上输入了数据，才开始分析关联规则，并向前端界面返回结果
        if (InputData != null && InputData.length > 0)
        {
            HashMap<ArrayList<String>, Integer> MaxL = new HashMap<ArrayList<String>, Integer>();// 最大频繁项集
            ArrayList<String> RulesResult = new ArrayList<String>(); //关联规则结果集

            //最小支持度、置信度赋值
            apriori.min_support = InputData[0];
            apriori.min_confident = InputData[1];
            apriori.init(file);//初始化事务集Data，项目集C，候选集L
            MaxL = apriori.IterationResult(apriori.C, apriori.L);//计算最大频繁项集
            RulesResult = apriori.TerminalCalculate();//计算关联规则

            //向前端界面返回数据
            request.getSession().setAttribute("MaxL",MaxL);
            request.getSession().setAttribute("RulesResult",RulesResult);
            request.getSession().setAttribute("InputData",InputData);
        }

        //告知index界面当前需要加载的界面地址
        PrintWriter out = response.getWriter();
        out.println("<script>window.location='index.jsp?externalPage=AprioriInterface.jsp';</script>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request,response);
    }
}
