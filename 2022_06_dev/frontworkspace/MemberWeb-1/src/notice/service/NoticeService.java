package notice.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdk.nashorn.internal.scripts.JD;
import member.commne.JDBCTemplate;
import notice.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.PageData;

public class NoticeService {
	
	private JDBCTemplate jdbcTemplate;
	NoticeDao nDao;
	public NoticeService(){
		jdbcTemplate = JDBCTemplate.getInstance();
		nDao = new NoticeDao();
	}
	public int insertNotice(Notice notice) {
		int result=0;
		Connection conn = null;
		
		
		try {
			conn = jdbcTemplate.createConnection();
			result = nDao.insertNotice(conn, notice);
			
			if(result==1) {
				JDBCTemplate.commit();
			}
			
			
			
		} catch (SQLException e) {
			JDBCTemplate.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
		
		
		
		
		
		return result;
	}

	
	public PageData noticeList(int currentPage) {
		ArrayList<Notice> nList=null;
		Connection conn= null;
		PageData pd = new PageData();
		
		try {
			conn=jdbcTemplate.createConnection();
			nList=nDao.noticeList(conn, currentPage);
			
			String pageNavi = nDao.getpageNavi(conn, currentPage);
			pd.setnList(nList);
			pd.setPagenavi(pageNavi);

			
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close();
		}
		
		
		return pd;
	}
	
	
	public Notice noticeDetail(int noticeNo) {
		Notice notice=null;
		Connection conn = null;
		
		try {
			conn=jdbcTemplate.createConnection();
			notice=nDao.noticeDetail(conn, noticeNo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close();
		}

		
		return notice;
	}
	public int deleteNotice(int noticeNo) {
		int result=0;
		Connection conn = null;
		
		try {
			conn=jdbcTemplate.createConnection();
			result = nDao.deleteNotice(conn, noticeNo);
			if(result==1) {
				JDBCTemplate.commit();
			}
			
		} catch (SQLException e) {
			JDBCTemplate.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close();
		}
		
		return result;
	}
	public int NoticeModify(Notice notice) {
		int result=0;
		Connection conn = null;
		
		try {
			conn=jdbcTemplate.createConnection();
			result = nDao.NoticeModify(conn, notice);
			if(result==1) {
				JDBCTemplate.commit();
			}
			
		} catch (SQLException e) {
			JDBCTemplate.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close();
		}
		
		return result;
	}
	
	

}
