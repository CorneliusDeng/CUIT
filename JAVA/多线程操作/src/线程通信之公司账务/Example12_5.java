package 线程通信之公司账务;

//线程同步目的是解决共享资源冲突问题
//对于大多数的程序而言，他们都需要线程之间相互的通讯来完成整个线程的生命周期，
//而实现线程之间同步的最简单的办法就是上锁。为了防止相互关联的两个线程之间错误地访问共享资源，
//线程需要在访问资源的时候上锁和解锁，对于锁而言，有读锁，写锁和读写锁等不同的同步策略。


public class Example12_5 
{

	public static void main(String[] args) 
	{
		Bank bank = new Bank();
		bank.setMoney(200);  //一开始公司的账内有200万
		
		Thread accountant, cashier;
		accountant = new Thread(bank);
		cashier = new Thread(bank);
		
		accountant.setName("会计");
		cashier.setName("出纳");
		
		accountant.start();
		cashier.start();
	}

}
