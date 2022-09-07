package com.kh.junspring.board.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.junspring.board.domain.Board;
import com.kh.junspring.board.store.BoardStore;

@Repository
public class BoardStoreLogic implements BoardStore{

	@Override
	public int insertBoard(Board board, SqlSessionTemplate session) {
		int result = session.insert("BoardMapper.insertBoard",board);
		return result;
	}

}
