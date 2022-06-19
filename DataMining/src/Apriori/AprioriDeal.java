package Apriori;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

// Apriori算法实现
public class AprioriDeal
{
    float min_support; //最小支持度，为了避免浮点数精度问题，取整数
    float min_confident; //最小置信度
    DecimalFormat df = new DecimalFormat("#.00");//置信度百分化格式输出
    ArrayList<ArrayList<String>> Data = new ArrayList<ArrayList<String>>(); //事务集Data
    HashMap<ArrayList<String>, Integer> C = new HashMap<ArrayList<String>, Integer>(); //项目集C
    HashMap<ArrayList<String>, Integer> L = new HashMap<ArrayList<String>, Integer>(); //频繁集L
    HashMap<ArrayList<String>, Integer> L_FRE = new HashMap<ArrayList<String>, Integer>(); //存放所有的频繁项集

    // 读取训练集信息，返回事务集
    public ArrayList<ArrayList<String>> ReadFile(File file)
    {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> temp = null;
        int data_length = 0; //事务集计数,主要用处是读数据时不取首行标题
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                //不读取第一行
                if (data_length != 0)
                {
                    temp = new ArrayList<String>();
                    // 获取每一行的数据,先以\t为分割切成两部分
                    String[] context = line.split("\t");
                    // 只处理第二部分数据，以逗号为分割符，获取真正的数据
                    String[] value = context[1].split(",");
                    // 逐项获取处理后的每行数据，将它们组合成为一个list
                    for(int i = 0; i < value.length ; i++)
                    {
                        temp.add(value[i]);
                    }
                    result.add(temp);
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
        return result;
    }

    // 剪枝步：从候选集C中删除小于最小支持度的事务，并放入频繁集L中
    public void Pruning(HashMap<ArrayList<String>, Integer> C, HashMap<ArrayList<String>, Integer> L)
    {
        L.clear(); //先删除频繁集L中的所有映射
        L.putAll(C); //先把候选集中的所有键值对插入到频繁集L中
        // 删除小于最小支持度的映射,其中“支持度=元素在事务集中出现的次数➗事务集中的事务数”，此处取频数不取概率
        ArrayList<ArrayList<String>> delete_key = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> key : L.keySet())
        {
            if ( L.get(key) < min_support)
            {
                delete_key.add(key);
            }
        }
        for (int i = 0; i < delete_key.size(); i++)
        {
            L.remove(delete_key.get(i));
        }
    }

    // 初始化事务集Data，项目集C，频繁集L
    public void init(File file)
    {
        // 初始化事务集Data
        Data = ReadFile(file);
        // 扫描事务集Data，生成项目集C，
        for (int i = 0; i < Data.size(); i++)
        {//先取到一条事务
            for (int j = 0; j < Data.get(i).size(); j++)
            {//再遍历取到的事务中的所有元素
                String[] temp = { Data.get(i).get(j) }; //把取到的元素生成一个字符串数组
                ArrayList<String> item = new ArrayList<String>(Arrays.asList(temp)); //将数组temp转化为List
                //判断项目集C中是否包含指定的键
                if (!C.containsKey(item))
                {
                    C.put(item, 1);
                }
                else
                {
                    C.put(item, C.get(item) + 1);
                }
            }
        }
        Pruning(C, L); // 剪枝
        L_FRE.putAll(L); // 整合频繁项集
    }

    // 两个候选集求并集
    public ArrayList<String> ListUnion(ArrayList<String> arraylist1, ArrayList<String> arraylist2)
    {
        ArrayList<String> listunion = new ArrayList<String>();
        listunion.addAll(arraylist1);
        listunion.addAll(arraylist2);
        //将ArrayList转化为HashSet去掉重复元素，再将HashSet转换为ArrayList
        listunion = new ArrayList<String>(new HashSet<String>(listunion));
        return listunion;
    }

    // 迭代出最大频繁集，参数为完成了初始化的项目集、频繁集，返回最大频繁集
    public HashMap<ArrayList<String>, Integer> IterationResult
    (HashMap<ArrayList<String>, Integer> C,HashMap<ArrayList<String>, Integer> L)
    {
        // 用于判断是否结束剪枝的临时变量
        HashMap<ArrayList<String>, Integer> L_temp = new HashMap<ArrayList<String>, Integer>();
        String str = null;
        int t = 1;// 迭代次数
        while (L.size() > 0)
        {// 一旦被剪枝后剪干净，剪枝之前则是最终要求的结果。
            t++;
            L_temp.clear();
            L_temp.putAll(L);
            // 一、连接步
            C.clear();
            // 1.将L中的项以一定的规则两两匹配
            ArrayList<ArrayList<String>> L_key = new ArrayList<ArrayList<String>>(L.keySet());
            for (int i = 0; i < L_key.size(); i++)
            {
                for (int j = i + 1; j < L_key.size(); j++)
                {
                    ArrayList<String> C_item = new ArrayList<String>(ListUnion(L_key.get(i), L_key.get(j)));
                    if (C_item.size() == t)
                    {
                        C.put(C_item, 0);// 频繁项集的所有非空子集都必须是频繁的
                    }
                }
            }
            // 2.通过扫描Data，计算此项的支持度
            for (ArrayList<String> key : C.keySet())
            {
                for (int i = 0; i < Data.size(); i++)
                {
                    if (Data.get(i).containsAll(key))
                    {
                        C.put(key, C.get(key) + 1 );
                    }
                }
            }
            // 二、剪枝步
            Pruning(C, L);
            L_FRE.putAll(L);
        }
        return L_temp;
    }

    // 求一个集合的所有子集
    public ArrayList<ArrayList<String>> ListSubset(ArrayList<String> L)
    {
        if (L.size() > 0)
        {
            ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
            for (int i = 0; i < Math.pow(2, L.size()); i++)
            {// 集合子集个数=2的该集合长度的次方的幂
                ArrayList<String> subSet = new ArrayList<String>();
                int index = i;
                for (int j = 0; j < L.size(); j++)
                {
                    // 通过逐一位移，判断索引那一位是1，如果是，再添加此项
                    if ((index & 1) == 1)
                    {// 位与运算，判断最后一位是否为1
                        subSet.add(L.get(j));
                    }
                    index >>= 1;// 索引右移一位
                }
                result.add(subSet); // 把子集存储起来
            }
            return result;
        }
        else
        {
            return null;
        }
    }

    // 判断两个集合相交是否为空
    public boolean IntersectionIsNull(ArrayList<String> l1, ArrayList<String> l2)
    {
        Set<String> s1 = new HashSet<String>(l1);
        Set<String> s2 = new HashSet<String>(l2);
        s1.retainAll(s2);
        if (s1.size() > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    //根据最大频繁集，计算出满足最小置信度的各个关联事件
    public ArrayList<String> TerminalCalculate()
    {
        ArrayList<String> RulesResult = new ArrayList<String>();//返回关联规则结果集
        int k = 0; //用于关联规则结果集下标计数
        for (ArrayList<String> key : L_FRE.keySet())
        {// 对最大频繁集各个事件进行判断
            ArrayList<ArrayList<String>> key_allSubset = ListSubset(key);
            // 获取所有频繁集中每个集合的子集
            for (int i = 0; i < key_allSubset.size(); i++)
            {
                ArrayList<String> item_pre = key_allSubset.get(i);//得到一个真子集
                if (0 < item_pre.size() && item_pre.size() < key.size())
                {// 判断是否是非空真子集
                    // 各个非空互补真子集之间形成关联事件
                    double item_pre_support = L_FRE.get(item_pre);//得到真子集的支持度度
                    for (int j = 0; j < key_allSubset.size(); j++)
                    {
                        ArrayList<String> item_post = key_allSubset.get(j);
                        if (0 < item_post.size()
                                && item_post.size() < key.size()
                                && ListUnion(item_pre, item_post).equals(key)
                                && IntersectionIsNull(item_pre, item_post))
                        //不相交的两个非空真子集，相并为频繁项集
                        {
                            double d = L_FRE.get(ListUnion(item_pre, item_post));
                            double confident = d / item_pre_support; // 事件的置信度
                            if (confident > min_confident)
                            {// 如果事件的置信度大于最小置信度, 就把它加入到结果集内
                                String result = item_pre + "==>" + item_post + " ：置信度=" + df.format(confident*100) + "%";
                                RulesResult.add(result);
                            }
                        }
                    }
                }
            }
        }
        return RulesResult;
    }
}