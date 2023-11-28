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
            <h1>Waybill manager</h1>
            <div class="info__wrapper">
                <ul>
                    <c:if test="${actionType eq 'entry' || actionType eq 'loading'}">
                        <li class="info__item" id="product__add">
                            <form name="driverAddWaybillProductForm" method="POST" action="/storage/request-list/create-request">
                                <div class="info__select-field">
                                    <select name="title">
                                        <c:forEach items="${productList}" var="product">
                                            <option><p>${product.getTitle()}</p></option>
                                        </c:forEach>
                                    </select>
                                    <label>Truck/storage product</label>
                                </div>
                                <input type="hidden" name="command" value="add_waybill_product" />
                                <input type="number" name="quantity" id="quantity" min="0" max="100" step="1" value="0">
                                <input type="submit" name="createSubmit" value="">
                            </form>
                        </li>
                    </c:if>
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
                                    <c:if test="${actionType eq 'entry' || actionType eq 'loading'}">
                                        <form name="driverDeleteWaybillProductForm" method="POST" action="/storage/request-list/create-request">
                                            <input type="hidden" name="command" value="delete_waybill_product" />
                                            <input type="hidden" name="productIdentifier" value="${waybill.getProductIdentifier()}" />
                                            <div class="info__product__field" id="product__delete">
                                                <input type="submit" value="" class="product__delete-submit">
                                            </div>
                                        </form>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li class="info__item">
                        <form name="driverCreateRequestForm" method="POST" action="/storage/request-list">
                            <input type="hidden" name="command" value="create_request" />
                            <input type="submit" name="createSubmit" value="Create">
                        </form>
                    </li>
                </ul>
                <!-- <form name="driverCancelRequestForm" method="POST" action="/storage/user-list">
                    <input type="hidden" name="command" value="delete_user" />
                    <input type="hidden" name="identifier" value="${profile.get(0).getIdentifier()}" />
                    <input type="submit" name="cancelSubmit" value="Cancel" class="info__extra-submit">
                </form> -->
            </div>
        </div>
    </div>
</div>
</body>
</html>