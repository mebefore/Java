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
			String sql = "UPDATE SELF \r\n SET SELF_APPLY = 'N', SELF_START = NULL,"
					+ "SELF_FINISH = NULL\r\n WHERE MEMBER_ID = ? ";
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
}

	
	
	

