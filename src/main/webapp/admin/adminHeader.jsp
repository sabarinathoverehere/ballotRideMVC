<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/CSS/styles.css">
</head>

<body>
	<%
	String username = (String) session.getAttribute("username");
	%>

	<h2>
		Welcome,<%=username%></h2>
	<h1>Admin Home</h1>

	<nav>
		<div class="nav-container">
			<a href="#" class="logo">BallotRide</a>
			<ul class="navlinks">
				<li><a href="${pageContext.request.contextPath}/admin/adminHome.jsp">Home</a></li>
				<li><a href="#">Vehicle</a></li>
				<li class="dropdown"><a href="#">Settings</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/userView">View Users</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/adminAddUser.jsp">Add</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/adminEditUser.jsp">Edit</a></li>
					
					</ul>
				</li>
				<li class="dropdown"><a href="#">Owners </a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/admin/adminOwner.jsp?v=0">Add</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/searchOwner.jsp?oid=0">Edit</a></li>
						<li><a href="#">Delete</a></li>
						<li><a href="#">View Owners</a></li>
					</ul></li>
				<li class="dropdown"><a href="#">Drivers</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/driverReqs">View Requests</a></li>
					</ul></li>
				<li class="dropdown"><a href="${pageContext.request.contextPath}/showLocations">Location</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/admin/adminLocationAdd.jsp">Add</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/adminLocationEdit.jsp">Edit</a></li>
					
					</ul>
				</li>
					
				<li class="dropdown"><a href="${pageContext.request.contextPath}/showtenders">Tenders</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/admin/adminAssignTenders.jsp">Assign Tenders</a></li>
						<li><a href="${pageContext.request.contextPath}/adminCurrentStatusTenders">History</a></li>
					
					</ul></li>
				<li><a href="#">Payments</a></li>
				<li><a href="#">Logout</a></li>
			</ul>
		</div>
	</nav>


