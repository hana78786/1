package com.kh.junspring.board.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.junspring.board.domain.Board;
import com.kh.junspring.board.domain.Reply;
import com.kh.junspring.board.service.BoradService;
import com.kh.junspring.board.store.BoardStore;

@Service
public class BoradServiceImple implements BoradService {
	@Autowired
	SqlSessionTemplate session;
	@Autowired
	BoardStore bStore;
	

	@Override
	public int registerBoard(Board board) {
		int result = bStore.insertBoard(board, session);
		return result;
	}

	@Override
	public int modifyBoardOneByNo(Board board) {
		int result = bStore.updateBoardOneByNo(board, session);
		return result;
	}

	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int count = bStore.selectTotalCount(session, searchCondition, searchValue);
		return count;
	}


	@Override
	public int removeOneByNo(int boardNo) {
		int result = bStore.deleteOnebyNo(session, boardNo);
		return result;
	}

	@Override
	public int registerReply(Reply reply) {
		int result =bStore.insertReply(session, reply);
		return result;
	}

	@Override
	public Board printOneVyNo(Integer boardNo) {
		Board board = bStore.selectOnbyNo(boardNo, session);
		int result = 0 ;
		if(board != null) {
			result = bStore.updateBoardCoaunt(session, boardNo);
		}
		return board;
	}


	@Override
	public List<Board> printAllBoard(int currentPage, int limit) {
		List<Board> bList = bStore.selectAllboard(session,currentPage,limit);
		return bList;
	}

	@Override
	public List<Board> printAllByValue(String searchCondition, String searchValue, int currentPage, int boardLimit) {
		List<Board> bList = bStore.selectAllByValue(session,searchCondition, searchValue, currentPage,boardLimit);
		return bList;
	}

	@Override
	public List<Reply> PrintAllReply(Integer boardNo) {
		List<Reply> rList = bStore.selectAllReply(session,boardNo);
		return rList;
	}



	

	
	
}
