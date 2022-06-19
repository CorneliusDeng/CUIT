package 第二个线程操作;

public class House implements Runnable
{
	int waterAmount;  //模拟储水量
	
	public void setWater(int w)
	{
		waterAmount = w;
	}
	
	public void run() 
	{
		int m = 1;
		while(true)
		{
			if (waterAmount <= 0)
			{
				return;
			}
			
			waterAmount -= m;
			System.out.println("剩"+waterAmount+"克");
			try
			{
				Thread.sleep(2000);//2000毫秒  //sleep()方法并不释放对象锁，即使有synchronized同步块，其他线程仍然不会访问共享数据
			}
			catch(InterruptedException e)
			{
				System.out.println("程序在睡眠时被打断");
			}
		}
	}
	
}
