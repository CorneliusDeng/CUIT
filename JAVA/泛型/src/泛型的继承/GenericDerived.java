package 泛型的继承;

public class GenericDerived<T,V> extends Generic<T>
{

	V dob;
	public GenericDerived(T ob, V dob) 
	{
		super(ob);
		this.dob = dob;
	}
	
	public V getDob() 
	{
		return dob;
	}
	public void setDob(V dob) 
	{
		this.dob = dob;
	}
	public void showType() 
	{
		System.out.println("V的实际类型是: " + dob.getClass().getName());
	}
}
