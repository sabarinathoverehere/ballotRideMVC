<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<!-- Import modern font -->
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&display=swap" rel="stylesheet">
<style>
body {
    margin: 0;
    font-family: 'Inter', sans-serif;
    background: #f4f6f8;
}

.login-container {
    width: 360px;
    padding: 35px 30px;
    margin: 100px auto;
    background: #fff;
    border-radius: 12px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.08);
}

.login-container h2 {
    text-align: center;
    margin-bottom: 30px;
    color: #2c3e50;
}

.login-container label {
    display: block;
    margin-bottom: 8px;
    font-weight: 500;
    color: #2c3e50;
}

.login-container input[type="text"],
.login-container input[type="password"] {
    width: 100%;
    padding: 12px 15px;
    margin-bottom: 18px;
    border: 1px solid #ccc;
    border-radius: 8px;
    transition: all 0.3s ease;
     box-sizing: border-box;
}

.login-container input[type="text"]:focus,
.login-container input[type="password"]:focus {
    border-color: #3498db;
    box-shadow: 0 0 10px rgba(52,152,219,0.2);
}

.login-container input[type="submit"] {
    width: 100%;
    padding: 12px;
    background: #3498db;
    border: none;
    border-radius: 8px;
    color: #fff;
    font-size: 16px;
    font-weight: 500;
    cursor: pointer;
    transition: all 0.3s ease;
}

.login-container input[type="submit"]:hover {
    background: #2980b9;
    transform: translateY(-2px);
}
</style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <form method="post" action="loginAction.jsp">
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required />

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required /> 

        <input type="submit" value="Login" />
    </form>
</div>

</body>
</html>
