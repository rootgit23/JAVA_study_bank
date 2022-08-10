<%@page import="com.im.start.bank.BankMembersDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>)request.getAttribute("list"); %>
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
			<% for(BankMembersDTO bankMembersDTO : ar) { %>
				<tr>
					<td><%=bankMembersDTO.getUser_name() %></td>
					<td><%=bankMembersDTO.getName() %></td>
					<td><%=bankMembersDTO.getEmail() %></td>
					<td><%=bankMembersDTO.getPhone() %></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>