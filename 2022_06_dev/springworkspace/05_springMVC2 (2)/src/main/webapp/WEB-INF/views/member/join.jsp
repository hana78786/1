<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류페이지</title>
</head>
<body>
<h1 align="center">회원가입</h1>
	<div class="">
		<form action="/member/join.kh" method="post">
			<table>
				<tr>
					<td>* 아이디</td>
					<td><input type="text" id="memberId" name="memberId" >
					</td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" name="memberPw" value="" required="required"></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="memberName" ></td>
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
					<td><input type="text" name="post" value="${post }" class="postcodify_postcode5"></td>
					<!-- 배열로 값을 받았다면 ${addreess[0]}으로 표기하여 출력할수 있다-->
					<td><button type="button" id="postcodify_search_button">검색</button></td>
				</tr>
				<tr>
					<td>도로명주소</td>
					<td><input type="text" name="address1"  class="postcodify_address"></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td><input type="text" name="address2" class="postcodify_details"></td>
				</tr>
				<tr>
				<td colspan="2" align="center">
			<input type="submit" value="가입하기">

				</td>
				</tr>
			</table>
			
		</form>
	</div>
	
	<script type="text/javascript">
	$(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
	</script>

</body>
</html>