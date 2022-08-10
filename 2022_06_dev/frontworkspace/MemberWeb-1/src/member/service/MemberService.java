package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdk.nashorn.internal.scripts.JD;
import member.Dao.MemberDao;
import member.commne.JDBCTemplate;
import member.model.Member;

public class MemberService {

	private JDBCTemplate jdbcTemplate;
	MemberDao mDao;
	public MemberService() {
		jdbcTemplate=JDBCTemplate.getInstance();
		mDao = new MemberDao();
		
	}
	
	
	public int loginCheck(String memberId, String memberPw) {
		Connection conn=null;
		int result=0;
		try {
			conn = jdbcTemplate.createConnection();
			result=mDao.login(memberId,memberPw,conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close();
		}
		
		return result;
	}


	public int insertMember(Member member){
		int result=0;
		Connection conn;
			try {	
			conn = jdbcTemplate.createConnection() ;
			result=mDao.insertMember(member, conn);
			if(result>0) {
			JDBCTemplate.commit();
			}
			} catch (SQLException e) {
				JDBCTemplate.rollback();
				e.printStackTrace();
			}
			finally{
				JDBCTemplate.close();
			}
			
		
		return result;
	}


	public ArrayList<Member> allList() {
		ArrayList<Member> mList=null;
		Connection conn=null;
		try {
			conn = jdbcTemplate.createConnection();
			mList=mDao.allList(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally{
			JDBCTemplate.close();
		}
		
		return mList;
		
	}


	public Member mypage(String memberId) {
		Member member=null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			member=mDao.mypage(memberId,conn);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally{
			JDBCTemplate.close();
		}
		return member;
	}


	public int modifyMember(Member member) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn= jdbcTemplate.createConnection();
			result=mDao.modifyMember(member, conn);
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


	public int deleteMember(String memberId) {
		int result=0;
		Connection conn = null;
		
		try {
			conn=jdbcTemplate.createConnection();
			result=mDao.deleteMember(memberId, conn);
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

	
	
	

}


