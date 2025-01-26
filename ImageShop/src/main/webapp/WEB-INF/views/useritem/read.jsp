<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/useritem.css">
<title>Image Shop</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<jsp:include page="/WEB-INF/views/common/menu.jsp" />
	<main align="center">
		<h2>
			<spring:message code="useritem.header.read" />
		</h2>

		<form:form modelAttribute="userItem">
			<form:hidden path="userItemNo" />

			<table class="useritem_table">
				<tr>
					<td><spring:message code="useritem.itemName" /></td>
					<td><form:input path="itemName" readonly="true" /></td>
					<td><font color="red"><form:errors path="itemName" /></font></td>
				</tr>
				<tr>
					<td><spring:message code="useritem.itemPrice" /></td>
					<td><form:input path="price" readonly="true" /></td>
					<td><font color="red"><form:errors path="price" /></font></td>
				</tr>
				<tr>
					<td><spring:message code="useritem.itemFile" /></td>
					<td><img src="/item/display?itemId=${userItem.itemId}" width="210"></td>
				</tr>
				<tr>
					<td><spring:message code="useritem.itemDescription" /></td>
					<td><form:textarea path="description" readonly="true" /></td>
					<td><font color="red"><form:errors path="description" /></font></td>
				</tr>
			</table>
		</form:form>
		<div>
			<button type="button" id="btnList">
				<spring:message code="action.list" />
			</button>
		</div>
	</main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script>
		$(document).ready(function() {

			let formObj = $("#useritem");

			$("#btnList").on("click", function() {
				self.location = "/useritem/list";
			});

		});
	</script>
</body>
</html>