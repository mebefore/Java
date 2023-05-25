package com.yedam.self;

import java.sql.Date;

public class Self {

	
	
	private String memberId;
	private String memberName;
	private Date selfStrat;
	private Date selfFinish;
	private String selfApply;
	
	
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
	public Date getSelfStrat() {
		return selfStrat;
	}
	public void setSelfStrat(Date selfStrat) {
		this.selfStrat = selfStrat;
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
