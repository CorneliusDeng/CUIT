package com.zyyj.bean;

public class ExchangeRule {
	private String rule_id;
	private String name;
	private String createdate;
	private int score;
	private int integral;
	
	public ExchangeRule(String rule_id, String name, String createdate, int score, int integral) {
		super();
		this.rule_id = rule_id;
		this.name = name;
		this.createdate = createdate;
		this.score = score;
		this.integral = integral;
	}
	public ExchangeRule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getRule_id() {
		return rule_id;
	}
	public void setRule_id(String rule_id) {
		this.rule_id = rule_id;
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
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	@Override
	public String toString() {
		return "{\"rule_id\":\"" + rule_id + "\", \"name\":\"" + name + "\", \"createdate\":\"" + createdate + "\", \"score\":\"" + score
				+ "\", \"integral\":\"" + integral + "\"}";
	}
	
	

}
