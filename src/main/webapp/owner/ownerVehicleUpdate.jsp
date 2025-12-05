<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="ownerHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="general-form">
    <form method="post" action="${pageContext.request.contextPath}/updateVehicle">
   	    <label>VEHICLE ID</label>
        <input type="text" name="vehicleId" value="${resultOfSearch.getVehicleId()}" >

        <label>OwnerID</label>
        <input type="text" name="ownerId" value="${resultOfSearch.getOwnerId()}" >

        <label>VEHICLE NUMBER</label>
        <input type="text" name="vehiclenumber" value="${resultOfSearch.getVehicleNo()}" >

        <label>VEHICLE TYPE</label>
        <input type="text" name="vehicleType" value="${resultOfSearch.getVehicleType()}">


        <input type="submit" value="Update">
    </form>
</div>
</body>
</html>