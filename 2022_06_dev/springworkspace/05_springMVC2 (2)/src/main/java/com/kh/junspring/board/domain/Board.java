package com.kh.junspring.board.domain;

import java.sql.Date;

public class Board {

	private int boardNo;
	private String boardTitle;
	private String boardContents;
	private String boardWirter;
	private String boardFile;
	private String boardRename;
	private String boardFildpath;
	private int boardCount;
	private Date bCreateDate;
	private Date bUpdateDate;
	private String bStatus;
	
	
	
	public Board() {
		
	}



	public Board(int boardNo, String boardTitle, String boardContents, String boardWirter, String boardFile,
			String boardRename, String boardFildpath, int boardCount, Date bCreateDate, Date bUpdateDate,
			String bStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContents = boardContents;
		this.boardWirter = boardWirter;
		this.boardFile = boardFile;
		this.boardRename = boardRename;
		this.boardFildpath = boardFildpath;
		this.boardCount = boardCount;
		this.bCreateDate = bCreateDate;
		this.bUpdateDate = bUpdateDate;
		this.bStatus = bStatus;
	}



	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContents=" + boardContents
				+ ", boardWirter=" + boardWirter + ", boardFile=" + boardFile + ", boardRename=" + boardRename
				+ ", boardFildpath=" + boardFildpath + ", boardCount=" + boardCount + ", bCreateDate=" + bCreateDate
				+ ", bUpdateDate=" + bUpdateDate + ", bStatus=" + bStatus + "]";
	}



	public int getBoardNo() {
		return boardNo;
	}



	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}



	public String getBoardTitle() {
		return boardTitle;
	}



	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}



	public String getBoardContents() {
		return boardContents;
	}



	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}



	public String getBoardWirter() {
		return boardWirter;
	}



	public void setBoardWirter(String boardWirter) {
		this.boardWirter = boardWirter;
	}



	public String getBoardFile() {
		return boardFile;
	}



	public void setBoardFile(String boardFile) {
		this.boardFile = boardFile;
	}



	public String getBoardRename() {
		return boardRename;
	}



	public void setBoardRename(String boardRename) {
		this.boardRename = boardRename;
	}



	public String getBoardFildpath() {
		return boardFildpath;
	}



	public void setBoardFildpath(String boardFildpath) {
		this.boardFildpath = boardFildpath;
	}



	public int getBoardCount() {
		return boardCount;
	}



	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}



	public Date getbCreateDate() {
		return bCreateDate;
	}



	public void setbCreateDate(Date bCreateDate) {
		this.bCreateDate = bCreateDate;
	}



	public Date getbUpdateDate() {
		return bUpdateDate;
	}



	public void setbUpdateDate(Date bUpdateDate) {
		this.bUpdateDate = bUpdateDate;
	}



	public String getbStatus() {
		return bStatus;
	}



	public void setbStatus(String bStatus) {
		this.bStatus = bStatus;
	}
	
	
	
	
	

}
