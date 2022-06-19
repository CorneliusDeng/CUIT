package 第二个线程操作;

//Thread的构造方法是：Thread(Runnable target)
//使用了实现了Runnable接口的对象，一旦轮到它来享用CPU资源，目标对象在调用start()方法后会自动调用接口中的run()方法（接口回调）

public class Example12_2 
{

	public static void main(String[] args) 
	{
		House house = new House();
		
		house.setWater(10);
		
		Thread dog, cat;
		
		dog = new Thread(house);
		cat = new Thread(house);
		
		dog.start();
		cat.start();
	}

}
