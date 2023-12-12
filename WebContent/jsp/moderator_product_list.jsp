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
                <form name="moderatorUsersForm" method="POST" action="/storage/user-list">
                    <input type="hidden" name="command" value="users" />
                    <input type="hidden" name="page" value="path.page.moderator.user_list" />
                    <input type="submit" name="usersSubmit" value="Users">
                </form>
            </li>
            <li class="heading__item">
                <form name="moderatorProductsForm" method="POST" action="/storage/product-list">
                    <input type="hidden" name="command" value="product_list" />
                    <input type="submit" name="productsSubmit" value="Products">
                </form>
            </li>
            <li class="heading__item">
                <div class="heading__logo">
                    <form name="moderatorWelcomeForm" method="POST" action="/storage/welcome-page">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.moderator.welcome" />
                        <input type="submit" name="welcomeSubmit" value="">
                    </form>
                </div>
            </li>
            <li class="heading__item">
                <form name="moderatorProfileForm" method="POST" action="/storage/profile">
                    <input type="hidden" name="command" value="profile" />
                    <input type="hidden" name="page" value="path.page.moderator.profile" />
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
        <div class="content__switch-form">
            <input type="submit" id="toggleButton" value="Unused product list..." class="content__switch-submit">
        </div>
        <div id="usedProductContent" class="content__wrapper">
            <h1>Used product list</h1>
            <div class="list__wrapper">
                <form name="moderatorCreateUserForm" method="POST" action="/storage/product-list/create-product">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.moderator.product_create" />
                    <input type="submit" name="createSubmit" value="Create new" class="content__submit">
                </form>
                <ul>
                    <c:forEach items="${usedProductList}" var="product">
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
                                $<p>${product.getPrice()}</p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div id="unusedProductContent" class="content__wrapper">
            <h1>Unused product list</h1>
            <div class="list__wrapper">
                <form name="moderatorCreateUserForm" method="POST" action="/storage/product-list/create-product">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.moderator.product_create" />
                    <input type="submit" name="createSubmit" value="Create new" class="content__submit">
                </form>
                <ul>
                    <c:forEach items="${unusedProductList}" var="product">
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
                                $<p>${product.getPrice()}</p>
                            </div>
                            <form name="deleteProduct" method="POST" action="/storage/product-list">
                                <input type="hidden" name="command" value="delete_product" />
                                <input type="hidden" name="identifier" value="${product.getIdentifier()}" />
                                <div class="list__field" id="product__delete">
                                    <input type="submit" value="" id="list__delete-submit">
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
            var usedProductContent = document.getElementById("usedProductContent");
            var unusedProductContent = document.getElementById("unusedProductContent");

            // Get reference to the button
            var toggleButton = document.getElementById("toggleButton");

            // Initial state (show storage content, hide truck content)
            usedProductContent.style.display = "flex";
            unusedProductContent.style.display = "none";

            // Add click event listener to the button
            toggleButton.addEventListener("click", function () {
                // Toggle visibility of content wrappers
                if (usedProductContent.style.display === "flex") {
                    usedProductContent.style.display = "none";
                    unusedProductContent.style.display = "flex";
                    toggleButton.value = "Used product list...";
                } else {
                    usedProductContent.style.display = "flex";
                    unusedProductContent.style.display = "none";
                    toggleButton.value = "Unused product list...";
                }
            });
        });
    </script>
</body>
</html>