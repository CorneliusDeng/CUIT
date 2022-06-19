package 线程通信之出租车问题;

public class MotorMan extends Thread
{
	Car car;
	public MotorMan(Car car)
	{
		this.car = car;
	}
	public void run()
	{
		while(true)
		{
			car.driver();
		}
	}
}
