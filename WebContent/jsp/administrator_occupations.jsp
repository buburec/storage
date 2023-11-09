<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StorageKP</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
    <link rel="stylesheet" href="./css/reset.css" type="text/css">
    <link rel="stylesheet" href="./css/heading.css" type="text/css">
    <link rel="stylesheet" href="./css/occupations.css" type="text/css">
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

    <div class="occupations__wrapper">
        <h1>Occupation list</h1>
        <form method="post">
            <ul class="occupations__list">
                <li class="occupations__item">
                    <div class="occupations__field" id="identifier">
                        0000
                    </div>
                    <div class="occupations__field" id="title">
                        Administrator
                    </div>
                    <div class="occupations__field" id="description">
                        Responsible for system administration
                    </div>
                </li>
                <li class="occupations__item">
                    <div class="occupations__field" id="identifier">
                        0001
                    </div>
                    <div class="occupations__field" id="title">
                        Moderator
                    </div>
                    <div class="occupations__field" id="description">
                        Responsible for content moderation
                    </div>
                </li>
                <li class="occupations__item">
                    <div class="occupations__field" id="identifier">
                        0002
                    </div>
                    <div class="occupations__field" id="title">
                        Storekeeper
                    </div>
                    <div class="occupations__field" id="description">
                        Responsible for managing storage
                    </div>
                </li>
                <li class="occupations__item">
                    <div class="occupations__field" id="identifier">
                        0003
                    </div>
                    <div class="occupations__field" id="title">
                        Driver
                    </div>
                    <div class="occupations__field" id="description">
                        Responsible for driving trucks
                    </div>
                </li>
            </ul>
        </form>
    </div>
</body>
</html>