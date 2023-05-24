package com.yedam.Class;

import java.util.List;
import java.util.Scanner;

import com.yedam.member.Member;

public class ClassService {
	Scanner sc = new Scanner(System.in);
	
	//1.전체 수강생 조회
	public void getMember() {
		System.out.println("=====전체 학생 정보 조회=====");
		List<Class> list = ClassDAO.getInstance().getClassInfo();
		
		for(int i=0; i<list.size(); i++) {
			//이름 아이디 (비번) 번호 주소 학교 타입
			//전체학생을어캐조회하지
			System.out.print(i+1+".");
			System.out.print(" 이름 : " + list.get(i).getMemberName()+" |");
			System.out.print(" 담당 선생님 : " + list.get(i).getMemberTeacher()+" |");
			System.out.print(" 반 : " + list.get(i).getMemberClass()+" |");
			System.out.println(" 등급: " + list.get(i).getMemberGrade());
			
			System.out.println("");
			
			
		}
	}
	
	//2. 학생 단건 조회
	public void getonlymember() {
		System.out.println("========================");
		System.out.println("| 학생 이름 입력 >");
		//아이디는 String이라 String으로 받아야 되나?
		String memberName = sc.nextLine();
		
		Member member = ClassDAO.getInstance().getonlyMember(memberName);
		System.out.println("========================");
		if(member != null) {
			//이름 아이디 폰번 주소 학교 타입
			System.out.println("| 이름 : " + member.getMemberName());
			System.out.println("|이름 : " + member.getMemberId());
			System.out.println("| 휴대폰 번호 : " + member.getMemberNum());
			System.out.println("| 주소 : " + member.getMemberAddr());
			System.out.println("| 학교 : " + member.getMemberSchool());
			System.out.println("| 타입 : " + member.getMemberType());
		}else {
			System.out.println("| 조회되는 정보가 없습니다.");
		}
		
	}
	
	
	//4-1) 학생 등록
	public void insertMember() {
		Member member = new Member();
		System.out.println("=======학생 등록========");
		System.out.println(" 이름 >");
		member.setMemberName(sc.nextLine());
		
		System.out.println("아이디 >");
		member.setMemberId(sc.nextLine());
		
		System.out.println("비밀번호 >");
		member.setMemberPw(sc.nextLine());
		
		System.out.println("전화번호 >");
		member.setMemberNum(Integer.parseInt(sc.nextLine()));
		
		System.out.println("주소 >");
		member.setMemberAddr(sc.nextLine());
		
		System.out.println("학교 >");
		member.setMemberSchool(sc.nextLine());
		
		System.out.println("타입 >");
		member.setMemberType(sc.nextLine());
		
		int result = ClassDAO.getInstance().insertMember(member);
		
		if(result > 0) {
			System.out.println("학생 정보 입력 완료");
		} else {
			System.out.println("학생 정보를 다시 입력해주세요.");
		}
		
		
		
		
	}
	
	
	//1-2 나의 수강 정보
		public void getClassInfo2() {
			System.out.println("======나의 강의 정보=======");
			List<Class> list = ClassDAO.getInstance().getClassInfo2();
			for(int i=0; i<list.size(); i++) {
				//이름 선생 반 등급
				System.out.println(list.get(i).getMemberName()+" 님의 정보입니다.");
				System.out.println("담당선생님 : " + list.get(i).getMemberTeacher()+" 입니다.");
				System.out.println("클래스는 " + list.get(i).getMemberClass() +" 입니다.");
				System.out.println("나의 등급은 "+list.get(i).getMemberGrade()+" 입니다.");
				System.out.println("");
			}
		}
	
	
	
	
	
	
}
