<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<body>

<form action="/notice/modify.do" method="post">
<input type="text" name="subject" value="${notice.subject }">
<br>
<textarea rows="10" cols="30" name="contents">${notice.contents }

</textarea>
<br>
 <input type="hidden" name="noticeNo" value="${notice.noticeNo }">
 <input type="submit" value="수정하기">
 <input type="reset" value="취소하기">

</form>

</body>
</html>