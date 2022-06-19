package 线程通信之生产与消费;

public class Producer implements Runnable 
{
	 private Storage s;  
	 static int i = 1;
	 
	 public Producer(Storage s) {
		super();
		this.s = s;
	}

	public void run() 
	{
		//while (true)
		//{
			s.produce("生产者");
			
		//}
		 
	 }
}
