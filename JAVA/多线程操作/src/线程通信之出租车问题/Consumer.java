package 线程通信之出租车问题;

public class Consumer extends Thread
{
	Car car;
	String name;
	public Consumer(Car car, String name)
	{
		this.name=name;
		this.car=car;
	}
	public void run()
	{
		car.wakeup(name);//乘客唤醒司机
	}

}
