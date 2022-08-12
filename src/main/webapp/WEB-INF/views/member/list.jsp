<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${pageScope.dto.user_name }</td>
					<td>${pageScope.dto.name }</td>
					<td>${pageScope.dto.email }</td>
					<td>${pageScope.dto.phone }</td>
				</tr>
			
			</c:forEach>
			
			<%--<% for(BankMembersDTO bankMembersDTO : ar) { 
				<tr>
					<td><%=bankMembersDTO.getUser_name() %></td>
					<td><%=bankMembersDTO.getName() %></td>
					<td><%=bankMembersDTO.getEmail() %></td>
					<td><%=bankMembersDTO.getPhone() %></td>
				</tr>
			<%} %>--%>
		</tbody>
	</table>
</body>
</html>