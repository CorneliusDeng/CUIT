package 线程通信之生产与消费;

public class Consumer implements Runnable  
{
	 private Storage s;  
	 static int i = 1;
	 
	public Consumer(Storage s) 
	{
		super();
		this.s = s;
	}

	public void run() 
	{
		//while (true)
		//{
			 s.consume("消费者");
		//}
		
	 }
}
