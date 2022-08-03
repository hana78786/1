<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!--  라이브러리 파일을 넣고 불러오는 작업이 필요 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core Tags 실습</title>
</head>
<body>
<h2>JSTL Core Tags1 실습</h2>
<c:set var ="num1" value="100"></c:set>
<c:set var="num2" value="200"></c:set>
<ol>
	<li><c:out value="${num1 }" ></c:out></li>
	<li><c:out value="${num2 }" ></c:out></li>
</ol>

	<h2>JSTL Core Tags2 실습</h2>
	<c:set var="number" value="300" scope="request"></c:set>
	request : ${requestScope.number}
</body>
</html>