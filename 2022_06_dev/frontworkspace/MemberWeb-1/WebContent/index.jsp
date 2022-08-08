<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Web!</title>

<style>
    a{text-decoration: none;}
</style>
</head>
<body>
<c:if test="${memberId eq null }">
<form action="/member/login.do" method="post">
    <input type="text" name="member-id" placeholder="id입력"><br>
    <input type="password" name="member-pw" placeholder="password입력"><br>
    <br>
    <input type="submit" value="로그인">  <input type="reset" value="취소">
    <br>
    </form>
    <br><a href="/enroll.html"> 회원가입</a>
    </c:if>
    
    <c:if test="${memberId ne null}">
    ${memberId }님 환영합니다!
    <a href="/member/logout.do">로그아웃</a>
    <a href="/member/list.do">전체 회원조회</a>
    </c:if>
    
    
</body>
</html>