<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 리스트</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover table-condensed">
				<colgroup>
					<col width="80" align="center">
					<col width="200">
					<col width="200">
				
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>강좌이름</th>
						<th>강사이름</th>
						<th>강좌소개</th>
						<th>등록날짜</th>
						<th>개강여부</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach items="${Llist }" var="Llist">

					<tr>
					<td>${Llist.lectureNo }</td> 
					
					<td><a href="/lecture/detail.do?lectureNo=${Llist.lectureNo }">${Llist.lectureName}</a></td>
					<td>${Llist.lectrueInstructor}</td>
					
					<td>${Llist.lectureIntroduce}</td>
					<td>${Llist.regDate}</td>
					<td>${Llist.useYn}</td>
					
					<td> <button class="btn btn-xs btn-warning" onclick ="location.href='/lecture/modify.do?lectureNo=${Llist.lectureNo }'">update</button> </td>
					
					
					<td> <button class="btn btn-xs btn-danger" onclick="lectureDelete(${Llist.lectureNo });" >delete</button> </td>
					
					</tr>
					</c:forEach>
				</thead>
				<tbody>				
					 
				</tbody>
			</table>
		</div>
	</div>
</div>

 <script>
function lectureDelete(i) {
	var check = confirm("삭제하시겠습니까?")
	if(check){
		location.href='/lecture/delete.do?lectureNo='+i;
	}
	
}

		
		
 

</script>


</body>
</html>