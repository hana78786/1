<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
    
    <table>
        <tr>
            <td>

                제목
            </td>
            <td>
                이름
            </td>
        </tr>
        <c:if test="${bbslist != null}">
            <c:forEach items="${bbslist}" var="list">
                <tr>
                    <td>

                       <a href="/readbbs.do?bbsNo=${list.bbsNo }">${list.title} 
                    </td>
                       <td>
                           ${list.name}

                       </td> 
                </tr>
            </c:forEach>
        </c:if>
        
    </table>
    <button onclick="location.href='/registfree.do';">글쓰기</button>
</body>
</html>