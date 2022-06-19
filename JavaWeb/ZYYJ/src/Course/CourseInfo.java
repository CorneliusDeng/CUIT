package Course;

public class CourseInfo 
{
	private String course_id;
	private String user_id;
	private String name;
	private String introduction;
	private String photo;
	private int practice_count;

	public String getCourse_id(){
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getUser_id(){
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getPractice_count() {
		return practice_count;
	}
	public void setPractice_count(int practice_count) {
		this.practice_count = practice_count;
	}
}