<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="general-table">
	<table>
		<tr>
			<th>SLNO</th>
			<th>LOCATION-ID</th>
			<th>DISTANCE</th>
			<th>STATUS</th>
			<th>CREATION</th>
			<th>END</th>
			
		</tr>
		
		<c:forEach var="tender" items="${tenders}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${tender.locationId}</td>
			<td>${tender.tenderDistance}</td>
			<td>${tender.tenderStatus}</td>
			<td>${tender.tenderCreation}</td>
			<td>${tender.tenderClosed}</td>

		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>