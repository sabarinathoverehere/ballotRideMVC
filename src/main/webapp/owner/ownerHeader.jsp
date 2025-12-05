<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/owner/CSS/styles.css">

<title>Owner Home</title>
</head>
<body>
	<%
	String username = (String) session.getAttribute("username");
	%>

	<h2>
		Welcome,<%=username%></h2>
	<h1>Owner Home</h1>

	<nav>
		<div class="nav-container">
			<a href="#" class="logo">BallotRide</a>
			<ul class="navlinks">
				<li><a href="${pageContext.request.contextPath}/owner/ownerHome.jsp">Home</a></li>
				<li class="dropdown"><a href="#">Vehicle</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/owner/ownerVehicleAdd.jsp">Add</a></li>
						<li><a href="${pageContext.request.contextPath}/owner/ownerVehicleEdit.jsp">Edit</a></li>
						<li><a href="#">Delete</a></li>
					</ul></li>
				<li class="dropdown"><a href="#">Drivers</a>
					<ul class="dropdown-menu">
						<li><a href="#">Add </a></li>
						<li><a href="${pageContext.request.contextPath}/driversViewOwner">View Drivers</a></li>
					</ul></li>
				<li class="dropdown"><a href="#">Daily Routes</a>
					<ul class="dropdown-menu">
						
						<li><a href="#">View Routes</a></li>
					</ul></li>
				<li><a href="#">Payments</a></li>
				<li><a href="#">Logout</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>