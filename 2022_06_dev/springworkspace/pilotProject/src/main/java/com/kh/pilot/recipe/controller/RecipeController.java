package com.kh.pilot.recipe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.pilot.recipe.domain.Recipe;
import com.kh.pilot.recipe.domain.RecipeMaterial;
import com.kh.pilot.recipe.domain.RecipeStep;
import com.kh.pilot.recipe.domain.RecipeTag;

public class RecipeController {

	public ModelAndView showRecipeWrite(ModelAndView mv, HttpSession session) {
		return mv;

	}

	public ModelAndView registRecipe (Recipe recipe, RecipeStep rStep, 
				RecipeMaterial rMaterial,RecipeTag rTag, ModelAndView mv,
				MultipartFile mainPic,MultipartFile detailPic1,
				MultipartFile detailPic2,MultipartFile detailPic3,
				MultipartFile detailPic4,MultipartFile detailPic5,
				MultipartFile detailPic6,MultipartFile detailPic7,
				MultipartFile detailPic8,MultipartFile detailPic9,
				MultipartFile detailPic10,HttpSession session 
				) {
			return mv;
	}

	public ModelAndView RecipeList(ModelAndView mv, int page) {
		return mv;
	}

	public ModelAndView viewRecipeStep(int recipeNo, HttpSession session,
			ModelAndView mv) {
		return mv;
	}

	public ModelAndView recipeModifyView(ModelAndView mv, Integer recipeNo) {
		return mv;
	}

	public ModelAndView modifyRecipe(Recipe recipe, RecipeStep rStep,RecipeTag rTag,
			MultipartFile mainPic,MultipartFile detailPic1,
			MultipartFile detailPic2,MultipartFile detailPic3,
			MultipartFile detailPic4,MultipartFile detailPic5,
			MultipartFile detailPic6,MultipartFile detailPic7,
			MultipartFile detailPic8,MultipartFile detailPic9,
			MultipartFile detailPic10,HttpSession session ,ModelAndView mv
				) {
		return mv;
		
	}

	public ModelAndView setRecommand(int recipeNo,HttpSession session,ModelAndView mv) {
		return mv;
		
	}

	public ModelAndView removeRecommand(int recipeNo,HttpSession session,ModelAndView mv) {
		return mv;
		
	}

	public ModelAndView removeRecipe(HttpSession session,ModelAndView mv,int recipyNo,String memberEmail) {
		return mv;
		
	}
	
}
