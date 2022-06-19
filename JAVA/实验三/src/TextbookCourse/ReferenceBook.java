package TextbookCourse;

public class ReferenceBook 
{
	private String rebook;
	private String reauthor;
	private String repub;
	private double reprice;
	private String ISBN;
	
	public ReferenceBook(String rebook, String reauthor, String repub, double reprice, String ISBN)
	{
		this.rebook = rebook;
		this.reauthor = reauthor;
		this.repub = repub;
		this.reprice = reprice;
		this.ISBN = ISBN;
	}
	public String getRebook()
	{
		return rebook;
	}
	public void setRebook(String rb)
	{
		this.rebook = rb;
	}
	
	public String getReauthor()
	{
		return reauthor;
	}
	public void setReauthor(String ra)
	{
		this.reauthor = ra;
	}
	
	public String getRepub()
	{
		return repub;
	}
	public void setRepub(String rp)
	{
		this.repub = rp;
	}
	
	public double getReprice()
	{
		return reprice;
	}
	public void setReprice(double rp)
	{
		this.reprice = rp;
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
		System.out.printf("参考书：%s\n作者：%s\n出版社：%s\n价格：%.2f\nISBN：%s\n", 
				rebook, reauthor, repub, reprice, ISBN);
	}
	
}
