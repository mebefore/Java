package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class MemberDAO extends DAO {
	
	private static MemberDAO memberDao = null;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if(memberDao == null) {
			memberDao = new MemberDAO();
			
		}
		return memberDao;
	}
	
	//로그인 기능
	public Member login(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberId(id);
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberType(rs.getString("member_type"));
				
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	
	
	
	//학생 정보 조회 - 이름, 아이디, 비번, 주소, 폰번, 학교, (수강일 추후 추가)
	public List<Member>getMemberInfo(){
		List<Member>list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT MEMBER_NAME, MEMBER_ID, MEMBER_PW, MEMBER_NUM, MEMBER_ADDR, MEMBER_SCHOOL\r\n"
					+ "FROM MEMBER\r\n"
					+ "WHERE MEMBER_ID = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				// 이름, 아이디, 비번 , 번호, 주소, 학교
				
				member.setMemberName(rs.getString("member_name"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberNum(rs.getInt("member_num"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberSchool(rs.getString("member_school"));
				list.add(member);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	
	//학생 등록
	public int join(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO member VALUES (?,?,?,?,?,?,'S')";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,member.getMemberName());
			pstmt.setString(2, member.getMemberId());
			pstmt.setString(3, member.getMemberPw());
			pstmt.setInt(4,member.getMemberNum());
			pstmt.setString(5,member.getMemberAddr());
			pstmt.setString(6,member.getMemberSchool());
			//pstmt.setString(7, member.getMemberType());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
}
