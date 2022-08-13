<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board Detail Page</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Num</th>
				<th>Title</th>
				<th>Content</th>
				<th>Name</th>
				<th>Date</th>
				<th>Hit</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${detail.num }</td>
				<td>${detail.title }</td>
				<td>${detail.content }</td>
				<td>${detail.userName }</td>
				<td>${detail.regist }</td>
				<td>${detail.hit }</td>
			</tr>
		</tbody>
	</table>
	<c:if test="${detail.userName eq member.user_name }">
	<a href="./update.file?num=${detail.num }">글 수정</a>
	<a href="./delete.file?num=${detail.num }">글 삭제</a>
	</c:if>

</body>
</html>