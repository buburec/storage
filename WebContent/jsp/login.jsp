<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>StorageKP: Login</title>
	<link rel="shortcut icon" href="./images/storage_logotype.svg" type="image/x-icon">
    <style>
        <jsp:include page= "/css/login.css"/>
    </style>
</head>
<body>
<form name="loginForm" method="POST" action="FrontController">
<input type="hidden" name="command" value="login" />
<div class="center">
	<h1>Sign in</h1>
	<form method="post">
		<div class="text_field">
			<input type="text" name="login" required>
			<span></span>
			<label>Username</label>
		</div>
		<div class="text_field">
			<input type="password" name="password" required>
			<span></span>
			<label>Password</label>
		</div>
		<input type="submit" value="Enter">
	</form>
</div>
</form>
</body>
</html>