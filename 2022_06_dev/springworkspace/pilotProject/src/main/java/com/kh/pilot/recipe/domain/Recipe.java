package com.kh.pilot.recipe.domain;

import java.sql.Date;

public class Recipe {
	
	private int recipeNo;
	private String memberEmail;
	private String recipeName;
	private String recipeInfo;
	private int recipePrice;
	private int viewCount;
	private String mainPic;
	private String mainPicRename;
	private String recipeCategory;
	private String recipeTime;
	private String recipeVideo;
	private String recipeStatus;
	private Date insertDate;
	private Date updateDate;
	
	public Recipe() {
		
	}

	public Recipe(int recipeNo, String memberEmail, String recipeName, String recipeInfo, int recipePrice,
			int viewCount, String mainPic, String recipeCategory, String recipeTime, String recipeVideo,
			String recipeStatus, Date insertDate, Date updateDate) {
		super();
		this.recipeNo = recipeNo;
		this.memberEmail = memberEmail;
		this.recipeName = recipeName;
		this.recipeInfo = recipeInfo;
		this.recipePrice = recipePrice;
		this.viewCount = viewCount;
		this.mainPic = mainPic;
		this.recipeCategory = recipeCategory;
		this.recipeTime = recipeTime;
		this.recipeVideo = recipeVideo;
		this.recipeStatus = recipeStatus;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Recipe [recipeNo=" + recipeNo + ", memberEmail=" + memberEmail + ", recipeName=" + recipeName
				+ ", recipeInfo=" + recipeInfo + ", recipePrice=" + recipePrice + ", viewCount=" + viewCount
				+ ", mainPic=" + mainPic + ", recipeCategory=" + recipeCategory + ", recipeTime=" + recipeTime
				+ ", recipeVideo=" + recipeVideo + ", recipeStatus=" + recipeStatus + ", insertDate=" + insertDate
				+ ", updateDate=" + updateDate + "]";
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

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeInfo() {
		return recipeInfo;
	}

	public void setRecipeInfo(String recipeInfo) {
		this.recipeInfo = recipeInfo;
	}

	public int getRecipePrice() {
		return recipePrice;
	}

	public void setRecipePrice(int recipePrice) {
		this.recipePrice = recipePrice;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getMainPic() {
		return mainPic;
	}

	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}

	public String getRecipeCategory() {
		return recipeCategory;
	}

	public void setRecipeCategory(String recipeCategory) {
		this.recipeCategory = recipeCategory;
	}

	public String getRecipeTime() {
		return recipeTime;
	}

	public void setRecipeTime(String recipeTime) {
		this.recipeTime = recipeTime;
	}

	public String getRecipeVideo() {
		return recipeVideo;
	}

	public void setRecipeVideo(String recipeVideo) {
		this.recipeVideo = recipeVideo;
	}

	public String getRecipeStatus() {
		return recipeStatus;
	}

	public void setRecipeStatus(String recipeStatus) {
		this.recipeStatus = recipeStatus;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	

}
