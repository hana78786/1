package com.kh.memeber.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.memeber.common.JDBCTemplate;
import com.kh.memeber.model.dao.MemberDAO;
import com.kh.memeber.model.vo.Member;

public class Service {
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;

	public Service() {
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}

	public ArrayList<Member> allMember() {
		Connection conn = null;

		ArrayList<Member> mList = null;

		try {
			conn = jdbcTemplate.createConnection();
			mList = mDao.allMember(conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTemplate.close();
		}

		return mList;
	}

	public int setMemeber(Member member) {
		Connection conn = null;
		int result = 0;

		try {
			conn = jdbcTemplate.createConnection();
			result = mDao.setMemeber(conn, member);
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTemplate.close();
		}

		return result;
	}

	public Member serchId(String serchId) {
		Connection conn = null;
		Member member = new Member();

		try {
			conn = jdbcTemplate.createConnection();
			member = mDao.serchId(serchId, conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTemplate.close();

		}
		return member;

	}

	public ArrayList<Member> serchName(String serchName) {
		Connection conn = null;

		ArrayList<Member> mList = null;

		try {
			conn = jdbcTemplate.createConnection();
			mList = mDao.serchName(serchName, conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTemplate.close();
		}

		return mList;
	}

	public int delMem(String serchId) {
		Connection conn = null;
		int result = 0;

		try {
			conn = jdbcTemplate.createConnection();
			result = mDao.delMem(conn, serchId);
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTemplate.close();
		}

		return result;
	}

	public int checkId(String serchId) {
		Connection conn = null;
		int result = 0;

		try {
			conn = jdbcTemplate.createConnection();
			result = mDao.checkId(conn, serchId);
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTemplate.close();
		}

		return result;
	}

	public int modifyMem(String serchId, Member member) {
		Connection conn = null;
		int result = 0;

		try {
			conn = jdbcTemplate.createConnection();
			result = mDao.modifyMem(serchId, member,conn);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTemplate.close();
		}

		return result;
	}

	public int serchPwd(String serchPwd, String serchId) {
		Connection conn = null;
		int result = 0;

		try {
			conn = jdbcTemplate.createConnection();
			result = mDao.serchPwd(serchPwd, serchId,conn);
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTemplate.close();
		}

		return result;
	}
}
