<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인페이지</title>
</head>

<body>

<c:if test="${empty Member}">
	<c:if test="${msg == 'loginEror' }">
		<script type="text/javascript">
			alert("아이디와 비밀번호를 확인하세요!");
		</script>
	</c:if>
	<form action="/loginMember.do" method="post">
		ID :
		<input type="text" placeholder="아이디를 입력하세요" required name="id">
		<br> PW :
		<input type="password" placeholder="비밀번호를 입력하세요" required name="pw">
		<br>
		<button>로그인</button>
	</form>
</c:if>
<c:if test="${!empty Member}">
	${Member.name }님 환영합니다!
	<button onclick="location.href='/loginout.do'">로그아웃</button>
</c:if>

</body>
</html>