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
                <form name="storekeeperTrucksForm" method="POST" action="/storage/truck-list">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.storekeeper.truck_list" />
                    <input type="submit" name="trucksSubmit" value="Trucks">
                </form>
            </li>
            <li class="heading__item">
                <form name="storekeeperRequestsForm" method="POST" action="/storage/request-list">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.storekeeper.request_list" />
                    <input type="submit" name="requestsSubmit" value="Requests">
                </form>
            </li>
            <li class="heading__item">
                <div class="heading__logo">
                    <form name="storekeeperWelcomeForm" method="POST" action="/storage/welcome-page">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.storekeeper.welcome" />
                        <input type="submit" name="welcomeSubmit" value="">
                    </form>
                </div>
            </li>
            <li class="heading__item">
                <form name="storekeeperProfileForm" method="POST" action="/storage/profile">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.storekeeper.profile" />
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
            <h1>Truck list</h1>
            <div class="list__wrapper">
                <ul>
                    <li class="list__item">
                        <div class="list__field" id="truck__identifier">
                            О753ХС95
                        </div>
                        <div class="list__field" id="truck__model">
                            Heavy-Duty Transporter XZ-2000
                        </div>
                        <div class="list__field" id="truck__host">
                            Bob Brown
                        </div>
                        <div class="list__field" id="truck__status">
                            inside
                        </div>
                        <form>
                            <input type="submit" value="" id="truck__picture">
                        </form>
                    </li>
                    <li class="list__item">
                        <div class="list__field" id="truck__identifier">
                            К857МУ20
                        </div>
                        <div class="list__field" id="truck__model">
                            Thunderstrike R-9000
                        </div>
                        <div class="list__field" id="truck__host">
                            Eva Lee
                        </div>
                        <div class="list__field" id="truck__status">
                            outside
                        </div>
                        <form>
                            <input type="submit" value="" id="truck__picture">
                        </form>
                    </li>
                    <li class="list__item">
                        <div class="list__field" id="truck__identifier">
                            Т177РА97
                        </div>
                        <div class="list__field" id="truck__model">
                            Inferno Blaster Z-500
                        </div>
                        <div class="list__field" id="truck__host">
                            Storekeeper
                        </div>
                        <div class="list__field" id="truck__status">
                            waiting
                        </div>
                        <form>
                            <input type="submit" value="" id="truck__picture">
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>