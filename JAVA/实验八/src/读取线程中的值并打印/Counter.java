package 读取线程中的值并打印;

public class Counter extends Thread
{
	Storage s;

	public Counter(Storage s)
	{
		this.s = s;
	}
	public void run()
	{
		System.out.println("Counter开始运行");
		for (int i = 0; i < 5; i++)
		{
			System.out.println("Counter写入:"+(i));
			try 
			{
				s.setNum(i);
				Thread.sleep(500);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println("Counter线程结束运行");
	}
}
