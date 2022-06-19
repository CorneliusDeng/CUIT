package com.zyyj.bean;

public class Checkpoint {
	private String checkpoint_id;
	private String name;
	private String creator;
	private String programme;
	private int limit_time;
	private String question_num;
	private int total_score;
	private int pass_score;
	private String comment;
	public Checkpoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Checkpoint(String checkpoint_id, String name, String creator, String programme, int limit_time,
			String question_num, int total_score, int pass_score, String comment) {
		super();
		this.checkpoint_id = checkpoint_id;
		this.name = name;
		this.creator = creator;
		this.programme = programme;
		this.limit_time = limit_time;
		this.question_num = question_num;
		this.total_score = total_score;
		this.pass_score = pass_score;
		this.comment = comment;
	}
	public String getCheckpoint_id() {
		return checkpoint_id;
	}
	public void setCheckpoint_id(String checkpoint_id) {
		this.checkpoint_id = checkpoint_id;
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
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public int getLimit_time() {
		return limit_time;
	}
	public void setLimit_time(int limit_time) {
		this.limit_time = limit_time;
	}
	public String getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(String question_num) {
		this.question_num = question_num;
	}
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public int getPass_score() {
		return pass_score;
	}
	public void setPass_score(int pass_score) {
		this.pass_score = pass_score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "{\"checkpoint_id\":\"" + checkpoint_id + "\", \"name\":\"" + name + "\", \"creator\":\"" + creator + "\", \"programme\":\""
				+ programme + "\", \"limit_time\":\"" + limit_time + "\", \"question_num\":\"" + question_num + "\", \"total_score\":\""
				+ total_score + "\", \"pass_score\":\"" + pass_score + "\", \"comment\":\"" + comment + "\"}";
	}	
}
