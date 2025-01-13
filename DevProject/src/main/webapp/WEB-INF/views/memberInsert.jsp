<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>inserMember</h1>
	<form action="/member/redirect" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="100"><br>
		date: <input type="text" name="dateOfBirth" value="2025/01/08"><br>
		car: <select name="car" multiple>
			<option value="소나타">소나타</option>
			<option value="그랜저">그랜저</option>
		</select><br> 
		postCode: <input type="text" name="address.postCode" /><br> 
		location: <input type="text" name="address.location" /><br>
		<input type="submit" value="Memberbeans">
	</form>
</body>
</html>