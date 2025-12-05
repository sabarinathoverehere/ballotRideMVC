<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="adminHeader.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="general-form">
    <form method="post" action="${pageContext.request.contextPath}/updateUser">

    	<label>User Id</label>
        <input type="text" name="userId" value="${userBeansSearch.getUserId()}" readOnly>


        <label>User Name</label>
        <input type="text" name="name" value="${userBeansSearch.getUserName()}">

        <label>User Password</label>
        <input type="text" name="password" value="${userBeansSearch.getUserPassword()}">

        <label>User Role</label>
        <input type="text" name="role" value="${userBeansSearch.getUserRole()}">

        <input type="submit" value="Update">
    </form>
</div>

</body>
</html>