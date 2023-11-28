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
        <div class="content__wrapper">
            <h1>Request list</h1>
            <div class="list__wrapper">
                <ul>
                    <form name="driverCreateRequestForm" method="POST" action="/storage/request-list/choose-request">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.driver.request_choose" />
                        <input type="submit" name="createSubmit" value="Create request" class="content__submit">
                    </form>
                    <c:forEach items="${requestList}" var="request">
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
                            <form name="driverRequestForm" method="POST" action="/storage/request-list/request">
                                <input type="hidden" name="command" value="driver_request" />
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
</body>
</html>