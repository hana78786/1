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
<jsp:include page="../common/menuBar.jsp"></jsp:include>
<br> <br>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover table-condensed">
				<colgroup>
					<col width="80" align="center">
					<col width="200">
					<col width="200">
					<col width="400">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>회원ID</th>
						<th>이름</th>
						<th>주소</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach items="${members }" var="member" varStatus="i">
					<!-- var가 출력되는 이름 items가 들어있는 벨류! --> 
					<tr>
					<td>${i.index }</td> 
					<!-- count를 쓰면 1 index를 쓰면 0부터 시작함 -->
					<td>${member.memberId }</td>
					<td> <a href="/member/detail.do?memberId=${member.memberId }"> ${member.memberName } </a></td>
					<%-- ?memberId=${member.memberId } 이렇게 ? = 으로 키값을 전달하는 주소를 쿼리 스트링이라고 함 --%>
					<td>${member.memberAddress }</td>
				<c:if test="${sessionScope.member.memberId eq member.memberId }">	
					<td><a class="btn btn-xs btn-warning" href='/member/modify.do'>update</a></td>
					
					
					<td> <a class="btn btn-xs btn-danger" href="/member/delete.do">delete</a> </td>
					</c:if>
					</tr>
					</c:forEach>
				</thead>
				<tbody>				
				
				</tbody>
			</table>
		</div>
	</div>
</div>



</body>
</html>