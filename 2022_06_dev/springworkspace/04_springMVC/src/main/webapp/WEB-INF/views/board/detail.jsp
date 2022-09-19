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



	<table align="center" border="1" width="500">
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

			<td>${board.boardContents }<br> <c:if
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
		<input type="hidden" name="refBoardNo" value="${board.boardNo }">
		<table align="center" width="500" border="1">
			<tr>
				<td><textarea rows="3" cols="55" placeholder="내용을 작성하세요"
						name="replyContents" required="required"></textarea></td>
				<td>
					<button>등록하기</button>
				</td>
			</tr>

		</table>
	</form>

	<table align="center" width="500" border="1">
${rList.get(0).replyWirter }
		<c:forEach items="${rList }" var="reply" varStatus="i">
			<tr>
				<td width="100">${reply.replyWirter }</td>
				<td>${reply.replyContents }</td>
				<td <c:if test="${reply.replyWirter != loginUser.memberId }"> colspan ="2"</c:if> >${reply.rCreateDate }</td>
				
				
				<c:if test="${reply.replyWirter == loginUser.memberId }">				
				<td><button type="button" onclick="modifyView(this.id)"
						id="modify${i.count }">수정</button> 
						<button onclick="removeRply(${reply.replyNo }, '${reply.replyWirter }', ${board.boardNo });">삭제</button> 
						</td>
				</c:if>
				
				
			</tr>
			<tr class="modifyViews">
				<form action="/board/modifireply.do" method="post">
					<td colspan="3"><input type="hidden" name="replyNo"
						value="${reply.replyNo }"> <input type="hidden"
						name="refBoardNo" value="${board.boardNo }">
						<input type="hidden" name="replyWirter"
						value="${reply.replyWirter }">
						 <textarea
							rows="3" cols="55" placeholder="내용을 작성하세요" name="replyContents"
							required="required" id="${reply.replyNo }">
							${reply.replyContents }
					</textarea></td>
					<td>
						<button>수정</button>
						<button onclick="modifyCancle('modify${i.count }')" type="button">취소</button>
					</td>
				</form>
			</tr>
		</c:forEach>
	</table>


	</form>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
	
	
		var modifyViews = document.getElementsByClassName('modifyViews')
		for (var i = 0; i < modifyViews.length; i++) {
			modifyViews[i].style.display = 'none'
		}
		function modifyCancle(idI) {
			var modifiId = document.getElementById(idI);
			modifiId.parentElement.parentElement.style.display = '';
			modifiId.parentElement.parentElement.nextElementSibling.style.display = 'none';
		}
		function modifyView(idI) {
			var modifiId = document.getElementById(idI);
			modifiId.parentElement.parentElement.style.display = 'none';
			modifiId.parentElement.parentElement.nextElementSibling.style.display = '';
		}
		function remove() {
			event.preventDefault(); // 하이퍼링크 이동방지
			if (window.confirm("게시물을 삭제하시겠습니까?")) {
				location.href = '/board/remove.kh?page=${pageNow}';
			}
		}
		
	/* 	function modifyreply(rNo){
			event.preventDefault();
			var replyContets = document.getElementById(rNo).innerHTML;
			
			var $form= $("<form>");
			$form.att("action", "/board/modifyReply.kh");
			$form.append("<inpyt type='hidden' value='replyContets');
			$form.append("<inpyt type='hidden' value'"+rNO+"' name='replyNo'>");
			console.log($form[0]);
			$form.appendTo("body");
			
		} */
		
	function removeRply(replyNo, replyWriter,boardNo){
			event.preventDefault();
			if(confirm("정말 삭제하시겠습니까?")){
			var $delform = $("<form>");
			$delform.attr("action","/board/removeReply.kh");
			$delform.attr("method", "post");
			$delform.append("<input type='hidden' name='replyNo' value='"+replyNo+"'>");
			$delform.append("<input type='hidden' name='replyWirter' value='"+replyWriter+"'>");
			$delform.append("<input type='hidden' name='boardNo' value='"+boardNo+"'>");
			$delform.appendTo("body");
			$delform.submit();
			}
		}
		
	</script>







</body>
</html>