<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StorageKP</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
    <link rel="stylesheet" href="./css/reset.css" type="text/css">
    <link rel="stylesheet" href="./css/heading.css" type="text/css">
    <link rel="stylesheet" href="./css/profile.css" type="text/css">
</head>
<body>
    <header class="heading__wrapper">
        <ul class="heading__list">
            <li class="heading__item">
                <form name="storekeeperTrucksForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.storekeeper.trucks" />
                    <input type="submit" name="trucksSubmit" value="Trucks">
                </form>
            </li>
            <li class="heading__item">
                <form name="storekeeperRequestsForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.storekeeper.requests" />
                    <input type="submit" name="requestsSubmit" value="Requests">
                </form>
            </li>
            <li class="heading__item">
                <div class="heading__logo">
                    <form name="storekeeperWelcomeForm" method="POST" action="FrontController">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.storekeeper.welcome" />
                        <input type="submit" name="welcomeSubmit" value="">
                    </form>
                </div>
            </li>
            <li class="heading__item">
                <form name="storekeeperProfileForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.storekeeper.profile" />
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

    <div class="profile__wrapper">
        <h1>Profile</h1>
        <form method="post">
            <ul class="profile__list">
                <li class="profile__item">
                    <div class="profile__blocked-field">
                        <input type="text" value="00000002" required>
                        <label>Identifier</label>
                    </div>
                    <div class="profile__blocked-field">
                        <input type="text" value="Storekeeper" required>
                        <label>Occupation</label>
                    </div>
                </li>
                <li class="profile__item">  
                    <div class="profile__field">
                        <input type="text" value="Alice" placeholder="First name" required>
                        <label>First name</label>
                    </div>
                    <div class="profile__field">
                        <input type="text" value="Johnson" placeholder="Last name" required>
                        <label>Last name</label>
                    </div>
                </li>
                <li class="profile__item">
                    <input type="submit" name="saveSubmit" value="Save changes">
                </li>
            </ul>
        </form>
    </div>
</body>
</html>