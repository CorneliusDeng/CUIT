package 第三个线程操作;

public class Example12_3 
{

	public static void main(String[] args) 
	{
		Home home = new Home();
		Thread showTime = new Thread(home);
		showTime.start();
		
		//因为垃圾实体没有被回收，所以三秒后悔同时出现两行相同的时间
	}

}
