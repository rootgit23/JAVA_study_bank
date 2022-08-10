<%@page import="com.im.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail");
%>
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
					<th>BOOKNUM</th><th>BOOKNAME</th><th>BOOKRATE</th><th>BOOKSALE</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%= bankBookDTO.getBookNum() %></td>
					<td><%= bankBookDTO.getBookName() %></td>
					<td><%= bankBookDTO.getBookRate() %></td>
					<td><%if (bankBookDTO.getBookSale() == 1) {%>
					판매중
					<%} else{ %>
					판매금지
					<%} %>
					</td>
				</tr>
			</tbody>
	</table>
	<a href="../member/Login">login</a>
	<a href="/member/join">join</a>
	<a href="./list">리스트보기</a>

</body>
</html>