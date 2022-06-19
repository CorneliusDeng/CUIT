
public class Counter implements Runnable {
    public static void main(String[] args) {
        Storage store = new Storage();
        new Counter(store);
        new Printer(store);
    }
    Storage storage;
    Counter(Storage s) {
        storage = s;
        new Thread(this).start();
    }
    public void run() {
        int i=0;
        while (true) {
            try {
				storage.setValue(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            i++;
        }
    }
}
class Printer implements Runnable {
    Storage storage;
    Printer(Storage s) {
        storage = s;
        new Thread(this).start();
    }
    public void run() {
        while (true) {
            try {
				System.out.println("printer:"+storage.getValue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
class Storage {
    int value;
    boolean canCounter=true;//鑳戒笉鑳界敓浜х殑鏍囪
    boolean canPrinter=false;//鑳戒笉鑳芥墦鍗扮殑鏍囪
    synchronized void setValue(int i) throws InterruptedException{
        while(!canCounter){//涓嶈兘鐢熶骇灏辩瓑
        	wait();
        }
        value = i;
        canCounter=false;
        canPrinter=true;
        notify();//鐢熶骇瀹屽氨鍞ら啋printer
    }
    synchronized int getValue() throws InterruptedException {
        while(!canPrinter){//涓嶈兘鎵撳嵃灏辩瓑
        	wait();
        }
        canCounter=true;
        canPrinter=false;
        notify();//鍞ら啋conter
        return value;
    }
}
