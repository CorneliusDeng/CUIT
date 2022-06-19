/*import java.util.*;
import java.util.Scanner;
public class Main10 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入");
		String coursename = reader.nextLine();
		String textbookname1 = reader.nextLine();
		String textbookname2 = reader.nextLine();
		String textbookname3 = reader.nextLine();
		
		Course course = new Course(coursename);
		Textbook textbook1 = new Textbook(textbookname1);
		Textbook textbook2 = new Textbook(textbookname2);
		Textbook textbook3 = new Textbook(textbookname3);
		
		Reference r = new Reference();
		r.set(course, textbook1, textbook2, textbook3);
		reader.close();
	}

}

class Textbook
{
	private String bookName;
	
	public Textbook(String name) 
	{
		bookName = name;
	}
	
	public void setBookName(String bookname)
	{
		this.bookName = bookname;
	}
	public String getBookName()
	{
		return bookName;
	}
}

class Course
{
	private String courseName;
	
	public Course(String coursename) 
	{
		this.courseName = coursename;
	}
	
	public String getCourseName() 
	{
		return courseName;
	}
	public void setCourseName(String name) 
	{
		this.courseName = name;
	}
}

class Reference
{
	
	public Reference()
	{
	}
	
	public void set(Course a, Textbook...textbooks)
	{
		List<Textbook> mylist = new ArrayList<Textbook>();
		
		for (Textbook ch : textbooks)
		{
			mylist.add(ch);
		}
		System.out.print("课程 《"+a.getCourseName()+"》的指定教材为："+mylist.get(0).getBookName()+","+mylist.get(1).getBookName()+","+mylist.get(2).getBookName());
	}
}*/
