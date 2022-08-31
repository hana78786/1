<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h3>회원 정보 조회</h3>
	<table class="table">
		<colgroup>
			<col width="150">
			<col width="*">
		</colgroup>
		<tr>
			<td>강좌번호</td>
			<td>
				<input class="form-control" value="${lecture.lectureNo}" readonly>
			</td>
		</tr>
		<tr>
			<td>강좌이름</td>
			<td>
				<input class="form-control" value="${lecture.lectureName}" readonly>
			</td>
		</tr>						
		<tr>
			<td>강사명</td>
			<td>
				<input class="form-control" value="${lecture.lectrueInstructor}" readonly>
			</td>
		</tr>
		<tr>
			<td>강좌소개</td>
			<td>
				<textarea class="form-control" readonly>${lecture.lectureIntroduce}</textarea>
			</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>
				<input class="form-control" value="${lecture.regDate}" readonly>
			</td>
		</tr>
		<tr>
			<td>개강여부</td>
			<td>
				<input class="form-control" value="${lecture.useYn}" readonly>
			</td>
		</tr>
	</table>

</body>
</html>