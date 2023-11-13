<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StorageKP</title>
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
            <h1>Request</h1>
            <div class="info__wrapper">
                <ul class="info__list">
                    <li class="info__item">  
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="00000003">
                            </form>
                            <label>info identifier</label>
                        </div>
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="Bob Brown">
                            </form>
                            <label>Sender</label>
                        </div>
                    </li>
                    <li class="info__item">  
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="Entry">
                            </form>
                            <label>Topic</label>
                        </div>
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="О753ХС95">
                            </form>
                            <label>Truck</label>
                        </div>
                    </li>
                    <li class="info__item">
                        <div class="info__commentary-field">
                            <form>
                                <textarea disabled>Monthly delivery from IKEA factory</textarea>
                            </form>
                            <label>Commentary</label>
                        </div>
                    </li>
                    <li class="info__item">  
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="none">
                            </form>
                            <label>Resolver</label>
                        </div>
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="sent">
                            </form>
                            <label>Status</label>
                        </div>
                    </li>
                    <li class="info__item">
                        <form>
                            <input type="submit" name="deleteSubmit" value="Delete">
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>