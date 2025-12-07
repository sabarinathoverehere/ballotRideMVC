<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>

<div class="general-form">
	<form name="locationsearch" method="post" action="${pageContext.request.contextPath}/findLocation">
		<label>Search</label>
	    <input type="text" placeholder="search by locationId" name="searchLocation" />
		<input type="submit" value="Search" />
			
	</form>
</div>

</body>
</html>