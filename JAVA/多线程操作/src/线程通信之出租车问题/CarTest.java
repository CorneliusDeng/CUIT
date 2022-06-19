package 线程通信之出租车问题;

public class CarTest 
{

	public static void main(String[] args) 
	{
		Car car = new Car();
	    MotorMan mm = new MotorMan(car);
	    Consumer cons1=new Consumer(car,"乘客1");
	    Consumer cons2=new Consumer(car,"乘客2");
	    Consumer cons3=new Consumer(car,"乘客3");
	    Consumer cons4=new Consumer(car,"乘客4");
	    Consumer cons5=new Consumer(car,"乘客5");
	    mm.start();
	    cons1.start();
	    cons2.start();
	    cons3.start();
	    cons4.start();
	    cons5.start();
	}

}
