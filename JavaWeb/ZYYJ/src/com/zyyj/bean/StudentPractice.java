package com.zyyj.bean;

public class StudentPractice {
	private String practice_id;
	private String stuName;
	private int status;
	private String createtime;
	private int score;
	private String programme;
	private String course;
	public StudentPractice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentPractice(String practice_id, String stuName, int status, String createtime, int score,
			String programme, String course) {
		super();
		this.practice_id = practice_id;
		this.stuName = stuName;
		this.status = status;
		this.createtime = createtime;
		this.score = score;
		this.programme = programme;
		this.course = course;
	}
	public String getPractice_id() {
		return practice_id;
	}
	public void setPractice_id(String practice_id) {
		this.practice_id = practice_id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "StudentPractice [practice_id=" + practice_id + ", stuName=" + stuName + ", status=" + status
				+ ", createtime=" + createtime + ", score=" + score + ", programme=" + programme + ", course=" + course
				+ "]";
	}
	
	
}
