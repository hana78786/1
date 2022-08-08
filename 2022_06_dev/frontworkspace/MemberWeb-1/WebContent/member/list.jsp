<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>휴대폰</th>
		<th>주소</th>
		<th>성별</th>
		<th>취미</th>
		<th>가입날짜</th>
		</tr>
		
		<c:forEach items="${mList }" var="member">
		<tr>
		<th>${member.memberId }</th>
		<th>${member.memberName }</th>
		<th>${member.email }</th>
		<th>${member.phone }</th>
		<th>${member.memberAddress }</th>
		<th>${member.gender }</th>
		<th>${member.memberHobby }</th>
		<th>${member.enrollDate}</th>
		</tr>
		</c:forEach>
		

</table>

</body>
</html>