package com.zyyj.bean;

public class StudentExam {
	private String practice_id;
	private String stu_name;
	private String exam_name;
	private int status;
	private String createtime;
	private int score;
	private String course_name;
	public StudentExam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentExam(String practice_id, String stu_name, String exam_name, int status, String createtime, int score,
			String course_name) {
		super();
		this.practice_id = practice_id;
		this.stu_name = stu_name;
		this.exam_name = exam_name;
		this.status = status;
		this.createtime = createtime;
		this.score = score;
		this.course_name = course_name;
	}
	public String getPractice_id() {
		return practice_id;
	}
	public void setPractice_id(String practice_id) {
		this.practice_id = practice_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
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
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Override
	public String toString() {
		return "StudentExam [practice_id=" + practice_id + ", stu_name=" + stu_name + ", exam_name=" + exam_name
				+ ", status=" + status + ", createtime=" + createtime + ", score=" + score + ", course_name="
				+ course_name + "]";
	}
	
	
	
}
