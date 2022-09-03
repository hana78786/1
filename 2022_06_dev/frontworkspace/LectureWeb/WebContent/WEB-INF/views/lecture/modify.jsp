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

<h3>회원 정보 수정</h3>
<form action="/lecture/modify.do" method="post">
	<table class="table">
		<colgroup>
			<col width="150">
			<col width="*">
		</colgroup>
		<tr>
			<td>강좌번호</td>
			<td>
				<input class="form-control" name ="lectureNo" value="${lecture.lectureNo}" readonly>
			</td>
		</tr>
		<tr>
			<td>강좌이름</td>
			<td>
				<input type="text" class="form-control"  name ="lectureName" value="${lecture.lectureName}" >
			</td>
		</tr>						
		<tr>
			<td>강사명</td>
			<td>
				<input type="text" class="form-control" name ="lectrueInstructor" value="${lecture.lectrueInstructor}" >
			</td>
		</tr>
		<tr>
			<td>강좌소개</td>
			<td>
				<textarea class="form-control"  name ="lectureIntroduce" >${lecture.lectureIntroduce}</textarea>
			</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>
				<input class="form-control" value="${lecture.regDate}" readOnly>
			</td>
		</tr>
		<tr>
			<td>개강여부</td>
			<td>
				<select name ="YN" class="form-control" >
				<option value="Y" id="YN_Y">Y</option>
				<option value="N" id="YN_N">N</option>
				
				<script>
				if('${lecture.useYn}' =='Y'){
					document.querySelector("#YN_Y").selected = 'selected';
				}else{
					document.querySelector("#YN_N").selected = 'selected';
				}
				
				</script>
				
				 
			</td>
		</tr>
		<tr>
			<td> <input type="submit" value="전송"> </td>
			<td>
				<input type="reset" value="초기화"> 
			</td>
		</tr>
	</table>
	</form>

</body>
</html>