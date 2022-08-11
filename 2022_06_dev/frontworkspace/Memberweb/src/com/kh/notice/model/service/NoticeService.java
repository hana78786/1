package com.kh.notice.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.notice.DAO.NoticeDao;
import com.kh.notice.model.vo.Notice;
import com.kh.notice.model.vo.PageData;

public class NoticeService {
	private JDBCTemplate jdbcTemplate;
	NoticeDao nDao;
	
	public NoticeService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		nDao= new NoticeDao();
		
	}

	public int insertNotice(Notice notice) {
		int result = 0;
		Connection conn = null;
		System.out.println("여기는 공지쓰기 서비스"+notice.getMemberId());
		
		try {
			conn=jdbcTemplate.createConnection();
			result= nDao.insertNotice(notice,conn);
			
			if(result==1) {
				JDBCTemplate.commit();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JDBCTemplate.rollback();
		}finally {
			JDBCTemplate.close();
		}
		
		
		return result;
	}

	public PageData noticeList(int currentpage) {
		//2개 리턴하기
		//1. 해쉬맵사용
		//2. class를 하나 더 만들기
		ArrayList<Notice> nList = null;
		Connection conn = null;
		String pageNavi = null;
		PageData pd = new PageData();
		
		
		
		try {
			conn=jdbcTemplate.createConnection();
			nList=nDao.noticelist(conn, currentpage);
			pageNavi=nDao.getPageNave(conn, currentpage);
			
			pd.setnList(nList);
			pd.setPageNavi(pageNavi);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close();
		}
		
		return pd;
	}

	public Notice noticeDetail(String noticeNo) {
		Notice notice =null;
		Connection conn = null;
		
		try {
			conn= jdbcTemplate.createConnection();
			notice = nDao.noticeDetale(conn, noticeNo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcTemplate.close();
		}
		
		
		
		return notice;
	}

	public int deleteNotice(int noticeNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn=jdbcTemplate.createConnection();
			result=nDao.deleteNotice(conn,noticeNo);
			if(result==1) {
				JDBCTemplate.commit();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JDBCTemplate.rollback();
		}finally{
			JDBCTemplate.close();
		}
		
		
		return result;
	}

	public Notice noticeModify(String noticeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateNotice(Notice notice) {
		int result=0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result=nDao.updateNotice(conn, notice);
			if(result==1) {
				JDBCTemplate.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JDBCTemplate.rollback();
			e.printStackTrace();
		}finally {
			JDBCTemplate.close();
		}
		
		return result;
	}

}
