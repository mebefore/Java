package com.yedam.exe;

import java.util.Scanner;

import com.yedam.Class.ClassService;
import com.yedam.member.MemberService;
import com.yedam.self.SelfService;
import com.yedam.subject.SubjectService;

public class MemberApp {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	SubjectService ss = new SubjectService();
	ClassService cs = new ClassService();
	SelfService sf = new SelfService();
	
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
						
						cs.getClassInfo2();
					}else {
						break;
					}
					
					break;
					
					
				case "2" :
					ss.subjectGrade();
					break;
					
				case "3" :
					System.out.println("| 1. 나의 자습실 현황 | 2. 자습실 신청 | 3. 뒤로가기");
					selectNo = sc.nextLine();
					if(selectNo.equals("1")) {
						sf.getselfInfo();
					
					//-> 자습실 내역이 존재하지 않습니다 (신청하지 않았으면)
						
					}else if(selectNo.equals("2")) {
						System.out.println("| 1. 신청 | 2. 연장 | 3. 취소 | 4. 뒤로가");
						selectNo = sc.nextLine();
						
						if(selectNo.equals("1")) {
							//신청 
							sf.selfApply();
							
						}else if(selectNo.equals("2")) {
							sf.selfExtend();
							
						}else if(selectNo.equals("3")){
							//취소
							sf.selfCancel();
							
						}else{
							break;
						}
						
					}else {
						break;
					}
					
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
		System.out.println("** 김수학수학학원 ** ========================================");
		System.out.println("< 1.내 정보 확인 | 2. 강의 등급 확인 | 3. 자습실 내역 | 4. 로그아웃 >");
		System.out.println("=========================================================");
	}
}

	
