package rental.vo;

import java.util.Date;

public class Rental {
	private int reaseNo;
	private int bookNo;
	private String userId;
	private Date reasDate;
	private Date returnDate;
	private String bookName;
	private String userName;
	
	

	public Rental() {}
	
	
	public Rental(int reaseNo, int bookNo, String userId, Date reasDate, Date returnDate, String bookName, String userName) {
		super();
		this.reaseNo = reaseNo;
		this.bookNo = bookNo;
		this.userId = userId;
		this.reasDate = reasDate;
		this.returnDate = returnDate;
		this.bookName = bookName;
		this.userName = userName;
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


	


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "Rental [reaseNo=" + reaseNo + ", bookNo=" + bookNo + ", userId=" + userId + ", reasDate=" + reasDate
				+ ", returnDate=" + returnDate + ", bookName=" + bookName + ", userName=" + userName + "]";
	}
	
	
	

}
