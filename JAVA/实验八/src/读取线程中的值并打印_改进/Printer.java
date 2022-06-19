package 读取线程中的值并打印_改进;

public class Printer extends Thread
{
	Storage s;

	public Printer(Storage s)
	{
		this.s = s;
	}
	public  void run()
	{
		for (int i = 1; i <= 5; i++)
		{
			s.getValue();
		}
	}
}
