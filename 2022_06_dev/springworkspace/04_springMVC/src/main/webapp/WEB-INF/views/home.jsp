<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My spring Web Page</title>
<link href="/resources/css/menubar-style.css" rel="stylesheet">
</head>
<body>
	<!--  jstl쓰기 위한 2가지 1. jar4개 2.taglib 추가 -->
	<!-- 	WEB-INF / lib폴더 만들어서 jar4개 추가하기, 위에 taglib썼다! -->
	<h1 align="center">Welcome Our WebSite!</h1>

	<!-- ${empty sessionScope.loginUser } -->
	<c:if test="${sessionScope.loginUser eq null}">
		<div class="login-area">
			<form action="/member/login.kh" method="post">
				<table align='right'>
					<tr>
						<td>아이디 :</td>
						<td><input type="text" name="memberId"></td>
						<td rowspan="2"><input type="submit" value="로그인"></td>
					</tr>
					<tr>
						<td>비밀번호 :</td>
						<td><input type="password" name="memberPw"></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="3"><a href="/member/joinView.kh">회원가입</a></td>

					</tr>
				</table>

			</form>
		</div>
	</c:if>

	<!-- ${not empty sessionScope.loginUser } -->
	<c:if test="${sessionScope.loginUser ne null}">
		<div class="login-area">
			<table align="right">
				<tr>
					<td colspan="3" rowspan="2">${loginUser.memberName }님환영합니다</td>
				</tr>
				<tr>
					
				</tr>
				<tr>
				<td ><a href="/member/myPage.kh">정보수정</a>
					<td ><a href="/member/logout.kh">로그아웃</a></td>
				</tr>
			</table>
		</div>
	</c:if>



	<div class="nav-area">
		<div class="menu" onclick="location.href='/home.kh';">Home</div>
		<div class="menu" onclick="showNoticeList();">공지사항</div>
		<div class="menu" onclick="">자유게시판</div>
		<div class="menu" onclick="">사진게시판</div>
	</div>

	<script>
		function showNoticeList() {

		}
	</script>
</body>
</html>