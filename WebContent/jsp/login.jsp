<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
	<link rel="stylesheet" href="./css/login.css" type="text/css">
	<link rel="shortcut icon" href="../images/logo.svg" type="image/x-icon">
    <link rel="stylesheet" href="../css/login.css" type="text/css">
</head>
<body>
    <div class="wrong__wrapper">
        <p>${wrongLogin}</p>
    </div>
    <div class="login__wrapper">
        <h1>StorageKP</h1>
        <div class="login__content">
            <form name="loginForm" method="POST" action="welcome-page">
                <input type="hidden" name="command" value="login" />
                <div class="login__field">
                    <input type="text" name="login" required>
                    <label>Username</label>
                    <span></span>
                </div>
                <div class="login__field">
                    <input type="password" name="password" required>
                    <label>Password</label>
                    <span></span>
                </div>
                <input type="submit" value="Sign in">
            </form>
        </div>
    </div>
</body>
</html>