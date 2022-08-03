<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp useBean</title>
</head>
<body>
	<jsp:useBean id="member" class="test.Member.Member">
		<jsp:setProperty property="id" name="member" value="user01"/>
		<jsp:setProperty property="password" name="member" value="pass01"/>
		<jsp:setProperty property="name" name="member" value="일용자"/>
	</jsp:useBean>
	
	<h2>jsp:useBean</h2>
	ID : <jsp:getProperty property="id" name="member"/> <br>
	PW : <jsp:getProperty property="password" name="member"/> <br>
	NAME : <jsp:getProperty property="name" name="member"/> <br>
	
</body>
</html>