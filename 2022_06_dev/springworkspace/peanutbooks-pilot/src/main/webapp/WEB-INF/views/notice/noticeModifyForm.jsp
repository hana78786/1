<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정페이지</title>
<!-- jQuery, bootstrap  -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
 <style>
	.container {
		width: 70%;
		max-width: 1000px;
		margin: 0 auto;
	}
	.btn {
	  appearance: none;
	    -webkit-appearance: none;
	  font-family: sans-serif;
	  cursor: pointer;
	  padding: 12px;
	  min-width: 150px;
	  border: none;
	    -webkit-transition: background-color 100ms linear;
	    -ms-transition: background-color 100ms linear;
	     transition: background-color 100ms linear;
	}
</style> 

<body>
<!-- header start -->
<jsp:include page="../header/header.jsp"></jsp:include>
<!-- header End -->

<!-- main contents start -->
<main>
<br><br>	
<div class="container">

	<h3 align="center">${notice.noticeNo }번 공지사항 수정하기</h3>
	<br><br>
		
	<form action="/notice/modify.kh" method="post" enctype="multipart/form-data" name="noticeForm">
		<input type="hidden" name="page" value="${page }">
		<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
		<input type="hidden" name="noticeFilename" value="${notice.noticeFilename }">
		<input type="hidden" name="noticeFileRename" value="${notice.noticeFileRename }">
		<table align="center" class="table col-10">
			<tr>
				<td  class="col-2" scope="col" align="center">종류</td>
				<td>
					<select name="noticeCategory"  class="form-select" aria-label="Default select example" >
						<option value="notice" <c:if test="${notice.noticeCategory == 'notice'}">selected</c:if>>공지</option>
						<option value="update" <c:if test="${notice.noticeCategory == 'update'}">selected</c:if>>업데이트</option>
						<option value="event" <c:if test="${notice.noticeCategory == 'event'}">selected</c:if>>이벤트</option>
						<option value="info" <c:if test="${notice.noticeCategory == 'info'}">selected</c:if>>안내</option>
					</select>
				</td>
			<tr>
				<td  class="col-2" scope="col" align="center">작성자</td>
				<td><input type="text" name="noticeWriter"  class="form-control" value="${notice.noticeWriter }" readonly></td>
			</tr>
			<tr>
				<td  class="col-2" scope="col" align="center">제목</td>
				<td><input type="text" name="noticeTitle" onkeyup="titleLengthCk(this);" class="form-control" value="${notice.noticeTitle }"></td>
			</tr>
			<tr>
				<td  class="col-2" scope="col" align="center">내용</td>
				<td> <textarea class="form-control" id="exampleFormControlTextarea1" cols="50" rows="20" name="noticeContents">${notice.noticeContents }</textarea>  </td>
			</tr>
		<c:if test="${!empty notice.noticeFileRename }">
			<tr>
				<td  class="col-2" scope="col" align="center">첨부파일</td>
				<td>
					<a href=""  onclick="fnImgPop(this.src)"><img alt="본문이미지" 
					src="/resources/nuploadFiles/${notice.noticeFileRename }" 
					style="width:200px; height:200px;" onclick="fnImgPop(this.src)"></a>
				</td>
			</tr>
			<tr>
				<td  class="col-2" scope="col" align="center">첨부파일 수정</td>
				<td>
					<input type="file" name="reloadFile">
					<a href="#">${notice.noticeFilename }</a>
				</td>
			</tr>
		</c:if>
		<c:if test="${empty notice.noticeFileRename }">
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="reloadFile">
				</td>
			</tr>
		</c:if>
			<tr>
				<td colspan="2" align="center">
					<input onclick="noticeCheck();" type="button" value="수정" class="btn btn-warning btn-sm">
					<button type="button" onclick="backBtn()" class="btn btn-warning btn-sm">목록</button> 
					 
				</td>
			</tr>
		</table>
	</form>
</div>
<br><br>
</main>
<!-- main contents End -->


<script>
	function backBtn() {
	    history.back();
	}
	
	function titleLengthCk(thisInput){
	 	console.log(thisInput.value.length);
	 	if(thisInput.value.length>30){
	 		thisInput.value = thisInput.value.substr(0,30);
	 	}	
	}
	function noticeCheck() {
		if(noticeForm.noticeTitle.value=="") { // document 를 생략해도 됨
	        alert("제목을 입력하세요!");
	        noticeForm.noticeTitle.focus();
	    	return false;
	    }else if(noticeForm.noticeContents.value==""){
	        alert("내용을 입력하세요");
	        noticeForm.noticeContents.focus();
	        return false;
	    }
		return noticeForm.submit();
	 }
	
	
</script>

<!-- Footer -->
<jsp:include page="../footer/footer.jsp"></jsp:include>
<!-- Footer -->
</body>
</html>