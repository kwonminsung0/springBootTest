<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/register">
		<input type=submit value=register(GET)>
	</form>
	<form action="/board/register" method="post">
		<input type=submit value=register(POST)>
	</form>
	<form action="/board/modify">
		<input type=submit value=modify(GET)>
	</form>
	<form action="/board/modify" method="post">
		<input type=submit value=modify(POST)>
	</form>
	<form action="/board/remove">
		<input type=submit value=remove(GET)>
	</form>
	<form action="/board/list" method="post">
		<input type=submit value=list(POST)>
	</form>
</body>
</html>