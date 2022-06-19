package Kmeans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/KmeansGetAction")
/*Servlet，读前端界面输入的初始化聚类中心数据，并返回给KmeansGetList处理*/
public class KmeansGetAction extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        KmeansBean bean1 = new KmeansBean();
        KmeansBean bean2 = new KmeansBean();
        KmeansBean bean3 = new KmeansBean();

        bean1.setR(Float.parseFloat(request.getParameter("c1_R")));
        bean1.setF(Float.parseFloat(request.getParameter("c1_F")));
        bean1.setM(Float.parseFloat(request.getParameter("c1_M")));

        bean2.setR(Float.parseFloat(request.getParameter("c2_R")));
        bean2.setF(Float.parseFloat(request.getParameter("c2_F")));
        bean2.setM(Float.parseFloat(request.getParameter("c2_M")));

        bean3.setR(Float.parseFloat(request.getParameter("c3_R")));
        bean3.setF(Float.parseFloat(request.getParameter("c3_F")));
        bean3.setM(Float.parseFloat(request.getParameter("c3_M")));


        //将得到的数据依次转发，此处不用一个ArrayList<KmensBean>统一转发，因为之后将无法强制转换一个非序列化的列表
        request.getSession().setAttribute("bean1",bean1);
        request.getSession().setAttribute("bean2",bean2);
        request.getSession().setAttribute("bean3",bean3);
        response.sendRedirect(request.getContextPath()+"/KmeansGetList");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request,response);
    }
}
