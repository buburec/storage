<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StorageKP</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
    <link rel="stylesheet" href="./css/reset.css" type="text/css">
    <link rel="stylesheet" href="./css/heading.css" type="text/css">
    <link rel="stylesheet" href="./css/requests.css" type="text/css">
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

    <div class="requests__wrapper">
        <h1>Active request list</h1>
        <form method="post">
            <ul class="requests__list">
                <li class="requests__item">
                    <div class="requests__field" id="identifier">
                        0000000001
                    </div>
                    <div class="requests__field" id="truck-model">
                        Heavy-Duty Transporter XZ-2000
                    </div>
                    <div class="requests__field" id="topic">
                        Unloading
                    </div>
                    <div class="requests__field" id="sent-date">
                        28.10.2023
                    </div>
                    <div class="requests__field" id="resolver">
                        Sender: Bob Brown
                    </div>
                    <div class="requests__field" id="status">
                        sent
                    </div>
                </li>
            </ul>
        </form>
        <h1>Solved request list</h1>
        <form method="post">
            <ul class="requests__list">
                <li class="requests__item">
                    <div class="requests__field" id="identifier">
                        0000000000
                    </div>
                    <div class="requests__field" id="truck-model">
                        Heavy-Duty Transporter XZ-2000
                    </div>
                    <div class="requests__field" id="topic">
                        Entry
                    </div>
                    <div class="requests__field" id="sent-date">
                        20.10.2023
                    </div>
                    <div class="requests__field" id="resolver">
                        Sender: Bob Brown
                    </div>
                    <div class="requests__field" id="status">
                        accepted
                    </div>
                </li>
            </ul>
        </form>
    </div>
</body>
</html>