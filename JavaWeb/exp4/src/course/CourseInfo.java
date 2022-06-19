package course;

// 封装课程信息的值Bean
public class CourseInfo 
{
	private int 	courseID;
	private String 	name;
	private int 	type;
	private float	credit;
	private int 	grade;
	private int 	major;
	private String	detail;
	
	public int getCourseID() 
	{
		return courseID;
	}
	public void setCourseID(int courseID) 
	{
		this.courseID = courseID;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getType() 
	{
		return type;
	}
	public void setType(int type) 
	{
		this.type = type;
	}
	public float getCredit() 
	{
		return credit;
	}
	public void setCredit(float credit) 
	{
		this.credit = credit;
	}
	public int getGrade() 
	{
		return grade;
	}
	public void setGrade(int grade) 
	{
		this.grade = grade;
	}
	public int getMajor() 
	{
		return major;
	}
	public void setMajor(int major) 
	{
		this.major = major;
	}
	public String getDetail() 
	{
		return detail;
	}
	public void setDetail(String detail) 
	{
		this.detail = detail;
	}
}
