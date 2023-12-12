<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                <form name="adminUsersForm" method="POST" action="/storage/user-list">
                    <input type="hidden" name="command" value="users" />
                    <input type="hidden" name="page" value="path.page.admin.user_list" />
                    <input type="submit" name="usersSubmit" value="Users">
                </form>
            </li>
            <li class="heading__item">
                <form name="adminOccupationsForm" method="POST" action="/storage/occupation-list">
                    <input type="hidden" name="command" value="occupations" />
                    <input type="submit" name="occupationSubmit" value="Occupations">
                </form>
            </li>
            <li class="heading__item">
                <div class="heading__logo">
                    <form name="adminWelcomeForm" method="POST" action="/storage/welcome-page">
                        <input type="hidden" name="command" value="forward" />
                        <input type="hidden" name="page" value="path.page.admin.welcome" />
                        <input type="submit" name="welcomeSubmit" value="">
                    </form>
                </div>
            </li>
            <li class="heading__item">
                <form name="adminProfileForm" method="POST" action="/storage/profile">
                    <input type="hidden" name="command" value="profile" />
                    <input type="hidden" name="visibility" value="hidden" />
                    <input type="hidden" name="page" value="path.page.admin.profile" />
                    <input type="submit" name="profileSubmit" value="Profile">
                </form>
            </li>
            <li class="heading__item">
                <form name="adminLogoutForm" method="POST" action="/storage/login">
                    <input type="hidden" name="command" value="logout" />
                    <input type="submit" name="signOutSubmit" value="Sign out">
                </form>
            </li>
        </ul>
    </header>

    <div class="body__wrapper">
        <div class="content__wrapper">
            <h1>User creating</h1>
            <div class="info__wrapper">
                <form name="adminCreateUser" method="POST" action="/storage/user-list">
                    <ul class="info__list">
                        <li class="info__item">
                            <div class="info__field">
                                <input type="text" name="identifier" placeholder="name_surname" required>
                                <label>Login</label>
                            </div>
                             <div class="info__field">
                                <input type="text" name="password" placeholder="1" placeholder="Password" required>
                                <label>Password</label>
                            </div>
                        </li>
                        <li class="info__item">
                            <div class="info__field">
                                <input type="text" name="fullName" placeholder="Name Surname" placeholder="Full name" required>
                                <label>Full name</label>
                            </div>
                            <div class="info__select-field">
                                <select name="title" required>
                                    <option>Administrator</option>
                                    <option>Moderator</option>
                                    <option>Storekeeper</option>
                                    <option>Driver</option>
                                </select>
                                <label>Occupation</label>
                            </div>
                        </li>
                        <li class="info__item">
                            <input type="hidden" name="command" value="create_user" />
                            <input type="submit" name="createSubmit" value="Create">
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</body>
</html>