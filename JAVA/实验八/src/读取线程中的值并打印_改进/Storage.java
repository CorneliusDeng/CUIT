package 读取线程中的值并打印_改进;

public class Storage 
{
	private boolean empty = true;
	public int value = 1;
	
	public synchronized void setValue(int data)
	{
		while(empty == true)
		{
			System.out.println("Counter写入:" + data);
			empty = false;
			notifyAll();//唤醒输出
		}
		value = data;
		try 
		{
			Thread.sleep(500);
			wait();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public synchronized void getValue()
	{
		while(empty == false)
		{
			System.out.println("Printer输出:" + value);
			value++;
			empty = true;
			notifyAll();//唤醒写入
		}
		try 
		{
			Thread.sleep(500);
			wait();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
