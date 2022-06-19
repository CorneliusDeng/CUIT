package PeopleManagement;

public class TeacherInformation extends People
{
	protected String department;//部门
	protected String technicalpost;//职称
	protected double salary;//工资
	
	public TeacherInformation()
	{
		
	}
	
	public TeacherInformation(String name, String gender, int num, String date,
			String department, String technicalpost, double salary)
	{
		super(name, gender, num, date);//引用父类中的构造函数元素
		this.department = department;
		this.technicalpost = technicalpost;
		this.salary = salary;
	}
	
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	
	public String getTechnicalpost()
	{
		return technicalpost;
	}
	public void setTechnicalpost(String technicalpost)
	{
		this.technicalpost = technicalpost;
	}
	
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public void display()
	{
		System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%.2f\n", 
				name, gender, num, date, department, technicalpost, salary);
	}
}
