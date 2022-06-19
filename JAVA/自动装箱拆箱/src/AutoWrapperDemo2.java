
public class AutoWrapperDemo2 
{
	/*JDK5.0引入了自动装箱/拆箱的功能，大大方便了基本类型和包装器类之间的转换，有助于防止发生错误。
	每当需要一种类型的对象时，这种基本类型会被自动封装到与它相同类型的包装器中，这个过程称为装箱；
	反过来，当需要一个值时，当前对象的值会从类包装器中自动提取出来，这个过程称为拆箱。
	 */
	public static int func(Integer iobj)
	{
		iobj++; // 在表达式中使用自动装箱/拆箱
		return iobj;
	}


	public static void main(String[] args) 
	{
		Integer iobj = 10;
		System.out.println(func(iobj)); // 在参数传递中使用自动装箱/拆箱
		// Boolean类型自动装箱/拆箱
		Boolean flag = true;
		if(flag)
		{
			System.out.println("flag is true");
		}
		// Character类型自动装箱/拆箱
		Character ch = 'a';
		char ch2 = ch;
		System.out.println("ch2:"+ch2);
		
	}

}
