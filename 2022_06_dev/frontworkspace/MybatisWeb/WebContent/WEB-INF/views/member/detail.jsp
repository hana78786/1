<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
</head> 
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
<br> <br>
<h3>회원 정보 조회</h3>
	<table class="table">
		<colgroup>
			<col width="150">
			<col width="*">
		</colgroup>
		<tr>
			<td>회원 ID</td>
			<td>
				<input class="form-control" value="${member.memberId }" readonly>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input class="form-control" value="${member.memberName }" readonly>
			</td>
		</tr>						
		<tr>
			<td>주소</td>
			<td>
				<input class="form-control" value="${member.memberAddress }" readonly>
			</td>
		</tr>
	</table>


</body>
</html>