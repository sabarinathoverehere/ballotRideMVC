<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="ownerHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Drivers</title>
</head>
<body>

	<div class="general-table">
		<table border="1">
			<tr>
				<th>SLNO</th>
				<th>OWNERID</th>
				<th>DRIVER NAME</th>
				<th>CONTACT NO</th>
				<th>STATUS</th>
				<th>ACTION</th>
			</tr>

			<c:forEach var="driver" items="${DriversList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${driver.ownerId}</td>
					<td>${driver.driverName}</td>
					<td>${driver.driverContact}</td>
					<td>${driver.driverStatus}</td>
					<td><a href="#">SEND</a> <a href="#">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>