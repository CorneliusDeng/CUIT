package PeopleManagement;

public class StudentInformation extends People
{
	protected float score;//高考分数
	protected String field;//专业
	protected String classname;//班级
	
	public StudentInformation()
	{
		
	}
	public StudentInformation(String name, String gender, int num, String date,
			float score, String field, String classname)
	{
		super(name, gender, num, date);//引用父类中的构造函数元素
		this.score = score;
		this.field = field;
		this.classname = classname;
	}
	
	public float getScore()
	{
		return score;
	}
	public void setScore(float score)
	{
		this.score = score;
	}
	
	public String getField()
	{
		return field;
	}
	public void setField(String field)
	{
		this.field = field;
	}
	
	public String getClassname()
	{
		return classname;
	}
	public void setClassname(String classname)
	{
		this.classname = classname;
	}
	
	public void display()
	{
		System.out.printf("%s\t%s\t%s\t%s\t%.2f\t%s\t%s\n", 
				name, gender, num, date, score, field, classname);
	}
}
