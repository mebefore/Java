package com.yedam.self;

public class Self {

	private String memberId;
	private String memberName;
	private String memberClass;
	private int selfCounter;
	private String selfToday;
	
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberClass() {
		return memberClass;
	}
	public void setMemberClass(String memberClass) {
		this.memberClass = memberClass;
	}
	public int getSelfCounter() {
		return selfCounter;
	}
	public void setSelfCounter(int selfCounter) {
		this.selfCounter = selfCounter;
	}
	public String getSelfToday() {
		return selfToday;
	}
	public void setSelfToday(String selfToday) {
		this.selfToday = selfToday;
	}
}
