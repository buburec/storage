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
                <form name="storekeeperTrucksForm" method="POST" action="/storage/truck-list">
                    <input type="hidden" name="command" value="storekeeper_truck_list" />
                    <input type="submit" name="trucksSubmit" value="Trucks">
                </form>
            </li>
            <li class="heading__item">
                <form name="storekeeperRequestsForm" method="POST" action="/storage/request-list">
                    <input type="hidden" name="command" value="storekeeper_requests" />
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
                    <input type="hidden" name="command" value="profile" />
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
        <div class="content__switch-form">
            <input type="submit" id="toggleButton" value="Resolved request list..." class="content__switch-submit">
        </div>
        <div id="activeRequestsContent" class="content__wrapper">
            <h1>Active request list</h1>
            <div class="list__wrapper">
                <ul>
                    <c:forEach items="${activeRequestList}" var="request">
                        <li class="list__item">
                            <div class="list__field" id="request__identifier">
                                <p>${request.getIdentifier()}</p>
                            </div>
                            <div class="list__field" id="request__truck-model">
                                <p>${request.getTruckModel()}</p>
                            </div>
                            <div class="list__field" id="request__topic">
                                <p>${request.getTopic()}</p>
                            </div>
                            <form name="storekeeperRequestForm" method="POST" action="/storage/request-list/request">
                                <input type="hidden" name="command" value="storekeeper_request" />
                                <input type="hidden" name="requestIdentifier" value="${request.getIdentifier()}" />
                                <input type="submit" value="" id="request__picture">
                            </form>
                            <div class="list__field" id="request__sent-date">
                                <p>${request.getSentDate()}</p>
                            </div>
                            <div class="list__field" id="request__resolver">
                                <p>${request.getResolver()}</p>
                            </div>
                            <div class="list__field" id="request__status">
                                <p>${request.getStatus()}</p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div id="resolvedRequestsContent" class="content__wrapper">
            <h1>Resolved request list</h1>
            <div class="list__wrapper">
                <ul>
                    <c:forEach items="${resolvedRequestList}" var="request">
                        <li class="list__item">
                            <div class="list__field" id="request__identifier">
                                <p>${request.getIdentifier()}</p>
                            </div>
                            <div class="list__field" id="request__truck-model">
                                <p>${request.getTruckModel()}</p>
                            </div>
                            <div class="list__field" id="request__topic">
                                <p>${request.getTopic()}</p>
                            </div>
                            <form name="storekeeperRequestForm" method="POST" action="/storage/request-list/request">
                                <input type="hidden" name="command" value="storekeeper_request" />
                                <input type="hidden" name="requestIdentifier" value="${request.getIdentifier()}" />
                                <input type="submit" value="" id="request__picture">
                            </form>
                            <div class="list__field" id="request__sent-date">
                                <p>${request.getSentDate()}</p>
                            </div>
                            <div class="list__field" id="request__resolver">
                                <p>${request.getResolver()}</p>
                            </div>
                            <div class="list__field" id="request__status">
                                <p>${request.getStatus()}</p>
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
            var activeRequestsContent = document.getElementById("activeRequestsContent");
            var resolvedRequestsContent = document.getElementById("resolvedRequestsContent");

            // Get reference to the button
            var toggleButton = document.getElementById("toggleButton");

            // Initial state (show storage content, hide truck content)
            activeRequestsContent.style.display = "flex";
            resolvedRequestsContent.style.display = "none";

            // Add click event listener to the button
            toggleButton.addEventListener("click", function () {
                // Toggle visibility of content wrappers
                if (activeRequestsContent.style.display === "flex") {
                    activeRequestsContent.style.display = "none";
                    resolvedRequestsContent.style.display = "flex";
                    toggleButton.value = "Active request list...";
                } else {
                    activeRequestsContent.style.display = "flex";
                    resolvedRequestsContent.style.display = "none";
                    toggleButton.value = "Resolved request list...";
                }
            });
        });
    </script>
</body>
</html>