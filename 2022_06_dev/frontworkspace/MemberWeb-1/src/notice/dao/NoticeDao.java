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

	public ArrayList<Notice> noticeList(Connection conn, int currentPage) {
		ArrayList<Notice> nList = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		String query="select * from (select row_number() over(order by notice_no desc) as num ,notice_tbl.* from notice_tbl) where num between ? and ?";
		int recordCountPerPage = 5;
		int start= currentPage* recordCountPerPage -(recordCountPerPage-1);
		
		int end = currentPage* recordCountPerPage;

		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,start );
			pstmt.setInt(2, end);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setRowNum(rset.getInt(1));
				notice.setNoticeNo(rset.getInt(2));
				notice.setSubject(rset.getString(3));
				notice.setcontents(rset.getString(4));
				notice.setMemberId(rset.getString(5));
				notice.setRegDate(rset.getDate(6));
				
				nList.add(notice);

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		
		
		return nList;
	}
	
	public String getpageNavi(Connection conn,int currentPage) {
		StringBuffer sb = new StringBuffer();
		int recordTotalPage=countNotice(conn);
		int recorodCountperPage=5;
		
		int pageNavitotalCount=0;
		if(recordTotalPage%recorodCountperPage!=0) {
			pageNavitotalCount=recordTotalPage/recorodCountperPage+1;
		}else {
			pageNavitotalCount=recordTotalPage/recorodCountperPage;
		}
		
		
		if(currentPage<0) {
			currentPage=1;
		}else if(currentPage>pageNavitotalCount) {
			currentPage=pageNavitotalCount;
		}
		
		
		
		int pageNaviCountPerPage=5;
		int startNavi = ((currentPage-1)/pageNaviCountPerPage)*pageNaviCountPerPage+1;
		int endNavi = startNavi+pageNaviCountPerPage-1;
		
		
		if (endNavi>pageNavitotalCount) {
			endNavi=pageNavitotalCount;
		}
		
		boolean needPrev=true;
		boolean needNext=true;
		
		if(startNavi==1) {
			needPrev=false;
		}
		
		if(endNavi==pageNavitotalCount) {
			needNext=false;
		}
		
		
		if(needPrev) {		
		sb.append("<a href='/notice/list.do?currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i=startNavi;i<=endNavi;i++) {
			sb.append("<a href='/notice/list.do?currentPage="+i+"'> [ "+i+"]</a>");
		}
		if(needNext) {
			sb.append("<a href='/notice/list.do?currentPage="+(endNavi+1)+"'> [다음] </a>");	
		}
		
		
		
		
		
		return sb.toString();
		
	}
	
	public int countNotice(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from notice_tbl";
		
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
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
