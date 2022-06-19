package 第一个线程操作;

public class SpeakElephant extends Thread
{
	public void run()
	{
		for (int i = 1; i <= 20; i++)
		{
			System.out.print("大象"+i);
			System.out.println("");
		}
	}
}
