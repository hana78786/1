package com.kh.junspring.board.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.junspring.board.domain.Board;
import com.kh.junspring.board.domain.Reply;

public interface BoardStore {

	public int insertBoard(Board board, SqlSessionTemplate session);

	public List<Board> selectAllboard(SqlSessionTemplate session,  int curretnPage, int limit);
	
	public int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue);

	public Board selectOnbyNo(Integer boardNo, SqlSessionTemplate session);

	public int deleteOnebyNo(SqlSessionTemplate session, int boardNo);

	public int updateBoardOneByNo(Board board, SqlSessionTemplate session);

	public List<Board> selectAllByValue(SqlSessionTemplate session, String searchCondition, String searchValue,  int currentPage, int boardLimit);
	
	public int updateBoardCoaunt(SqlSessionTemplate session, int boardNo);

	public int insertReply(SqlSessionTemplate session, Reply reply);

	public List<Reply> selectAllReply(SqlSessionTemplate session, Integer boardNo);

	public int updateOneReply(Reply reply, SqlSessionTemplate session);

	public int deleteReply(String replyNo, SqlSessionTemplate session);
	
	
}
