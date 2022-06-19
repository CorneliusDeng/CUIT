package ch9;
//基于UDP的简单的Client/Server程序设计

import java.io.*;
import java.net.*;
import java.util.*;
public class QuoteClient {
	public static void main(String[] args) throws IOException{
		if(args.length!=1) {
			args=new String[]{"127.0.0.1"};
		}
		DatagramSocket socket=new DatagramSocket();
		//创建数据报套接字
		byte [] buf=new byte[512]; //创建缓冲区
		InetAddress address=InetAddress.getByName(args [0]);
		//由命令行给出的第一个参数默认为Server的名字，通过它得到Server的IP信息
		DatagramPacket packet=new DatagramPacket(buf, buf.length, address, 4445);
		//创建DatagramPacket对象
		socket.send(packet); //发送
		packet=new DatagramPacket(buf,buf.length);
		//创建新的DatagramPacket对象，用来接收数据报
		socket.receive(packet); //接收
		int len=packet.getLength();
		String received=new String(packet.getData(),0,len,"UTF-8");
		//根据接收到的字节数组生成相应的字符串
//		System.out.println("rec.length: "+len );
		System.out.println("Quote of the Moment:\n"+received );
		//打印生成的字符串
		socket.close(); //关闭套接口
	}
}
