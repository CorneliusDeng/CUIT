public class Main18 
{
	public static final int NUM=100;
	public static void main(String[] args) {
		SelectCourse sCourse;
		Course course=new Course("001",new String("java程序设计"),3);
		student[] s=new student[NUM];
		for(int i=0;i<NUM;i++){
			s[i]=new student((new Integer(100+i)).toString(),"StudentName_"+i,"computer");
		}
		sCourse=new SelectCourse(course,s,100,3);
		sCourse.appendStu(new student("800","  name_last "," computer"));
		System.out.println(sCourse.getCourse()+"---课程选课情况为：");
		
		for(int i=0;i<sCourse.getCurNum();i++){
			System.out.println(sCourse.getStu()[i]);
		}
	}
}


class Course
{
	 private String cNo;//课程编号
	 private String cName;//课程名
	 private int credit;//学分
	 
	 public Course(String No, String cName, int credit)
	 {
		 this.cNo = No;
		 this.cName = cName;
		 this.credit = credit;
	 }
	 public Course()
	 {
			cNo="000";
			cName="";
			credit=0;
	 }
	 
	 public String getCNo() 
	 {
		 return cNo;
	 }
	 
	 public void setCNo(String no) 
	 {
		 cNo = no;
	 }
	 
	 public String getCName() 
	 {
		 return cName;
	 }
	 public void setCName(String name) 
	 {
		cName = name;
	 }
	 public int getCredit() 
	 {
		return credit;
	 }
	 public void setCredit(int credit)
	 {
		 this.credit = credit;
	 }
	 
	 public String toString()
	 {
		 return"课程编号:"+cNo+",课程名:"+cName+",学分:"+credit;
	 }
}

class student
{
	private String no;
	private String name;
	private String subject;//专业
	
	public student(String no, String name, String subject)
	{
		this.no = no;
		this.name = name;
		this.subject = subject;
	}
	
	public String getNo() 
	{
		return no;
	}
	public void setNo(String no) 
	{
		this.no = no;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getSubject() 
	{
		return subject;
	}
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
	public String toString()
	{
		return "    学生编号:"+no+",学生姓名:"+name;
	}
}

class SelectCourse
{
	private Course course; //课程
	private student[] stu; //学生
	private int maxNum;
	private int curNum;
	
	public SelectCourse(Course course, student[] stu, int maxNum, int curNum)
	{
		this.course = course;
		this.stu = stu;
		this.maxNum = maxNum;
		this.curNum = curNum;
	}
	
	void appendStu(student s)
	{
		if (curNum < maxNum)
		{
			stu[curNum++] = s;
		}
	}
	
	public Course getCourse() 
	{
		return course;
	}
	
	public void setCourse(Course course) 
	{	
		this.course = course;
	}
	
	public student[] getStu() 
	{
		return stu;
	}
	public void setStu(student[] stu) 
	{
		this.stu = stu;
	}
	public int getMaxNum() 
	{
		return maxNum;
	}
	public void setMaxNum(int maxNum) 
	{
		this.maxNum = maxNum;
	}
	public int getCurNum() 
	{
		return curNum;
	}
	public void setCurNum(int curNum) 
	{
		this.curNum = curNum;
	}
}





