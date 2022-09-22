package com.kh.pilot.panda.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.pilot.panda.domain.QAComment;
import com.kh.pilot.panda.service.QACommentService;
import com.kh.pilot.panda.store.QACommentStore;

@Service
public class QACommentServiceImpl implements QACommentService {
	@Autowired
	QACommentStore qCStore;
	@Autowired
	SqlSessionTemplate session;

	@Override
	public int registQAComment(QAComment qAComment) {
		int result=qCStore.insertQAComment(qAComment, session);
		return result;
	}

	@Override
	public int modifyQAComment(QAComment qAComment) {
		int result=qCStore.updateQAComment(qAComment, session);
		return result;
	}

	@Override
	public int reomoveOneQACommentNo(int qaCommentNo) {
		int result = qCStore.deleteOneQACommentNo(qaCommentNo, session);
		return result;
	}

}
