package 线程通信之卖票问题;

public class Example12_6 
{

	public static void main(String[] args) 
	{
		TicketHouse officer = new TicketHouse();
		
		Thread zhangfei, likui;
		
		zhangfei = new Thread(officer);
		likui = new Thread(officer);
		
		zhangfei.setName("张飞");
		likui.setName("李逵");
		
		zhangfei.start();
		likui.start();
	}

}
