package notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import notice.model.vo.Notice;

public class NoticeDao {

	public int insertNotice(Connection conn, Notice notice) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql ="insert into notice_tbl values(SEQ_NOTICENO.NEXTVAL,?,?,?,default)";
		
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, notice.getSubject());
			pstmt.setString(2, notice.getcontents());
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

	public ArrayList<Notice> noticeList(Connection conn) {
		ArrayList<Notice> nList = new ArrayList<Notice>();
		Statement stmt = null;
		ResultSet rset= null;
		String query="select * from notice_tbl order by 1 desc";
		
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt(1));
				notice.setSubject(rset.getString(2));
				notice.setcontents(rset.getString(3));
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
	

	public Notice noticeDetail(Connection conn, int noticeNo) {
		Notice notice = new Notice();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql ="select * from notice_tbl where notice_no=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				notice.setNoticeNo(rset.getInt(1));
				notice.setSubject(rset.getString(2));
				notice.setcontents(rset.getString(3));
				notice.setMemberId(rset.getString(4));
				notice.setRegDate(rset.getDate(5));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return notice;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql="delete notice_tbl where notice_no=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
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

	public int NoticeModify(Connection conn, Notice notice) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql="update notice_tbl set subject=?, contents=? where notice_no=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, notice.getSubject());
			pstmt.setString(2, notice.getcontents());
			pstmt.setInt(3, notice.getNoticeNo());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
