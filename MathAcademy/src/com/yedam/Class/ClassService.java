package com.yedam.Class;

import java.util.List;
import java.util.Scanner;

import javax.security.auth.Subject;

import com.yedam.member.Member;
import com.yedam.member.MemberDAO;
import com.yedam.self.Self;
import com.yedam.subject.SubjectDAO;

public class ClassService {
	Scanner sc = new Scanner(System.in);
	
	//1.전체 수강생 조회(class 전체 정보)
	public void getMember() {
		System.out.println("전체 학생 정보 조회 >");
		List<Class> list = ClassDAO.getInstance().getClassInfo();
		
		for(int i=0; i<list.size(); i++) {
			//이름 아이디 (비번) 번호 주소 학교 타입
			System.out.println("");
			System.out.print(i+1+".");
			System.out.print(" 이름 : " + list.get(i).getMemberName()+" |");
			System.out.print(" 담당 선생님 : " + list.get(i).getMemberTeacher()+" |");
			System.out.print(" 반 : " + list.get(i).getMemberClass()+" |");
			System.out.println(" 등급: " + list.get(i).getMemberGrade());
			System.out.println("");
			
		}
	}
	
	//2. member 전체 정보
	public void getMembers() {
		System.out.println("전체 학생 정보 조회 >");
		List<Member> list = MemberDAO.getInstance().getMemberInfo1();
		
		for(int i=0; i<list.size(); i++) {
			//이름 아이디 (비번) 번호 주소 학교 타입
			System.out.println("");
			System.out.print(i+1+".");
			System.out.print(" 이름 : " + list.get(i).getMemberName()+" |");
			System.out.println(" 아이디 : " + list.get(i).getMemberId());
			System.out.print("   휴대폰 번호 : " + list.get(i).getMemberNum()+" |");
			System.out.print(" 주소 : " + list.get(i).getMemberAddr()+" |");
			System.out.println("  학교 : " + list.get(i).getMemberSchool());
			System.out.print("   타입 : " + list.get(i).getMemberType());
			System.out.println("");
			
		}
	}
	
	
	
	
	
	
	
	//2. 학생 단건 조회
	public void getonlymember() {
		System.out.println("========================");
		System.out.println("| 조회할 회원 아이디 입력 >");
		String memberId = sc.nextLine();
		
		Member member = ClassDAO.getInstance().getonlyMember(memberId);
		System.out.println("========================");
		if(member != null) {
			//이름 아이디 폰번 주소 학교 타입
			System.out.println("| 이름 : " + member.getMemberName());
			System.out.println("| 아이디 : " + member.getMemberId());
			System.out.println("| 휴대폰 번호 : " + member.getMemberNum());
			System.out.println("| 주소 : " + member.getMemberAddr());
			System.out.println("| 학교 : " + member.getMemberSchool());
			System.out.println("| 타입 : " + member.getMemberType());
		}else {
			System.out.println("| 조회되는 정보가 없습니다.");
		}
		
	}
	
	
	//2. 학생 단건 조회(Class)
		public void getonlyClass() {
			System.out.println("========================");
			System.out.println("| 조회할 회원 아이디 입력 >");
			String memberId = sc.nextLine();
			
			Class cs = ClassDAO.getInstance().getonlyClass(memberId);
			System.out.println("========================");
			if(cs != null) {
				//이름 아이디 폰번 주소 학교 타입
				System.out.println("| 아이디 : " + cs.getMemberId());
				System.out.println("| 이름 : " + cs.getMemberName());
				System.out.println("| 담당 선생님 : " + cs.getMemberTeacher());
				System.out.println("| 반 : " + cs.getMemberClass());
				System.out.println("| 내신 등급 : "+ cs.getMemberGrade());
			}else {
				System.out.println("| 조회되는 정보가 없습니다.");
			}
			
		}
		
		
	//2. 학생 단건 조회(subject)
		public void getonlySubject() {
			System.out.println("========================");
			System.out.println("| 조회할 회원 아이디 입력 >");
			String memberId = sc.nextLine();
					
			com.yedam.subject.Subject sj = ClassDAO.getInstance().getonlySubject(memberId);
			System.out.println("========================");
			if(sj != null) {

				System.out.println("| 아이디 : " + sj.getMemberId());
				System.out.println("| 이름 : " + sj.getMemberName());
				System.out.println("| 미적분 : " + sj.getCalculus());
				System.out.println("| 확률과 통계 : " + sj.getProbability());
				System.out.println("| 수학1 : " + sj.getMath1());
				System.out.println("| 수학2 : " + sj.getMath2());
				System.out.println("| 기하 : " + sj.getGeometry());
			}else {
				System.out.println("| 조회되는 정보가 없습니다.");
			}
					
		}
		
		
		//오류나서 냅둔거 근데 위에 com.yedam 어쩌고로 하니 되긴 됏음 뭐지?
//		//2. 학생 단건 조회(subject)
//				public void getonlySubject() {
//					System.out.println("========================");
//					System.out.println("| 조회할 회원 아이디 입력 >");
//					String memberId = sc.nextLine();
//							
//					Subject sj = ClassDAO.getInstance().getonlySubject(memberId);
//					System.out.println("========================");
//					if(sj != null) {
//
//						System.out.println("| 아이디 : " + sj.getMemberId());
//						System.out.println("| 이름 : " + sj.getMemberName());
//						System.out.println("| 미적분 : " + sj.getCalculus());
//						System.out.println("| 확률과 통계 : " + sj.getProbability());
//						System.out.println("| 수학1 : " + sj.getMath1());
//						System.out.println("| 수학2 : " + sj.getMath2());
//						System.out.println("| 기하 : " + sj.getGeometry());
//					}else {
//						System.out.println("| 조회되는 정보가 없습니다.");
//					}
//							
//				}
				
	//3. 자습실 등록 멤버 조회
	public void getSelfInfo() {
		System.out.println("=============자습실 신청자 목록==============");
		List<Self> list = ClassDAO.getInstance().getSelfInfo();
		for(int i=0; i<list.size(); i++) {
			//아이디 시작 끝 apply 
			System.out.print(i+1+".");
			System.out.println(" 아이디 : " + list.get(i).getMemberId());
			System.out.print("자습실 신청일 : " +list.get(i).getSelfStart());
			System.out.println(" | 자습실 종료일 : " + list.get(i).getSelfFinish());
			System.out.println("자습실 신청 여부 : " + list.get(i).getSelfApply());

			
			System.out.println("");
			
			
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
		member.setMemberNum((sc.nextLine()));
		
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
	
	//학생 강의 정보 등록 4-2-2 CLASS
	//NAME TEACHER CLASS GRADE
		public void insertClass() {
			Class cs = new Class();
			System.out.println("=== 학생 강의 정보 등록=== ");
			
			
			System.out.println("| 학생 아이디 입력 > ");
			cs.setMemberId(sc.nextLine());
			
			System.out.println("| 학생 이름 입력 > ");
			cs.setMemberName(sc.nextLine());
			
			System.out.println("| 담당 선생님 입력 > ");
			cs.setMemberTeacher(sc.nextLine());
			
			System.out.println("| 클래스 입력 > ");
			cs.setMemberClass(sc.nextLine());
			
			System.out.println("| 내신 등급 입력 > ");
			cs.setMemberGrade(sc.nextLine());
			
			int result = ClassDAO.getInstance().insertClass(cs);
			
			if(result > 0) {
				System.out.println("학생 강의 정보 입력 완료");
			} else {
				System.out.println("학생 강의 정보를 다시 입력해주세요.");
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
	
	
	//4-3-1 전번 수정
		public void updatePhone() {
			Member member = new Member();
			System.out.println("==========회원 정보 수정==========");
			
			System.out.println("| 수정할 회원 아이디> ");
			member.setMemberId(sc.nextLine());
			
			System.out.println("| 수정할 전화번호 > ");
			member.setMemberNum((sc.nextLine()));
			
			int result = ClassDAO.getInstance().updatePhone(member);
			
			if(result > 0) {
				System.out.println("전화번호 수정 완료");
				System.out.println("");
			}else {
				System.out.println("아이디를 다시 확인해주세요.");
			}
		
			
			
			
		}


	//주소 수정
		public void updateAddr() {
			Member member = new Member();
			System.out.println("========주소 수정========");
			
			System.out.println("| 수정할 회원 이름 > ");
			member.setMemberId(sc.nextLine());
			
			System.out.println("| 수정 주소 입력 > ");
			member.setMemberAddr(sc.nextLine());
			
			int result = ClassDAO.getInstance().updateAddr(member);
			
			if(result > 0) {
				System.out.println("주소 수정 완료");
				System.out.println("");
			}else {
				System.out.println("아이디를 다시 확인해주세요.");
			}
			
		}
		
	//학교수정
		public void updateSchool() {
			Member member = new Member();
			System.out.println("========학교 수정========");
			
			System.out.println("| 수정할 회원 이름 > ");
			member.setMemberId(sc.nextLine());
			
			System.out.println("| 수정 학교 입력 > ");
			member.setMemberSchool(sc.nextLine());
			
			int result = ClassDAO.getInstance().updateSchool(member);
			
			if(result > 0) {
				System.out.println("학교 수정 완료");
				System.out.println("");
			}else {
				System.out.println("아이디를 다시 확인해주세요.");
			}
		}
		
		
	//선생님 수정
		public void updateTeacher() {
			Class cs = new Class();
			System.out.println("========선생님 수정========");
			
			System.out.println("| 수정할 회원 이름 > ");
			cs.setMemberName(sc.nextLine());
			
			System.out.println("| 수정 선생님 입력 > ");
			cs.setMemberTeacher(sc.nextLine());
			
			int result = ClassDAO.getInstance().updateTeacher(cs);
			
			if(result > 0) {
				System.out.println("선생님 수정 완료");
			}else {
				System.out.println("선생님 등록을 먼저 해주세요.");
			}
		}
		
		
		//등급 수정 
		public void updateType() {
			Member member = new Member();
			System.out.println("=========== 타입 수정 ============");
			System.out.println("관리자 - M , 회원 - S ");
			
			System.out.println("| 수정할 회원 이름 > ");
			member.setMemberId(sc.nextLine());
			
			System.out.println("| 수정할 타입 입력 > ");
			member.setMemberType(sc.nextLine());
			
			int result = ClassDAO.getInstance().updateType(member);
			
			if(result > 0) {
				System.out.println("등급 수정 완료");
			}else {
				System.out.println("등급 수정 실패");
			}
			
		}
		
	//학급 수정
		public void updateClass() {
			Class cs = new Class();
			System.out.println("========학급 수정========");
					
			System.out.println("| 수정할 회원 이름 > ");
			cs.setMemberName(sc.nextLine());
					
			System.out.println("| 수정 학급 입력 > ");
			cs.setMemberClass(sc.nextLine());
					
			int result = ClassDAO.getInstance().updateClass(cs);
					
			if(result > 0) {
				System.out.println("학급 수정 완료");
			}else {
				System.out.println("학급 등록을 먼저 해주세요.");
			}
		}
				
		//학급 수정
		public void updateGrade() {
			Class cs = new Class();
			System.out.println("========수학 등급 수정========");
				
			System.out.println("| 수정할 회원 이름 > ");
			cs.setMemberName(sc.nextLine());
					
			System.out.println("| 수정 등급 입력 > ");
			cs.setMemberGrade(sc.nextLine());
					
			int result = ClassDAO.getInstance().updateGrade(cs);
					
			if(result > 0) {
				System.out.println("등급 수정 완료");
			}else {
				System.out.println("등급 입력을 먼저 해주세요");
			}
		}			
			
			
	//회원 삭제 (member table삭제)
	public void deleteMember() {
		System.out.println("삭제할 회원 아이디를 입력해주세요.");
		String memberId = sc.nextLine();
		
		int result = ClassDAO.getInstance().deleteMember(memberId);
		
		if(result > 0) {
			System.out.println("");
			System.out.println("삭제가 완료되었습니다.");
		}else {
			System.out.println("");
			System.out.println("확인 후 다시 입력하세요.");
		}
		
	}
				
	//회원 삭제 (class table삭제)
		public void deleteClass() {
			System.out.println("삭제할 회원 이름을 입력해주세요.");
			String memberName = sc.nextLine();
			
			int result = ClassDAO.getInstance().deleteClass(memberName);
			
			if(result > 0) {
				System.out.println("");
				System.out.println("삭제가 완료되었습니다.");
			}else {
				System.out.println("");
				System.out.println("확인 후 다시 입력하세요.");
			}
			
		}
		
		//회원 삭제 (class table삭제)
				public void deleteSubject() {
					System.out.println("삭제할 회원 아이디를 입력해주세요.");
					String memberId = sc.nextLine();
					
					int result = ClassDAO.getInstance().deleteSubject(memberId);
					
					if(result > 0) {
						System.out.println("");
						System.out.println("삭제가 완료되었습니다.");
					}else {
						System.out.println("");
						System.out.println("확인 후 다시 입력하세요.");
					}
					
				}
				
				
				
				
}