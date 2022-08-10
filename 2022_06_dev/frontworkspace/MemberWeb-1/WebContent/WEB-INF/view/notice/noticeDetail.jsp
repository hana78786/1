<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지상세확인</title>
</head>
<body>
번호 : ${notice.noticeNo }
<br>
제목 : ${notice.subject }  작성자 :${notice.memberId }
<br>
내용 : ${notice.contents }
<br>
등록일 : ${notice.regDate }
<br>
<form action="/notice/modify.do" style="display:inline-block;">
<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
<input type="submit" value="수정하기">
</form>
<form action="/notice/delete.do" style="display:inline-block;">
<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
<input type="submit" value="삭제하기">
</form>
<a href="/notice/list.do">목록으로 돌아가기</a>
</body>
</html>