<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${ empty member}">

<a href="/member/login.file">Login</a>
<a href="/member/join.file">Join</a>
</c:if>

<c:if test="${ not empty member }">
<h3>${member.name } 님 환영합니다</h3>
<a href="./member/logout.file">LogOut</a>
<a href="#">MyPage</a>
</c:if>

<a href="/bankbook/list.file">상품리스트</a>
<a href="/bankbook/add.file">Add</a>
<a href="/member/search.file">검색</a>
<a href="/bankbook/update.file">업데이트</a>
<a href="/board/list.file">글 목록보기</a>

</body>
</html>
