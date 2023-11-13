<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <h1>Occupation list</h1>
            <div class="list__wrapper">
                <ul>
                    <li class="list__item">
                        <div class="list__field" id="occupation__identifier">
                            0000
                        </div>
                        <div class="list__field" id="occupation__title">
                            Administrator
                        </div>
                        <div class="list__field" id="occupation__description">
                            Responsible for system administration
                        </div>
                    </li>
                    <li class="list__item">
                        <div class="list__field" id="occupation__identifier">
                            0001
                        </div>
                        <div class="list__field" id="occupation__title">
                            Moderator
                        </div>
                        <div class="list__field" id="occupation__description">
                            Responsible for content moderation
                        </div>
                    </li>
                    <li class="list__item">
                        <div class="list__field" id="occupation__identifier">
                            0002
                        </div>
                        <div class="list__field" id="occupation__title">
                            Storekeeper
                        </div>
                        <div class="list__field" id="occupation__description">
                            Responsible for managing storage
                        </div>
                    </li>
                    <li class="list__item">
                        <div class="list__field" id="occupation__identifier">
                            0003
                        </div>
                        <div class="list__field" id="occupation__title">
                            Driver
                        </div>
                        <div class="list__field" id="occupation__description">
                            Responsible for driving trucks
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>