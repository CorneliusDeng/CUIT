package score;

public class ScoreInfo 
{
	private int stID;
	private int stCode;
	private int stName;
	private String courseID;
	private String courseName;
	private float score;
	private int major;

	public int getStID() {
		return stID;
	}

	public void setStID(int stID) {
		this.stID = stID;
	}

	public int getStCode() {
		return stCode;
	}

	public void setStCode(int stCode) {
		this.stCode = stCode;
	}

	public int getStName() {
		return stName;
	}

	public void setStName(int stName) {
		this.stName = stName;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}
}
