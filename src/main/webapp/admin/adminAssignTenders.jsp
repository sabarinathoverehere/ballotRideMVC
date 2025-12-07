<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<%@ page import="com.election.dao.LocationDao" %>
<%@ page import="com.election.beans.LocationBean" %>
<%@ page import ="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Create New Tender</h2>

<div class="general-form">
    <form name="addTender" method="post" action="${pageContext.request.contextPath}/addTender">

        <label>Location</label>
        <select name="locationId" required>
            <option value="">Select Location</option>
            <% 
            List<LocationBean> locations = LocationDao.getAllLocations();
            request.setAttribute("allLocations",locations);
            %>
            <c:forEach var="loc" items="${allLocations}">
                <option value="${loc.locationId}">${loc.locationName}</option>
            </c:forEach>
        </select>
        <br/><br/>

   
        <label>Distance (km)</label>
        <input type="text" name="distance" required />
        <br/><br/>


        <input type="submit" value="Create Tender" />

    </form>
</div>
</body>
</html>