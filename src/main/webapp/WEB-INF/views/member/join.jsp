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
        ID를 입력하세요 : <input type="text" name="ID">
        <p>
        비밀번호를 입력하세요 : <input type="password" name="pw">
        </p>
        이름을 입력하세요 : <input type="text" name="name">
        <p>
        이메일을 입력하세요 : <input type="email" name="email">
        </p>
        전화번호를 입력하세요 : <input type="tel" name="phone">
        <p>
        <input type="submit" value="회원가입">
        </p>
    </form>
</body>
</html>