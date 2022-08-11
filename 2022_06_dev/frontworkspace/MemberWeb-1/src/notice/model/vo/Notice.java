package notice.model.vo;

import java.sql.Date;

public class Notice {
	private String subject;
	private int noticeNo;
	private String contents;
	private Date regDate;
	private String memberId;
	private int rowNum;
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public Notice(){
		
	}

	public Notice(String subject, int noticeNo, String contents, Date regDate, String memberId) {
		super();
		this.subject = subject;
		this.noticeNo = noticeNo;
		this.contents = contents;
		this.regDate = regDate;
		this.memberId = memberId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getcontents() {
		return contents;
	}

	public void setcontents(String contents) {
		this.contents = contents;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Notice [subject=" + subject + ", noticeNo=" + noticeNo + ", contents=" + contents + ", regDate="
				+ regDate + ", memberId=" + memberId + "]";
	}


		
	
	
	
}
