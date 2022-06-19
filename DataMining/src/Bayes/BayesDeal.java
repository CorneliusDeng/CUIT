package Bayes;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BayesDeal
{
    public ArrayList<BayesBean> list = new ArrayList<BayesBean>();
    double data_length = 0.0;//计算训练集中记录的数量

    public BayesDeal(){

    }

    /*读取训练集文件信息，筛选并保存有效数据*/
    public void ReadFile(File file)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                //不读取第一行
                if (data_length != 0)
                {
                    //获取每一行的数据,以逗号为分割
                    String[] context = line.split(",");
                    //保留真正有效的数据，删除第一列的序号
                    String[] value = Arrays.copyOfRange(context,1, context.length);
                    Boolean flag = false;
                    if (value[6].trim().equals("是"))
                    {
                        flag = true;
                    }
                    BayesBean bean = new BayesBean(value[0], value[1], value[2], value[3], value[4], value[5], flag);
                    list.add(bean);

                }
                data_length++;
            }
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /*贝叶斯算法*/
    public double[] TrainBayes(String[] test)
    {
        double[] deal_true = new double[6];//计算在”好瓜“下各属性的频数
        double num_yes = 0.0;//训练集中好瓜的数量
        double yes = 1.0;//最终贝叶斯算出”好瓜“的概率
        double[] deal_false = new double[6];
        double num_no = 0.0;//训练集中坏瓜的数量
        double no = 1.0;//最终贝叶斯算出”坏瓜“的概率
        double[] result = new double[2];//传递的最终结果

        //遍历训练集
        for (int i = 0; i < list.size(); i++)
        {
            BayesBean bean = list.get(i);
            //在训练集判断为”好瓜“的条件下，计算测试集属性与该条训练集属性相同的数量
            if (bean.getResult() == true)
            {
                num_yes++;
                if (test[0].equals(bean.getColor()))
                {
                    deal_true[0] = deal_true[0] + 1;
                }
                if (test[1].equals(bean.getRoot()))
                {
                    deal_true[1] = deal_true[1] + 1;
                }
                if (test[2].equals(bean.getSound()))
                {
                    deal_true[2] = deal_true[2] + 1;
                }
                if (test[3].equals(bean.getVein()))
                {
                    deal_true[3] = deal_true[3] + 1;
                }
                if (test[4].equals(bean.getNavel()))
                {
                    deal_true[4] = deal_true[4] + 1;
                }
                if (test[5].equals(bean.getTouch()))
                {
                    deal_true[5] = deal_true[5] + 1;
                }
            }
            //在训练集判断为”坏瓜“的条件下，计算测试集属性与该条训练集属性相同的数量
            if (bean.getResult() == false)
            {
                num_no++;
                if (test[0].equals(bean.getColor()))
                {
                    deal_false[0] = deal_false[0] + 1;
                }
                if (test[1].equals(bean.getRoot()))
                {
                    deal_false[1] = deal_false[1] + 1;
                }
                if (test[2].equals(bean.getSound()))
                {
                    deal_false[2] = deal_false[2] + 1;
                }
                if (test[3].equals(bean.getVein()))
                {
                    deal_false[3] = deal_false[3] + 1;
                }
                if (test[4].equals(bean.getNavel()))
                {
                    deal_false[4] = deal_false[4] + 1;
                }
                if (test[5].equals(bean.getTouch()))
                {
                    deal_false[5] = deal_false[5] + 1;
                }
            }
        }
        for (int i = 0; i < deal_true.length; i++)
        {
            //计算条件概率，为了避免出现结果为0的异常，不计算属性计数为0的记录
            if (deal_true[i] != 0)
            {
                deal_true[i] = deal_true[i] / num_yes;
                yes = yes * deal_true[i];
            }

        }
        for (int i = 0; i < deal_false.length; i++)
        {
            //计算条件概率，为了避免出现结果为0的异常，不计算属性计数为0的记录
            if (deal_false[i] != 0)
            {
                deal_false[i] = deal_false[i] / num_no;
                no = no * deal_false[i];
            }
        }

        /*最终贝叶斯的结果*/
        //条件概率部分乘以该分类在样本中的概率，得到分子部分
        yes = yes * (num_yes / data_length);
        no = no * (num_no / data_length);
        //最终结果，分母为该属性组合下的全概率公式
        result[0] = yes / (yes + no); //好瓜概率
        result[1] = no / (yes + no);  //坏瓜概率

        return result;
    }
}
