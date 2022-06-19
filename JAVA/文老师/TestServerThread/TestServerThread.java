package ch9;

import java.net.*;
import java.io.*;
public class TestServerThread{
	static ServerSocket ss;
	public static void main(String args[]){
	   server();
	}
	public static void server(){
		try{
			System.out.println("server starting...");
			ss=new ServerSocket(6000);
			Socket s;
			while(true){
				s=ss.accept();
				new serverThread(s).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class serverThread extends Thread{
	Socket s;
	public serverThread(Socket s){
		this.s=s;
	}
	public void run(){
		try{
			OutputStream os=s.getOutputStream();
    		os.write("Hello,welcome to server!".getBytes());
    		InputStream is=s.getInputStream();
    		byte [] buf=new byte[100];
    		int len=is.read(buf);
    		System.out.println(new String(buf,0,len));
    		os.close();
    		is.close();
    		s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}