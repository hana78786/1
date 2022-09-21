package com.kh.pilot.recipe.store.logic1;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.pilot.recipe.domain.RecipeComment;
import com.kh.pilot.recipe.store.RecipeCommentStore;

@Repository
public class RecipeCommentStoreLogic implements RecipeCommentStore {
	
	

	@Override
	public int insertRecipeComment(RecipeComment rComment, SqlSessionTemplate session) {
		int result = session.insert("RecipeMapper.insertRecipeComment",rComment);
		return result;
	}

	@Override
	public int updateOneRecipeComment(RecipeComment rComment, SqlSessionTemplate session) {
		int result= session.update("RecipeMapper.updateOneComment",rComment);
		System.out.println(rComment.toString());
		return result;
	}

	@Override
	public int deleteOneRecipeComment(int commentNo, SqlSessionTemplate session) {
		int result = session.delete("RecipeMapper.deleteOneRecipeComment",commentNo);
		return result;
	}

}
