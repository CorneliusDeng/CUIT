package Kmeans;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class KmeansDeal
{
    ArrayList<KmeansBean> data = new ArrayList<KmeansBean>(); //保存从文件中读取到的数据
    DecimalFormat df = new DecimalFormat("#.00"); //数据格式化

    //读文件，保存数据
    public void ReadFile(File file)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line = null;
            int data_length = 0; //训练集数据计数
            while ((line = br.readLine()) != null)
            {
                //不读取第一行
                if (data_length != 0)
                {
                    //获取每一行的数据,以逗号为分割
                    String[] context = line.split(",");
                    //将读取到的数据放到data中，不读ID
                    double r = Double.parseDouble(context[1]);//R-最近一次消费时间间隔
                    double f = Double.parseDouble(context[2]);//F-消费频率
                    double m = Double.parseDouble(context[3]);//M-消费总金额
                    KmeansBean bean = new KmeansBean(r, f, m);
                    data.add(bean);
                }
                data_length++;
            }
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("读取文件数据失败");
        }
    }

    //计算各点之间的欧氏距离
    public double distance(KmeansBean a, KmeansBean b)
    {
        double result = 0;
        result = Math.sqrt(Math.pow(a.getR()-b.getR(),2) + Math.pow(a.getF()-b.getF(),2) + Math.pow(a.getF()-b.getF(),2));
        return result;
    }

    public ArrayList<String> KMeansCalculate(KmeansBean bean1, KmeansBean bean2, KmeansBean bean3)
    {
        //最终结果
        ArrayList<String> RESULT = new ArrayList<String>();

        //中心点
        KmeansBean center1 = new KmeansBean();
        KmeansBean center2 = new KmeansBean();
        KmeansBean center3 = new KmeansBean();

        int cluster1 = 0; //第一簇的数目
        int cluster2 = 0; //第二簇的数目
        int cluster3 = 0; //第三簇的数目
        boolean flag = true; //迭代是否继续的标志
        int iteration = 0; //迭代次数

        //开始统计三类总人数
        while(flag)
        {
            iteration++;
            cluster1 = 0;
            cluster2 = 0;
            cluster3 = 0;

            //中心点1、2、3各属性的取值
            double cluster1_R = 0;
            double cluster1_F = 0;
            double cluster1_M = 0;
            double cluster2_R = 0;
            double cluster2_F = 0;
            double cluster2_M = 0;
            double cluster3_R = 0;
            double cluster3_F = 0;
            double cluster3_M = 0;
            //遍历的当前点到中心点1、2、3的距离
            double DistanceTo1 = 0;
            double DistanceTo2 = 0;
            double DistanceTo3 = 0;

            for(int i = 0; i < data.size(); i ++)
            {
                KmeansBean tempbean = data.get(i);
                //遍历计算获取的点到中心点的距离，第一次循环时中心点为用户输入
                DistanceTo1 = Double.parseDouble(df.format(distance(bean1, tempbean)));
                DistanceTo2 = Double.parseDouble(df.format(distance(bean2, tempbean)));
                DistanceTo3 = Double.parseDouble(df.format(distance(bean3, tempbean)));

                //比较当前点到中心点的距离
                if(DistanceTo1 <= DistanceTo2 && DistanceTo1 <= DistanceTo3)
                {//离中心点1最近
                    cluster1++;
                    cluster1_R += tempbean.getR();
                    cluster1_F += tempbean.getF();
                    cluster1_M += tempbean.getM();
                }
                if(DistanceTo2 < DistanceTo1 && DistanceTo2 <= DistanceTo3)
                {//离中心点2最近
                    cluster2++;
                    cluster2_R += tempbean.getR();
                    cluster2_F += tempbean.getF();
                    cluster2_M += tempbean.getM();
                }
                if(DistanceTo3 < DistanceTo1 && DistanceTo3 < DistanceTo2)
                {//离中心点3最近
                    cluster3++;
                    cluster3_R += tempbean.getR();
                    cluster3_F += tempbean.getF();
                    cluster3_M += tempbean.getM();
                }

            }

            //更新中心点的值
            //中心点1
            center1.setR(Double.parseDouble(df.format(cluster1_R/cluster1)));
            center1.setF(Double.parseDouble(df.format(cluster1_F/cluster1)));
            center1.setM(Double.parseDouble(df.format(cluster1_M/cluster1)));
            //中心点2
            center2.setR(Double.parseDouble(df.format(cluster2_R/cluster2)));
            center2.setF(Double.parseDouble(df.format(cluster2_F/cluster2)));
            center2.setM(Double.parseDouble(df.format(cluster2_M/cluster2)));
            //中心点3
            center3.setR(Double.parseDouble(df.format(cluster3_R/cluster3)));
            center3.setF(Double.parseDouble(df.format(cluster3_F/cluster3)));
            center3.setM(Double.parseDouble(df.format(cluster3_M/cluster3)));

            //中心点不再变化时，结束迭代
            if(
                    (bean1.getR() == center1.getR() && bean1.getF() == center1.getF() && bean1.getM() == center1.getM()) &&
                            (bean2.getR() == center2.getR() && bean2.getF() == center2.getF() && bean2.getM() == center2.getM()) &&
                            (bean3.getR() == center3.getR() && bean3.getF() == center3.getF() && bean3.getM() == center3.getM())
            )
            {
                flag = false;

            }

            //中心点更新
            bean1 = new KmeansBean(center1.getR(), center1.getF(), center1.getM());
            bean2 = new KmeansBean(center2.getR(), center2.getF(), center2.getM());
            bean3 = new KmeansBean(center3.getR(), center3.getF(), center3.getM());
        }

        //返回结果
        String RESULT1 = "第一簇样本数：" + cluster1 + "，第二簇样本数：" + cluster2 + "，第三簇样本数：" + cluster3;
        RESULT.add(RESULT1);
        String RESULT2 = "第一簇中心点：" + "\n" + bean1.toString();
        RESULT.add(RESULT2);
        String RESULT3 = "第二簇中心点：" + "\n" + bean2.toString();
        RESULT.add(RESULT3);
        String RESULT4 = "第三簇中心点：" + "\n" + bean3.toString();
        RESULT.add(RESULT4);
        String RESULT5 = iteration + "次迭代";
        RESULT.add(RESULT5);
        return RESULT;
    }
}
