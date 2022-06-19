package 接口基本操作;

public class Example7_1 
{

	public static void main(String[] args) 
	{
		China zhang = new China();
		Japan henlu = new Japan();
		
		zhang.number = 28 + Computable.MAX;
		henlu.number = 14 + Computable.MAX;
		
		System.out.println("zhang的学号"+zhang.number+",zhang求和结果"+zhang.f(100));
		System.out.println("henlu的学号"+henlu.number+",zhang求和结果"+henlu.f(100));
		
		/*
		 * 类重写的接口方法以及接口中的常量可以被类的对象调用，而且常量也可以用接口名直接调用
		 * 如果父类实现了某个接口，那么子类也就自然实现了该接口，子类不必再显式地使用关键字implements声明实现了这个接口
		 * 如果一个类声明实现了一个接口，但是没有重写接口中的所有方法，那么这个类必须是abstract类
		 * */

	}

}
