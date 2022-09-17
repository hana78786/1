package com.kh.pilot.recipe.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
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
	@Autowired
	private RecipeService rService;

	/**
	 * 레시피 등록 창 연결
	 * 
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/recipe/writeView.do", method = RequestMethod.GET)
	public ModelAndView showRecipeWrite(ModelAndView mv, HttpSession session) {
		mv.setViewName("/recipe/recipeWirteForm");
		return mv;

	}

	/**
	 * 레시피 등록 컨트롤러
	 * 
	 * @param recipe
	 * @param rStep
	 * @param rMaterial
	 * @param rTag
	 * @param mv
	 * @param mainPic
	 * @param detailPic1
	 * @param detailPic2
	 * @param detailPic3
	 * @param detailPic4
	 * @param detailPic5
	 * @param detailPic6
	 * @param detailPic7
	 * @param detailPic8
	 * @param detailPic9
	 * @param detailPic10
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/recipe/regist.do", method = RequestMethod.POST)
	public ModelAndView registRecipe(@ModelAttribute Recipe recipe, @ModelAttribute RecipeStep rStep,
			@ModelAttribute RecipeMaterial rMaterial, @ModelAttribute RecipeTag rTag, ModelAndView mv,
			@RequestParam(value = "mainPicture", required = false) MultipartFile mainPicture,
			@RequestParam(value = "recipePicture", required = false) List<MultipartFile> recipePicture,
			HttpSession session, HttpServletRequest request) {
		try {
			// 레시피 전달

			// 사진 저장코드
			String mainPic = mainPicture.getOriginalFilename();
			if (!mainPic.equals("")) {

				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\recipeImg"; // 내가 저장할 폴더
				File file = new File(savePath); // 파일 객체 만들기

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String mainPicRename = sdf.format(new Date(System.currentTimeMillis())) + "."
						+ mainPic.substring(mainPic.lastIndexOf(".") + 1);

				if (!file.exists()) { // 경로에 savePath가 없을땐
					file.mkdir(); // 경로 만들기
				}

				mainPicture.transferTo(new File(savePath + "\\" + mainPicRename));// 파일을 buploadFile경로에 저장
				recipe.setMainPic(mainPic);
				recipe.setMainPicRename(mainPicRename);

			}
			// 사진 저장 코드 종료

			int result = rService.registRecipe(recipe);

			// 레시피 재료 리스트 만들어서 전달하기
			ArrayList<RecipeMaterial> rmList = new ArrayList<RecipeMaterial>();
			String amount[] = rMaterial.getAmount().split(",");
			String material[] = rMaterial.getMaterial().split(",");
			for (int i = 0; i < material.length; i++) {

				// 재료나 수량이 비어있지 않을때만 List에 저장
				if (!amount[i].equals("") && !material[i].equals("")) {
					RecipeMaterial rMaterialOne = new RecipeMaterial();
					rMaterialOne.setAmount(amount[i]);
					rMaterialOne.setMaterial(material[i]);
					rMaterialOne.setMaterialOrder(i + 1);
					rmList.add(rMaterialOne);
				}

			}
			int result1 = rService.registMaterial(rmList);

			// 레시피 순서 리스트 만들어서 전달하기
			ArrayList<RecipeStep> rsList = new ArrayList<RecipeStep>();
			String arrDescription[] = rStep.getRecipeDescription().split(",");

			///// 레시피 순서 사진 저장코드


			for (int i = 0; i < recipePicture.size(); i++) {
				String recipePic = recipePicture.get(i).getOriginalFilename();
				String recipePicRename = "";
				if (!recipePic.equals("")) {

					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\recipeImg"; // 내가 저장할 폴더
					File file = new File(savePath); // 파일 객체 만들기

					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					recipePicRename = sdf.format(new Date(System.currentTimeMillis())) + "stepImg" + i + "."
							+ recipePic.substring(recipePic.lastIndexOf(".") + 1);// 동시에여러사진이올라가기에 이름에 순서추가해줌

					if (!file.exists()) { // 경로에 savePath가 없을땐
						file.mkdir(); // 경로 만들기
					}
					recipePicture.get(i).transferTo(new File(savePath + "\\" + recipePicRename));// 파일을 buploadFile경로에 저장
					///// 여기까지 사진 저장코드/////

				}
				// 여기서부터 레시피 step 테이블에 저장할 값 List화 시키는 코드
				RecipeStep rStepOne = new RecipeStep();
				if (i < arrDescription.length) {
					if (!arrDescription[i].equals("")) {
						rStepOne.setRecipeDescription(arrDescription[i]);
					}
				}
				rStepOne.setRecipePic(recipePic);
				rStepOne.setRecipePicRename(recipePicRename);
				rStepOne.setRecipeOrder(i + 1);

				
					rsList.add(rStepOne);
				
			System.out.println(i);
			}
			System.out.println("여기는 나오니?");

			int result2 = rService.registStep(rsList); // 레시피 순서저장 코드 종료
			System.out.println(result2);

			// 레시피 태그 true false로 받음
			int result3 = rService.registTag(rTag);

		} catch (

		Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/error");
		}
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
