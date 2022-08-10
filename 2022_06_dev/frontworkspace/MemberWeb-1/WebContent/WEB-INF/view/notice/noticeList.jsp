<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 리스트</title>
</head>
<body>
<table border="1">
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>작성날짜</th>

</tr>
<c:forEach items="${nList }" var="notice" varStatus="i">
<tr>
<td>${i.count }</td>

<td><a href="/notice/detail.do?noticeNo=${notice.noticeNo }">${notice.subject }</a></td>

<td>${notice.memberId}</td>
<td>${notice.regDate }</td>
</tr>
</c:forEach>

</table>

<a href="/index.jsp">마이페지로..</a>

</body>
</html>