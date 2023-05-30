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
		
		//subject 전체 조회
		public List<Subject> getMemberSubject(){
			List<Subject> list = new ArrayList<>();
			Subject sj = null;
			
			try {
				conn();
				String sql = "SELECT * FROM SUBJECT ORDER BY 1";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					sj = new Subject();
					sj.setMemberId(rs.getString("member_id"));
					sj.setMemberName(rs.getString("member_name"));
					sj.setCalculus(rs.getString("Calculus"));
					sj.setProbability(rs.getString("Probability"));
					sj.setMath1(rs.getString("Math1"));
					sj.setMath2(rs.getString("Math2"));
					sj.setGeometry(rs.getString("Geometry"));
					list.add(sj);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return list;
			
		}
		
	//미적분 수정
	public int updateCal (Subject sj) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE SUBJECT SET CALCULUS = ? WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sj.getCalculus());
			pstmt.setString(2, sj.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

	//확통 수정
		public int updatePro (Subject sj) {
			int result = 0;
			
			try {
				conn();
				String sql = "UPDATE SUBJECT SET PROBABILITY = ? WHERE MEMBER_ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sj.getProbability());
				pstmt.setString(2, sj.getMemberId());
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return result;
		}
	
		
		//수학1 수정
			public int updateMath1 (Subject sj) {
				int result = 0;
					
				try {
					conn();
					String sql = "UPDATE SUBJECT SET MATH1 = ? WHERE MEMBER_ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sj.getMath1());
					pstmt.setString(2, sj.getMemberId());
						
					result = pstmt.executeUpdate();
						
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					disconn();
				}
				return result;
			}	
	
			
		//수학2 수정
		public int updateMath2 (Subject sj) {
			int result = 0;
					
			try {
				conn();
				String sql = "UPDATE SUBJECT SET MATH2 = ? WHERE MEMBER_ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sj.getMath2());
				pstmt.setString(2, sj.getMemberId());
						
				result = pstmt.executeUpdate();
						
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return result;
		}		
	
		
		//수학2 수정
			public int updateGeo (Subject sj) {
				int result = 0;
							
				try {
					conn();
					String sql = "UPDATE SUBJECT SET GEOMETRY = ? WHERE MEMBER_ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sj.getGeometry());
					pstmt.setString(2, sj.getMemberId());
								
					result = pstmt.executeUpdate();
								
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					disconn();
				}
				return result;
			}			

}