<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardTitle }</title>
<link href="/resources/css/menubar-style.css" rel="stylesheet">


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
				<td ><a href="/member/myPage.kh">정보수정</a>
					<td ><a href="/member/logout.kh">로그아웃</a></td>
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
	
	
	
		<table align="center" border="1">
			<tr>
				<td>제목</td>
				<td>${board.boardTitle }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.boardWirter }</td>
				
	
			</tr>
			<tr>
				<td>작성일</td>
				<td>${board.bCreateDate }</td>
			</tr>
			<tr>
				<td>내용</td>

				<td>
						${board.boardContents }
						<br>
						
						<c:if test="${board.boardRename ne null}">
						<img alt="본문이미지" src="/resources/buploadFiles/${board.boardRename }">

						</c:if>
						</td>
			</tr>
		
			<tr>
				<td colspan="2"><input type="button" value="수정" onclick="location.href='/board/modifyView.kh?boardNo=${board.boardNo}';"> 
				
				
				<!--검색/일반의 경우 목록주소 -->
				<!-- 일반으로 상세 진입시 목록 -->
				<c:if test="${empty searchValue  }">
				<button type="button" onclick="location.href='/board/list.kh?page=${pageNow }';">목록</button>
				</c:if>
				<!-- 검색 으로 상세 진입시 -->
				<c:if test="${searchValue ne null }">
				<button type="button" onclick="location.href='/board/search.kh?searchCondition=${searchCondition }&searchValue=${searchValue}&page=${pageNow }';">목록</button>
				</c:if>
				<!-- 목록주소 태그 종료 -->
				
				<button type="button" onclick="remove()">삭제</button>
				</td>
			</tr>

		</table>


	</form>
	
	<script>
		function remove() {
			event.preventDefault(); // 하이퍼링크 이동방지
			if(window.confirm("게시물을 삭제하시겠습니까?")){
			location.href='/board/remove.kh';
						
			}
			
			
		}
	
	</script>
	
	
	
	
	
	

</body>
</html>