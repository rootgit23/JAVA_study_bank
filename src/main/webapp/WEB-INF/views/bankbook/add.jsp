<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>통장 등록</h1>
	<form action="add" method="post">
	BookNum : <input type="number" name="booknum">
	<p>
	BookName : <input type="text" name="bookname">
	</p>
	BookRate : <input type="number" name = "bookrate">
	<p>
	BookSale : <input type="number" name = "booksale">
	</p>
	<input type="submit" value="통장등록">
	</form>

</body>
</html>