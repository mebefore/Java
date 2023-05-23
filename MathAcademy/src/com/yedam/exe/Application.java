package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class Application {

	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	
	boolean run = true;
	
	public Application() {
		run();
	}

	private void run() {
		while (run) {
			if(MemberService.memberInfo == null) {
				
				System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");
				int menu = Integer.parseInt(sc.nextLine());
				if (menu == 1) {
					//로그인 기능				
						ms.login();	
						
					
				} else if (menu == 2) {
					//회원가입 기능 만들어야댐
					ms.join();
					
				}else if(menu ==3) {
					
					System.out.println("프로그램 종료");
					run = false;
				}else {
					System.out.println("없는 메뉴 선택");
				}
			
			
			
			}else if(MemberService.memberInfo != null) {
			//로그인한 정보를 토대로 업무를 나눔(고객(N)/은행원(B))
			if(MemberService.memberInfo.getMemberType().equals("S")) {
				//S = 학생
				new MemberApp();
			}else if(MemberService.memberInfo.getMemberType().equals("M")) {
				//M = 관리자
				new ManagerApp();
			}
		}
	}
	}
}

