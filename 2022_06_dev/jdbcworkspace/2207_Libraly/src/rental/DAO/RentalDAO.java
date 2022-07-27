package rental.DAO;

import java.util.Date;

public class RentalDAO {
	
	private int reaseNo;
	private int bookNo;
	private String userId;
	private Date reasDate;
	private Date returnDate;
	
	
	public RentalDAO(int reaseNo, int bookNo, String userId, Date reasDate, Date returnDate) {
		super();
		this.reaseNo = reaseNo;
		this.bookNo = bookNo;
		this.userId = userId;
		this.reasDate = reasDate;
		this.returnDate = returnDate;
	}


	public int getReaseNo() {
		return reaseNo;
	}


	public void setReaseNo(int reaseNo) {
		this.reaseNo = reaseNo;
	}


	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Date getReasDate() {
		return reasDate;
	}


	public void setReasDate(Date reasDate) {
		this.reasDate = reasDate;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	@Override
	public String toString() {
		return "RentalDAO [reaseNo=" + reaseNo + ", bookNo=" + bookNo + ", userId=" + userId + ", reasDate=" + reasDate
				+ ", returnDate=" + returnDate + "]";
	}
	
	
	

}
