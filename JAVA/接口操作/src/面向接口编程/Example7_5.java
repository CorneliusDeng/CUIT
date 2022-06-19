package 面向接口编程;

public class Example7_5 
{

	public static void main(String[] args) 
	{
		AdvertisementBoard board = new AdvertisementBoard();
		
		board.show(new BlackLandCorp());
		board.show(new WhiteCloudCorp());

	}

}
