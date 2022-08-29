<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">회원가입</h1>
<form action="/member/register.do" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="userId">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="userPwd">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="userName">
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<input type="text" name="userAddr">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div>
					<input type="reset" value="취소">
					<input type="submit" value="가입">
				</div>
			</td>
		</tr>
	</table>
</form>

</body>
</html>