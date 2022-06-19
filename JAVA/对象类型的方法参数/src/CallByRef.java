
public class CallByRef
{
	/*引用传递(call by reference) ,将参数的引用（类似于C语言的内存指针）传递给被调方法，
	 * 被调方法通过传递的引用值获取其指向的内存空间，从而在原始内存空间直接进行操作，这样将导致原始内存空间状态的修改。
	 */
	
	int a, b;
	CallByRef(int i, int j) //构造函数
	{
		a = i;
		b = j;
	}
	void change(CallByRef obj) 
	{
		obj.a = 50;
		obj.b = 40;
		System.out.println("在change方法中  obj.a=" + obj.a + ",obj.b=" + obj.b);
	}

	public static void main(String[] args) 
	{
		CallByRef obj = new CallByRef(15, 20);
		System.out.println("调用change方法前  obj.a=" + obj.a + ",obj.b=" + obj.b);
		obj.change(obj);
		System.out.println("调用change方法后  obj.a=" + obj.a + ",obj.b=" + obj.b);
	}

}
