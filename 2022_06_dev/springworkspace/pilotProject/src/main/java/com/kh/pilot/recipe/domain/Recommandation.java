package com.kh.pilot.recipe.domain;

public class Recommandation {
	private int recipeNo;
	private String memberEmail;
	
	public Recommandation() {
		
	}

	public Recommandation(int recipeNo, String memberEmail) {
		super();
		this.recipeNo = recipeNo;
		this.memberEmail = memberEmail;
	}

	@Override
	public String toString() {
		return "Recommandation [recipeNo=" + recipeNo + ", memberEmail=" + memberEmail + "]";
	}

	public int getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	
}
