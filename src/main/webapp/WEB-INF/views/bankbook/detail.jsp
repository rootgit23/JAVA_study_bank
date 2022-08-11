<%@page import="com.im.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	<%
	//요청이 발생하면 발생, 응답이 나가면 소멸 : RequestScope
	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail");
	>%
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Detail</h1>
	<table border="1">
			<thead>
				<tr>
					<th>BOOKNUM</th><th>BOOKNAME</th><th>BOOKRATE</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${requestScope.detail.getBookNum()}</td>
					<td>${requestScope.detail.bookName}</td>
					<td>${detail.bookRate}</td>
					<td>
					
					</td>
				</tr>
			</tbody>
	</table>
	<a href="../member/Login">login</a>
	<a href="/member/join">join</a>
	<a href="./list">리스트보기</a>
	<a href="./update?bookNum=${detail.bookNum}">수정</a>
	<a href="./delete?bookNum=${detail.bookNum }">삭제</a>

</body>
</html>