<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                <form name="moderatorUsersForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.moderator.users" />
                    <input type="submit" name="usersSubmit" value="Users">
                </form>
            </li>
            <li class="heading__item">
                <form name="moderatorProductsForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.moderator.products" />
                    <input type="submit" name="productsSubmit" value="Products">
                </form>
            </li>
            <li class="heading__item">
                <div class="heading__logo">
                    <form name="moderatorWelcomeForm" method="POST" action="FrontController">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.moderator.welcome" />
                        <input type="submit" name="welcomeSubmit" value="">
                    </form>
                </div>
            </li>
            <li class="heading__item">
                <form name="moderatorProfileForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.moderator.profile" />
                    <input type="submit" name="profileSubmit" value="Profile">
                </form>
            </li>
            <li class="heading__item">
                <form name="logoutForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="logout" />
                    <input type="submit" name="signOutSubmit" value="Sign out">
                </form>
            </li>
        </ul>
    </header>

    <div class="users__wrapper">
        <h1>User list</h1>
        <form method="post">
            <input type="submit" name="createSubmit" value="Create new">
            <ul class="users__list">
                <li class="users__item">
                    <div class="users__field" id="identifier">
                        00000000
                    </div>
                    <div class="users__field" id="full-name">
                        John Doe
                    </div>
                    <div class="users__field" id="occupation">
                        Administrator
                    </div>
                    <div class="users__field" id="status">
                        offline
                    </div>
                </li>
                <li class="users__item">
                    <div class="users__field" id="identifier">
                        00000001
                    </div>
                    <div class="users__field" id="full-name">
                        Jane Smith
                    </div>
                    <div class="users__field" id="occupation">
                        Moderator
                    </div>
                    <div class="users__field" id="status">
                        online
                    </div>
                </li>
                <li class="users__item">
                    <div class="users__field" id="identifier">
                        00000002
                    </div>
                    <div class="users__field" id="full-name">
                        Alice Johnson
                    </div>
                    <div class="users__field" id="occupation">
                        Storekeeper
                    </div>
                    <div class="users__field" id="status">
                        offline
                    </div>
                </li>
                <li class="users__item">
                    <div class="users__field" id="identifier">
                        00000003
                    </div>
                    <div class="users__field" id="full-name">
                        Bob Brown
                    </div>
                    <div class="users__field" id="occupation">
                        Driver
                    </div>
                    <div class="users__field" id="status">
                        offline
                    </div>
                </li>
            </ul>
        </form>
    </div>
</body>
</html>