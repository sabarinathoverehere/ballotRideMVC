<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="ownerHeader.jsp" %>
<div class="general-form">
	<form name="Usersearch" method="post" action="${pageContext.request.contextPath}/vehicleAdd">
		<label>OWNER ID</label>
	    <input type="text"  name="ownerId" />
	    <label>LICENSE NO</label>
	    <input type="text"  name="licenseplate" />
	    <label>VEHICLE TYPE</label>
	    <input type="text"  name="vehicleType" />
		<input type="submit" value="ADD" />
			
	</form>
</div>	

</body>
</html>