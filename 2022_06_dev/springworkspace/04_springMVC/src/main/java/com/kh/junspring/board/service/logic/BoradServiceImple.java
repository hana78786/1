package com.kh.junspring.board.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.junspring.board.domain.Board;
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
	public List<Board> printAllBoard(int currentPage, int limit) {
		List<Board> bList = bStore.selectAllboard(session,currentPage,limit);
		return bList;
	}


	@Override
	public int getTotalCount() {
		int count = bStore.selectTotalCount(session);
		return count;
	}

	
	
}
