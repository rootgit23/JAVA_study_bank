<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<h1>로그인</h1>
    <form action="./Login" method="post">
        ID를 입력하세요 : <input type="text" name="id">
        <p>
        비밀번호를 입력하세요 : <input type="password" name="pw">
        </p>
        <input type="submit" value="로그인">
        <a href="/study_index.html">메인절대</a>
        <img src="../images/image.jpg">
        <img src="/images/image.jpg">
        <a href="../study_index.html">메인상대</a>
    </form>
</body>
</html>