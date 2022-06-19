package PeopleManagement;


public class People 
{
	protected String name;//姓名
	protected String gender;//性别
	protected int num;//编号
	protected String date;//出生日期
	
	public People()//为了让Test中的学生、老师类能构造基本信息为空的对象，父类中也需要构造一个无参的构造函数
	{
		
	}
	public People(String name, String gender, int num, String date)
	{
		this.name = name;
		this.gender= gender;
		this.num = num;
		this.date = date;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public int getNum()
	{
		return num;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
}
