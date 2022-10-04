<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<link href="/resources/css/menubar-style.css" rel="stylesheet">


</head>
<body>
<header>
	<jsp:include page="../home.jsp"/>
	</header>




	<h1 align="center">${board.boardNo }번 게시물 수정하기</h1>
	<br>
	<br>
	
	
	<!-- enctype을 이용해 파일을 전송한다 오타조심!!!!-->
	<form action="/board/modify.kh" method="post"	enctype="multipart/form-data">
	<input type="hidden" name="boardNo" value="${board.boardNo }" readonly>
	<input type="hidden" name="boardRename" value="${board.boardRename }">
	<input type="hidden" name="boardFile" value="${board.boardFile }">
	<input type="hidden" name="boardFildpath" value="${board.boardFildpath }">
	<input type="hidden" name="searchValue" value="${searchValue }">
	<input type="hidden" name="searchCondition" value="${searchCondition }">
	<input type="hidden" name="page" value="${pageNow }">
		<table align="center" border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="boardTitle" value="${board.boardTitle }" required="required"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="boardWirter" value="${board.boardWirter }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>내용</td>

				<td><textarea id="summernote" name="boardContents"
						style="resize: none; width: 500px; height: 100%;" required="required"> ${board.boardContents }</textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="reloadFile">
				<a href="#"> ${board.boardFile }</a>

				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"> <input
					type="reset" value="취소">
					<a href="/board/list.kh">목록으로</a>
					<a href="javascript:history.go(-1);">이전페이지로</a>
					</td>
			</tr>

		</table>


	</form>

	<script>
		$('#summernote').summernote({
			height : 300, // set editor height
			minHeight : null, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true, // set focus to editable area after initializing summernote
		});
		$('[aria-label="Picture"]').css('display','none');
	</script>
</body>
</html>