<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="com.election.beans.OwnerBean" %>
<%@ page import ="com.election.dao.OwnerDao" %>
<%
String userid = request.getParameter("userId"); 
String ownerName = request.getParameter("ownerName");
String ownerAddress = request.getParameter("address");
String ownerContact = request.getParameter("contact");
int userId = Integer.parseInt(userid);

OwnerBean ownerBean = new OwnerBean();
ownerBean.setUserId(userId);
ownerBean.setoName(ownerName.toUpperCase().trim());
ownerBean.setoAddress(ownerAddress.toUpperCase().trim());
ownerBean.setoContact(ownerContact.toUpperCase().trim());

boolean checkExist = OwnerDao.checkOwnerDetails(ownerBean);
if (checkExist) {
	response.sendRedirect("adminOwner.jsp?v=1");
} else {
	boolean flagInsert = OwnerDao.insertOwner(ownerBean);
	if (flagInsert) {
		response.sendRedirect("adminOwner.jsp?v=2");
	} else {
		response.sendRedirect("adminOwner.jsp?v=3");
	}
}
%>