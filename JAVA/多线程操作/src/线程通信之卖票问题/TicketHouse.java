package 线程通信之卖票问题;

/*调用某个对象的wait()方法，相当于让当前线程交出此对象的monitor（锁），然后进入等待状态，
 * 等待后续再次获得此对象的锁（Thread类中的sleep方法使当前线程暂停执行一段时间，从而让其他线程有机会继续执行，但它并不释放对象锁）；
 * 
	notify()方法能够唤醒一个正在等待该对象的monitor的线程，当有多个线程都在等待该对象的monitor的话，
	则只能唤醒其中一个线程，具体唤醒哪个线程则不得而知。

	调用某个对象的notify()方法，当前线程也必须拥有这个对象的monitor，
	因此调用notify()方法必须在同步块或者同步方法中进行（synchronized块或者synchronized方法）。

	nofityAll()方法能够唤醒所有正在等待该对象的monitor的线程，这一点与notify()方法是不同的。
	
	这里要注意一点：notify()和notifyAll()方法只是唤醒等待该对象的monitor的线程，并不决定哪个线程能够获取到monitor。*/


public class TicketHouse implements Runnable
{
	int fiveAmount = 2, tenAmount = 0, twentyAmount = 0;
	
	public void run()
	{
		if (Thread.currentThread().getName().equals("张飞"))
		{
			saleTicket(20);
		}
		else if (Thread.currentThread().getName().equals("李逵"))
		{
			saleTicket(5);
		}
	}
	
	private synchronized void saleTicket(int money)
	{
		if (money == 5)//如果使用该方法的线程传递的参数是5，就不用了等待
		{
			fiveAmount += 1;
			System.out.println("给"+Thread.currentThread().getName()+"入场券，"
					+Thread.currentThread().getName()+"的钱正好");
		}
		else if (money == 20)
		{
			while (fiveAmount < 3)
			{
				try
				{
					System.out.println("\n"+Thread.currentThread().getName()+"靠边等。。。。");
					wait();
					System.out.println("\n"+Thread.currentThread().getName()+"继续买票");
				}
				catch(InterruptedException e)
				{
					
				}
			}
			fiveAmount -= 3;
			twentyAmount += 1;
			System.out.println("给"+Thread.currentThread().getName()+"入场券,"
					+Thread.currentThread().getName()+"给20.找15元");
		}
		notifyAll();
	}
}
