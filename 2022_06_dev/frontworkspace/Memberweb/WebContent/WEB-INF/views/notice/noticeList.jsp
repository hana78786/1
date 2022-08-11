<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
<h1>공지사항</h1>
<table border="1">
	<tr>
	<th>번호</th>
	<th>제목</th>
	
	<th>글쓴이</th>
	<th>작성일</th>
	</tr>
	
	<c:forEach items="${nList }" var="notice" varStatus="i">
		<tr>
	<td>${notice.rowNum }</td>
	
<!-- jsp에서 varStatus를 이용하여 숫자를 다시 센다 seq는 오류에따라 숫자가 씹히기도 하니까 -->
<!-- 보기엔 이게 좋다! -->
<%-- 	<td>${notice.noticeNo }</td> --%>
	<td> <a href="/notice/detaile.do?noticeNo=${notice.noticeNo }">${notice.subject }</a></td>
	
	
	
	</form>
	
	<td>${notice.memberId }</td>
	<td>${notice.regDate }</td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="4">
	
	${pageNavi }
	
<!-- 		<a href="/notice/list.do?currentPage=1">1</a> <a href="/notice/list.do?currentPage=2">2</a> <a href="/notice/list.do?currentPage=3">3</a> <a href="/notice/list.do?currentPage=4">4</a>  -->
<!-- 		<a href="#">다음</a> -->
	
	</td>
	</tr>

	

</table>

<a href="/index.jsp">마이페이지</a>

</body>
</html>