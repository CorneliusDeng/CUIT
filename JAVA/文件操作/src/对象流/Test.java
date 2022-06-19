package 对象流;
import java.io.*;

//对象的输入输出流的作用： 用于写入对象 的信息和读取对象的信息。 使得对象持久化

public class Test {

	public static void main(String[] args) 
	{
		TV changhong = new TV();
		changhong.setName("长虹电视");
		changhong.setPrice(5678);
		
		File file = new File("D:\\All SourceCode\\Javasourcecode\\文件操作\\src\\对象流\\television.txt");
		
		try
		{
			FileOutputStream fileOut = new FileOutputStream(file);//层层继承，其实没必要，直接使用“辈分”最小的类
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			//objectOut.writeObject(changhong);
			objectOut.close();
			
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			TV xinfei = new TV();//(TV)objectIn.readObject();
			//objectIn.close();
			
			xinfei.setName("新飞电视");
			xinfei.setPrice(6666);
			
			System.out.println("changhong的名字："+changhong.getName());
			System.out.println("changhong的价格："+changhong.getPrice());
			System.out.println("xinfei的名字："+xinfei.getName());
			System.out.println("xinfei的价格："+xinfei.getPrice());
		}
		/*catch(ClassNotFoundException evevt)
		{
			System.out.println("不能读出对象");
		}*/
		catch(IOException evevt)
		{
			System.out.println("event");
		}

	}

}
