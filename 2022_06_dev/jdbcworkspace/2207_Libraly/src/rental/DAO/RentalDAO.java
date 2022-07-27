package rental.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rental.vo.Rental;

public class RentalDAO {
	ArrayList rList = null;

	public ArrayList<Rental> allList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select lease_no, book_no,user_Id,lease_date,return_date,book_name,user_name  from library left join book using (book_no) "
				+ "left join customer using (user_id) ";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			rList = new ArrayList<Rental>();
			while (rset.next()) {
				Rental rental = new Rental();
				rental.setReaseNo(rset.getInt(1));
				rental.setBookNo(rset.getInt(2));
				rental.setUserId(rset.getString(3));
				rental.setReasDate(rset.getDate(4));
				rental.setReturnDate(rset.getDate(5));
				rental.setBookName(rset.getString(6));
				rental.setUserName(rset.getString(7));
				rList.add(rental);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rList;
	}

	public ArrayList<Rental> serchRentalId(String userid, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select lease_no, book_no,user_Id,lease_date,return_date,book_name,user_name  from library left join book using (book_no)" + 
				"left join customer using (user_id) where user_id= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			rset = pstmt.executeQuery();
			
			rList = new ArrayList<Rental>();
			while(rset.next()) {
				Rental rental = new Rental();
				rental.setReaseNo(rset.getInt(1));
				rental.setBookNo(rset.getInt(2));
				rental.setUserId(rset.getString(3));
				rental.setReasDate(rset.getDate(4));
				rental.setReturnDate(rset.getDate(5));
				rental.setBookName(rset.getString(6));
				rental.setUserName(rset.getString(7));
				
				rList.add(rental);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rList;
	}

}
