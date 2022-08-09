<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>
</head>
<body>
<form action="/member/modify.do">

<fieldset>
<legend>회원정보</legend>
아이디 : <input type="text" name="member-id" value="${member.memberId }" readonly> <br>
비밀번호 : <input type="password" name="member-pw" value="${member.memberPw }"> <br>
이름 : <input type="text" name="member-name" value="${member.memberName }" readonly> <br>
나이 : <input type="text" name="member-age" value="${member.memberAge }" readonly> <br>
이메일 : <input type="text" name="member-email" value="${member.email }"> <br>
전화번호 : <input type="text" name="member-phone" value="${member.phone }"> <br>
주소 : <input type="text" name="member-address" value="${member.memberAddress }"> <br>
취미 : <input type="text" name="member-hobby" value="${member.memberHobby }"> <br>
<br>
<input type="radio" name="gender" value="M"
<c:if test="${member.gender == 'M'.charAt(0) }"> checked</c:if>
> 남
<input type="radio" name="gender" value="F"
<c:if test="${member.gender == 'F'.charAt(0) }"> checked</c:if>
> 여
<br>
<input type="submit" value="수정"> <input type="reset" value="취소"> 
</fieldset>
<a href="/member/delete.do">회원탈퇴</a>

</form>
</body>
</html>