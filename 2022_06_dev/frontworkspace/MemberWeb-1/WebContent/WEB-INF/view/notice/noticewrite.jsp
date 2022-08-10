<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
</head>
<body>
<form action="/notice/write.do" method="post">
<input tyep="text" name="subject" size ="75" placeholder="제목을 입력하세요"><br>
</input>
<textarea rows="30" cols="80" name="contents"></textarea>
<br>
<input type="submit" value="전송">
<input type="reset">

</form>
</body>
</html>