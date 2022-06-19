package TextbookCourse;

public class Course 
{
	private String courseName;
	private String teacherName;
	
	public Course(String name0, String teacher0) 
	{
		this.courseName = name0;
		this.teacherName = teacher0;
	}
	public String getCourseName() 
	{
		return courseName;
	}
	public void setCourseName(String name) 
	{
		this.courseName = name;
	}
	
	public String getTeacherName() 
	{
		return teacherName;
	}
	public void setTeacherName(String teacher) 
	{
		this.teacherName = teacher;
	}
	
	public void display()
	{
		System.out.printf("课程名称：%s\n", courseName);
		System.out.printf("执教该课程的老师：%s\n", teacherName);
	}
	
}
