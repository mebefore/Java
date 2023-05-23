package com.yedam.member;

import java.util.Scanner;

public class MemberService {
	
	public static Member memberInfo = null;
	
	Scanner sc = new Scanner(System.in);
	//MemberService ms = new MemberService();
	
	public void login() {
		System.out.println("=====로그인=====");
		System.out.println("ID를 입력하세요.");
		
		String  id = sc.nextLine();
		
		System.out.println("PW를 입력하세요.");
		String pw = sc.nextLine();
		
		Member member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(member.getMemberPw().equals(pw)) {
				System.out.println("로그인 성공!");
				memberInfo = member;
				
			}else {
				System.out.println("비밀번호 불일치");
			}
			
		}else {
			System.out.println("아이디 불일치");
		}
	}
	
	
	
	
	public void join() {
		Member member = new Member();
		System.out.println("======회원가입========");
		
		System.out.println("| 이름 > ");
		member.setMemberName(sc.nextLine());
		
		System.out.println("| 아이디 > ");
		member.setMemberId(sc.nextLine());
		
		System.out.println("| 비밀번호 > ");
		member.setMemberPw(sc.nextLine());
		
		System.out.println(" | 전화번호 > ");
		member.setMemberNum(Integer.parseInt(sc.nextLine()));
		
		System.out.println("| 주소 > ");
		member.setMemberAddr(sc.nextLine());
		
		System.out.println("| 학교 > ");
		member.setMemberSchool(sc.nextLine());
		
		int result = MemberDAO.getInstance().join(member);
		
		if(result > 0) {
			System.out.println("회원 가입 완료");
		}else {
			System.out.println("다시 시도 해주세요.");
		}
		
	}
}
