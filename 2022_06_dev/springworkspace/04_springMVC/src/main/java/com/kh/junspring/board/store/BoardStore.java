package com.kh.junspring.board.store;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.junspring.board.domain.Board;

public interface BoardStore {

	int insertBoard(Board board, SqlSessionTemplate session);

}
