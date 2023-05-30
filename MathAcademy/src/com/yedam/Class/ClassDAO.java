package com.yedam.Class;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.Member;
import com.yedam.member.MemberService;
import com.yedam.self.Self;
import com.yedam.subject.Subject;

public class ClassDAO extends DAO {
	
	private static ClassDAO classDao = null;
	
	private ClassDAO() {
		
		
	}
	
	public static ClassDAO getInstance() {
		if(classDao == null) {
			classDao = new ClassDAO();
			
		}return classDao;
	}
	
	//1.전체 수강생 조회
	//관리자가 모든 사람의 정보를 조회해야되는 상황
	public List<Class> getClassInfo(){
		List<Class> list = new ArrayList<>();
		Class cs = null;
		
		try {
			conn();
			//조인해서 member subject 다 보게 할까
			//관리자로 로그인해서 하려면 뭔가 조건이 있어야대는데 'M'이걸로
			String sql = "select * from class ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				cs = new Class();
				cs.setMemberName(rs.getString("member_name"));
				cs.setMemberTeacher(rs.getString("member_teacher"));
				cs.setMemberClass(rs.getString("member_class"));
				cs.setMemberGrade(rs.getString("member_grade"));
				list.add(cs);
				
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
		
	}
	
	
	
	//단건 조회(member)
	public Member getonlyMember(String memberId) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberName(rs.getString("member_name"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberNum(rs.getString("member_num"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberSchool(rs.getString("member_school"));
				member.setMemberType(rs.getString("member_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
		
	}
	
	
	//단건 조회(Class)
		public Class getonlyClass(String memberId) {
			Class cs = null;
			try {
				conn();
				String sql = "SELECT * FROM CLASS WHERE MEMBER_ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					cs = new Class();
					cs.setMemberId(rs.getString("member_id"));
					cs.setMemberName(rs.getString("member_name"));
					cs.setMemberTeacher(rs.getString("member_teacher"));
					cs.setMemberClass(rs.getString("member_class"));
					cs.setMemberGrade(rs.getString("member_grade"));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return cs;
			
		}
		
		
	//단건 조회(subject)
			public Subject getonlySubject(String memberId) {
				Subject sj = null;
				try {
					conn();
					String sql = "SELECT * FROM SUBJECT WHERE MEMBER_ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, memberId);
						
					rs = pstmt.executeQuery();
						
					if(rs.next()) {
						sj = new Subject();
							
						sj.setMemberId(rs.getString("member_id"));
						sj.setMemberName(rs.getString("member_name"));
						sj.setCalculus(rs.getString("calculus"));
						sj.setProbability(rs.getString("probability"));
						sj.setMath1(rs.getString("math1"));
						sj.setMath2(rs.getString("math2"));
						sj.setGeometry(rs.getString("geometry"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					disconn();
				}
				return sj;
				
			}		
	
	
	//회원 삭제
	public int deleteMember(String memberId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE MEMBER WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원 삭제(Class)
		public int deleteClass(String memberName) {
			int result = 0;
			try {
				conn();
				String sql = "DELETE MEMBER WHERE MEMBER_NAME = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,memberName);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return result;
		}
		
		//회원 삭제(Subject)
				public int deleteSubject(String memberId) {
					int result = 0;
					try {
						conn();
						String sql = "DELETE MEMBER WHERE MEMBER_ID = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1,memberId);
						
						result = pstmt.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						disconn();
					}
					return result;
				}
	
	
	//자습실 멤버 조회
	//1.전체 수강생 조회
		//관리자가 모든 사람의 정보를 조회해야되는 상황
		public List<Self> getSelfInfo(){
			List<Self> list = new ArrayList<>();
			Self sf = null;
			
			try {
				conn();
				//조인해서 member subject 다 보게 할까
				//관리자로 로그인해서 하려면 뭔가 조건이 있어야대는데 'M'이걸로
				String sql = "select * from self ORDER BY 1";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					sf = new Self();
//					sf.setSelfMember(rs.getInt("self_member"));
//					sf.setSelfLimit(rs.getInt("self_limit"));
					sf.setMemberId(rs.getString("member_id"));
					sf.setSelfStart(rs.getDate("self_start"));
					sf.setSelfFinish(rs.getDate("self_finish"));
					sf.setSelfApply(rs.getString("self_apply"));
					list.add(sf);
					
				}
						
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return list;
			
		}
	
	
	
	//4-1) 회원 등록
	public int insertMember (Member member) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2,member.getMemberId());
			pstmt.setString(3, member.getMemberPw());
			pstmt.setString(4,member.getMemberNum());
			pstmt.setString(5,member.getMemberAddr());
			pstmt.setString(6,member.getMemberSchool());
			pstmt.setString(7, member.getMemberType());
			//타입은 어캐햐지
			
			result = pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//class 학생 강의 정보 등록
	public int insertClass (Class cs) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO CLASS VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cs.getMemberId());
			pstmt.setString(2, cs.getMemberName());
			pstmt.setString(3, cs.getMemberTeacher());
			pstmt.setString(4, cs.getMemberClass());
			pstmt.setString(5,cs.getMemberGrade());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	//MEMER 1-2)
	//나의 강의 정보
	public List<Class>getClassInfo2(){
		List<Class>list = new ArrayList<>();
		Class CS = null;
		try {
			conn();
			String sql = "SELECT * FROM CLASS WHERE MEMBER_NAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberName());
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				CS = new Class();
				
				//이름, 선생, 클래스, 등급
				
				CS.setMemberName(rs.getString("member_name"));
				CS.setMemberTeacher(rs.getString("member_teacher"));
				CS.setMemberClass(rs.getString("member_Class"));
				CS.setMemberGrade(rs.getString("member_grade"));
				list.add(CS);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//전번 수정
	public int updatePhone(Member member) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE MEMBER SET MEMBER_NUM = ? WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberNum());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//타입 수정
		public int updateType(Member member) {
			int result = 0;
			
			try {
				conn();
				String sql = "UPDATE MEMBER SET MEMBER_TYPE = ? WHERE MEMBER_ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberType());
				pstmt.setString(2, member.getMemberId());
				
				result = pstmt.executeUpdate();
						
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return result;
		}
	
	
	//주소 수정
	public int updateAddr (Member member) {
		int result = 0;
	
		try {
			conn();
			String sql = "UPDATE MEMBER SET MEMBER_ADDR = ? WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberAddr());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//학교 수정
	public int updateSchool (Member member) {
		int result = 0;
	
		try {
			conn();
			String sql = "UPDATE MEMBER SET MEMBER_TYPE = ? WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberType());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//선생님 수정
	public int updateTeacher (Class cs) {
		int result = 0;
	
		try {
			conn();
			String sql = "UPDATE CLASS SET MEMBER_TEACHER = ? WHERE MEMBER_NAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cs.getMemberTeacher());
			pstmt.setString(2, cs.getMemberName());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//학급
		public int updateClass (Class cs) {
			int result = 0;
		
			try {
				conn();
				String sql = "UPDATE CLASS SET MEMBER_CLASS = ? WHERE MEMBER_NAME = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cs.getMemberClass());
				pstmt.setString(2, cs.getMemberName());
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return result;
		}
	
		
		//등급
			public int updateGrade(Class cs) {
				int result = 0;
				
				try {
					conn();
					String sql = "UPDATE CLASS SET MEMBER_GRADE = ? WHERE MEMBER_NAME = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, cs.getMemberGrade());
					pstmt.setString(2, cs.getMemberName());
						
					result = pstmt.executeUpdate();
						
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
						disconn();
				}
				return result;
			}

}