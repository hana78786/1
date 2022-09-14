<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/menubar-style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>


	<header>
		<h1 align="center">Welcome Our WebSite!</h1>

		<!-- ${empty sessionScope.loginUser } -->
		<c:if test="${sessionScope.loginUser eq null}">
			<div class="login-area">
				<form action="/member/login.kh" method="post">
					<table align='right'>
						<tr>
							<td>아이디 :</td>
							<td><input type="text" name="memberId"></td>
							<td rowspan="2"><input type="submit" value="로그인"></td>
						</tr>
						<tr>
							<td>비밀번호 :</td>
							<td><input type="password" name="memberPw"></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="3"><a href="/member/joinView.kh">회원가입</a></td>

						</tr>
					</table>

				</form>
			</div>
		</c:if>

		<!-- ${not empty sessionScope.loginUser } -->
		<c:if test="${sessionScope.loginUser ne null}">
			<div class="login-area">
				<table align="right">
					<tr>
						<td colspan="3" rowspan="2">${loginUser.memberName }님환영합니다</td>
					</tr>
					<tr>

					</tr>
					<tr>
						<td><a href="/member/myPage.kh">정보수정</a>
						<td><a href="/member/logout.kh">로그아웃</a></td>
					</tr>
				</table>
			</div>
		</c:if>



		<div class="nav-area">
			<div class="menu" onclick="location.href='/home.kh';">Home</div>
			<div class="menu" onclick="showNoticeList();">공지사항</div>
			<div class="menu" onclick="location.href='/board/list.kh';">자유게시판</div>
			<div class="menu" onclick="">사진게시판</div>
		</div>

		<script>
			function showNoticeList() {

			}
		</script>
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


		<c:forEach items="${bList }" var="board" varStatus="i">
			<tr>
				<td>${i.count }</td>
				
				<c:if test="${searchValue eq null }">
				<td><a href="/board/detail.kh?boardNo=${board.boardNo }">${board.boardTitle }</td>
				</c:if>
				
				<c:if test="${searchValue ne null }">
				<td><a href="/board/detail.kh?boardNo=${board.boardNo }&searchCondition=${searchCondition }&searchValue=${searchValue}">${board.boardTitle }</td>
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

		<!-- 검색/ 일반 페이징 c:if -->

		<!--  일반 페이징 시작 -->
		<c:if test="${searchValue eq null }">
			<tr align="center" height="20">
				<td colspan="6">
					<!-- 	startNavi가 1일이 아닐때만 출력 --> <c:if
						test="${startNavi ne 1 && startNavi > 0}">
						<a href="/board/list.kh?page=${startNavi-1 }">이전</a>
					</c:if> <!-- p는 기준을 삼을 임시변수 startNavi부터 시작해 endNavi까지 출력한다 --> <c:forEach
						var="p" begin="${startNavi }" end="${endNavi }">
						<c:if test="${pageNow == p  }">
							<b>${p }</b>
						</c:if>
						<c:if test="${pageNow ne p}">
							<a href="/board/list.kh?page=${p }">${p }</a>
						</c:if>
					</c:forEach> <!-- 	endNavi가 maxPage와 같지 않을때만 출력 --> <c:if
						test="${endNavi < maxPage }">
						<a href="/board/list.kh?page=${endNavi+1 }">다음</a>
					</c:if>

				</td>
			</tr>
		</c:if>

		<!--  검색 페이징 시작 -->
		<c:if test="${searchValue ne null }">
		<input type="hidden" name="searchCondition" value="${searchCondition }">
		<input type="hidden" name="searchValue" value="${searchValue}">
			<tr align="center" height="20">
				<td colspan="6">
					<!-- 	startNavi가 1일이 아닐때만 출력 --> <c:if
						test="${startNavi ne 1 && startNavi > 0}">
						<a
							href="/board/search.kh?searchCondition=${searchCondition }&searchValue=${searchValue}&page=${startNavi-1 }">이전</a>
					</c:if> <!-- p는 기준을 삼을 임시변수 startNavi부터 시작해 endNavi까지 출력한다 --> <c:forEach
						var="p" begin="${startNavi }" end="${endNavi }">
						<c:if test="${pageNow == p  }">
							<b>${p }</b>
						</c:if>
						<c:if test="${pageNow ne p}">
							<a
								href="/board/search.kh?searchCondition=${searchCondition }&searchValue=${searchValue}&page=${p }">${p }</a>
						</c:if>
					</c:forEach> <!-- 	endNavi가 maxPage와 같지 않을때만 출력 --> <c:if
						test="${endNavi < maxPage }">
						<a
							href="/board/search.kh?searchCondition=${searchCondition }&searchValue=${searchValue}&page=${endNavi+1 }">다음</a>
					</c:if>

				</td>
			</tr>
		</c:if>

		<!--  일반/ 검색용 페이징 종료 -->




		<tr>
			<td colspan="4" align="center">
				<form action="/board/search.kh" method="get">
					<select name="searchCondition">
						<option value="all">전체</option>
						<option value="writer">작성자</option>
						<option value="title">제목</option>
						<option value="contents">내용</option>
					</select> <input type="text" size="25" name="searchValue" required="required"> <input
						type="submit" value="검색">
				</form>
			</td>
			<td colspan="2" align="center">
				<button onclick="location.href='/board/writeView.kh';">글쓰기</button>
			</td>
		</tr>
	</table>

</body>
</html>