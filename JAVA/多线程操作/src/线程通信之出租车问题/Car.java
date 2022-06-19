package 线程通信之出租车问题;

public class Car
{//乘客唤醒司机，司机开车
	private boolean isLoad;
	public synchronized void driver()
	{
		int i = 0;
		
		//没有乘客时，司机休息
		//司机线程调用wait()阻塞
		try 
		{
			wait();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		//有乘客坐车的过程
        while( i < 1000)
        {
        	i++; 
        }
		//到达目的地乘客下车
		i = 0;
		isLoad = false;
		//司机休息
		//司机线程调用wait()阻塞
		try 
		{
			wait();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	public synchronized void wakeup(String name)
	{
		//车上没有人时，才能向司机打招呼
		if(isLoad == false)
		{                           
			isLoad = true;
			notify();
			System.out.println("乘客:"+name+"上车");
		}
	}
}

