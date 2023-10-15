<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>StorageKP: Users</title>
	<link rel="shortcut icon" href="./images/storage_logotype.svg" type="image/x-icon">
	<style>
        <jsp:include page= "/css/user_list.css"/>
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
<div class="user_list">
	<h1>User list</h1>
	<a href="profile.jsp"><table>
		<tr>
			<td><b>00001231</b></td>
			<td>Ivanov Leonid Romanovich</td>
			<td>Driver</td>
			<td>ivaleo1978@gmail.com</td>
		</tr>
	</table></a>
	<input type="submit" value="Add new user">
</div>
</body>
</html>