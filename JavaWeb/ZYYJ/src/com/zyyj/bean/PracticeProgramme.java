package com.zyyj.bean;

public class PracticeProgramme {
	private String programme_id;
	private String name;
	private String creator;
	private String createdate;
	private String course;
	private int score;
	private String note;
	
	public PracticeProgramme(String programme_id, String name, String creator, String createdate, String course,
			int score, String note) {
		super();
		this.programme_id = programme_id;
		this.name = name;
		this.creator = creator;
		this.createdate = createdate;
		this.course = course;
		this.score = score;
		this.note = note;
	}
	public PracticeProgramme() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "{\"programme_id\":\"" + programme_id + "\", \"name\":\"" + name + "\", \"creator\":\"" + creator
				+ "\", \"createdate\":\"" + createdate + "\", \"course\":\"" + course + "\", \"score\":\"" + score + "\", \"note\":\"" + note + "\"}";
	}
	
	
}
