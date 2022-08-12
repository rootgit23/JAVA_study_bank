<%@page import="com.im.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<a href="../member/login.file">login</a>
	<a href="/member/join.file">join</a>
	<a href="./list.file">리스트보기</a>
	<a href="./update.file?bookNum=${detail.bookNum}">수정</a>
	<a href="./delete.file?bookNum=${detail.bookNum }">삭제</a>
	
	<c:if test="${ not empty member }">
	<a href="../bankAccount/add.file?bookNum=${detail.bookNum }">상품가입하기</a>
	</c:if>

</body>
</html>