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
                   <input type="hidden" name="command" value="forward" />
                   <input type="hidden" name="page" value="path.page.admin.occupation_list" />
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
                   <input type="hidden" name="command" value="forward" />
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
                <ul class="info__list">
                    <li class="info__item">
                        <div class="info__blocked-field">
                            <form>
                                <input type="text" value="00000000" required>
                            </form>
                            <label>Identifier</label>
                        </div>
                        <div class="info__select-field">
                            <form>
                                <select required>
                                    <option>Moderator</option>
                                    <option>Storekeeper</option>
                                    <option>Driver</option>
                                </select>
                            </form>
                            <label>Occupation</label>
                        </div>
                    </li>
                    <li class="info__item">  
                        <div class="info__field">
                            <form>
                                <input type="text" value="John" placeholder="First name" required>
                            </form>
                            <label>First name</label>
                        </div>
                        <div class="info__field">
                            <form>
                                <input type="text" value="Doe" placeholder="Last name" required>
                            </form>
                            <label>Last name</label>
                        </div>
                    </li>
                    <li class="info__item">
                        <form>
                            <input type="submit" name="createSubmit" value="Create">
                        </form>
                        <form>
                            <input type="submit" name="cancelSubmit" value="Cancel">
                    </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>