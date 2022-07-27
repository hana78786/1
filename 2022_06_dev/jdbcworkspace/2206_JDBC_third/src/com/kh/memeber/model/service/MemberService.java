package com.kh.memeber.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.memeber.common.JDBCTmeplate;
import com.kh.memeber.model.dao.MemberDAO;
import com.kh.memeber.model.vo.Member;

public class MemberService {
	private JDBCTmeplate jdbcTemplate;
	private MemberDAO mDao;
	int result = 0;

	public MemberService() {
		jdbcTemplate = JDBCTmeplate.getInstatnce();
		mDao = new MemberDAO();
	}

	public ArrayList<Member> printAll() {
		Connection conn = null;
		ArrayList<Member> mList = null;
		try {
			conn = JDBCTmeplate.createConnection();
			mList = mDao.allMember(conn);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcTemplate.close(); //close는 반드시 닫아야 하기 때문에 finally에 할것
		}
		return mList;
	}

	
	public int resgisterMeber(Member member) {
		Connection conn;

		try {
			conn = JDBCTmeplate.createConnection();
			result = mDao.setMemeber(member, conn);
			
			if(result>0) {
				conn.commit();
			}else {
				jdbcTemplate.rollback(); //롤백 메소드를 만들어서 예외처리 없이 한줄로 롤백 처리 가능
				//conn.rollback(); // 여러 쿼리문을 처리했을때 일부만 성공한다면 0이 리턴된다, 처리된 일부값만 커밋되지 않도록 롤배갛ㄴ다,.
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//conn.rollbadk()// 일부만 성공시 예외처리를 실행된다, 이 경우 여기에 rollback()을 넣어 일부 실행을 막을수있다.
		} finally {
			jdbcTemplate.close();
		}
		return result;

	}

	public Member serchId(String serchId) {
		Member member = new Member();
		try {

			Connection conn = JDBCTmeplate.createConnection();
			member = mDao.serchId(serchId, conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcTemplate.close();
		}
		return member;
	}

	public ArrayList<Member> serchName(String serchName) {
		ArrayList<Member> mList = new ArrayList();
		try {
			Connection conn = JDBCTmeplate.createConnection();
			mList = mDao.serchName(serchName, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcTemplate.close();
		}
		return mList;
	}

	public int delMem(String serchId) {
		Connection conn = null;

		try {

			conn = JDBCTmeplate.createConnection();
			result = mDao.delMem(serchId, conn);
			
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcTemplate.close();
		}
		return result;
	}

	public int checkId(String serchId) {
		Connection conn = null;

		try {
			conn = JDBCTmeplate.createConnection();
			result = mDao.checkId(serchId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcTemplate.close();
		}
		return result;
	}

	public int modifyMem(String serchId, Member member) {
		Connection conn = null;

		try {
			conn = JDBCTmeplate.createConnection();
			result = mDao.modifyMem(serchId, member, conn);
			
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcTemplate.close();
		}
		return result;
	}

	public int serchPwd(String serchPwd, String serchId) {
		Connection conn = null;

		try {
			conn = JDBCTmeplate.createConnection();
			result = mDao.serchPwd(serchPwd, serchId, conn);
			
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcTemplate.close();
		}
		return result;
	}

}
