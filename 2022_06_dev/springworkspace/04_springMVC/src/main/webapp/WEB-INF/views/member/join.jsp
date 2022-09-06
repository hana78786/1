<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1 align="center">회원가입</h1>
	<div class="">
		<form action="/member/register.kh" method="post">
			<table>
				<tr>
					<td>* 아이디</td>
					<td><input type="text" id="memberId" name="memberId">
					</td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" name="memberPw"></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="memberName"></td>
				</tr>

				<tr>
					<td>* 이메일</td>
					<td><input type="text" name="memberEmail"></td>
				</tr>
				<tr>
					<td>* 전화번호</td>
					<td><input type="text" name="memberPhone"></td>
				</tr>
				<tr>
					<td>* 우편번호</td>
					<td><input type="text" name="post"></td>
				</tr>
				<tr>
					<td>* 주소</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
				<td colspan="2" align="center">
			<input type="submit" value="전송">
				
				</td>
				</tr>
			</table>
			
		</form>
	</div>

</body>
</html>