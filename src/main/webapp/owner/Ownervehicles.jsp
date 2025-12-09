<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ownerHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="general-table">
	<table>
		<tr>
			<th>SLNO</th>
			<th>OWNER ID</th>
			<th>LICENSE PLATE</th>
			<th>VEHICLE TYPE</th>
		</tr>
		
		<c:forEach var="vehicle" items="${readVehicles}" varStatus ="status">
		<tr>
			<td>${status.count}</td>
			<td>${vehicle.ownerId}</td>
			<td>${vehicle.vehicleNo}</td>
			<td>${vehicle.vehicleType}</td>
			
		</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>