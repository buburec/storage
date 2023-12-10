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
        <!--<div class="content__wrapper">
        <input type="submit" id="toggleButton" value="Truck product list" class="content__submit">
        </div>-->
        <div class="content__switch-form">
            <input type="submit" id="toggleButton" value="Truck product list..." class="content__switch-submit">
        </div>
        <div id="storageContent" class="content__wrapper">
            <h1>Storage product list</h1>
            <div class="list__wrapper">
                <ul>
                    <c:forEach items="${storageProductList}" var="product">
                        <li class="list__item">
                            <div class="list__field" id="product__identifier">
                                <p>${product.getIdentifier()}</p>
                            </div>
                            <div class="list__field" id="product__title">
                                <p>${product.getTitle()}</p>
                            </div>
                            <div class="list__field" id="product__description">
                                <p>${product.getDescription()}</p>
                            </div>
                            <div class="list__field" id="product__quantity">
                                <p>${product.getQuantity()}</p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div id="truckContent" class="content__wrapper">
            <h1>Truck product list</h1>
            <div class="list__wrapper">
                <ul>
                    <c:forEach items="${storageTruckProductList}" var="truckProduct">
                        <li class="list__item">
                            <div class="list__field" id="product__identifier">
                                <p>${truckProduct.getTruckIdentifier()}</p>
                            </div>
                            <div class="list__field" id="product__title">
                                <p>${truckProduct.getTitle()}</p>
                            </div>
                            <div class="list__field" id="product__description">
                                <p>${truckProduct.getDescription()}</p>
                            </div>
                            <div class="list__field" id="product__quantity">
                                <p>${truckProduct.getQuantity()}</p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            // Get references to the content wrappers
            var storageContent = document.getElementById("storageContent");
            var truckContent = document.getElementById("truckContent");

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
                    toggleButton.value = "Storage product list...";
                } else {
                    storageContent.style.display = "flex";
                    truckContent.style.display = "none";
                    toggleButton.value = "Truck product list...";
                }
            });
        });
    </script>
</body>
</html>