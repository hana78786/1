package com.kh.pilot.panda.service;

import java.util.List;

import com.kh.pilot.panda.domain.QA;
import com.kh.pilot.panda.domain.QAComment;

public interface QAService {
	
	public int registQandA(QA qA);

	public int  modifyQandA(QA qA);

	public List<QA>  allQAList(int currentPage, int limit);

	public int  reomoveOneQandANo(int qaNo) ;

	public QA  printOneQANo(int qaNo) ;

	public  List<QAComment> allQACommentList(int currentPage, int limit);

}
