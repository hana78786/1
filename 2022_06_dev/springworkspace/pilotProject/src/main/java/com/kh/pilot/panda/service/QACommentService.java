package com.kh.pilot.panda.service;

import com.kh.pilot.panda.domain.QAComment;

public interface QACommentService {
	
	public int registQAComment(QAComment qAComment);

	public int modifyQAComment(QAComment qAComment);

	public int reomoveOneQACommentNo(int qaCommentNo);

}
