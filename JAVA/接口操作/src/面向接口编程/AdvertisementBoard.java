package 面向接口编程;

public class AdvertisementBoard //负责创建广告牌
{
	public void show(Advertisement adver)
	{
		System.out.println(adver.getCorpName()+"的广告词如下：");
		adver.showAdvertisement();//接口回调
	}
}
