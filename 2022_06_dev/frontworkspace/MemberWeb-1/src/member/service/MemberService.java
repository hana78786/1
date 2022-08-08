package member.service;

import java.sql.Connection;
import java.util.ArrayList;

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
		Connection conn = jdbcTemplate.createConnection(); 
		int result=mDao.login(memberId,memberPw,conn);
		
		
		return result;
	}


	public int insertMember(Member member) {
		Connection conn = jdbcTemplate.createConnection() ;
				
		int result=mDao.insertMember(member, conn);
		
		return result;
	}


	public ArrayList<Member> allList() {
		ArrayList<Member> mList;
		Connection conn= jdbcTemplate.createConnection();
		mList=mDao.allList(conn);
		
		
		
		return mList;
	}


}
