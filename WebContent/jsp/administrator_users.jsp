<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StorageKP</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
    <link rel="stylesheet" href="./css/reset.css" type="text/css">
    <link rel="stylesheet" href="./css/heading.css" type="text/css">
    <link rel="stylesheet" href="./css/users.css" type="text/css">
</head>
<body>
    <header class="heading__wrapper">
        <ul class="heading__list">
            <li class="heading__item">
                <form name="adminUsersForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="users" />
                    <input type="hidden" name="page" value="path.page.admin.users" />
                    <input type="submit" name="usersSubmit" value="Users">
                </form>
            </li>
            <li class="heading__item">
                <form name="adminOccupationsForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.admin.occupations" />
                    <input type="submit" name="occupationSubmit" value="Occupations">
                </form>
            </li>
            <li class="heading__item">
                <div class="heading__logo">
                    <form name="adminWelcomeForm" method="POST" action="FrontController">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.admin.welcome" />
                        <input type="submit" name="welcomeSubmit" value="">
                    </form>
                </div>
            </li>
            <li class="heading__item">
                <form name="adminProfileForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.admin.profile" />
                    <input type="submit" name="profileSubmit" value="Profile">
                </form>
            </li>
            <li class="heading__item">
                <form name="adminLogoutForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="logout" />
                    <input type="submit" name="signOutSubmit" value="Sign out">
                </form>
            </li>
        </ul>
    </header>

    <div class="users__wrapper">
        <h1>User list</h1>
        <form name="createSubmitForm" method="POST" action="FrontController">
            <input type="hidden" name="command" value="forward" />
            <input type="hidden" name="page" value="path.page.admin.profile" />
            <input type="submit" name="createSubmit" value="Create new">
        </form>
        <form>
            <ul class="users__list">
               <c:forEach items="${userList}" var="user">
                   <li class="users__item">
                       <div class="users__field" id="identifier">
                           <p>${user.getIdentifier()}</p>
                       </div>
                       <div class="users__field" id="full-name">
                           <p>${user.getFullName()}</p>
                       </div>
                       <div class="users__field" id="occupation">
                           <p>${user.getOccupation()}</p>
                       </div>
                       <div class="users__field" id="status">
                           <p>${user.getStatus()}</p>
                       </div>
                   </li>
               </c:forEach>
            </ul>
        </form>
    </div>
</body>
</html>