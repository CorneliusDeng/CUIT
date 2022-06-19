package 接口基本操作;

public interface Computable //创建一个Computable接口
{
	int MAX = 100;
	int f(int x);
	
	/*
	 * 接口中的变量一定是public static final的，
	 * 方法一定是public abstract类型的
	 * 这些都是可以简写的
	 * */
}
