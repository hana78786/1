<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${bbs.title}</title>
</head>
<body>
  작성자 : ${bbs.name} <br>
  내용 : ${bbs.contents}<br>
<button onclick="location.href='/freemodifyview.do?bbsNo=${bbs.bbsNo}';">수정</button>
</body>
</html>