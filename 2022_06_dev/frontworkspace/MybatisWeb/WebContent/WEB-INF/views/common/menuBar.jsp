<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴바</title>
<style>
	.login-area {
		height : 100px;
	}
	.btn-login {
		height : 50px;
	}
	.nav-area {
		background : gray;
		height : 50px;
	}
	.menu {
		display : table-cell;
		width : 250px;
		height : 50px;
		text-align : center;
		vertical-align : middle;
		font-size : 20px;
		background : gray;
		color : black;
	}
	.menu:hover {
		background : gold;
		cursor : pointer;
	}
	img{
	width : 40%;
	height : 40%;}
</style>
</head>
<body>

<h1 align="center">Welcome to Mybatis Web</h1>
<br>
<div class="login-area">
<c:if test="${empty sessionScope.member }">

	<form action="/member/login.do" method="post">
		<table align="right">
			<tr>
				<td>아이디 : </td>
				<td><input type="text" name="userId"></td>
				<td rowspan="2"><button id="" class="btn-login">로그인</button></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="userPwd"></td>
			</tr>
			<tr>
				<td colspan="3">
					<a href="/member/register.do">회원가입</a>
					<a href="#">아이디/비밀번호 찾기</a>
				</td>
			</tr>
		</table>
	</form>
</c:if>
<c:if test="${not empty sessionScope.member }">
	<table align="right">
		<tr>
			<td colspan="2"><b>${sessionScope.member.memberName }</b>님 환영합니다.</td>
		</tr>
		<tr>
		<td> 
		<button onclick="location.href='/member/logout.do'">로그아웃</button>
		</td>
		</tr>
	
	</table>

</c:if>
</div>
<div class="nav-area">
	<div class="menu" onclick="goHome();">Home</div>
	<div class="menu" onclick="location.href='/member/list.do'">멤버목록</div>
	<!-- location : get방식으로 이동 -->
	<div class="menu" onclick="">강좌목록</div>
	<div class="menu" onclick="">게시판</div>
	<div class="menu" onclick="">ETC</div>
</div>
<script>
function goHome(){
	location.href="/index.jsp";
}
</script>

</body>
</html>