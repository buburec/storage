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
    <link rel="stylesheet" href="../css/list.css" type="text/css">
    <style>
        /* Стили для вкладок */
        .tabs {
          display: flex;
          list-style: none;
          padding: 0;
          margin: 0;
        }

        .tab {
          margin-right: 10px;
          cursor: pointer;
          padding: 8px 16px;
          border: 1px solid #ccc;
          border-radius: 5px 5px 0 0;
          background-color: #f2f2f2;
        }

        .tab:hover {
          background-color: #ddd;
        }

        .tab.active {
          background-color: #fff;
          border-bottom: 1px solid #fff;
        }

        /* Скрытие контента вкладок */
        .tab-content {
          display: none;
          padding: 20px;
          border: 1px solid #ccc;
          border-radius: 0 0 5px 5px;
        }

        .tab-content.active {
          display: block;
        }
  </style>
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
            <h1>Request creating</h1>
            <div class="info__wrapper">
                <ul class="tabs">
                    <li class="tab" onclick="showTab('tab1')">Movement</li>
                    <li class="tab" onclick="showTab('tab2')">Loading</li>
                    <li class="tab" onclick="showTab('tab3')">Unloading</li>
                </ul>
                <div id="tab1" class="tab-content active">
                    <li class="info__item">
                    <form name="driverEntryRequestForm" method="POST" action="/storage/request-list/create-request">
                        <input type="hidden" name="command" value="entry_request" />
                        <input type="submit" name="createSubmit" value="Entry request">
                    </form>
                    <form name="driverExitRequestForm" method="POST" action="/storage/request-list/create-request">
                        <input type="hidden" name="command" value="exit_request" />
                        <input type="submit" name="createSubmit" value="Exit request">
                    </form>
                    </li>
                    <form name="driverCreateRequestForm" method="POST" action="/storage/request-list/create-request">
                        <ul>
                            <li class="info__item">
                                <div class="info__select-field">
                                    <select required name="truckIdentifier">
                                        <c:forEach items="${truckIdentifierList}" var="truck">
                                            <option><p>${truck.getTruckIdentifier()}</p></option>
                                        </c:forEach>
                                    </select>
                                    <label>Truck</label>
                                </div>
                                <div class="info__select-field">
                                    <select name="selectedProducts">
                                        <c:forEach items="${productList}" var="product">
                                            <option><p>${product.getTitle()}</p></option>
                                        </c:forEach>
                                    </select>
                                    <input type="number" name="quantity" id="quantity" min="0" max="100" step="1" value="0">
                                     <input type="submit" name="createSubmit" value="Tick">
                                </div>

                           </li>
                            <li class="info__item">
                                <div class="info__commentary-field">
                                    <textarea name="commentary"></textarea>
                                    <label>Commentary</label>
                                </div>
                            </li>
                            <li class="info__item">
                                <input type="hidden" name="command" value="entry_request" />
                                <input type="submit" name="createSubmit" value="Create">
                            </li>
                        </ul>
                    </form>
                </div>
                <div id="tab2" class="tab-content">
                    <form name="driverCreateRequestForm" method="POST" action="/storage/request-list/create-request">
                        <ul>
                            <li class="info__item">
                                <div class="info__select-field">
                                    <select required name="truckIdentifier">
                                        <option>О753ХС95</option>
                                    </select>
                                    <label>Truck</label>
                                </div>
                                <div class="info__select-field">
                                    <select required name="trucksProduct">
                                        <option>Chair</option>
                                    </select>
                                    <label>Trucks product</label>
                                </div>
                            </li>
                            <li class="info__item">
                                <div class="info__commentary-field">
                                    <textarea name="commentary"></textarea>
                                    <label>Commentary</label>
                                </div>
                            </li>
                            <li class="info__item">
                                <input type="hidden" name="command" value="entry_request" />
                                <input type="submit" name="createSubmit" value="Create">
                            </li>
                        </ul>
                    </form>
                </div>
                <div id="tab3" class="tab-content">
                    <form>
                        <ul>
                            <li class="info__item">
                                <div class="info__select-field">
                                    <select required>
                                        <option>О753ХС95</option>
                                    </select>
                                    <label>Truck</label>
                                </div>
                                <div class="info__select-field">
                                    <select required>
                                        <option>Chair</option>
                                    </select>
                                    <label>Storage product</label>
                                </div>
                            </li>
                            <li class="info__item">
                                <div class="info__commentary-field">
                                    <textarea></textarea>
                                    <label>Commentary</label>
                                </div>
                            </li>
                            <li class="info__item">
                                <input type="submit" name="createSubmit" value="Create">
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>

    </div>
    <script>
        function showTab(tabId) {
            // Скрыть все вкладки и сделать неактивными
            var tabs = document.querySelectorAll('.tab-content');
            tabs.forEach(function(tab) {
              tab.classList.remove('active');
            });

            // Показать выбранную вкладку и сделать ее активной
            document.getElementById(tabId).classList.add('active');

            // Убрать класс 'active' у всех вкладок
            var tabButtons = document.querySelectorAll('.tab');
            tabButtons.forEach(function(button) {
              button.classList.remove('active');
            });

            // Добавить класс 'active' к выбранной вкладке
            event.currentTarget.classList.add('active');
        }
    </script>
</body>
</html>