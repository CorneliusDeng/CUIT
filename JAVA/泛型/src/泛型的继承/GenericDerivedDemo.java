package 泛型的继承;

public class GenericDerivedDemo 
{

	public static void main(String[] args) 
	{
		// 定义泛型类Generic的一个Integer版本
		Generic<Integer> intOb = new Generic<Integer>(88);
		intOb.showType();
		
		// 定义泛型类GenericDerived的对象
		GenericDerived<Integer,String> derived = new GenericDerived<Integer, String>(12,"test string");
		derived.showType();
	}

}
