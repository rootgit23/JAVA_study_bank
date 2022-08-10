<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
    <h1>회원가입</h1>
    <form action="join" method="post">
        ID를 입력하세요 : <input type="text" name="USER_NAME">
        <p>
        비밀번호를 입력하세요 : <input type="password" name="PASSWORD">
        </p>
        이름을 입력하세요 : <input type="text" name="NAME">
        <p>
        이메일을 입력하세요 : <input type="email" name="EMAIL">
        </p>
        전화번호를 입력하세요 : <input type="tel" name="PHONE">
        <p>
        <input type="submit" value="회원가입">
        </p>
    </form>
</body>
</html>