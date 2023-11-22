<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Block</title>
    <link rel="shortcut icon" href="./images/logo.svg" type="image/x-icon">
	<link rel="stylesheet" href="./css/block.css" type="text/css">
</head>
<body>
    <div class="block__wrapper">
        <h1>You're blocked!</h1>
        <div class="block__description">
            Contact the moderation team to find out the reason for your blocking
        </div>
		 <form name="backToSignInForm" method="POST" action="/storage/login">
            <input type="hidden" name="command" value="logout" />
            <input type="submit" value="Back to sign in">
        </form>
    </div>
</body>
</html>