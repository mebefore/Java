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
			if (MemberService.memberInfo == null) {

				System.out.println("=======김수학수학학원입니다=======");
				System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");
				System.out.println("============================");
				int menu = Integer.parseInt(sc.nextLine());
				if (menu == 1) {
					// 로그인 기능
					ms.login();
				} else if (menu == 2) {
					// 회원가입
					ms.join();

				} else if (menu == 3) {

					System.out.println("프로그램 종료");
					run = false;
				} else {
					System.out.println("없는 메뉴 선택");
				}

			} else if (MemberService.memberInfo != null) {
				if (MemberService.memberInfo.getMemberType().equals("S")) {
					// S = 학생
					new MemberApp();
				} else if (MemberService.memberInfo.getMemberType().equals("M")) {
					// M = 관리자
					new ClassApp();
				}
			}
		}
	}
}
