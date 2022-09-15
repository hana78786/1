<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardTitle }</title>

</head>
<body>
	<header>
		<jsp:include page="../home.jsp" />
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

			<td>${board.boardContents } <br> <c:if
					test="${board.boardRename ne null}">
					<img alt="본문이미지"
						src="/resources/buploadFiles/${board.boardRename }">

				</c:if>
			</td>
		</tr>

		<tr>
			<td colspan="2">
				<!--검색/일반의 경우 목록주소 --> <!-- 일반으로 상세 진입시 목록 --> <c:if
					test="${empty searchValue  }">
					<input type="button" value="수정"
						onclick="location.href='/board/modifyView.kh?boardNo=${board.boardNo}&page=${pageNow }';">
					<button type="button"
						onclick="location.href='/board/list.kh?page=${pageNow }';">목록</button>
				</c:if> <!-- 검색 으로 상세 진입시 --> <c:if test="${searchValue ne null }">
					<input type="button" value="수정"
						onclick="location.href='/board/modifyView.kh?boardNo=${board.boardNo}&searchCondition=${searchCondition }&searchValue=${searchValue}&page=${pageNow }';">
					<button type="button"
						onclick="location.href='/board/search.kh?searchCondition=${searchCondition }&searchValue=${searchValue}&page=${pageNow }';">목록</button>
				</c:if> <!-- 목록주소 태그 종료 -->

				<button type="button" onclick="remove()">삭제</button>
			</td>
		</tr>

	</table>

	<!--  댓글 목록 -->
	<form action="/board/addReply.kh" method="post">

		<table align="center" width="500" border="1">
			<tr>
				<td>
				<textarea rows="3" cols="55"></textarea>
				</td>
				<td>
					<button>등록하기</button>
				</td>
			</tr>

		</table>



	</form>

	</form>

	<script>
		function remove() {
			event.preventDefault(); // 하이퍼링크 이동방지
			if (window.confirm("게시물을 삭제하시겠습니까?")) {
				location.href = '/board/remove.kh?page=${pageNow}';

			}

		}
	</script>







</body>
</html>