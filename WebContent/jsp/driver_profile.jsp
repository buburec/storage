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
    <link rel="stylesheet" href="./css/list.css" type="text/css">
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
        <div class="content__switch-form">
            <input type="submit" id="toggleButton" value="Truck list..." class="content__switch-submit">
        </div>
        <div id="profileContent" class="content__wrapper">
            <h1>Profile</h1>
            <div class="info__wrapper">
                <form name="driverUpdateProfileForm" method="POST" action="/storage/profile">
                    <ul class="info__list">
                        <li class="info__item">
                            <div class="info__blocked-field">
                                <input type="text" name="identifier" value="${profile.get(0).getIdentifier()}" required>
                                <label>Login</label>
                            </div>
                            <div class="info__field">
                                <input type="text" name="password" value="${profile.get(0).getPassword()}" required>
                                <label>Password</label>
                            </div>
                        </li>
                        <li class="info__item">
                            <div class="info__blocked-field">
                                <input type="text" value="${profile.get(0).getTitle()}" required>
                                <label>Occupation</label>
                            </div>
                            <div class="info__field">
                                <input type="text" name="fullName" value="${profile.get(0).getFullName()}" required>                                    <label>Full name</label>
                            </div>
                        </li>
                        <li class="info__item">
                            <input type="hidden" name="command" value="update_driver_profile" />
                            <input type="submit" name="saveSubmit" value="Save changes">
                        </li>
                    </ul>
                </form>
            </div>
        </div>

        <div id="truckListContent" class="content__wrapper">
            <h1>Truck list</h1>
            <div class="list__wrapper">
                <ul>
                    <form name="driverCreateTruckForm" method="POST" action="/storage/profile/create-truck">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.driver.truck_create" />
                        <input type="submit" name="createSubmit" value="Create truck" class="content__submit">
                    </form>
                    <c:forEach items="${insideTruckList}" var="truck">
                        <li class="list__item">
                            <div class="list__field" id="truck__identifier">
                                <p>${truck.getTruckIdentifier()}</p>
                            </div>
                            <div class="list__field" id="truck__model">
                                <p>${truck.getModel()}</p>
                            </div>
                            <div class="list__field" id="truck__status">
                                inside
                            </div>
                        </li>
                    </c:forEach>
                    <c:forEach items="${outsideTruckList}" var="truck">
                        <li class="list__item">
                            <div class="list__field" id="truck__identifier">
                                <p>${truck.getTruckIdentifier()}</p>
                            </div>
                            <div class="list__field" id="truck__model">
                                <p>${truck.getModel()}</p>
                            </div>
                            <div class="list__field" id="truck__status">
                                outside
                            </div>
                            <form name="driverCreateTruckForm" method="POST" action="/storage/profile">
                                <input type="hidden" name="command" value="forward" />
                                <input type="hidden" name="truckIdentifier" value="${truck.getTruckIdentifier()}" />
                                <div class="info__product__field" id="product__delete">
                                    <input type="submit" value="" class="product__delete-submit">
                                </div>
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            // Get references to the content wrappers
            var storageContent = document.getElementById("profileContent");
            var truckContent = document.getElementById("truckListContent");

            // Get reference to the button
            var toggleButton = document.getElementById("toggleButton");

            // Initial state (show storage content, hide truck content)
            storageContent.style.display = "flex";
            truckContent.style.display = "none";

            // Add click event listener to the button
            toggleButton.addEventListener("click", function () {
                // Toggle visibility of content wrappers
                if (storageContent.style.display === "flex") {
                    storageContent.style.display = "none";
                    truckContent.style.display = "flex";
                    toggleButton.value = "Profile...";
                } else {
                    storageContent.style.display = "flex";
                    truckContent.style.display = "none";
                    toggleButton.value = "Truck list...";
                }
            });
        });
    </script>
</body>
</html>