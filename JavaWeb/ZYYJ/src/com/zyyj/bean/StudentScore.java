package com.zyyj.bean;

public class StudentScore {
	private String studentName;
	private int score;
	public StudentScore(String studentName, int score) {
		super();
		this.studentName = studentName;
		this.score = score;
	}
	public StudentScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "{\"studentName:\"" + studentName + "\", \"score\":\"" + score + "\"}";
	}
}
