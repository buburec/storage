<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StorageKP</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
    <link rel="stylesheet" href="./css/reset.css" type="text/css">
    <link rel="stylesheet" href="./css/style.css" type="text/css">
    <link rel="stylesheet" href="./css/welcome.css" type="text/css">
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
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.admin.occupation_list" />
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
                    <input type="hidden" name="command" value="forward" />
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
            <h1>Welcome to StorageKP system!</h1>
            <div class="welcome__wrapper">
                Our system is a comprehensive framework that facilitates the efficient management of products within
                a storage facility. It involves various roles and functions to ensure the smooth flow of operations.
                <ul class="welcome__list">
                    <li class="welcome__item">
                        <h2>Access Control</h2>
                        The system have a mechanism for controlling access to the storage facility. This
                        includes granting permissions for truck drivers to enter the storage area.
                    </li>
                    <li class="welcome__item">
                        <h2>Truck Entry Management</h2>
                        Storekeepers are responsible for reviewing requests from
                        truck drivers who wantto enter the storage facility.
                    </li>
                    <li class="welcome__item">
                        <h2>Loading and Unloading</h2>
                        Once truck drivers are granted entry, they can unload goods
                        from their vehicles and load products onto their trucks.
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>