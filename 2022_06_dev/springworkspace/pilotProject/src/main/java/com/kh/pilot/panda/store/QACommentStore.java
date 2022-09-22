package com.kh.pilot.panda.store;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.pilot.panda.domain.QAComment;

public interface QACommentStore {
	
	public int insertQAComment(QAComment qAComment,SqlSessionTemplate session);

	public int  updateQAComment(QAComment qAComment,SqlSessionTemplate session);


	public int  deleteOneQACommentNo(int qaCommentNo,SqlSessionTemplate session);

}
