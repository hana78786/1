<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// String name = request.getParameter("user-name");
// String color = request.getParameter("color");
// String animal = request.getParameter("animal");
// String[] foods = request.getParameterValues("foods");
String name = (String)request.getAttribute("name");
String color = (String)request.getAttribute("color");
String animal = (String)request.getAttribute("animal");
String[] foods =(String[])request.getAttribute("foods");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취향 테스트 결과</title>
</head>
<body>
	<h2>개인 취향 테스트 결과 화면</h2>
	<%=name%>님의 개인 취향은
	<br>
	

	<%=color%>색을 좋아하고
	
	<%=animal%>을 좋아한다



	
	좋아하는 음식은 
	<% for(int i =0 ; i<foods.length;i++){
		out.println(foods[i]);}%>
	

	입니다



</body>
</html>