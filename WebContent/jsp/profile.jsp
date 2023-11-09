<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StorageKP</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
    <link rel="stylesheet" href="./css/reset.css" type="text/css">
    <link rel="stylesheet" href="./css/heading.css" type="text/css">
    <link rel="stylesheet" href="./css/profile.css" type="text/css">
</head>
<body>
    <div class="profile__wrapper">
        <h1>Profile</h1>
        <form method="post">
            <ul class="profile__list">
                <li class="profile__item">
                    <div class="profile__field">
                        <input type="text" value="" required>
                        <label>Identifier</label>
                    </div>
                    <div class="profile__field">
                        <input type="text" value="" required>
                        <label>Occupation</label>
                    </div>
                </li>
                <li class="profile__item">
                    <div class="profile__field">
                        <input type="text" value="" placeholder="First name" required>
                        <label>First name</label>
                    </div>
                    <div class="profile__field">
                        <input type="text" value="" placeholder="Last name" required>
                        <label>Last name</label>
                    </div>
                </li>
                <li class="profile__item">
                    <input type="submit" name="saveSubmit" value="Save changes">
                    <input type="submit" name="cancelSubmit" value="Cancel">
                </li>
            </ul>
        </form>
    </div>
</body>
</html>