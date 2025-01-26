<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/board.css">
<title>Image Shop</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<jsp:include page="/WEB-INF/views/common/menu.jsp" />
	<main align="center">
		<h2>
			<spring:message code="board.header.list" />
		</h2>
		<!-- 검색 폼을 만든다. -->
		<form:form modelAttribute="pgrq" method="get" action="list${pgrq.toUriStringByPage(1)}">
			<form:select path="searchType" items="${searchTypeCodeValueList}" itemValue="value" itemLabel="label" />
			<form:input path="keyword" />
			<button id='searchBtn'>
				<spring:message code="action.search" />
			</button>
		</form:form>

		<sec:authorize access="hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')">
			<a href="/board/register"><spring:message code="action.new" /></a>
		</sec:authorize>
		<table border="1" class="board_table">
			<tr>
				<th align="center" width="80"><spring:message code="board.no" /></th>
				<th align="center" width="320"><spring:message code="board.title" /></th>
				<th align="center" width="100"><spring:message code="board.writer" /></th>
				<th align="center" width="180"><spring:message code="board.regdate" /></th>
			</tr>
			<c:choose>
				<c:when test="${empty list}">
					<tr>
						<td colspan="4"><spring:message code="common.listEmpty" /></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list}" var="board">
						<tr>
							<td align="center">${board.boardNo}</td>
							<!-- 게시글 상세보기할 때 페이징 요청 정보를 매개변수로 전달한다. -->
							<td align="left"><a href="/board/read${pgrq.toUriString(pgrq.page)}&boardNo=${board.boardNo}"><c:out value="${board.title}" /></a></td>
							<td align="right">${board.writer}</td>
							<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regDate}" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<!-- 페이징 네비게이션 -->
		<div>
			<c:if test="${pagination.prev}">
				<a href="/board/list${pagination.makeQuery(pagination.startPage - 1)}">&laquo;</a>
			</c:if>
			<c:forEach begin="${pagination.startPage }" end="${pagination.endPage }" var="idx">
				<c:if test="${pagination.pageRequest.page eq idx}">
					<a href="/board/list${pagination.makeQuery(idx)}">[${idx}]</a>
				</c:if>
				<c:if test="${!(pagination.pageRequest.page eq idx)}">
					<a href="/board/list${pagination.makeQuery(idx)}">${idx}</a>
				</c:if>
			</c:forEach>
			<c:if test="${pagination.next && pagination.endPage > 0}">
				<a href="/board/list${pagination.makeQuery(pagination.endPage + 1)}">&raquo;</a>
			</c:if>
		</div>
	</main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script>
		let result = "${msg}";

		if (result === "SUCCESS") {
			alert("<spring:message code='common.processSuccess' />");
		}
	</script>
</body>
</html>