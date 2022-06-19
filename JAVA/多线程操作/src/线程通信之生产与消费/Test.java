package 线程通信之生产与消费;

public abstract class Test 
{
	static Storage storage;
	
    public static void main(String[] args)
    {
        storage=new Storage();
        
        for(int i = 1; i < 6; i++)
        {
        	new Thread(new Producer(storage)).start();
        }
        
        for(int i = 1; i < 4; i++)
        {
            new Thread(new Consumer(storage)).start();
        }
    }
}

