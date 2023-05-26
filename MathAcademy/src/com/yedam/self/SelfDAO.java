package com.yedam.self;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.Member;
import com.yedam.member.MemberService;

public class SelfDAO extends DAO {
	
private static SelfDAO selfDao = null;

	
	private SelfDAO() {
		
	}
	
	public static SelfDAO getInstance() {
		if(selfDao == null) {
			selfDao = new SelfDAO();
			
		}
		return selfDao;
	}
	
	
	//자습실 신청하기 (일주일 단위)
	public int selfApply () {
		int result = 0;
		try {
			conn();
			String sql ="INSERT INTO SELF VALUES(?, sysdate, sysdate+7, 'Y')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,MemberService.memberInfo.getMemberId());
			
			result = pstmt.executeUpdate();
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//자습실 연장하기
	public int selfExtend() {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE SELF SET SELF_FINISH=SYSDATE+7 WHERE MEMBER_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,MemberService.memberInfo.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//취소
	public int selfCancel() {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM SELF WHERE MEMBER_ID = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,MemberService.memberInfo.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//나의 자습실 내역
		public Self getselfInfo(String memberId) {
			Self self = null;
			try {
				conn();
				String sql = "SELECT * FROM SELF WHERE MEMBER_ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					self = new Self();
					self.setMemberId(rs.getString("member_id"));
					self.setSelfStart(rs.getDate("self_start"));
					self.setSelfFinish(rs.getDate("self_finish"));
					self.setSelfApply(rs.getString("self_apply"));
					
				}
						
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return self;
		}
		
		
		
		

	
}

	
	
	

