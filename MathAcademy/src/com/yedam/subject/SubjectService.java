package com.yedam.subject;

import java.util.List;

public class SubjectService {
	
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
}
