<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>

<div class="general-table">
	<table>
		<tr>
			<th>SLNO</th>
			<th>USER-NAME</th>
			<th>PASSWORD</th>
			<th>USER-ROLE</th>
		</tr>
		
		<c:forEach var="user" items="${userViews}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${user.userName}</td>
			<td>${user.userPassword}</td>
			<td>${user.userRole}</td>
			
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>