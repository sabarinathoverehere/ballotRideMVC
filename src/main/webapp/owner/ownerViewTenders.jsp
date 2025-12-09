<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="ownerHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.election.dao.DriverDao"%>
<%@ page import="java.util.List"%>
<%@ page import="com.election.beans.DriverBean"%>



<div class="general-table">
	<table>
		<tr>
			<th>SLNO</th>
			<th>LOCATION-ID</th>
			<th>DISTANCE</th>
			<th>STATUS</th>
			<th>CREATION</th>
			<th>END</th>
			<th>ACTION</th>
		</tr>

		<c:forEach var="tender" items="${opentenders}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${tender.locationId}</td>
				<td>${tender.tenderDistance}</td>
				<td>${tender.tenderStatus}</td>
				<td>${tender.tenderCreation}</td>
				<td>${tender.tenderClosed}</td>

				<td><c:choose>
						<c:when test="${tender.tenderStatus == 'active'}">
							<button disabled>ACCEPTED</button>
						</c:when>

						<c:otherwise>
							<!-- FORM MUST BE INSIDE <td> NOT <a> -->
							<form method="post"
								action="${pageContext.request.contextPath}/acceptTender">

								<input type="hidden" name="tenderId" value="${tender.tenderId}" />

								<select name="driverId" required style="padding: 4px;">
									<c:forEach var="drv" items="${DriverList}">
										<option value="${drv.driverId}">${drv.driverName}</option>
									</c:forEach>
								</select>

								<button type="submit" class="approve-btn">ACCEPT</button>
							</form>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>