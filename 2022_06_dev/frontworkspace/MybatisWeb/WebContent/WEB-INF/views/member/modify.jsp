<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
<br> <br>
<h3>회원 정보 수정</h3>
<form action="/member/modify.do" method="post">		
<input type="hidden" name="userId" value="${member.memberId }">
	<table class="table">
		<colgroup>
			<col width="150">
			<col width="*">
		</colgroup>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" class="form-control" name="userPwd" value="${member.memberPw }">
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<input type="text" class="form-control" name="userAddr" value="${member.memberAddress }">
			</td>
		</tr>
	</table>
	<div>
		<a href="#">취소</a>
		<input type="submit" class="btn btn-sm btn-success" value="수정">
	</div>
</form>


</body>
</html>