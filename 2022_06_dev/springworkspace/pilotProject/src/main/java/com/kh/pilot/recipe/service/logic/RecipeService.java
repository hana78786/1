package com.kh.pilot.recipe.service.logic;

public interface RecipeService {


	public int registRecipe(recipe:Recipe);

	public int registDetail(rdList:List<RecipeStep>);

	public int registTag(rTag:RecipeTag) ;

	public int registMaterial(rmList:List<RecipeMaterial>) ;


	public List<Recipe> printRecipeList(currentPage:Int,limit:Int);


	public Recipe printOneRecipe(recipeNo:int) ;
	public List<RecipeStep> printOneRecipeDetail(recipeNo:int) ;

	public List<RecipeMaterial> printOneRecipeMaterial(recipeNo:int) ;
	

	public RecipeTag printOneRecipeTag(recipeNo:int)  ;

	public int checkRecommand(recipeNo:int, memberEmail:String);

	public int allRecipeCommentList(page:Int, limit:int, recipeNo:int);


	public int setRecommand(recommand:Recommandation) ;

	public int removeRecommand(recommand:Recommandation) ;

	public int modifyOneRecipe(recipe:Recipe) ;

	public int modifyOneRecipeDetail(rdList:List<RecipeDetail>) ;

	public int  modifyOneRecipeMaterial(rmList:List<RecipeMaterial>);

	public int modifyOneRecipeTag(rtList:List<RecipeTag>);


	public int removeOneRecipe(redipeNo:int) ;




}
