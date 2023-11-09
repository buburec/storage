<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
	<link rel="stylesheet" href="./css/login.css" type="text/css">
</head>
<body>
	<form name="loginForm" method="POST" action="FrontController">
	<input type="hidden" name="command" value="login" />
    <div class="login__wrapper">
        <h1>StorageKP</h1>
	    <form method="post">
		    <div class="login__field">
			    <input type="text" name="login" required>
			    <span></span>
			    <label>Username</label>
		    </div>
		    <div class="login__field">
			    <input type="password" name="password" required>
			    <span></span>
			    <label>Password</label>
		    </div>
		    <input type="submit" value="Sign in">
	    </form>
    </div>
	</form>
</body>
</html>