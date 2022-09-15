package com.kh.pilot.recipe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.pilot.recipe.domain.Recipe;
import com.kh.pilot.recipe.domain.RecipeMaterial;
import com.kh.pilot.recipe.domain.RecipeStep;
import com.kh.pilot.recipe.domain.RecipeTag;
import com.kh.pilot.recipe.service.RecipeService;

@Controller
public class RecipeController {
	private RecipeService rService;
	


	@RequestMapping(value="/recipe/writeView.kh", method = RequestMethod.GET)
	public ModelAndView showRecipeWrite(ModelAndView mv, HttpSession session) {
		mv.setViewName("/recipe/recipeWirteForm");
		return mv;

	}

	@RequestMapping(value="/recipe/regist.do", method = RequestMethod.POST)
	public ModelAndView registRecipe(
			@ModelAttribute Recipe recipe,@ModelAttribute RecipeStep rStep,@ModelAttribute RecipeMaterial rMaterial,@ModelAttribute RecipeTag rTag,
			ModelAndView mv, 
			@RequestParam(value="mainPicture", required = false) MultipartFile mainPic, 
			@RequestParam(value="recipePicture1", required = false)MultipartFile detailPic1, 
			@RequestParam(value="recipePicture2", required = false)MultipartFile detailPic2,
			@RequestParam(value="recipePicture3", required = false)MultipartFile detailPic3,
			@RequestParam(value="recipePicture4", required = false)MultipartFile detailPic4, 
			@RequestParam(value="recipePicture5", required = false)MultipartFile detailPic5,
			@RequestParam(value="recipePicture6", required = false)MultipartFile detailPic6,
			@RequestParam(value="recipePicture7", required = false)MultipartFile detailPic7, 
			@RequestParam(value="recipePicture8", required = false)MultipartFile detailPic8, 
			@RequestParam(value="recipePicture9", required = false)MultipartFile detailPic9, 
			@RequestParam(value="recipePicture10", required = false)MultipartFile detailPic10,
			HttpSession session) {
		
		int result = rService.registRecipe(recipe);
		int result1 = rService.registMaterial(rmList);
		int result2 = rService.registStep(rsList);
		int result3 = rService.registTag(rTag);
		
		return mv;
	}

	public ModelAndView RecipeList(ModelAndView mv, int page) {
		return mv;
	}

	public ModelAndView viewRecipeStep(int recipeNo, HttpSession session, ModelAndView mv) {
		return mv;
	}

	public ModelAndView recipeModifyView(ModelAndView mv, Integer recipeNo) {
		return mv;
	}

	public ModelAndView modifyRecipe(Recipe recipe, RecipeStep rStep, RecipeTag rTag, MultipartFile mainPic,
			MultipartFile detailPic1, MultipartFile detailPic2, MultipartFile detailPic3, MultipartFile detailPic4,
			MultipartFile detailPic5, MultipartFile detailPic6, MultipartFile detailPic7, MultipartFile detailPic8,
			MultipartFile detailPic9, MultipartFile detailPic10, HttpSession session, ModelAndView mv) {
		return mv;

	}

	public ModelAndView setRecommand(int recipeNo, HttpSession session, ModelAndView mv) {
		return mv;

	}

	public ModelAndView removeRecommand(int recipeNo, HttpSession session, ModelAndView mv) {
		return mv;

	}

	public ModelAndView removeRecipe(HttpSession session, ModelAndView mv, int recipyNo, String memberEmail) {
		return mv;

	}

}
