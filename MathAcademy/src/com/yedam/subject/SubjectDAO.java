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
					String sql = "SELECT * FROM SUBJECT where member_name = ?";
					pstmt = conn.prepareStatement(sql);
					//id로 해도되나? name으로 해야되나;
					
					pstmt.setString(1,MemberService.memberInfo.getMemberName());
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						subject = new Subject();
						//subject.setMemberId(rs.getString("member_id"));
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
			
			
			
		//과목 등급 등록
		public int insertSubject (Subject sub) {
			int result = 0;
			
			try {
				conn();
				String sql = "INSERT INTO SUBJECT VALUES(?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sub.getMemberId());
				pstmt.setString(2, sub.getMemberName());
				pstmt.setString(3, sub.getCalculus());
				pstmt.setString(4, sub.getProbability());
				pstmt.setString(5, sub.getMath1());
				pstmt.setString(6, sub.getMath2());
				pstmt.setString(7, sub.getGeometry());
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return result;
		}
}
