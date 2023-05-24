package com.yedam.subject;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.MemberService;

public class SubjectDAO extends DAO{

	private static SubjectDAO subjectDao = null;
	
	private SubjectDAO() {
		
	}
	
	public static SubjectDAO getInstance() {
		if(subjectDao == null) {
			subjectDao = new SubjectDAO();
		}
		return subjectDao;
	}
	
	//학생 과목 등급 조회
			//로그인 된 상태에서 과목 등급 조회
			public List<Subject> getSubjectInfo(){
				List<Subject> list = new ArrayList<>();
				Subject subject = null;
				try {
					conn();
					String sql = "SELECT * FROM SUBJECT where member_id = ?";
					pstmt = conn.prepareStatement(sql);
					//id로 해도되나? name으로 해야되나;
					
					pstmt.setString(1,MemberService.memberInfo.getMemberId());
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						subject = new Subject();
						subject.setMemberId(rs.getString("member_id"));
						subject.setMemberName(rs.getString("member_name"));
						subject.setCalculus(rs.getString("calculus"));
						subject.setProbability(rs.getString("probability"));
						subject.setMath1(rs.getString("math1"));
						subject.setMath2(rs.getString("math2"));
						subject.setGeometry(rs.getString("geometry"));
						list.add(subject);
						
					}
							
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					disconn();
				}
				return list;
			}
}
