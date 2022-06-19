package UDFiles;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class UploadFile
{
    public static void main(String[] args)  throws Exception{
        Configuration conf = new Configuration();

        //指定使用HDFS文件系统
        conf.set("fs.defaultFS","hdfs://192.168.111.128:9000");
        //通过如下的方式进行客户端身份的设置
        System.setProperty("HADOOP_USER_NAME","master");
        //通过FileSystem的静态方法获取文件系统客户端对象
        FileSystem fs = FileSystem.get(conf);
        //上传一个文件testjava.txt
        fs.copyFromLocalFile(new Path("D:\\AllSourceCode\\JavaHadoop\\testjava.txt"),new Path("/input"));
        //关闭文件系统
        fs.close();
    }
}
