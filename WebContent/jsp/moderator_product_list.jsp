<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.moderator.product_list" />
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
                    <input type="hidden" name="command" value="forward" />
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
        <div class="content__wrapper">
            <h1>Storage product list</h1>
            <div class="list__wrapper">
                <form name="moderatorCreateUserForm" method="POST" action="user-list/create-user">
                    <input type="hidden" name="command" value="forward" />
                    <input type="hidden" name="page" value="path.page.admin.user_create" />
                    <input type="submit" name="createSubmit" value="Create new" class="content__submit">
                </form>
                <ul>
                    <li class="list__item">
                        <div class="list__field" id="product__identifier">
                            00000000
                        </div>
                        <div class="list__field" id="product__title">
                            Elegant Chair
                        </div>
                        <div class="list__field" id="product__description">
                            A stylish and comfortable chair with a modern design
                        </div>
                        <div class="list__field" id="product__quantity">
                            $129.99
                        </div>
                    </li>
                    <li class="list__item">
                        <div class="list__field" id="product__identifier">
                            00000001
                        </div>
                        <div class="list__field" id="product__title">
                            Classic Sofa
                        </div>
                        <div class="list__field" id="product__description">
                            A timeless sofa that adds sophistication to any living space
                        </div>
                        <div class="list__field" id="product__quantity">
                            $299.99
                        </div>
                    </li>
                    <li class="list__item">
                        <div class="list__field" id="product__identifier">
                            00000002
                        </div>
                        <div class="list__field" id="product__title">
                            Rustic Coffee Table
                        </div>
                        <div class="list__field" id="product__description">
                            A sturdy and charming coffee table made from reclaimed wood
                        </div>
                        <div class="list__field" id="product__quantity">
                            $89.95
                        </div>
                    </li>
                    <li class="list__item">
                        <div class="list__field" id="product__identifier">
                            00000003
                        </div>
                        <div class="list__field" id="product__title">
                            Luxury Bedding Set
                        </div>
                        <div class="list__field" id="product__description">
                            Transform your bedroom with this luxurious bedding set
                        </div>
                        <div class="list__field" id="product__quantity">
                            $199.00
                        </div>
                    </li>
            </div>
        </div>
    </div>
</body>
</html>