package 读取线程中的值并打印_改进;

public class Counter extends Thread
{
	Storage s;

	public Counter(Storage s)
	{
		this.s = s;
	}
	public  void run()
	{
		for (int i = 1; i <= 5; i++)
		{
			s.setValue(s.value);
		}
	}
}
