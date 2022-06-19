package 泛型定义及使用;

public class GenericDemo 
{

	public static void main(String[] args) 
	{
		//泛型的类型参数只能是类类型（包括自定义类），不能是基本数据类型
		// 定义泛型类Genneric的一个Integer版本
		Generic<Integer> intOb = new Generic<Integer>(88);
		intOb.showTyep();
		int i = intOb.getOb();
		System.out.println("value= " + i);
		// 定义泛型类Genneric的一个String版本
		Generic<String> strOb = new Generic<String>("Hello Java!");
		strOb.showTyep();
		String s = strOb.getOb();
		System.out.println("value= " + s);
	}

}
