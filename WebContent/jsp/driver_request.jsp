<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <h1>${requestList.get(0).getTopic()} request</h1>
            <div class="info__wrapper">
                <ul class="info__list">
                    <li class="info__item">  
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="${requestList.get(0).getIdentifier()}">
                            </form>
                            <label>Request identifier</label>
                        </div>
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="${requestList.get(0).getTruckIdentifier()}">
                            </form>
                            <label>Truck</label>
                        </div>
                    </li>
                    <li class="info__item">
                        <div class="info__commentary-field">
                            <form>
                                <textarea disabled>${requestList.get(0).getCommentary()}</textarea>
                            </form>
                            <label>Sender's commentary</label>
                        </div>
                    </li>
                    <li class="info__item">
                        <ul class="info__product__list">
                            <c:forEach items="${waybillList}" var="waybill">
                                <li class="info__product__item">
                                    <div class="info__product__field" id="product__identifier">
                                        <p>${waybill.getProductIdentifier()}</p>
                                    </div>
                                    <div class="info__product__field" id="product__title">
                                        <p>${waybill.getProductTitle()}</p>
                                    </div>
                                    <div class="info__product__field" id="product__quantity">
                                        <p>${waybill.getQuantity()}</p>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li class="info__item">  
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="${requestList.get(0).getResolver()}">
                            </form>
                            <label>Resolver</label>
                        </div>
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="${requestList.get(0).getStatus()}">
                            </form>
                            <label>Status</label>
                        </div>
                    </li>
                    <c:if test="${not empty requestList.get(0).getResolverResponse()}">
                        <li class="info__item">
                            <div class="info__commentary-field">
                                <form>
                                    <textarea disabled>${requestList.get(0).getResolverResponse()}</textarea>
                                </form>
                                <label>Resolver's response</label>
                            </div>
                        </li>
                    </c:if>
                    <li class="info__item">
                        <form name="driverRequestsForm" method="POST" action="/storage/request-list">
                            <input type="hidden" name="command" value="driver_requests" />
                            <input type="submit" name="staySubmit" value="OK">
                        </form>
                        <c:if test="${requestList.get(0).getStatus() eq 'sent'}">
                            <form name="driverRequestsForm" method="POST" action="/storage/request-list">
                                <input type="hidden" name="requestIdentifier" value="${requestList.get(0).getIdentifier()}" />
                                <input type="hidden" name="command" value="delete_request" />
                                <input type="submit" name="deleteSubmit" value="Delete">
                            </form>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>