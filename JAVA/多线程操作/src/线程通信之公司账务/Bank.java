package 线程通信之公司账务;

//线程同步就是若干个线程都需要使用一个synchronized修饰的方法，这样多个线程调用synchronized方法就必须遵守同步机制
//当一个线程使用这个方法时，其他线程想使用这个方法时就必须等待，直到线程A使用完该方法

public class Bank implements Runnable
{
	int money = 200;//本来存有两百万
	
	public void setMoney(int n)
	{
		money = n;
	}
	
	public void run()
	{
		if (Thread.currentThread().getName().equals("会计"))
		{
			saveOrTake(300);
		}
		else if (Thread.currentThread().getName().equals("出纳"))
		{
			saveOrTake(150);
		}
	}
	
	public synchronized void saveOrTake(int amount)//存取方法
	{
		if (Thread.currentThread().getName().equals("会计"))
		{
			for (int i = 1; i <= 3; i++)
			{
				money += amount / 3;  //每存入amount/3，稍微歇一会
				System.out.println(Thread.currentThread().getName() +
						"存入" + amount / 3 + ", 账上有"+ money + "万，休息一会再存");
				try				
				{
					Thread.sleep(1000);					//这个时候出纳仍不能使用saveOrTake方法
				}
				catch(InterruptedException e){}
			}
		}
		else if (Thread.currentThread().getName().equals("出纳"))
		{
			for (int i = 1; i <= 3; i++)
			{
				money -= amount / 3;  //每取出amount/3，稍微歇一会
				System.out.println(Thread.currentThread().getName() +
						"取出" + amount / 3 + ", 账上有"+ money + "万，休息一会再取");
			}
			try				
			{
				Thread.sleep(1000);					//这个时候会计扔不能使用saveOrTake方法
			}
			catch(InterruptedException e){}
		}
	}
}
