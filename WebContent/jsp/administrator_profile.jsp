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
    <link rel="stylesheet" href="./css/info.css" type="text/css">
    <link rel="shortcut icon" href="../images/logo.svg" type="image/x-icon">
    <link rel="stylesheet" href="../css/reset.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link rel="stylesheet" href="../css/info.css" type="text/css">
</head>
<body>
    <header class="heading__wrapper">
        <ul class="heading__list">
            <li class="heading__item">
                <form name="adminUsersForm" method="POST" action="/storage/user-list">
                    <input type="hidden" name="command" value="users" />
                    <input type="hidden" name="page" value="path.page.admin.user_list" />
                    <input type="submit" name="usersSubmit" value="Users">
                </form>
            </li>
            <li class="heading__item">
                <form name="adminOccupationsForm" method="POST" action="/storage/occupation-list">
                    <input type="hidden" name="command" value="occupations" />
                    <input type="submit" name="occupationSubmit" value="Occupations">
                </form>
            </li>
            <li class="heading__item">
                <div class="heading__logo">
                    <form name="adminWelcomeForm" method="POST" action="/storage/welcome-page">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.admin.welcome" />
                        <input type="submit" name="welcomeSubmit" value="">
                    </form>
                </div>
            </li>
            <li class="heading__item">
                <form name="adminProfileForm" method="POST" action="/storage/profile">
                    <input type="hidden" name="command" value="profile" />
                    <input type="hidden" name="visibility" value="hidden" />
                    <input type="hidden" name="page" value="path.page.admin.profile" />
                    <input type="submit" name="profileSubmit" value="Profile">
                </form>
            </li>
            <li class="heading__item">
                <form name="adminLogoutForm" method="POST" action="/storage/login">
                    <input type="hidden" name="command" value="logout" />
                    <input type="submit" name="signOutSubmit" value="Sign out">
                </form>
            </li>
        </ul>
    </header>

    <div class="body__wrapper">
        <div class="content__wrapper">
            <h1>Profile</h1>
            <div class="info__wrapper">
                <form name="adminUpdateProfileForm" method="POST" action="/storage/profile">
                    <ul class="info__list">
                        <li class="info__item">
                            <div class="info__blocked-field">
                                <input type="text" name="identifier" value="${profile.get(0).getIdentifier()}" required>
                                <label>Login</label>
                            </div>
                            <div class="info__field">
                                <input type="text" name="password" value="${profile.get(0).getPassword()}" required>
                                <label>Password</label>
                            </div>
                        </li>
                        <li class="info__item">
                            <div class="info__blocked-field">
                                <input type="text" value="${profile.get(0).getTitle()}" required>
                                <label>Occupation</label>
                            </div>
                            <div class="info__field">
                                <input type="text" name="fullName" value="${profile.get(0).getFullName()}" required>                                    <label>Full name</label>
                            </div>
                        </li>
                        <li class="info__item">
                            <input type="hidden" name="command" value="update_profile" />
                            <input type="hidden" name="page" value="path.page.admin.profile" />
                            <input type="submit" name="saveSubmit" value="Save changes">
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</body>
</html>