<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>


<h1 align="center">회원정보수정</h1>
	<div class="">
		<form action="/member/modify.kh" method="post">
			<table>
				<tr>
					<td>* 아이디</td>
					<td><input type="text" id="memberId" name="memberId" value="${member.memberId }" readonly>
					</td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" name="memberPw" required="required"></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="memberName" value="${member.memberName }" readonly></td>
				</tr>

				<tr>
					<td>* 이메일</td>
					<td><input type="text" name="memberEmail" value="${member.memberEmail }" readonly></td>
				</tr>
				<tr>
					<td>* 전화번호</td>
					<td><input type="text" name="memberPhone" value="${member.memberPhone }" readonly></td>
				</tr>
				<tr>
					<td>* 우편번호</td>
					<td><input type="text" name="post" value="${post }" class="postcodify_postcode5"></td>
					<!-- 배열로 값을 받았다면 ${addreess[0]}으로 표기하여 출력할수 있다-->
					<td><button type="button" id="postcodify_search_button">검색</button></td>
				</tr>
				<tr>
					<td>도로명주소</td>
					<td><input type="text" name="address1" value="${address1 }" class="postcodify_address"></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td><input type="text" name="address2" value="${address2 }" class="postcodify_details"></td>
				</tr>
				<tr>
				<td colspan="2" align="center">
			<input type="submit" value="수정하기">
			<button type="button" onclick="removeMember();"> 탈퇴하기 </button>
			<!-- //type을 button으로 꼭 적어줘야! submit이 되지 않는다!! 꼭 기억하기!
				 -->
				</td>
				</tr>
			</table>
			
		</form>
	</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

<script>
function removeMember() {
	if(window.confirm("탈퇴하시겠습니까?")){
	location.href="/member/remove.kh";
	}
	
}
$(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
</body>
</html>