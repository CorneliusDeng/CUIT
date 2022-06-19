package 吵醒线程;

//interrupt()方法可以吵醒休眠的线程，导致休眠的线程发生InterruptedException异常，从而结束休眠，重新排队等待CPU资源
//在实现Runnable接口的类的run()方法定义中可以使用Thread的静态方法public static Thread currentThread();获取当前线程的引用

public class Road implements Runnable
{
	Thread attachThread;
	public void setAttachThread(Thread t)
	{
		attachThread = t;
	}
	
	public void run()
	{
		String name = Thread.currentThread().getName();
		if (name.equals("司机"))
		{
			try
			{
				System.out.println("我是"+name+"在马路上停车");
				System.out.println("想睡上一个小时后再开车");
				Thread.sleep(1000*60*60);
			}
			catch (InterruptedException e)
			{
				System.out.println("被警察叫醒了");
			}
			System.out.println(name+"继续开车");
		}
		else if (name.equals("警察"))
		{
			for (int i = 1; i <= 3; i++)
			{
				System.out.println(name+"喊：开车！");
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException e)
				{
				
				}
			}
			attachThread.interrupt();//吵醒driver
		}
	}
}
