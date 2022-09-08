<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
	<h1 align="center">게시글 목록</h1>
	<br>
	<br>
	<table align="center" border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>첨부파일</th>
		</tr>


		<c:forEach items="${bList }" var="board" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${board.boardTitle }</td>
				<td>${board.boardWirter }</td>
				<td>${board.bCreateDate }</td>
				<td>${board.boardCount }</td>
				<td>0</td>
			</tr>
		</c:forEach>
		<tr align="center" height="20">
			<td colspan="6">
			
			<!-- 	startNavi가 1일이 아닐때만 출력 -->
			<c:if test="${startNavi ne 1 && startNavi > 0}">
			<a href="/board/list.kh?page=${startNavi-1 }">이전</a>
			</c:if>
			
			
			<!-- p는 기준을 삼을 임시변수 startNavi부터 시작해 endNavi까지 출력한다 -->
			<c:forEach var="p" begin="${startNavi }" end="${endNavi }" >
			<a href="/board/list.kh?page=${p }">${p }</a>
			</c:forEach>
			
			
			
			<!-- 	endNavi가 maxPage와 같지 않을때만 출력 -->
			<c:if test="${endNavi ne maxPage }">
			<a href="/board/list.kh?page=${endNavi+1 }">다음</a>
			</c:if>
			
			</td>
	</table>
</body>
</html>