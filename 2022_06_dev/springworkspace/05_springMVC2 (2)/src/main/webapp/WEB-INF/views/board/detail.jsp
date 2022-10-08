<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardTitle }</title>

</head>
<body onload="getReplyList();">
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


	<input type="hidden" name="refBoardNo" value="${board.boardNo }">
	<table align="center" width="500" border="1">
		<tr>
			<td><textarea rows="3" cols="55" placeholder="내용을 작성하세요"
					name="replyContents" id="replyContents" required="required"></textarea></td>
			<td>
				<button id="rSubmit">등록하기</button>
			</td>
		</tr>

	</table>


	<table align="center" width="500" border="1" id="rtb">
		<thead>
			<td colspan="4"><b id="rCount">댓글목록</b></td>
		</thead>
		<tbody>
		</tbody>

		<script>
		var reply = "";
			function getReplyList() {
				var board = "${board.boardNo}";
				$.ajax({
					url : "/board/replyList.kh",
					data : {
						"boardNo" : board
					},
					type : "get",
					success : function(result) { //댓글목록 불러오는 함수
						var $tableBody = $('#rtb tbody'); //$는 의미없음 그냥 변수명 중 하나
						$tableBody.html(''); //tbody를 초기화 시켜야 댓글 목록의 중첩을 막을수 있음 아니면 등록할떄마다 append로 이어짐
						$('#rCount').text("댓글 ("+result.length+")") //댓글수 출력
						if (result != null) {
	
							for ( var i in result) {
							
								var $tr = $("<tr id="+result[i].replyNo+">");
								var $rWriter = $("<td width='100' >").text(
										result[i].replyWirter);
								var $rContent = $("<td>").text(
										result[i].replyContents);
								var $rCreatDate = $("<td width='100'>").text(
										result[i].rCreateDate);
								var $btnArea = $("<td width='80'>").append(
										"<button onclick='modifyreply("+result[i].replyNo+")'>수정</button>").append(
										"<a href='#'>삭제</a>");

								$tr.append($rWriter);
								$tr.append($rContent);
								$tr.append($rCreatDate);
								$tr.append($btnArea);
								$tableBody.append($tr);

							}
						}

					},
					error : function() {
						console.log("요청실패");

					}
				})

			}
		</script>





		<%-- <c:forEach items="${rList }" var="reply" varStatus="i">
			<tr>
				<td width="100">${reply.replyWirter }</td>
				<td>${reply.replyContents }</td>
				<td
					<c:if test="${reply.replyWirter != loginUser.memberId }"> colspan ="2"</c:if>>${reply.rCreateDate }</td>


				<c:if test="${reply.replyWirter == loginUser.memberId }">
					<td><button type="button" onclick="modifyView(this.id)"
							id="modify${i.count }">수정</button>
						<button
							onclick="removeRply(${reply.replyNo }, '${reply.replyWirter }', ${board.boardNo });">삭제</button>
					</td>
				</c:if>


			</tr>
			<tr class="modifyViews">
				<form action="/board/modifireply.do" method="post">
					<td colspan="3"><input type="hidden" name="replyNo"
						value="${reply.replyNo }"> <input type="hidden"
						name="refBoardNo" value="${board.boardNo }"> <input
						type="hidden" name="replyWirter" value="${reply.replyWirter }">
						<textarea rows="3" cols="55" placeholder="내용을 작성하세요"
							name="replyContents" required="required" id="${reply.replyNo }">
							${reply.replyContents }
					</textarea></td>
					<td>
						<button>수정</button>
						<button onclick="modifyCancle('modify${i.count }')" type="button">취소</button>
					</td>
				</form>
			</tr>
		</c:forEach> --%>
	</table>


	</form>

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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

	 /* 	
	 			function modifyreply(rNo){
				var replyContets = document.getElementById(rNo).innerHTML;
				
				var $form= $("<form>");
				$form.att("action", "/board/modifyReply.kh");
				$form.append("<inpyt type='hidden' value='replyContets');
				$form.append("<inpyt type='hidden' value'"+rNO+"' name='replyNo'>");
				console.log($form[0]);
				$form.appendTo("body");
				
			}  */

		function removeRply(replyNo, replyWriter, boardNo) {
			event.preventDefault();
			if (confirm("정말 삭제하시겠습니까?")) {
				var $delform = $("<form>");
				$delform.attr("action", "/board/removeReply.kh");
				$delform.attr("method", "post");
				$delform
						.append("<input type='hidden' name='replyNo' value='"+replyNo+"'>");
				$delform
						.append("<input type='hidden' name='replyWirter' value='"+replyWriter+"'>");
				$delform
						.append("<input type='hidden' name='boardNo' value='"+boardNo+"'>");
				$delform.appendTo("body");
				$delform.submit();
			}
		}

		$('#rSubmit').on("click", function() {
			var replyContents = $("#replyContents").val();
			var refBoradNo = "${board.boardNo}"
			$.ajax({
				url : "/board/replyAdd.kh",
				data : {
					"replyContents" : replyContents,
					"refBoardNo" : refBoradNo
				},
				type : "post",
				success : function(result) {
					if (result == "success") {
						alert("등록성공")
					}
					$('#replyContents').val('') //댓글 등록시 댓글 등록창 초기화
					getReplyList(); //등록후 댓글 목록 불러오기 함수 실행
					//DOM 조작 함수호츨 등 가능
				},
				error : function() {
					alert("등록 실패")

				}
			})
		})
		
		function modifyreply(rNo) {	
			$.ajax({
				url : "/board/replyModi.kh",
				data : {
					"replyNo" : rNo,
				},
				type : "get",
				success : function(result) {
					
						var $td = $("<td colspan='3'>");
						var $textarea= "<textarea rows='3' cols='55' placeholder='내용을 작성하세요' name='replyContents' id='replyContents"+rNo+"' required='required'>"
						+result.rContents+"</textarea>"
						var apTd = "<td><button onclick='modifyDo("+rNo+")'>수정하기</button> <button onclick='getReplyList();'>취소</button> "
						$td.html($textarea)

						console.log(result.rContents);
						$('#'+rNo).html('');
						$('#'+rNo).append($td).append(apTd);
						
						
					
					
				},
				error : function() {
					alert("등록 실패")

				}
			})
			
			
		}
		
		function modifyDo(rNo){
			var replyContents = $('#replyContents'+rNo).val();
			$.ajax({
				url : "/board/modifireply.do",
				data : {
					"replyContents" : replyContents,
					"replyNo" : rNo
				},
				type : "post",
				success : function(result) {
					if (result == "success") {
						alert("등록성공")
					}

					getReplyList(); //등록후 댓글 목록 불러오기 함수 실행
					//DOM 조작 함수호츨 등 가능
				},
				error : function() {
					alert("등록 실패")

				}
			})
			
			
		}

			
			
		
	</script>







</body>
</html>