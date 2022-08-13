<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board Add Page</h1>
	<form action="add.file" method = "post">
		<div>
		작성자 : <input type="text" name="userName" readonly="readonly" value=${member.user_name }>
		</div>
		<div>
		제목 : <input type="text" name="title">
		</div>
		<div>
		내용 : <input type="text" name="content">
		</div>
		<button type="submit">입력</button>
	</form>

</body>
</html>