package TextbookCourse;

public class Textbook 
{
	private String bookName;
	private String author;
	private String publishment;
	private String ISBN;
	public double price;
	
	
	public Textbook(String name, String author, String publish, double price, String ISBN) 
	{
		this.bookName = name;
		this.author = author;
		this.publishment = publish;
		this.price = price;	
		this.ISBN = ISBN;
	}
	
	public String getBookName()
	{
		return bookName;
	}
	public void setBookName(String bn)
	{
		this.bookName = bn;
	}
	
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String au)
	{
		this.author = au;
	}
	
	public String getPublishment()
	{
		return publishment;
	}
	public void setPublishment(String pu)
	{
		this.publishment = pu;
	}
	
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double pr)
	{
		this.price = pr;
	}
	public String getISBN()
	{
		return ISBN;
	}
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}
	
	public void display()
	{
		System.out.printf("该课程的教材：%s\n作者：%s\n出版社：%s\n价格：%.2f\nISBN：%s\n", 
				bookName, author, publishment, price, ISBN);
	}
}
