<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>StorageKP: Home</title>
	<link rel="shortcut icon" href="./images/storage_logotype.svg" type="image/x-icon">
	<style>
        <jsp:include page= "/css/welcome.css"/>
    </style>
</head>
<body>
<div class="heading">
	<table>
		<tr>
			<td><a href="FrontController?command=welcome" title="Welcome page" >
				<img src="./images/storage_logotype.svg" alt="logo"></a></td>
			<td><a href="FrontController?command=user_list" title="User list">Users</a></td>
			<td><a href="FrontController?command=profile" title="Account settings">Profile</a></td>
			<td><a href="FrontController?command=logout" title="Login page">Sign out</a></td>
		</tr>
	</table>
</div>
<div class="welcome">
	<h1>Welcome to StorageKP system!</h1>
	<table>
		<caption>Our system is a comprehensive framework that facilitates the efficient management of products within a storage facility.
			It involves various roles and functions to ensure the smooth flow of operations.</caption>
		<tr>
			<td><p>Access Control</p>
				The system have a mechanism for controlling access to the storage facility. This includes granting permissions 
				for truck drivers to enter the storage area.</td>
			<td><p>Truck Entry Management</p>
				Storekeepers are responsible for reviewing requests from truck drivers who want to enter the storage
				facility.</td>
			<td><p>Loading and Unloading</p>
				Once truck drivers are granted entry, they can unload goods from their vehicles and load products
				onto their trucks.</td>
		</tr>
	</table>
</div>
</body>
</html>