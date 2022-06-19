
public class CallByValue 
{
	/*按值传递(call by value) ,将要传递的参数的值传递给被调方法，
	 * 被调方法通过创建一份新的内存拷贝来存储传递的值，然后在内存拷贝上进行数值操作，所以按值传递不会改变原始参数的值
	 */
	/*定义change方法*/
	public  void change(int num) 
	{
	num += 5;
	System.out.println("在change中 num的值为 : " + num);
	}
	
	public static void main(String[] args) 
	{
		int num = 5;
		System.out.println("调用change方法前 : " + num);
		//创建一个CallByValue类型的对象
		CallByValue callByValue = new CallByValue();
		callByValue.change(num);
		System.out.println("调用change方法后 : " + num);
	}

}
