package com.kh.junspring.board.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.junspring.board.domain.Board;
import com.kh.junspring.board.domain.Reply;
import com.kh.junspring.board.store.BoardStore;

@Repository
public class BoardStoreLogic implements BoardStore{

	@Override
	public int insertBoard(Board board, SqlSessionTemplate session) {
		int result = session.insert("BoardMapper.insertBoard",board);
		return result;
	}
	@Override
	public int insertReply(SqlSessionTemplate session, Reply reply) {
		int result = session.insert("BoardMapper.insertReply",reply);
				return result;
	}

	@Override
	public int updateBoardOneByNo(Board board, SqlSessionTemplate session) {
		int result = session.update("BoardMapper.modifyBoard",board);
		
		return result;
	}
	
	@Override
	public int deleteOnebyNo(SqlSessionTemplate session, int boardNo) {
		int result = session.delete("BoardMapper.deleteBoardOne", boardNo);
		return result;
	}
	
	
	
	@Override
	public int updateBoardCoaunt(SqlSessionTemplate session, int boardNo) {
		int result = session.update("BoardMapper.updateBoardCount", boardNo);
		return result;
	}

	@Override
	public Board selectOnbyNo(Integer boardNo, SqlSessionTemplate session) {
		Board board = session.selectOne("BoardMapper.selectBoardOne", boardNo);
		return board;
	}

	@Override
	public List<Board> selectAllByValue(SqlSessionTemplate session, String searchCondition, String searchValue,  int currentPage, int boardLimit) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("serchValue", searchValue);
		int offset = (currentPage-1)*boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Board> bList = session.selectList("BoardMapper.selectAllByValue",paramMap, rowBounds);
		return bList;
	}

	@Override
	public List<Board> selectAllboard(SqlSessionTemplate session, int currentPage, int limit) {
		//offset currentPage에 의해서 변경되는 값
		//1->1, 2->11, 3->21 게시판 페이지에서 처음의 출력되는 게시물의 번호
		//limit는 한 페이지당 보여주고 싶은 게시물의 갯수
		//지금은 10
		
		//RowBounds란 쿼리문을 변경하지 않고도 페이징을 처리할수 있게 해주는 클래스이며
		//offset과 limit값을 이용해서 동작함, offset은 currentPage에 의해서 변하는 값이고
		//limit값은 고정값이다
	
		//offset은 0, 10 , 20으로 currentPage에서 실제로 2페이지에 출력하는 첫 게시물의 번호인 11 보다 1작다
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds= new RowBounds(offset,limit);
		List<Board> bList = session.selectList("BoardMapper.selectAllBoard",null,rowBounds);
		return bList;
	}
	
	@Override
	public int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("serchValue", searchValue);
		int count = session.selectOne("BoardMapper.selectBoardCount",paramMap);
		return count;
	}
	
	@Override
	public List<Reply> selectAllReply(SqlSessionTemplate session, Integer boardNo) {
		List<Reply> rList = session.selectList("BoardMapper.selecAllreply", boardNo);
		return rList;
	}
	
	@Override
	public int updateOneReply(Reply reply, SqlSessionTemplate session) {
		int result = session.update("BoardMapper.updateOneReply", reply);
		return result;
	}
	
	@Override
	public int deleteReply(String replyNo, SqlSessionTemplate session) {
		int result = session.delete("BoardMapper.deleteOneReply", replyNo);
		return result;
	}
	@Override
	public Reply selectOneReply(int replyNo, SqlSessionTemplate session) {
		Reply reply = session.selectOne("BoardMapper.selectOnereply", replyNo);
		return reply;
	}

	


}
