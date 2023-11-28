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
                    <input type="hidden" name="visibility" value="hidden" />
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
            <h1>Product creating</h1>
            <div class="info__wrapper">
                <ul class="info__list">
                    <form name="createProductForm" method="POST" action="/storage/product-list">
                        <li class="info__item">
                            <div class="info__field">
                                <input type="text" name="title" value="" placeholder="Chair" required>
                                <label>Title</label>
                            </div>
                            <div class="info__field">
                                <input type="text" name="price" value="" placeholder="$19.99" required>
                                <label>Price</label>
                            </div>
                        </li>
                        <li class="info__item">
                            <div class="info__commentary-field">
                                <textarea name="description" placeholder="Good quality, pleasant to the touch"></textarea>
                                <label>Description</label>
                            </div>
                        </li>
                        <li class="info__item">
                            <input type="hidden" name="command" value="create_product" />
                            <input type="submit" name="createSubmit" value="Create">
                        </li>
                    </form>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>