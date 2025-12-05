<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="general-table">
		<table border="1">
			<tr>
				<th>SLNO</th>
				<th>OWNER ID</th>
				<th>DRIVER NAME</th>
				<th>CONTACT</th>
				<th>STATUS</th>
				<th>ACTION</th>
			</tr>

			<c:forEach var="driver" items="${drivers}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${driver.ownerId}</td>
					<td>${driver.driverName}</td>
					<td>${driver.driverContact}</td>
					<td>${driver.driverStatus}</td>
					<td><c:choose>
							<c:when
								test="${driver.driverStatus == 'Approved' || driver.driverStatus == 'approved'}">
								<button >Approved</button>
							</c:when>
							<c:otherwise>
								<a
									href="${pageContext.request.contextPath}/approveDrivers?id=${status.count}">
									<button class="approve-btn">Approve</button>
								</a>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>