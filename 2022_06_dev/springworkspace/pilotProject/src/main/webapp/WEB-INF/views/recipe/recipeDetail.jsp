<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${recipe.recipeName }</title>
</head>
<body>
	<h1>${recipe.recipeName }</h1>
	<img src="/resources/recipeImg/${recipe.mainPicRename }">
	<br>
	<c:if test="${rTag.jmt }">
#jmt 
</c:if>
	<c:if test="${rTag.healthy }">
#건강한 
</c:if>
	<c:if test="${rTag.goodSpicy }">
#맛있게 매운 
</c:if>
	<c:if test="${rTag.full }">
#든든한 
</c:if>
	<c:if test="${rTag.soSpicy }">
#아주 매운 
</c:if>
	<c:if test="${rTag.sweet }">
#달콤한 
</c:if>
	<c:if test="${rTag.easy }">
#간편한 
</c:if>
	<c:if test="${rTag.party }">
#파티용 
</c:if>
	<br> 작성자 : ${recipe.memberEmail } ${recipe.recipeInfo }
	<c:forEach items="${rmList}" var="rmList">
재료: ${rmList.material}, 수량 : ${rmList.amount}
<br>
	</c:forEach>

	<c:forEach items="${rsList }" var="rsList">
		<c:if test="${rsList.recipePicRename ne null }">
			<img src="/resources/recipeImg/${rsList.recipePicRename }">
			<br>
		</c:if>
		
			${rsList.recipeDescription }
		
		<br>
	</c:forEach>

</body>
</html>