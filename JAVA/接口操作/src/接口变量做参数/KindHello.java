package 接口变量做参数;

class KindHello 
{
	public void lookHello(SpeakHello hello)//接口类型参数
	{
		hello.speakHello();//接口回调
	}
}
