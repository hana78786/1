package com.kh.junspring.board.service.logic;

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

}
