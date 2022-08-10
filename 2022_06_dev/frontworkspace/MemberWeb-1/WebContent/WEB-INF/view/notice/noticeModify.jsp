<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/notice/modify.do" method="post">
<input tyep="text" name="subject" size ="75" value="${notice.subject }"><br>
</input>
<textarea rows="30" cols="80" name="contents">${notice.contents }</textarea>
<br>
<input type="hidden" name ="noticeNo" value="${notice.noticeNo }">
<input type="submit" value="전송">
<input type="reset">


</body>
</html>