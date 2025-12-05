<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    /* Reset default browser styles */
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background: #f0f2f5;
    }

    .login-container {
        width: 350px;
        padding: 40px;
        margin: 100px auto;
        background: #fff;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        border-radius: 10px;
    }

    .login-container h2 {
        text-align: center;
        margin-bottom: 30px;
        color: #333;
    }

    .login-container input[type="text"],
    .login-container input[type="password"] {
        width: 100%;
        padding: 12px 15px;
        margin: 8px 0 20px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    .login-container input[type="submit"] {
        width: 100%;
        padding: 12px;
        background-color: #4CAF50;
        border: none;
        border-radius: 5px;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: background 0.3s ease;
    }

    .login-container input[type="submit"]:hover {
        background-color: #45a049;
    }

    .login-container label {
        font-weight: bold;
        color: #555;
    }
</style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <form method="post" action="loginAction.jsp">
        <label for="username">UserName:</label>
        <input type="text" name="username" id="username" required />

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required /> 

        <input type="submit" value="Login" />
    </form>
</div>

</body>
</html>
