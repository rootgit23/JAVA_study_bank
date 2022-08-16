<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board Update Page</h1>
	<form action="update.file" method="post">
		<input type="hidden" name="num" readonly="readonly" value=${detail.num }>
		<div>
			제목 : <input type="text" name="title" value=${detail.title }>
		</div>
		<div>
			내용 : <input type="text" name="content" value=${detail.content }>
		</div>
		<button type="submit">글 수정</button>
	</form>

</body>
</html>