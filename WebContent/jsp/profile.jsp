<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>StorageKP: Profile</title>
	<link rel="shortcut icon" href="./images/storage_logotype.svg" type="image/x-icon">
	<style>
        <jsp:include page= "/css/profile.css"/>
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
<div class="profile">
	<h1>Profile</h1>
	<table>
		<caption>Ivanov Leonid Romanovich</caption>
		<tr>
			<td>Identifier:</td>
			<td><input type="text" value="00001231" style="pointer-events:none"></td>
		</tr>
		<tr>
			<td>Occupation:</td>
			<td><input type="text" value="Driver" style="pointer-events:none"></td>
		</tr>
		<tr>
			<td>Mail:</td>
			<td><input type="text" value="ivaleo1978@gmail.com"></td>
		</tr>
	</table>
</div>
<div class="control">
	<table>
		<tr>
			<td><input type="submit" value="Save changes"></td>
			<td><input type="submit" value="Delete account"></td>
		</tr>
	</table>
</div>
</body>
</html>