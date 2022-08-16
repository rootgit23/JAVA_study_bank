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
	<h3>Board List Page</h3>
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
			<c:forEach items="${list }" var = "dto">
				<tr>
					<td>${dto.num }</td>
					<td><a href="./detail.file?num=${dto.num}">${dto.title }</a></td>
					<td>${dto.content }</td>
					<td>${dto.userName }</td>
					<td>${dto.regist }</td>
					<td>${dto.hit }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${not empty member }">
	<a href="./add.file">글 작성</a>
	</c:if>

</body>
</html>