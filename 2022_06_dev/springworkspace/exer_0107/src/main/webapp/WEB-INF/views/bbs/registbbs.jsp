<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물쓰기</title>
</head>
<body>

    <form action="/registfree.do" method="post">
	    	<input type="text" name ="title" placeholder="제목을 입력하세요">
	        <textarea name="contents" id="" cols="30" rows="10"></textarea>
	    <button>등록</button>
    </from>
</body>
</html>