<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="general-table">
	<table border="1">
		<tr>
			<th>Tender ID</th>
			<th>Owner ID</th>
			<th>Driver ID</th>
			<th>Creation</th>
			<th>Status</th>
			<th>Assigned At</th>
			<th>Closed At</th>
		</tr>

		<c:forEach var="t" items="${tenders}">
			<tr>
				<td>${t.tenderId}</td>
				<td>${t.ownerId}</td>
				<td>${t.driverId}</td>
				<td>${t.tenderCreation}</td>
				<td>${t.tenderStatus}</td>
				<td>${t.assignedAt}</td>
				<td>${t.tenderClosed}</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>