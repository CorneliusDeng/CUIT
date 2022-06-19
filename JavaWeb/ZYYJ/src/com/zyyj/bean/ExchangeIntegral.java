package com.zyyj.bean;

public class ExchangeIntegral {
	private String exchange_id;
	private String rule_name;
	private String stu_name;
	private String createdate;
	private int score;
	private int integral;
	public ExchangeIntegral() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ExchangeIntegral(String exchange_id, String rule_name, String stu_name, String createdate, int score,
			int integral) {
		super();
		this.exchange_id = exchange_id;
		this.rule_name = rule_name;
		this.stu_name = stu_name;
		this.createdate = createdate;
		this.score = score;
		this.integral = integral;
	}

	public String getExchange_id() {
		return exchange_id;
	}
	public void setExchange_id(String exchange_id) {
		this.exchange_id = exchange_id;
	}
	public String getRule_name() {
		return rule_name;
	}
	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
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
	
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "ExchangeIntegral [exchange_id=" + exchange_id + ", rule_name=" + rule_name + ", stu_name=" + stu_name
				+ ", createdate=" + createdate + ", score=" + score + ", integral=" + integral + "]";
	}
	
	
	
}
