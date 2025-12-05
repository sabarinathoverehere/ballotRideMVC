<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="adminHeader.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.election.beans.UserBean"%>
<%@ page import="com.election.dao.UserDao"%>
<%@ page import="com.election.beans.OwnerBean" %>
<%@ page import="com.election.dao.OwnerDao" %>
<%
List<UserBean> usersList = UserDao.getAllUsers();
request.setAttribute("usersList", usersList);
List<OwnerBean> ownersList = OwnerDao.getAllOwners();
request.setAttribute("ownersList", ownersList);
String v = request.getParameter("v");
String caption = "";

if (v.equals(0)) {
	caption = "";

} else if (v.equals("1")) {
	caption = "already exist";
} else if (v.equals("2")) {
	caption = "inserted";
} else if (v.equals("3")) {
	caption = "OOPS!please insert again";
} else if (v.equals("4")) {
	caption = "updated";
} else if (v.equals("5")) {
	caption = "Deleted";
}
%>

<h2>OwnerDetails</h2>
<div class="general-form">

	<form name="owner-add" method="post" action="adminOwnerAddAction.jsp">
		<label for="userId">User ID</label> 
		<select id="userId" name="userId"
			required style="padding: 8px; margin-bottom: 10px;">
			<c:forEach var="u" items="${usersList}">
				<option value="${u.userId}">${u.userId} - ${u.userName}</option>
			</c:forEach>
		</select> 
		<label for="ownerName">Owner Name</label> 
		<input type="text" 	id="ownerName" name="ownerName" required> 
		<label for="address">Address</label> 
		<input type="text" id="address"
			name="address" required> 
			<label for="contact">
			Contact</label>
		<input type="text" id="contact" name="contact" required> 
		<input 	type="submit" value="Submit">
		
	</form>
</div>
<div class="general-table">
	<table border="1">
		<tr>
			<th>SLNO</th>
			<th>USERID</th>
			<th>OWNER NAME</th>
			<th>ADDRESS</th>
			<th>CONTACT NO</th>
			<th>ACTION</th>
		</tr>

	<c:forEach var="owner" items="${ownersList}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${owner.userId}</td>
			<td>${owner.oName}</td>
			<td>${owner.oAddress}</td>
			<td>${owner.oContact}</td>
			<td><a href="#">Edit</a> <a href="#">Delete</a></td>
		</tr>
     </c:forEach>
		<tr>
			<td colspan="5" class="alert-msg"><%=caption%></td>
		</tr>
	</table>
</div>


<%@ include file="../footer.html"%>