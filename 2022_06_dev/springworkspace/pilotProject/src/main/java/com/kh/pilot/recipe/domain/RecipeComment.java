package com.kh.pilot.recipe.domain;

import java.sql.Date;

public class RecipeComment {
	private int comment;
	private int recipeNo;
	private Date commentDate;
	private String commentContents;
	private String memberEmail;
	
	public RecipeComment() {
		
	}

	public RecipeComment(int comment, int recipeNo, Date commentDate, String commentContents, String memberEmail) {
		super();
		this.comment = comment;
		this.recipeNo = recipeNo;
		this.commentDate = commentDate;
		this.commentContents = commentContents;
		this.memberEmail = memberEmail;
	}

	@Override
	public String toString() {
		return "RecipeComment [comment=" + comment + ", recipeNo=" + recipeNo + ", commentDate=" + commentDate
				+ ", commentContents=" + commentContents + ", memberEmail=" + memberEmail + "]";
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public int getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContents() {
		return commentContents;
	}

	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	
	

}
