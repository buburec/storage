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
    <link rel="stylesheet" href="./css/info.css" type="text/css">
    <link rel="stylesheet" href="./css/list.css" type="text/css">
</head>
<body>
    <header class="heading__wrapper">
        <ul class="heading__list">
            <li class="heading__item">
                <form name="driverProductsForm" method="POST" action="/storage/product-list">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.driver.product_list" />
                    <input type="submit" name="productsSubmit" value="Products">
                </form>
            </li>
            <li class="heading__item">
                <form name="driverRequestsForm" method="POST" action="/storage/request-list">
                    <input type="hidden" name="command" value="requests" />
                    <input type="hidden" name="page" value="path.page.driver.request_list" />
                    <input type="submit" name="requestsSubmit" value="Requests">
                </form>
            </li>
            <li class="heading__item">
                <div class="heading__logo">
                    <form name="driverWelcomeForm" method="POST" action="/storage/welcome-page">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.driver.welcome" />
                        <input type="submit" name="welcomeSubmit" value="">
                    </form>
                </div>
            </li>
            <li class="heading__item">
                <form name="driverProfileForm" method="POST" action="/storage/profile">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.driver.profile" />
                    <input type="submit" name="profileSubmit" value="Profile">
                </form>
            </li>
            <li class="heading__item">
                <form name="driverProfileForm" method="POST" action="/storage/login">
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
                <ul class="info__list">
                    <li class="info__item">
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="bob_driver99" required>
                            </form>
                            <label>Login</label>
                        </div>
                        <div class="info__field">
                            <form>
                                <input type="text" value="1" required>
                            </form>
                            <label>Password</label>
                        </div>
                    </li>
                    <li class="info__item">
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="Driver" required>
                            </form>
                            <label>Occupation</label>
                        </div>
                        <div class="info__field">
                            <form>
                                <input type="text" value="Bob Brown" required>
                            </form>
                            <label>Full name</label>
                        </div>
                    </li>
                    <li class="info__item">
                        <form>
                            <input type="submit" name="saveSubmit" value="Save changes">
                        </form>
                    </li>
                </ul>
            </div>
        </div>

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
                        <div class="list__field" id="truck__status">
                            inside
                        </div>
                        <form name="driverTruckForm" method="POST" action="/storage/truck">
                            <input type="hidden" name="command" value="forward" />
                            <input type="hidden" name="page" value="path.page.driver.truck" />
                            <input type="submit" value="" id="truck__picture">
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>