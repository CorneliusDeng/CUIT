package com.hadoop.hdfs.JavaApi.test2;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HDFSApp hd=new HDFSApp();
		try {
			hd.setUp();
			hd.mkdir();
			hd.create();
			//hd.copyFromLocalFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
