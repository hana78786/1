package com.kh.notice.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.notice.model.vo.Notice;

public class NoticeDao {

	public int insertNotice(Notice notice, Connection conn) {
		int result=0;
		PreparedStatement pstmt = null;
		String query="insert into notice_tbl values(seq_noticeno.nextval,?,?,?,default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getSubject());
			pstmt.setString(2, notice.getContents());
			pstmt.setString(3, notice.getMemberId());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public ArrayList<Notice> noticelist(Connection conn) {
		ArrayList<Notice> nList = new ArrayList<Notice>();
		Statement stmt=null;
		ResultSet rset= null;
		String query="select * from notice_tbl order by 1 desc";
		//역순으로 정렬하여 최신글부터 출력되도록 한다
		
		
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			
			
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt(1));
				notice.setSubject(rset.getString(2));
				notice.setContents(rset.getString(3));
				notice.setMemberId(rset.getString(4));
				notice.setRegDate(rset.getDate(5));
				
				nList.add(notice);
			
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		return nList;
	}

	public Notice noticeDetale(Connection conn, String noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql ="select * from notice_tbl where notice_no = ?";
		Notice notice = new Notice();
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(noticeNo));
			rset=pstmt.executeQuery();
			if(rset.next()) {
				notice.setNoticeNo(rset.getInt(1));
				notice.setSubject(rset.getString(2));
				notice.setContents(rset.getString(3));
				notice.setMemberId(rset.getString(4));
				notice.setRegDate(rset.getDate(5));

				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return notice;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		int result=0;
		Statement stmt = null;
		String query="delete NOTICE_TBL where notice_no="+noticeNo;
		
		try {
			stmt=conn.createStatement();
			result=stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int updateNotice(Connection conn, Notice notice) {
		int result=0;
		PreparedStatement pstmt = null;
		String query = "UPDATE NOTICE_TBL SET SUBJECT = ?, CONTENTS = ? WHERE NOTICE_NO = ?" ;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getSubject());
			pstmt.setString(2, notice.getContents());
			pstmt.setInt(3, notice.getNoticeNo());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		
		
		return result;
	}

}
