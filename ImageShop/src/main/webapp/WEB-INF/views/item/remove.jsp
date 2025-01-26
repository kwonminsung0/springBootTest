<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/item.css">
<title>Image Shop</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<jsp:include page="/WEB-INF/views/common/menu.jsp" />
	<main align="center">
		<h2>
			<spring:message code="item.header.remove" />
		</h2>
		<form:form modelAttribute="item" action="/item/remove">
			<form:hidden path="itemId" />
			<table class="item_table">
				<tr>
					<td><spring:message code="item.itemName" /></td>
					<td><form:input path="itemName" disabled="true" /></td>
				</tr>
				<tr>
					<td><spring:message code="item.itemPrice" /></td>
					<td><form:input path="price" disabled="true" />&nbsp;원</td>
				</tr>
				<tr>
					<td><spring:message code="item.picture" /></td>
					<td><img src="picture?itemId=${item.itemId}" width="210"></td>
				</tr>
				<tr>
					<td><spring:message code="item.preview" /></td>
					<td><img src="display?itemId=${item.itemId}" width="210"></td>
				</tr>
				<tr>
					<td><spring:message code="item.itemDescription" /></td>
					<td><form:textarea path="description" disabled="true" /></td>
				</tr>
			</table>
		</form:form>
		<div>
			<button type="button" id="btnRemove">
				<spring:message code="action.remove" />
			</button>
			<button type="button" id="btnList">
				<spring:message code="action.list" />
			</button>
		</div>
	</main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script>
		$(document).ready(function() {
			let formObj = $("#item");
			$("#btnRemove").on("click", function() {
				formObj.submit();
			});

			$("#btnList").on("click", function() {
				self.location = "/item/list";
			});
		});
	</script>
</body>
</html>