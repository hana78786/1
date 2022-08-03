<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
// String name = request.getParameter("user-name");
// String color = request.getParameter("color");
// String animal = request.getParameter("animal");
// String[] foods = request.getParameterValues("foods");
// String name = (String)request.getAttribute("name");
// String color = (String)request.getAttribute("color");
// String animal = (String)request.getAttribute("animal");
// String[] foods =(String[])request.getAttribute("foods");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취향 테스트 결과</title>
</head>
<body>
	<h2>개인 취향 테스트 결과 화면</h2>
	${name}님의 개인 취향은
	<br>
	
	<c:choose>
		<c:when test="${color == 'blue'}">
		파란색을
		</c:when>
		<c:when test="${color == 'red'}">
		빨간색을
		</c:when>
		<c:when test="${color == 'yellow'}">
		노란색을
		</c:when>
		<c:when test="${color == 'green'}">
		초록색을
		</c:when>
	
	
	</c:choose>
	좋아하고
	<br>

	
		<c:choose>
		<c:when test="${animal == 'dog'}">
		강아지를
		</c:when>
		<c:when test="${animal == 'cat'}">
		고양이를
		</c:when>
		<c:when test="${animal == 'rabbit'}">
		토끼를
		</c:when>
	</c:choose>
	좋아한다
<br>


	
	좋아하는 음식은 
	<c:forEach items="${foods }" var="food">
	
	<c:choose>
		<c:when test="${food == 'jjajjang'}">
		짜장면 
		</c:when>
		<c:when test="${food == 'champong'}">
		짬뽕 
		</c:when>
		<c:when test="${food == 'tangsuyuk'}">
		탕수육
		</c:when>
		<c:when test="${food == 'yangjangpi'}">
		양장피
		</c:when>
		<c:when test="${food == 'palboche'}">
		팔보채
		</c:when>
	
</c:choose>
	
	
	</c:forEach>
	
	입니다
<br>


</body>
</html>