package com.yedam.Class;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.Member;
import com.yedam.member.MemberService;

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
	
	//단건 조회
	public Member getonlyMember(String memberName) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberName(rs.getString("member_name"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberNum(rs.getInt("member_num"));
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
			pstmt.setInt(4,member.getMemberNum());
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
	
	
}
