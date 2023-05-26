package com.yedam.self;

import java.sql.Date;

public class Self {

	
	
	private String memberId;
	private Date selfStart;
	private Date selfFinish;
	private String selfApply;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public Date getSelfStart() {
		return selfStart;
	}
	public void setSelfStart(Date selfStart) {
		this.selfStart = selfStart;
	}
	public Date getSelfFinish() {
		return selfFinish;
	}
	public void setSelfFinish(Date selfFinish) {
		this.selfFinish = selfFinish;
	}
	public String getSelfApply() {
		return selfApply;
	}
	public void setSelfApply(String selfApply) {
		this.selfApply = selfApply;
	}
	
	
	
}
