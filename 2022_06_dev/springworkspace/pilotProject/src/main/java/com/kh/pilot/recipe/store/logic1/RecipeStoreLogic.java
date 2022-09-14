package com.kh.pilot.recipe.store.logic1;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.pilot.recipe.domain.Recipe;
import com.kh.pilot.recipe.domain.RecipeComment;
import com.kh.pilot.recipe.domain.RecipeMaterial;
import com.kh.pilot.recipe.domain.RecipeStep;
import com.kh.pilot.recipe.domain.RecipeTag;
import com.kh.pilot.recipe.domain.Recommandation;
import com.kh.pilot.recipe.store.RecipeStore;

public class RecipeStoreLogic implements RecipeStore {

	@Override
	public int insertRecipe(Recipe recipe, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertStep(List<RecipeStep> rmList, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertTag(RecipeTag rTag, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMaterial(List<RecipeMaterial> rmList, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Recipe> selectAllRecipe(int currentPage, int limit, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recipe selectOneRecipe(int recipeNo, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecipeStep> selectOneRecipeDetail(int recipeNo, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecipeMaterial> selecttOneRecipeMaterial(int recipeNo, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeTag selectOneRecipeTag(int recipeNo, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectRecipeCommentList(int page, int limit, int recipeNo, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectRecommand(SqlSessionTemplate session, int recipeNo, String memberEmail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countRecommand(SqlSessionTemplate session, int recipeNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RecipeComment> selectRecipeCommentList(int currentPage, int limit, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertRecommand(Recommandation recommand, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRecommand(Recommandation recommand, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOneRecipe(SqlSessionTemplate session, Recipe recipe) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOneRecipeStep(SqlSessionTemplate session, List<RecipeStep> rsList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOneRecipeMaterial(SqlSessionTemplate session, List<RecipeMaterial> rmList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOneRecipeTag(SqlSessionTemplate session, List<RecipeTag> rtList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOneRecipe(SqlSessionTemplate session, int redipeNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
