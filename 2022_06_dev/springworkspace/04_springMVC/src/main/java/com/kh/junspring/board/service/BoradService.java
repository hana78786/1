package com.kh.junspring.board.service;

import java.util.List;

import com.kh.junspring.board.domain.Board;

public interface BoradService {

	//게시물등록
	public int registerBoard(Board board);
	
	//게시물 삭제
	public int removeOneByNo(int boardNo);
	//delete from board_tbl where board_no = ?
	
	
	
	//게시판 리스트 출력
	public List<Board> printAllBoard(int currentPage, int limit);

	public int getTotalCount();

	//게시물 상세 출력
	//select * from board_tbl where board_no = ?
	public Board printOneVyNo(Integer boardNo);

	public int modifyBoardOneByNo(Board board);

	

	

}
