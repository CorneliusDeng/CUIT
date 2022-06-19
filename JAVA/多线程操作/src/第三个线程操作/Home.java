package 第三个线程操作;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Home implements Runnable
{
	int time = 0;
	SimpleDateFormat m = new SimpleDateFormat("hh:mm:ss");
	Date date;
	
	public void run()
	{
		while (true)
		{
			date = new Date();
			System.out.println(m.format(date));
			time++;
			
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e) 
			{
				System.out.println("程序在睡眠时被打断");
			}
			
			if (time == 3)//三秒之后线程又被分配了实体，新实体又开始运行。之前的实体变成垃圾，JVM认为它仍在运行，不会回收它
			{
				Thread thread = Thread.currentThread();
				thread = new Thread(this);
				thread.start();
			}
		}
	}
}
