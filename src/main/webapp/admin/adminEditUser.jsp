<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<div class="general-form">
	<form name="Usersearch" method="post" action="${pageContext.request.contextPath}/findUser">
		<label>Search</label>
	    <input type="text" placeholder="search by userId" name="searchUser" />
		<input type="submit" value="Search" />
			
	</form>
</div>	
</body>
</html>