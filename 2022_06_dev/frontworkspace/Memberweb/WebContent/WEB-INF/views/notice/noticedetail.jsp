<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 내용</title>
</head>
<body>
<h1>공지사항</h1>

<h2>${notice.subject }</h2> 
${notice.contents }
<%-- <input type="text" size="100" placeholder="제목을 입력하세요" name="subject" value="${notice.subject }"> --%>
<%-- <textarea rows="30" cols="100" name="contents" >${notice.contents }</textarea> <br> --%>
<!-- <input type="submit" value="완료"> -->
<!-- <input type="reset" value="취소"> -->


<br> <a href="/notice/modify.do?noticeNo=${notice.noticeNo }">수정하기</a>
<%--  <a href="/notice/delete.do?noticeNo=${notice.noticeNo}">삭제하기</a> --%>
 <br>
 <form action="/notice/delete.do?noticeNo=${notice.noticeNo}">
	<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
	<input type="submit" value="삭제">
	</form>
	
	<a href="/notice/list.do">리스트로 돌아가기</a>
	

</body>
</html>