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


	<header>
		
			<input type="hidden" name="searchCondition" value="${searchCondition }">
			<input type="hidden" name="searchValue" value="${searchValue}">

		<jsp:include page="../home.jsp"/>

	</header>



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



		<!-- 게시물 리스트 출력시 리스트 반환값이 있을때/없을때 if문 -->
		<!-- 반환값 있을때 -->
		<c:if test="${!empty bList }">
			<c:forEach items="${bList }" var="board" varStatus="i">
				<tr>
					<td>${i.count }</td>

					<c:if test="${searchValue eq null }">
						<td><a href="/board/detail.kh?boardNo=${board.boardNo }&page=${pageNow }">${board.boardTitle }</td>
					</c:if>

					<c:if test="${searchValue ne null }">
						<td><a
							href="/board/detail.kh?boardNo=${board.boardNo }&searchCondition=${searchCondition }&searchValue=${searchValue}&page=${pageNow }">${board.boardTitle }</td>
					</c:if>

					<td>${board.boardWirter }</td>
					<td>${board.bCreateDate }</td>
					<td>${board.boardCount }</td>
					<c:if test="${!empty board.boardFile }">
						<td>O</td>
					</c:if>
					<c:if test="${empty board.boardFile }">
						<td>X</td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>

		<!-- 반환값 없을때 -->
		<c:if test="${empty bList }">
			<tr>
				<td colspan="6" rowspan = "2" align="center">데이터가 존재하지 않습니다</td>
			</tr>
		</c:if>

		<!-- 리스트 if문 종료 -->




		<!-- 검색/ 일반 페이징 c:if 시작 -->

		<!--  일반 페이징 시작 -->
		<c:if test="${searchValue eq null }">
			<tr align="center" height="20">
				<td colspan="6">
					<!-- 	startNavi가 1일이 아닐때만 출력 --> <c:if
						test="${startNavi ne 1 && startNavi > 0}">
						<a href="/board/${urlVal }.kh?page=${startNavi-1 }">이전</a>
					</c:if> <!-- p는 기준을 삼을 임시변수 startNavi부터 시작해 endNavi까지 출력한다 --> <c:forEach
						var="p" begin="${startNavi }" end="${endNavi }">
						<c:if test="${pageNow == p  }">
							<b>${p }</b>
						</c:if>
						<c:if test="${pageNow ne p}">
							<a href="/board/${urlVal }.kh?page=${p }">${p }</a>
						</c:if>
					</c:forEach> <!-- 	endNavi가 maxPage와 같지 않을때만 출력 --> <c:if
						test="${endNavi < maxPage }">
						<a href="/board/${urlVal }.kh?page=${endNavi+1 }">다음</a>
					</c:if>

				</td>
			</tr>
		</c:if>

		<!--  검색 페이징 시작 -->
		<c:if test="${searchValue ne null }">
			<tr align="center" height="20">
				<td colspan="6">
					<!-- 	startNavi가 1일이 아닐때만 출력 --> <c:if
						test="${startNavi ne 1 && startNavi > 0}">
						<a
							href="/board/${urlVal }.kh?searchCondition=${searchCondition }&searchValue=${searchValue}&page=${startNavi-1 }">이전</a>
					</c:if> <!-- p는 기준을 삼을 임시변수 startNavi부터 시작해 endNavi까지 출력한다 --> <c:forEach
						var="p" begin="${startNavi }" end="${endNavi }">
						<c:if test="${pageNow == p}">
							<b>${p }</b>
						</c:if>
						<c:if test="${pageNow ne p}">
							<a
								href="/board/${urlVal }.kh?searchCondition=${searchCondition }&searchValue=${searchValue}&page=${p }">${p }</a>
						</c:if>
					</c:forEach> <!-- 	endNavi가 maxPage와 같지 않을때만 출력 --> <c:if
						test="${endNavi < maxPage }">
						<a
							href="/board/${urlVal }.kh?searchCondition=${searchCondition }&searchValue=${searchValue}&page=${endNavi+1 }">다음</a>
					</c:if>

				</td>
			</tr>
		</c:if>

		<!--  일반/ 검색용 페이징 종료 -->




		<tr>
			<td colspan="4" align="center">
				<form action="/board/search.kh" method="get">
					<select name="searchCondition">
						<option value="all" <c:if test="${searchCondition eq 'all' }"> selected </c:if>>전체</option>
						<option value="writer" <c:if test="${searchCondition eq 'writer' }"> selected </c:if> >작성자</option>
						<option value="title" <c:if test="${searchCondition eq 'title' }"> selected </c:if> >제목</option>
						<option value="contents" <c:if test="${searchCondition eq 'contents' }"> selected </c:if> >내용</option>
					</select> 
					
					
					<input type="text" size="25" name="searchValue"	required="required" value="${searchValue }"> 
					<input type="submit" value="검색">
				</form>
			</td>
			<td colspan="2" align="center">
				<button onclick="location.href='/board/writeView.kh';">글쓰기</button>
			</td>
		</tr>
	</table>

</body>

<script>
</script>
</html>