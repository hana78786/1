<%@page import="test.Member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <% --%>
<!-- //     Member member = (Member)request.getAttribute("Member"); -->
<%--     %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Test1</title>
</head>
<body>
<%-- 	아이디 : <%=member.getId() %> <br> --%>
<%-- 	비밀번호 : <%=member.getPassword() %> <br> --%>
<%-- 	아이디 : <%=member.getName() %> <br> --%>

	아이디 : ${Member.id } <br>
	비밀번호 : ${Member.password } <br>
	이름 : ${Member.name }
	 
	 <h1>Member List 처리</h1>
	 <h2>첫번째 데이터</h2>
	 아이디 : ${mList[0].id }	
	 비밀번호 : ${mList[0].password }	
	 이름 : ${mList[0].name }	
	 
	 <h2>두번째 데이터</h2>
	 아이디 : ${mList[1].id }	
	 비밀번호 : ${mList[1].password }	
	 이름 : ${mList[1].name }	
	 
	 <h2>세번째 데이터</h2>
	 아이디 : ${mList[2].id }	
	 비밀번호 : ${mList[2].password }	
	 이름 : ${mList[2].name }	


</body>
</html>