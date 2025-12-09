<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="adminHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="general-table">
	<table>
		<tr>
			<th>SLNO</th>
			<th>LOCATION-NAME</th>
		</tr>
		
		<c:forEach var="location" items="${allLocations}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${location.locationName}</td>
			
		</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>