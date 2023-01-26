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
  제목 : ${bbs.title}
  <form action="/freemodify.do" method="post">
  내용 : <textarea name="contents">${bbs.contents}</textarea><br>
  <input type="hidden" name="bbsNo" value="${bbs.bbsNo}">
  <button>수정</button>
  </form>
</body>
</html>