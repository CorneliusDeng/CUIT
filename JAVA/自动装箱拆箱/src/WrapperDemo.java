
public class WrapperDemo {

	public static void main(String[] args) 
	{
		// 将基本类型转换为包装器类对象
		Integer iobj = new Integer(10);
		// 将包装器类对象转换为基本类型
		int num = iobj.intValue();
		
		System.out.println(""+num);


	}

}
