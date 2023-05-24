package com.yedam.exe;

import java.util.Scanner;

import com.yedam.Class.ClassService;
import com.yedam.member.MemberService;

public class ClassApp {
	Scanner sc = new Scanner(System.in);
	ClassService cs = new ClassService();
	
	public ClassApp() {
		run();
	}
	
	private void run() {
		while(true) {
			menu();
			String menuNo = sc.nextLine();
			
			if(menuNo.equals("1")) {
				//1. 전체 수강생 조회
				cs.getMember();
			}else if (menuNo.equals("2")) {
				//2. 학생 개개인 조회
				cs.getonlymember();
			}else if (menuNo.equals("3")){
				//3.자습실 신청자 조회
			}else if (menuNo.equals("4")) {
				//4. 회원 관리
				System.out.println("| 1. 새로운 회원 등록 | 2. 학생 강의 정보 등록 | 3. 회원 수정 | 4. 뒤로가기");
				menuNo = sc.nextLine();
				if(menuNo.equals("1")) {
					//새로운 회원 등록
					cs.insertMember();
					
				}else if(menuNo.equals("2")){
					
					System.out.println("| 1. 과목 등급 등록 | 2. 학생 강의 정보 등록");
					if(menuNo.equals("1")) {
						//subject
						
					}else if(menuNo.equals("2")){
						//class
						
					}
					
				}else if(menuNo.equals("3")){ 
					
					System.out.println("| 1.회원 정보 수정 | 2. 학생 과목 관련 수정 | 3. 학생 강의 정보 수정");
					if(menuNo.equals("1")) {
						//member
						
					}else if(menuNo.equals("2")){
						//subject
						
					}else if(menuNo.equals("3")) {
						//class
					}
					break;
				}
				
			}else if (menuNo.equals("5")) {
				System.out.println("종료");
				MemberService.memberInfo = null;
				break;
			}
			
		}
	}
	
	
	private void menu() {
		System.out.println("| 1. 전체 수강생 조회 | 2. 학생 정보 조회 | 3. 자습실 관리 |"
				+ " 4. 회원 관리 | 5. 뒤로가기 | ");
	}
	
}
