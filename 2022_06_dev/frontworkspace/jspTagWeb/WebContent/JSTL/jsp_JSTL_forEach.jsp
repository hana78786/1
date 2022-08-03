<%@page import="test.Member.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose문</title>
</head>
<body>
items는 리스트 데이터를 받음, var는 리스트 중 한개를 받음, varStatus는index값과 관련이 있음
<br>
<%
	ArrayList<Member> mList = new ArrayList<Member>();
mList.add(new Member("user01","pass01","일용자"));
mList.add(new Member("user02","pass02","이용자"));
mList.add(new Member("user03","pass03","삼용자"));
request.setAttribute("mList", mList);
%>
<c:forEach items="${mList }" var="member" varStatus="">
${member.id },
${member.password },
${member.name }
<br>

</c:forEach>

</body>
</html>