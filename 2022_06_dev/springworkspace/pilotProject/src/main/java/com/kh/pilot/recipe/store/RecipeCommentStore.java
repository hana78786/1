package com.kh.pilot.recipe.store;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.pilot.recipe.domain.RecipeComment;

public interface RecipeCommentStore {
	
	
	public int insertRecipeComment(RecipeComment rComment, SqlSessionTemplate session) ;


	public int updateOneRecipeComment(RecipeComment rComment,SqlSessionTemplate session);


	public int deleteOneRecipeComment(int commentNo,SqlSessionTemplate session);

}
