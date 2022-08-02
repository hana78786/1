<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String name = (String)request.getAttribute("name");
String animal = (String)request.getAttribute("animal");
String color = (String)request.getAttribute("color");
String[] foods = (String[])request.getAttribute("foods");



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취향 결과</title>
</head>
<body>
<h1>당신의 취향은?</h1>
<%=name %>님의 취향은.... <br>
<%=color %>, <%=animal %>,
 <%
 for(String food : foods)
 {%>
 <%=food %>
 
 <%}%>


</body>
</html>