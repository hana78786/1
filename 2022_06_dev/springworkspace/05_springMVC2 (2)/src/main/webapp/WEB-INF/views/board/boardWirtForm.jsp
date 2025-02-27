<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
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




	<h1 align="center">게시글 등록 페이지</h1>
	<br>
	<br>
	
	
	<!-- enctype을 이용해 파일을 전송한다 오타조심!!!!-->
	<form action="/board/register.kh" method="post"	enctype="multipart/form-data">
		<table align="center" border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="boardTitle"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="boardWirter" value="${loginUser.memberName }" readonly></td>
			</tr>
			<tr>
				<td>내용</td>

				<td><textarea id="summernote" name="boardContents"
						style="resize: none; width: 500px; height: 100%;"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="uploadFile"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"> <input
					type="reset" value="취소"></td>
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
	</script>
</body>
</html>