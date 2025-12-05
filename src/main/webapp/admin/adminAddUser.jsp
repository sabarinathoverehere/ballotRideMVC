<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>


<div class="general-form">
    <form method="post" action="${pageContext.request.contextPath}/addUser">

      

        <label>User Name</label>
        <input type="text" name="name">

        <label>User Password</label>
        <input type="text" name="password">

        <label>User Role</label>
        <input type="text" name="role" placeholder="admin or owner">

        <input type="submit" value="Adduser">
    </form>
</div>

</body>
</html>