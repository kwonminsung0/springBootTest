<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>read</h4>
	<form action="/board/get" method="get">
		<button type="submit" name="modify">수정</button>
		<button type="submit" name="remove">삭제</button>
	</form>
	<a href="/board/get?list">목록</a>
</body>
</html>