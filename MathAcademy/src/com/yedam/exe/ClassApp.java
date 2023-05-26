package com.yedam.exe;

import java.util.Scanner;

import com.yedam.Class.ClassService;
import com.yedam.member.MemberService;
import com.yedam.subject.SubjectService;

public class ClassApp {
	Scanner sc = new Scanner(System.in);
	ClassService cs = new ClassService();
	SubjectService SS = new SubjectService();
	
	public ClassApp() {
		run();
	}
	
	private void run() {
		while(true) {
			menu();
			String menuNo = sc.nextLine();
			
			
			if(menuNo.equals("1")) {
				System.out.println("");
				System.out.println("  1. 학생 학원 정보 조회 | 2. 학생 과목 등급 조회");
				System.out.println("");
				menuNo = sc.nextLine();
				if(menuNo.equals("1")) {
					cs.getMember();
				}else {
					SS.getMemberSubject();
				}
				
			}else if (menuNo.equals("2")) {
				//2. 학생 개개인 조회
				cs.getonlymember();
			}else if (menuNo.equals("3")){
				cs.getSelfInfo();
			}else if (menuNo.equals("4")) {
				//회원관리
				
				System.out.println("| 1. 새로운 회원 등록 | 2. 학생 강의 정보 등록 | 3. 회원 수정 | 4. 회원 삭제 | 5. 뒤로가기");
				menuNo = sc.nextLine();
				if(menuNo.equals("1")) {
					cs.insertMember();
					
				}else if(menuNo.equals("2")) {
					System.out.println("| 1. 과목 등급 등록 | 2. 학생 강의 정보 등록");
					menuNo = sc.nextLine();
					if(menuNo.equals("1")) {
						SS.insertSubject();
					}else if(menuNo.equals("2")) {
						cs.insertClass();
					}
					
				}else if(menuNo.equals("3")) {
					System.out.println("| 1.회원 정보 수정 | 2. 학생 과목 관련 수정 | 3. 학생 강의 정보 수정");
					menuNo = sc.nextLine();
					if(menuNo.equals("1")) {
						
						System.out.println("| 1. 전화번호 수정 | 2. 주소 수정 | 3. 학교 수정 | 4. 타입 수정 ");
						menuNo = sc.nextLine();
						
						if(menuNo.equals("1")) {
							cs.updatePhone();
						}else if(menuNo.equals("2")) {
							cs.updateAddr();
						}else if(menuNo.equals("3")) {
							cs.updateSchool();
						}else if(menuNo.equals("4")) {
							cs.updateType();
						}
						
					}else if(menuNo.equals("2")) {
						System.out.println("| 1. 미적분 | 2. 확률과 통계 | 3. 수학1 | 4. 수학2 | 5. 기하");
						menuNo = sc.nextLine();
						
						if(menuNo.equals("1")) {
							//미적분
						}else if(menuNo.equals("2")) {
							//확통
						}else if(menuNo.equals("3")) {
							//수학1
						}else if(menuNo.equals("4")) {
							//수학2
						}else if(menuNo.equals("5")) {
							
						}
						
					}else if(menuNo.equals("3")) {
						System.out.println("| 1. 담당 선생님 수정 | 2. 클래스 수정 | 3. 수학 등급 수정");
						menuNo = sc.nextLine();
						if(menuNo.equals("1")) {
							cs.updateTeacher();
						}else if(menuNo.equals("2")) {
							cs.updateClass();
						}else if(menuNo.equals("3")) {
							cs.updateGrade();
						}
					}
					
				}else if(menuNo.equals("4")) {
					cs.deleteMember();
					
				}
				
				break;
				
				
			}else if (menuNo.equals("5")) {
				System.out.println("종료");
				MemberService.memberInfo = null;
				break;
			}
			
		}
	}
	
	
	private void menu() {
		System.out.println("=======================*** 김수학수학학원 MANAGER MODE*** ===========================");
		System.out.println("");
		System.out.println("  1. 전체 학생 정보 조회 | 2. 단일 회원 정보 조회 | 3. 자습실 조회 |"
				+ " 4. 회원 관리 | 5. 로그아웃 ");
		System.out.println("");
		System.out.println("=================================================================================");
	}
	
}
