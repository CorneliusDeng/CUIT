package 吵醒线程;

public class Example12_4 
{

	public static void main(String[] args) 
	{
		Road road = new Road();
		Thread police, driver;
		
		police = new Thread(road);
		driver = new Thread(road);
		
		police.setName("警察");
		driver.setName("司机");
		
		road.setAttachThread(driver);
		driver.start();
		police.start();
	}

}
