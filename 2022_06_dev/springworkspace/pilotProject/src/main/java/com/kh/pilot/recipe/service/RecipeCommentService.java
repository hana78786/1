package com.kh.pilot.recipe.service;

import com.kh.pilot.recipe.domain.RecipeComment;

public interface RecipeCommentService {
	
	public int registRecipeComment (RecipeComment rComment) ;




	public int  modifyOneRecipeComment(RecipeComment rComment) ;
		
	
	


	public int  removeOneRecipeComment(int commentNo);

}