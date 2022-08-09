<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
<form action="/member/modify.do" method="post">
<fieldset>

	<legend>회원 상세 정보</legend>
	<ul>
	<li>ID: <input type="text" name="member-id" value="${member.memberId }" readonly></li><br>
		<li>이름 : <input type="text" name="member-name" value="${member.memberName }" readonly></li><br>
		<li>비밀번호 : <input type="password" name="member-pw" value="${member.memberPw }" ></li><br>
		<li>나이 : <input type="number" name="member-age" value="${member.memberAge }"  readonly></li><br>
		<li>이메일 : <input type="text" name="member-email" value="${member.memberEmail }" ></li><br>
		<li>폰번호 : <input type="text" name="member-phone" value="${member.memberPhone }" ></li><br>
		<li>주소 : <input type="text" name="member-address" value="${member.memberAddress }" ></li><br>

		<li>성별 : <input type="radio" name="gender" value="M"
		<c:if test="${member.memberGender == 'M'.charAt(0) }">checked</c:if> -
		>남 
		<input type="radio" name="gender" value="F"
		<c:if test="${member.memberGender == 'F'.charAt(0) }">checked</c:if>
		>여					
		</li><br>
		<li>취미 : <input type="text" name="member-hobby" value="${member.memberHobby }" ></li><br>
	</ul>
<input type="submit" value="수정">  <input type="reset" value="취소">
<a href="/index.jsp">메인페이지로 이동</a>
<a href="/member/delete.do">탈퇴</a>
<!--여기서 아이디를 넘겨줄수도있지만 서버에서 처리해야 누가 주소에서 아이디만 살짝 바꿔 탈퇴하는것을 막을수있음-->
</fieldset>
</form>


</body>
</html>