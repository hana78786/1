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

	public ArrayList<Notice> noticelist(Connection conn, int currentpage) {
		ArrayList<Notice> nList = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		String query=
				
				"select * from(select row_number() over(order by notice_no desc) as num, notice_tbl.*from notice_tbl) where num between ? and ? "
				;
		//역순으로 정렬하여 최신글부터 출력되도록 한다
		
		int recordCountPerPage=5;
		int start = currentpage*recordCountPerPage-(recordCountPerPage-1);
		int end = currentpage*recordCountPerPage;
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset=pstmt.executeQuery();
			
			
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setRowNum(rset.getInt(1));
				notice.setNoticeNo(rset.getInt(2));
				notice.setSubject(rset.getString(3));
				notice.setContents(rset.getString(4));
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
	
	
	public String getPageNave(Connection conn, int currentPage) {
		//noticeList.jps에 들어갈 페이지 넘버 스트링을 만들어주는 메소드
		//만들때에 전체 게시물의 갯수가 필요하다
		
		
		int recordTotalCount= this.totalCount(conn); // 게시물 전체의 갯수
		int recordCountperPage=5; //한 페이지당 보여줄 게시물의 갯수
//		게시물의 전체 갯수가 28이고 한페이지당 보여주는 게시물의 갯수가 10개이면
//		페이지의 갯수는 3
		int pageNaviTotalcount=0;
		if(recordTotalCount%recordCountperPage!=0) {
			pageNaviTotalcount = recordTotalCount / recordCountperPage+1;
		}else {
			pageNaviTotalcount = recordTotalCount / recordCountperPage;
		}
		
		if(currentPage<1) {
			currentPage=1;
		}else if(currentPage > pageNaviTotalcount) {
		currentPage = pageNaviTotalcount;
		}
	
				
		//1,2,3,4,5[다음]-> 6,7,8,9,10[다음] 
		int pageNaviCountPerPage=5; //한페이지에서 나오는 최대 페이지 갯수
		int startNavi =((currentPage-1)/pageNaviCountPerPage)*pageNaviCountPerPage+1;
		int endNavi=startNavi+pageNaviCountPerPage-1;
		
		if(endNavi>pageNaviTotalcount) {
			endNavi=pageNaviTotalcount;
		}
		
		boolean needPrev=true;
		boolean needNext = true;
		if(startNavi==1) {
			needPrev=false;
		}
		if(endNavi == pageNaviTotalcount) {
			needNext= false;
		}
		
		
		StringBuffer sb = new StringBuffer();
		if(needPrev) {
			sb.append("<a href='/notice/list.do?currentPage="+(startNavi-1)+"'>[이전]</a>");
		}
		
		for(int i = startNavi; i<=endNavi;i++) {
			sb.append("<a href=\"/notice/list.do?currentPage="+i+"\">"+i+"</a>");
		}
		if(needNext) {
			sb.append("<a href='/notice/list.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
		}
		
		
		return sb.toString();
	}
	
	public int totalCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset=null;
		String query="select count(*) from notice_tbl";
		int result = 0 ;
		
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			if(rset.next()) {
				result= rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
		
		return result;
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
