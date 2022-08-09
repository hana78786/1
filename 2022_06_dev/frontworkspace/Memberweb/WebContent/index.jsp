<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버웹</title>
</head>
<body>

<c:if test="${sessionScope.memberId eq null }">

<h1>로그인 페이지</h1>
<form action="/memeber/login.do" method="post">
	ID:<input type="text" name="memeber-id"><br>
	PW:<input type="password" name="member-pw">
	<input type="submit" value="로그인">
	<input type="reset" value="취소">
	<a href="./Member/enroll.html">회원가입</a>
	
</form>
</c:if>
	
	<c:if test="${sessionScope.memberId ne null }">
	${memberId }님 환영합니다.
	<a href="/memeber/logout.do">로그아웃</a>
	<!-- 로그아웃 링크를 누르면 해당 URL을 주소표시줄에 치는 것과 같고 get방식 -->
	<a href="/member/list.do">전체 회원조회</a>
	<a href="/member/mypage.do?memberId=${memberId}">마이페이지 </a>
	
	
	</c:if>
</body>
</html>