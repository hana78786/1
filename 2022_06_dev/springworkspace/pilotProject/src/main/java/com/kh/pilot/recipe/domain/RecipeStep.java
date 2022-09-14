package com.kh.pilot.recipe.domain;

public class RecipeStep {
	
	private int recipeOrder;
	private int recipeNo;
	private String recipeDescription;
	private String recipePic;
	
	public RecipeStep() {
		
	}

	public RecipeStep(int recipeOrder, int recipeNo, String recipeDescription, String recipePic) {
		super();
		this.recipeOrder = recipeOrder;
		this.recipeNo = recipeNo;
		this.recipeDescription = recipeDescription;
		this.recipePic = recipePic;
	}

	@Override
	public String toString() {
		return "RecipeStep [recipeOrder=" + recipeOrder + ", recipeNo=" + recipeNo + ", recipeDescription="
				+ recipeDescription + ", recipePic=" + recipePic + "]";
	}

	public int getRecipeOrder() {
		return recipeOrder;
	}

	public void setRecipeOrder(int recipeOrder) {
		this.recipeOrder = recipeOrder;
	}

	public int getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}

	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	public String getRecipePic() {
		return recipePic;
	}

	public void setRecipePic(String recipePic) {
		this.recipePic = recipePic;
	}
	
	

}
