<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  include file = "adminHeader.jsp" %>	

<%
String id = request.getParameter("oid");
int oId = Integer.parseInt(id);
%>

<div class="general-form">
	<form name="ownerseach" method="post" action="${pageContext.request.contextPath}/find">
		<label>Search</label>
	    <input type="text" placeholder="search by ownerId" name="searchowner" />
		<input type="submit" value="Search" />
			
	</form>
</div>	

</body>
</html>