<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StorageKP</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
    <link rel="stylesheet" href="./css/reset.css" type="text/css">
    <link rel="stylesheet" href="./css/style.css" type="text/css">
    <link rel="stylesheet" href="./css/list.css" type="text/css">
</head>
<body>
    <header class="heading__wrapper">
        <ul class="heading__list">
            <li class="heading__item">
                <form name="moderatorUsersForm" method="POST" action="/storage/user-list">
                    <input type="hidden" name="command" value="users" />
                    <input type="hidden" name="page" value="path.page.moderator.user_list" />
                    <input type="submit" name="usersSubmit" value="Users">
                </form>
            </li>
            <li class="heading__item">
                <form name="moderatorProductsForm" method="POST" action="/storage/product-list">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.moderator.product_list" />
                    <input type="submit" name="productsSubmit" value="Products">
                </form>
            </li>
            <li class="heading__item">
                <div class="heading__logo">
                    <form name="moderatorWelcomeForm" method="POST" action="/storage/welcome-page">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.moderator.welcome" />
                        <input type="submit" name="welcomeSubmit" value="">
                    </form>
                </div>
            </li>
            <li class="heading__item">
                <form name="moderatorProfileForm" method="POST" action="/storage/profile">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.moderator.profile" />
                    <input type="submit" name="profileSubmit" value="Profile">
                </form>
            </li>
            <li class="heading__item">
                <form name="logoutForm" method="POST" action="/storage/login">
                    <input type="hidden" name="command" value="logout" />
                    <input type="submit" name="signOutSubmit" value="Sign out">
                </form>
            </li>
        </ul>
    </header>

    <div class="body__wrapper">
        <div class="content__wrapper">
            <h1>User list</h1>
            <div class="list__wrapper">
                <ul>
                    <c:forEach items="${userList}" var="user">
                        <li class="list__item">
                            <div class="list__field" id="user__identifier">
                                <p>${user.getIdentifier()}</p>
                            </div>
                            <div class="list__field" id="user__full-name">
                                <p>${user.getFullName()}</p>
                            </div>
                            <div class="list__field" id="user__occupation">
                                <p>${user.getOccupation()}</p>
                            </div>
                            <div class="list__field" id="user__status">
                                <p>${user.getStatus()}</p>
                            </div>
                            <form name="adminEditUser" method="POST" action="/storage/user-list/edit-user">
                                <input type="hidden" name="command" value="edit_user" />
                                <input type="hidden" name="user_identifier" value="${user.getIdentifier()}">
                                <input type="hidden" name="user_fullName" value="${user.getFullName()}">
                                <input type="hidden" name="user_occupation" value="${user.getOccupation()}">
                                <input type="hidden" name="user_status" value="${user.getStatus()}">
                                <input type="hidden" name="visibility" value="submit" />
                                <input type="hidden" name="page" value="path.page.moderator.profile" />
                                <input type="submit" value="" id="user__picture">
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>