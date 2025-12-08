<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="ownerHeader.jsp"%>
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
			<th>ACTION</th>
		</tr>

		<c:forEach var="t" items="${list}">
			<tr>
				<td>${t.tenderId}</td>
				<td>${t.ownerId}</td>
				<td>${t.driverId}</td>
				<td>${t.tenderCreation}</td>
				<td>${t.tenderStatus}</td>
				<td>${t.assignedAt}</td>
				<td><c:choose>
						<c:when
							test="${t.tenderStatus == 'closed' || t.tenderStatus == 'Closed'}">
							<button>CLOSED</button>
						</c:when>

						<c:otherwise>
							<a
								href="${pageContext.request.contextPath}/closeTender?id=${t.tenderId}">
								<button class="approve-btn">CLOSE</button>
							</a>
						</c:otherwise>

					</c:choose></td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>