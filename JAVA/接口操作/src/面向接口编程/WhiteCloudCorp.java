package 面向接口编程;

public class WhiteCloudCorp implements Advertisement
{

	@Override
	public void showAdvertisement() 
	{
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("飞机中的战斗机，哎yes！");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
	}

	@Override
	public String getCorpName() 
	{	
		return "白云有限公司";
	}
	
}
