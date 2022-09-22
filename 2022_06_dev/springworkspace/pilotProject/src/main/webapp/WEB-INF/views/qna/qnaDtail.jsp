<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${qa.qaTitle }</title>

<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		crossorigin="anonymous">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</head>
<body>

q&a번호: ${qa.qaNo }
제목 :<c:if test="${qa.qaSecret == true}">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
  <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z"/>
</svg>
</c:if>
 ${qa.qaTitle }
작성자 : ${qa.memberEmail }
내용 : ${qa.qaContents }
작성일자 : ${qa.qaInsertDate }



<c:if test="${qa.qaFile1Rename ne null}">
<img src="/resources/qnaImg/${qa.qaFile1Rename}">
</c:if>
<c:if test="${qa.qaFile2Rename ne null}">
<img src="/resources/qnaImg/${qa.qaFile2Rename}">
</c:if>
<c:if test="${qa.qaFile3Rename ne null}">
<img src="/resources/qnaImg/${qa.qaFile3Rename}">
</c:if>
<c:if test="${qa.qaFile4Rename ne null}">
<img src="/resources/qnaImg/${qa.qaFile4Rename}">
</c:if>
<c:if test="${qa.qaFile5Rename ne null}">
<img src="/resources/qnaImg/${qa.qaFile5Rename}">
</c:if> 

<button onclick="location.href='/qna/List.do'">목록으로</button>
<button onclick="location.href='/qna/modifyView.do?qaNo=${qa.qaNo}'">수정하기</button>
<button onclick="location.href='/qna/remove.do?qaNo=${qa.qaNo}'">삭제하기</button>


<article id="reply-area">
				<div id="article3-area">
					<hr>

					<!-- 코멘트 출력영역 시작 -->
					<c:forEach items="${qcList}" var="qcList">
						<!-- 코멘트 한개 출력 -->
						<div id="oneComment">
							<div id="comment" class="row my-2">
								<div id="comment-picture" class="col-md-2 d-none d-md-inline">
									<!-- 코맨트 사진영역 -->

									<svg xmlns="http://www.w3.org/2000/svg" width="80%"
										height="80%" fill="currentColor"
										class="bi bi-person-bounding-box" viewBox="0 0 16 16">
				  					<path
											d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1h-3zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5zM.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5zm15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5z" />
				  					<path
											d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
									</svg>

								</div>
								<!-- 코멘트 사진 영역 종료 -->

								<div id="commnet-contens" class="col-md-10">
									<!-- 코멘트 내용 영역 -->
									<div
										class="shadow-lg p-3 mb-5 bg-body rounded mt-4 text-justify">
										<div id="comment-row" class="row">
											<div id="comment-writer" class="col-md-10">
												<h4>${qcList.memberEmail }</h4>
											</div>
											<div id="comment-button" class="col-md-2"
												style="text-align: right">신고</div>
										</div>
										<div id="comment-text-area">
											<span>${qcList.qaCommentDate }</span> <br>
											<p>${qcList.qaCommentContents }</p>
										</div>
										<div id="comment-delmodi-buttom-area"
											style="text-align: right">
											<button type="button" onclick="modifyViewOn(this);"
												class="btn btn-outline-primary">수정</button>
											<button onclick="removeComment(${qcList.qaCommentNo},${qcList.qaNo} );" class="btn btn-outline-primary">삭제</button>

										</div>

									</div>
								</div>
							</div>
							<!-- 코멘트 내용영역종료 -->
						</div>
						<!-- 코멘트 수정영역 시작 -->
						<div class="modifyView">
							<form action="/qna/commentModify.do" method="post">
								<div id="comment-modify-area" class="row my-2">
									<input type="hidden" value="${qcList.memberEmail }"
										name="memberEmail"> <input type="hidden"
										value="${qcList.qaNo }" name="qaNo">
										<input type="hidden"
										value="${qcList.qaCommentNo }" name="qaCommentNo">
									<div id="comment-textarea" class="col-md-11">
										<!-- 세션에서 사용자 id가지고 올것 -->
										<div class="form-floating">
											<textarea name="qaCommentContents" class="form-control"
												placeholder="Leave a comment here" id="floatingTextarea2"
												style="height: 100px">${qcList.qaCommentContents }</textarea>
											<label for="floatingTextarea2">댓글을 등록해주세요</label>
										</div>
									</div>

									<div id="comment-button-area" class="col-md-1">
										<input type="submit" value="수정" style="height: 50%;"
											class="btn btn-outline-primary">
										<button type="button" style="height: 50%;"
											onclick="modifyViewOff(this)"
											class="btn btn-outline-danger my-1">취소</button>
									</div>
								</div>
							</form>
						</div>
						<!-- 코멘트 수정영역 종료 -->

						<!-- 코멘트 출력 영역종료 -->
					</c:forEach>
					<hr>

					<!-- 코멘트 작성영역 -->

					<form action="/qna/commentWrite.do" method="post">
						<div id="comment-write-area" class="row">
							<input type="hidden" value="" name="memberEmail">
							 <input type="hidden" value="${qa.qaNo }" name="qaNo">
							 <input type="hidden" value="0" name="qaCommentNo">
							<div id="comment-textarea" class="col-md-11">
								<!-- 세션에서 사용자 id가지고 올것 -->
								<div class="form-floating">
									<textarea name="qaCommentContents" class="form-control"
										placeholder="" id="floatingTextarea2"
										style="height: 100px"></textarea>
									<label for="floatingTextarea2">댓글을 등록해주세요</label>
								</div>
							</div>

							<div id="comment-button-area" class="col-md-1">
								<input type="submit" value="등록" style="height: 100%;"
									class="btn btn-outline-primary">
							</div>



						</div>
						<!-- 코멘트 작성영역 종료 -->
					</form>


				</div>
				<!-- 아트클3 에어리어 div종료 -->
			</article>
			<!-- 아티클3 종료 -->

		</div>
		</article>
		<!-- 아티클 전체 들어감 -->


<script>




//코멘트 수정창 안보이게 하기
var modifyView = document.querySelectorAll('.modifyView')
for(var i=0; i<modifyView.length;i++){
	modifyView[i].style.display='none';
}

//코멘트 수정창 열기
function modifyViewOn(obj) {
	obj.parentElement.parentElement.parentElement.parentElement.parentElement.style.display='none'
	obj.parentElement.parentElement.parentElement.parentElement.parentElement.nextElementSibling.style.display='block'

	
}

//코멘트 수정창 닫기
function modifyViewOff(obj) {
	obj.parentElement.parentElement.parentElement.parentElement.style.display='none';
	obj.parentElement.parentElement.parentElement.parentElement.previousElementSibling.style.display="block";
}

//댓글 삭제 확인
function removeComment(commentNo,qaNo) {
	
	if(confirm("댓글을 삭제 하시겠습니까? 삭제하면 복구할수 없습니다")){
		location.href='/qna/removeComment.do?qaCommentNo='+commentNo+'&qaNo='+qaNo;
	}
	
}
</script>



</body>
</html>