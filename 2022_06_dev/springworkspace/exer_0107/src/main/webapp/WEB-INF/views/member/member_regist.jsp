<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>

<body>

    <main>
        <section>
            <form action="/member/regist_info.do" method="post">
                
                <fieldset>
                    <legend>회원가입
                        
                        
                    </legend>
                    ID : <input type="text" placeholder="아이디를 입력하세요" required name="id"> 
                    <br>
                    PW : <input type="password" placeholder="비밀번호를 입력하세요" required name="pw">
                    <br>
                    PW확인 :  <input type="password" placeholder="비밀번호와 똑같이 입력하세요" required>
                    <br>
                    이름 : <input type="text" placeholder="이름을 입력하세요" required name="name">
                    
                </fieldset>

                <button type="submit">회원가입</button>
            </form>

        </section>

    </main>

</body>
</html>