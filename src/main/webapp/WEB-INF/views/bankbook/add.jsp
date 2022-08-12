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
	<form action="add.file" method="post">
	BookNum : <input type="number" name="bookNum">
	<p>
	BookName : <input type="text" name="bookName">
	</p>
	BookRate : <input type="number" name = "bookRate">
	<p>
	BookSale : <input type="number" name = "bookSale">
	</p>
	<input type="submit" value="통장등록">
	</form>

</body>
</html>