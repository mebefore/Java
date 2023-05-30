package com.yedam.subject;

import java.util.List;
import java.util.Scanner;

public class SubjectService {
	Scanner sc = new Scanner(System.in);
	
	//등급 조회
	public void subjectGrade() {
		System.out.println("====나의 등급 확인=====");
		List<Subject>list = SubjectDAO.getInstance().getSubjectInfo();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMemberName()+ "님의 등급은");
			System.out.println("미적분 : " + list.get(i).getCalculus()+"입니다.");
			System.out.println("확률과 통계 : " + list.get(i).getProbability()+"입니다.");
			System.out.println("수학1 : " + list.get(i).getMath1()+"입니다.");
			System.out.println("수학2 : " + list.get(i).getMath2()+"입니다.");
			System.out.println("기하 : " + list.get(i).getGeometry()+"입니다.");
			
		}
		
	}
	
	
	//SUBJECT 등록
			public void insertSubject() {
				Subject sub = new Subject();
				
				
			System.out.println("=======과목 등록========");
				
			System.out.println(" 학생 아이디 입력 >");
			sub.setMemberId(sc.nextLine());
				
			System.out.println(" 학생 이름 입력 > ");
			sub.setMemberName(sc.nextLine());
				
			System.out.println("미적분 등급 입력 > ");
			sub.setCalculus(sc.nextLine());
				
			System.out.println("확률과 통계 등급 입력 >");
			sub.setProbability(sc.nextLine());
				
			System.out.println("수학1 등급 입력 >");
			sub.setMath1(sc.nextLine());
				
			System.out.println("수학2 등급 입력 >"); 
			sub.setMath2(sc.nextLine());
				
			System.out.println("기하 등급 입력 > ");
			sub.setGeometry(sc.nextLine());
					
			
			int result = SubjectDAO.getInstance().insertSubject(sub);
					
			if(result > 0) {
				System.out.println("등급 정보 입력 완료");
			} else {
				System.out.println("등급 정보를 다시 입력해주세요.");
			}
					
					
					
		}
			
		//SUBJECT 조회
			//1.전체 수강생 조회
			public void getMemberSubject() {
				System.out.println("=========전체 학생 등급 조회=========");
				List<Subject> list = SubjectDAO.getInstance().getMemberSubject();
				
				for(int i=0; i<list.size(); i++) {
					System.out.print(i+1+".");
					System.out.print(" 아이디 : " + list.get(i).getMemberId()+" |");
					System.out.println(" 이름 : " + list.get(i).getMemberName()+" ");
					System.out.print("    미적분 : " + list.get(i).getCalculus()+"|");
					System.out.print(" 확률과 통계 : " + list.get(i).getProbability()+ " |");
					System.out.print(" 수학1 : " + list.get(i).getMath1()+" |");
					System.out.print(" 수학2 : " + list.get(i).getMath2()+" |");
					System.out.println(" 기하 : " + list.get(i).getGeometry());
					
					System.out.println("");
					
					
				}
			}

		//미적분 수정
		public void updateCal() {
			Subject sj = new Subject();
			System.out.println("========미적분 등급========");
				
			System.out.println("| 수정할 회원 아이디 > ");
			sj.setMemberId(sc.nextLine());
				
			System.out.println("| 수정 등급 입력 > ");
			sj.setCalculus(sc.nextLine());
				
			int result = SubjectDAO.getInstance().updateCal(sj);
				
			if(result > 0) {
				System.out.println("등급 수정 완료");
				System.out.println("");
			}else {
				System.out.println("아이디를 다시 확인해주세요.");
			}
		}	
		
		
		
		//확통 수정
			public void updatePro() {
				Subject sj = new Subject();
				System.out.println("========확률과 통계 등급========");
						
				System.out.println("| 수정할 회원 아이디 > ");
				sj.setMemberId(sc.nextLine());
						
				System.out.println("| 수정 등급 입력 > ");
				sj.setProbability(sc.nextLine());
						
				int result = SubjectDAO.getInstance().updatePro(sj);
						
				if(result > 0) {
					System.out.println("등급 수정 완료");
					System.out.println("");
				}else {
					System.out.println("아이디를 다시 확인해주세요.");
				}
			}	
			
			
		//수학1 수정
			public void updateMath1() {
				Subject sj = new Subject();
				System.out.println("========수학1 등급========");
						
				System.out.println("| 수정할 회원 아이디 > ");
				sj.setMemberId(sc.nextLine());
						
				System.out.println("| 수정 등급 입력 > ");
				sj.setMath1(sc.nextLine());
						
				int result = SubjectDAO.getInstance().updateMath1(sj);
						
				if(result > 0) {
					System.out.println("등급 수정 완료");
					System.out.println("");
				}else {
					System.out.println("아이디를 다시 확인해주세요.");
				}
			}				
				

			//수학2 수정
			public void updateMath2() {
				Subject sj = new Subject();
				System.out.println("========수학2 등급========");
						
				System.out.println("| 수정할 회원 아이디 > ");
				sj.setMemberId(sc.nextLine());
						
				System.out.println("| 수정 등급 입력 > ");
				sj.setMath2(sc.nextLine());
						
				int result = SubjectDAO.getInstance().updateMath2(sj);
						
				if(result > 0) {
					System.out.println("등급 수정 완료");
					System.out.println("");
				}else {
					System.out.println("아이디를 다시 확인해주세요.");
				}
			}		

			
			//기하 수정
			public void updateGeo() {
				Subject sj = new Subject();
				System.out.println("========기하 등급========");
						
				System.out.println("| 수정할 회원 아이디 > ");
				sj.setMemberId(sc.nextLine());
						
				System.out.println("| 수정 등급 입력 > ");
				sj.setGeometry(sc.nextLine());
						
				int result = SubjectDAO.getInstance().updateGeo(sj);
						
				if(result > 0) {
					System.out.println("등급 수정 완료");
					System.out.println("");
				}else {
					System.out.println("아이디를 다시 확인해주세요.");
				}
			}			
}