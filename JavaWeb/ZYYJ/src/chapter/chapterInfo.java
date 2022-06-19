package chapter;

//章节管理值Bean
public class chapterInfo 
{
	private String chapter_id;
	private String course_id;
	private String name;
	private String photo;
	private String comment;
	public String getChapter_id() 
	{
		return chapter_id;
	}
	public void setChapter_id(String chapter_id) 
	{
		this.chapter_id = chapter_id;
	}
	public String getCourse_id() 
	{
		return course_id;
	}
	public void setCourse_id(String course_id) 
	{
		this.course_id = course_id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getPhoto() 
	{
		return photo;
	}
	public void setPhoto(String photo) 
	{
		this.photo = photo;
	}
	public String getComment() 
	{
		return comment;
	}
	public void setComment(String comment) 
	{
		this.comment = comment;
	}
}
