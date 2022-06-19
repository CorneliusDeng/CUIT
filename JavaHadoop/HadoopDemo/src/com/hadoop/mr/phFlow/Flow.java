package com.hadoop.mr.phFlow;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
public class Flow  implements WritableComparable<Flow>{
	private String tel;
	private int down;
	private int up;
	public Flow(){
		
	}
	public Flow(String tel, int down, int up) {
		super();
		this.tel = tel;
		this.down = down;
		this.up = up;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
     //按自定义字段顺序写入到数据输出流中
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(tel);
		out.writeInt(down);
		out.writeInt(up);
	}
    //按写入中的顺序从数据输入流读取字段数据
	@Override
	public void readFields(DataInput in) throws IOException {
		this.tel = in.readUTF();
		this.down = in.readInt();
		this.up = in.readInt();	
	}
//设置排序方式
	@Override
	public int compareTo(Flow o) {
		int telnum1 = Integer.parseInt(this.getTel().substring(0, 3));
		int telnum2 = Integer.parseInt(o.getTel().substring(0, 3));
		if(telnum1>=telnum2){
			return 1;
		}else{
			return -1;
		}
	}
	@Override
	public String toString() {
		return this.tel+":("+this.down+","+this.up+")";
	}
}