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
                <form name="driverProductsForm" method="POST" action="/storage/product-list">
                    <input type="hidden" name="command" value="driver_product_list" />
                    <input type="submit" name="productsSubmit" value="Products">
                </form>
            </li>
            <li class="heading__item">
                <form name="driverRequestsForm" method="POST" action="/storage/request-list">
                    <input type="hidden" name="command" value="driver_requests" />
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
                    <input type="hidden" name="command" value="driver_profile" />
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
            <h1>Request choosing</h1>
            <div class="info__wrapper">
                <form name="driverCreateRequestForm" method="POST" action="/storage/request-list/fill-request">
                    <ul>
                        <li class="info__item">
                            <div class="info__select-field">
                                <select name="actionType">
                                    <option>entry</option>
                                    <option>exit</option>
                                    <option>loading</option>
                                    <option>unloading</option>
                                </select>
                                <label>Action</label>
                            </div>
                            <!-- <div class="info__field"></div> -->
                        </li>
                        <li class="info__item">
                            <input type="hidden" name="command" value="choose_request" />
                            <input type="submit" name="createSubmit" value="Next step">
                        </li>
                    </ul>
                </form>
                <form name="driverCancelRequestForm" method="POST" action="/storage/user-list">
                    <input type="hidden" name="command" value="delete_user" />
                    <input type="hidden" name="identifier" value="${profile.get(0).getIdentifier()}" />
                    <input type="submit" name="cancelSubmit" value="Cancel" class="info__extra-submit">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>