package rental.Server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Member.common.JDBCTemplate;
import rental.DAO.RentalDAO;
import rental.vo.Rental;

public class RentalServer {
	
	JDBCTemplate jdbctemplate;
	RentalDAO rDao;
	int result = 0;
	
	public RentalServer() {
		jdbctemplate=JDBCTemplate.getInstance();
		rDao= new RentalDAO();
		
		
	}

	public ArrayList<Rental> allList() {
		ArrayList<Rental> rList = new ArrayList<Rental>();
		rDao = new RentalDAO();
		Connection conn = null;
		
		try {
			conn = jdbctemplate.createConnection();
			rList = rDao.allList(conn);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rList;
	}

	public ArrayList<Rental> serchId(String userid) {
		ArrayList<Rental> rList = new ArrayList<Rental>();
		Connection conn = null;
		rDao = new RentalDAO();
		
		try {
			conn = jdbctemplate.createConnection();
			rList = rDao.serchRentalId(userid, conn);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rList;
	}
	

}
