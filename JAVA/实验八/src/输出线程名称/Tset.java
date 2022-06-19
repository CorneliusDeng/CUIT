package 输出线程名称;

public class Tset 
{
	public static class sy6_1 extends Thread 
	{
		public void run()
		{
			for (int i = 1; i < 10; i++)
			{
				//Thread.currentThread().getName()是获取当前线程的名字，编号是从0开始的
				System.out.println("The thread name is:" + Thread.currentThread().getName());
			}
		}
	}
	public static void main(String[] args) 
	{
		sy6_1 thread1 = new sy6_1();
		thread1.setName("thread 1");
		thread1.start();
			
		sy6_1 thread2 = new sy6_1();
		thread2.setName("thread 2");
		thread2.start();
			
		sy6_1 thread3 = new sy6_1();
		thread3.setName("thread 3");
		thread3.start();
	}
}
