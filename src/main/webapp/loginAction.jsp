<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.election.beans.UserBean" %>
<%@ page import ="com.election.dao.UserDao" %>
<%
String userName = request.getParameter("username");
String password = request.getParameter("password");

UserBean userLogin = new UserBean();

userLogin.setUserName(userName);
userLogin.setUserPassword(password);
UserBean checkBean = UserDao.checkLogin(userLogin);
session.setAttribute("username", checkBean.getUserName());
session.setAttribute("ownerId", checkBean.getUserId()-1);
System.out.println(checkBean.getUserRole() + " "+checkBean.getUserName());
if (checkBean.getUserRole().equalsIgnoreCase("admin")) {
	response.sendRedirect("admin/adminHome.jsp");
} else if (checkBean.getUserRole().equalsIgnoreCase("owner")) {
	response.sendRedirect("owner/ownerHome.jsp");
} else {
	response.sendRedirect("index.jsp");
}

%>