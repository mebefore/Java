package com.yedam.Class;

public class Class {
	

//			member_name varchar2(20) primary key,
//			member_teacher varchar2(50),
//			member_class varchar2(20),
//			member_grade varchar2(10));
	
	private String memberName;
	private String memberTeacher;
	private String memberClass;
	private String memberGrade;
	
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberTeacher() {
		return memberTeacher;
	}
	public void setMemberTeacher(String memberTeacher) {
		this.memberTeacher = memberTeacher;
	}
	public String getMemberClass() {
		return memberClass;
	}
	public void setMemberClass(String memberClass) {
		this.memberClass = memberClass;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	
	
	
}
