package Programme;

public class ProgrammeInfo{
	private String programme_id;
	private String name;
	private String createdate;
	private int score;
	private String comment;

	
	public String getProgramme_id() {
		return programme_id;
	}
	public void setProgramme_id(String programme_id) {
		this.programme_id = programme_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}