package book.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.vo.Book;

public class BookDAO {
	ArrayList<Book> bList = null;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "student";
	private final String PASSWORD="student";
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	Book book = null;

	public ArrayList<Book> allBook() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from book";
		bList=new ArrayList<Book>();
		
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt=conn.prepareStatement(query);
			rset =pstmt.executeQuery();
			
			while(rset.next()) {
				book = new Book();
				book.setBookNumber(rset.getInt(1));
				book.setBookName(rset.getString(2));
				book.setBookWriter(rset.getString(3));
				book.setBookPrice(rset.getInt(4));
				book.setPublisher(rset.getString(5));
				book.setGenre(rset.getString(6));
				bList.add(book);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		return bList;
	}

}
