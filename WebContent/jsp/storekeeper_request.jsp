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
                            <input type="submit" name="acceptSubmit" value="Accept">
                        </form>
                        <form>
                            <input type="submit" name="declineSubmit" value="Decline">
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>