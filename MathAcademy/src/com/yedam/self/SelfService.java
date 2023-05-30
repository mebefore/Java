package com.yedam.self;

import java.util.Scanner;

import com.yedam.member.MemberDAO;
import com.yedam.member.MemberService;

public class SelfService {
	
	Scanner sc = new Scanner(System.in);
	
	//자습실 내역 확인
	public void getselfInfo() {
		System.out.println("아이디를 입력해주세요.");
		String memberId = sc.nextLine();
		
		Self self = SelfDAO.getInstance().getselfInfo(memberId);
		if(self != null) {
			//아이디 시작날 끝나는날 여부
			System.out.println(self.getMemberId()+"님의 자습실 내역입니다.");
			System.out.print(self.getSelfStart()+" 부터 ");
			System.out.println(self.getSelfFinish()+" 까지 이용 가능합니다.");
			System.out.println("자습실 신청 여부 : " +self.getSelfApply());
			System.out.println("");
		}else {
			System.out.println("");
			System.out.println("자습실 신청 내역이 없습니다.");
			System.out.println("");
		}
		
		
		
		
		
	}
	
	
	//자습실 신청
		String menuNo = sc.nextLine();
		
		
		public void selfApply() {
			

			System.out.println("=======자습실 신청========");
			System.out.println("1. 신청하기 | 2. 뒤로가기");
			
			menuNo = sc.nextLine();
			
			
			if(menuNo.equals("1")) {
				int result = SelfDAO.getInstance().selfApply();
				System.out.println("신청이 완료되었습니다.");
				
				String memberId = MemberService.memberInfo.getMemberId();
				
				//아이디 값 가져와서 SELF 칼럼 데이터 갖고오는 거
				Self result1 = SelfDAO.getInstance().getselfInfo(memberId);
				System.out.print(result1.getSelfStart()+" 부터 ");
				System.out.println(result1.getSelfFinish()+" 까지 이용 가능합니다.");
				System.out.println("");
				
			}else {
				
			}
		}
	
	//자습실 연장
	//신청자가 애초에 아니면 신청 먼저 해주라고 문구가 뜨게
	public void selfExtend() {
		

		System.out.println("=======자습실 연장========");
		System.out.println("자습실 연장은 오늘 날짜로부터 7일 연장됩니다.");
		System.out.println("1. 연장하기 | 2. 뒤로가기");
		
		menuNo = sc.nextLine();
		
		
		if(menuNo.equals("1")) {
			int result = SelfDAO.getInstance().selfExtend();
			
		if(result > 0) {
			System.out.println("연장이 완료되었습니다.");
			System.out.println("");
		}else {
			System.out.println("연장할 자습실 내역이 없습니다. 자습실 신청을 해주세요.");
			System.out.println("");
		}
		
		}
	}
	
	
	//자습실 취소
	//신청자가 아니면 취소할 내역이 없다고 뜨게
	public void selfCancel() {
		Self self = new Self();
		
		System.out.println("=======자습실 취소========");
		System.out.println("1. 취소하기 | 2. 뒤로가기");
		
		menuNo = sc.nextLine();
		
		if(menuNo.equals("1")) {
			int result = SelfDAO.getInstance().selfCancel();
			
		if(result > 0) {
			System.out.println("자습실 취소가 완료되었습니다.");
			System.out.println();
		}else {
			System.out.println("취소할 내역이 없습니다.");
			System.out.println("");
		}
//			System.out.println("취소 완료되었습니다.");
//			
//		}else {
//			int result = 0;
//			System.out.println("취소할 내역이 없습니다.");
//		}
		
		}
		
	}
}
