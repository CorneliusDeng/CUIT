package ExceptionHandling;

public class MyException extends Exception
{

	/**
	 * 因为继承了一个序列化接口，这个接口需要实现一个序列号，用于唯一标识这个类。为了不出现警告，需要在类里面声明这样一个字段。
		private static final long serialVersionUID = xxxxxxL;
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String message)
	{
		
		super(message);
		System.out.print(message);
	}
}
