<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   // String[] palces = request.getParameterValues("place");
    String[] places = (String[])request.getAttribute("places");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관광지 선택 결과</title>
</head>
<body>
<h2>당신이 선택한 관광지 입니다</h2>
<hr>
<span>선택한 장소는 : </span>
<%
	for(String place : places){
		%>
		<%= place %>
<%		
	}
%>
</body>
</html>