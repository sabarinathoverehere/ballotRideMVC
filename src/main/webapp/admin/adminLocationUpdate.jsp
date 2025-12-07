<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "adminHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="general-form">
    <form method="post" action="${pageContext.request.contextPath}/updateLocation">

    	<label>Location Id</label>
       <input type="text" name="locationId" value="${editedLocation.locationId}" readonly>


        <label>Location Name</label>
        <input type="text" name="locationName" value="${editedLocation.locationName}">

        
        <input type="submit" value="Update">
    </form>
</div>

</body>
</html>