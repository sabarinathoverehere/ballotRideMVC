<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="adminHeader.jsp" %>

<div class="general-form">
	<form name="addlocation" method="post" action="${pageContext.request.contextPath}/addLocations">
		<label>Location Name</label>
	    <input type="text"  name="locationName" />
		<input type="submit" value="ADD" />
			
	</form>
</div>	

</body>
</html>