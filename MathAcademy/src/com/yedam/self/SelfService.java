package com.yedam.self;

import java.util.Scanner;

import com.yedam.member.MemberDAO;

public class SelfService {
	
	Scanner sc = new Scanner(System.in);
	
	
	
	//자습실 신청
	String menuNo = sc.nextLine();
	
	
	public void selfApply() {
		

		System.out.println("=======자습실 신청========");
		System.out.println("1. 신청하기 | 2. 뒤로가기");
		
		menuNo = sc.nextLine();
		
		
		if(menuNo.equals("1")) {
			int result = SelfDAO.getInstance().selfApply();
			System.out.println("신청이 완료되었습니다.");
		}else {
			
		}
	}
	
	//자습실 연장
	public void selfExtend() {
		

		System.out.println("=======자습실 연장========");
		System.out.println("1. 연장하기 | 2. 뒤로가기");
		
		menuNo = sc.nextLine();
		
		
		if(menuNo.equals("1")) {
			int result = SelfDAO.getInstance().selfExtend();
			System.out.println("연장이 완료되었습니다.");
		}else {
			
		}
	}
	
	
	//자습실 취소
	public void selfCancel() {
		Self self = new Self();
		
		System.out.println("=======자습실 취소========");
		System.out.println("1. 취소하기 | 2. 뒤로가기");
		
		menuNo = sc.nextLine();
		
		if(menuNo.equals("1")) {
			int result = SelfDAO.getInstance().selfCancel();
			System.out.println("취소 완료되었습니다.");
		}else {
			
		}
		
	}
		
		
	}

