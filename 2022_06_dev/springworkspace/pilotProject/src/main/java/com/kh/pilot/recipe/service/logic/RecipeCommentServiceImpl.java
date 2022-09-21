package com.kh.pilot.recipe.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.pilot.recipe.domain.RecipeComment;
import com.kh.pilot.recipe.service.RecipeCommentService;
import com.kh.pilot.recipe.store.RecipeCommentStore;
@Service
public class RecipeCommentServiceImpl implements RecipeCommentService {
	@Autowired
	private RecipeCommentStore rcStore;
	@Autowired
	private SqlSessionTemplate session;
	
	/**코멘트등록*/
	public int registRecipeComment (RecipeComment rComment) {
		int result = rcStore.insertRecipeComment(rComment, session);
		return result;
		
	};



	/**코멘트수정*/
	public int  modifyOneRecipeComment(RecipeComment rComment) {
		int result =rcStore.updateOneRecipeComment(rComment, session);
		return result;
		
	};
		
	
	

	/**코멘트 삭제*/
	public int  removeOneRecipeComment(int commentNo) {
		int result =rcStore.deleteOneRecipeComment(commentNo, session);
		return result;
		
	};


}
