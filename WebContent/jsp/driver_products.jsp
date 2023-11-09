<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StorageKP</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
    <link rel="stylesheet" href="./css/reset.css" type="text/css">
    <link rel="stylesheet" href="./css/heading.css" type="text/css">
    <link rel="stylesheet" href="./css/products.css" type="text/css">
</head>
<body>
    <header class="heading__wrapper">
        <ul class="heading__list">
            <li class="heading__item">
                <form name="driverProductsForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.driver.products" />
                    <input type="submit" name="productsSubmit" value="Products">
                </form>
            </li>
            <li class="heading__item">
                <form name="driverRequestsForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.driver.requests" />
                    <input type="submit" name="requestsSubmit" value="Requests">
                </form>
            </li>
            <li class="heading__item">
                <div class="heading__logo">
                    <form name="driverWelcomeForm" method="POST" action="FrontController">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.driver.welcome" />
                        <input type="submit" name="welcomeSubmit" value="">
                    </form>
                </div>
            </li>
            <li class="heading__item">
                <form name="driverProfileForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.driver.profile" />
                    <input type="submit" name="profileSubmit" value="Profile">
                </form>
            </li>
            <li class="heading__item">
                <form name="driverProfileForm" method="POST" action="FrontController">
                    <input type="hidden" name="command" value="logout" />
                    <input type="submit" name="signOutSubmit" value="Sign out">
                </form>
            </li>
        </ul>
    </header>

    <div class="products__wrapper">
        <h1>Storage product list</h1>
        <form method="post">
            <ul class="products__list">
                <li class="products__item">
                    <div class="products__field" id="identifier">
                        00000000
                    </div>
                    <div class="products__field" id="title">
                        Elegant Chair
                    </div>
                    <div class="products__field" id="description">
                        A stylish and comfortable chair with a modern design
                    </div>
                    <div class="products__field" id="quantity">
                        384
                    </div>
                </li>
                <li class="products__item">
                    <div class="products__field" id="identifier">
                        00000001
                    </div>
                    <div class="products__field" id="title">
                        Classic Sofa
                    </div>
                    <div class="products__field" id="description">
                        A timeless sofa that adds sophistication to any living space
                    </div>
                    <div class="products__field" id="quantity">
                        231
                    </div>
                </li>
            </ul>
        </form>
        <h1>Truck product list</h1>
        <form method="post">
            <ul class="products__list">
                <li class="products__item">
                    <div class="products__field" id="identifier">
                        00000000
                    </div>
                    <div class="products__field" id="title">
                        Elegant Chair
                    </div>
                    <div class="products__field" id="description">
                        A stylish and comfortable chair with a modern design
                    </div>
                    <div class="products__field" id="quantity">
                        53
                    </div>
                </li>
                <li class="products__item">
                    <div class="products__field" id="identifier">
                        00000002
                    </div>
                    <div class="products__field" id="title">
                        Rustic Coffee Table
                    </div>
                    <div class="products__field" id="description">
                        A sturdy and charming coffee table made from reclaimed wood
                    </div>
                    <div class="products__field" id="quantity">
                        16
                    </div>
                </li>
            </ul>
        </form>
    </div>
</body>
</html>