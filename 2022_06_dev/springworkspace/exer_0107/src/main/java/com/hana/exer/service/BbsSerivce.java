package com.hana.exer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hana.exer.doamin.Bbs;


public interface BbsSerivce {

	List<Bbs> bbsTitle();

	int resgitBbs(Bbs bbs);
	


}
