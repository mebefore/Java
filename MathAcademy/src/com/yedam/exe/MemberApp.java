package com.yedam.exe;

import java.util.Scanner;

import com.yedam.Class.ClassService;
import com.yedam.member.MemberService;
import com.yedam.subject.SubjectService;

public class MemberApp {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	SubjectService ss = new SubjectService();
	ClassService cs = new ClassService();
	
	public MemberApp() {
		memberRun();
	}
	
	private void memberRun() {
		boolean flag = true;
		while(flag) {
			menu();
			String selectNo = sc.nextLine();
			switch(selectNo){

			
				case "1" :
					//1. 내정보 확인
					System.out.println("| 1. 나의 가입 정보 | 2. 나의 수강 정보 | 3. 뒤로가기");
					selectNo = sc.nextLine();
					if(selectNo.equals("1")) {
						ms.getMemberInfo();
						
					}else if(selectNo.equals("2")) {
						//2.김선생 어쩌고 그거 나오게
						cs.getClassInfo2();
					}else {
						break;
					}
					
					break;
					
				
					
				case "2" :
					ss.subjectGrade();
					break;
					
				case "3" :
					
					break;
				
					
				case "4" : 
					flag = false;
					MemberService.memberInfo = null;
					System.out.println("종료");
					break;
				
			}
		}
	}
	
	private void menu() {
		System.out.println("1.내 정보 확인 | 2. 강의 등급 확인 | 3. 자습실 내역 | 4. 뒤로가기");
	}
}

	
