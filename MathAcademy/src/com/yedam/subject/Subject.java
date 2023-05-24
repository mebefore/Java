package com.yedam.subject;

public class Subject {
	
//			MEMBER_NAME VARCHAR(20),
//			CALCULUS VARCHAR2(10),
//			PROBABILITY VARCHAR2(10),
//			MATH1 VARCHAR2(10),
//			MATH2 VARCHAR2(10),
//			GEOMETRY VARCHAR2(10));
	
	private String memberId;
	private String memberName;
	private String calculus;
	private String probability;
	private String math1;
	private String math2;
	private String geometry;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCalculus() {
		return calculus;
	}
	public void setCalculus(String calculus) {
		this.calculus = calculus;
	}
	public String getProbability() {
		return probability;
	}
	public void setProbability(String probability) {
		this.probability = probability;
	}
	public String getMath1() {
		return math1;
	}
	public void setMath1(String math1) {
		this.math1 = math1;
	}
	public String getMath2() {
		return math2;
	}
	public void setMath2(String math2) {
		this.math2 = math2;
	}
	public String getGeometry() {
		return geometry;
	}
	public void setGeometry(String geometry) {
		this.geometry = geometry;
	}
	
	
}
