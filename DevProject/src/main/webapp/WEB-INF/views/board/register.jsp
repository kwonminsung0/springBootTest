<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>register</h4>
	<form action="/board/post" method="post">
		<button type="submit" name="register">등록</button>
	</form>
	<a href="/board/get?list">목록</a>
</body>
</html>