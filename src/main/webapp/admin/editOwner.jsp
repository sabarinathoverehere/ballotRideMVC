<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="adminHeader.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="general-form">
    <form method="post" action="${pageContext.request.contextPath}/updateOwner">

        <label>OwnerID</label>
        <input type="text" name="oId" value="${ownerBean.getoId()}" readonly>

        <label>UserID</label>
        <input type="text" name="userId" value="${ownerBean.getUserId()}" readonly>

        <label>Owner Name</label>
        <input type="text" name="oName" value="${ownerBean.getoName()}">

        <label>Owner Address</label>
        <input type="text" name="oAddress" value="${ownerBean.getoAddress()}">

        <label>Owner Contact</label>
        <input type="text" name="oContact" value="${ownerBean.getoContact()}">

        <input type="submit" value="Update">
    </form>
</div>


</body>
</html>