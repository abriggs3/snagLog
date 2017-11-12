<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=1,initial-scale=1,user-scalable=1" />
	<title>Login Required</title>
	
	<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="login_form/assets/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="login_form/assets/css/styles.css" />
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<section class="container">
			<section class="login-form">
				<form method="post" action="j_security_check" role="login">
					<section class="form-outer">
						<h2>Please sign in</h2>
						<input type="text" name="j_username" required class="form-control input-lg" placeholder="username">
						<input type="password" name="j_password" required class="form-control input-lg" placeholder="password">
						<button type="submit" name="go" class="btn btn-lg btn-block">Sign in</button>
					</section>
					<div class="form-outer">
						<input type="checkbox" name="remember" value="1" /> Remember me<br />
						<a href="register">Create account</a> or <a href="#">reset password</a>
					</div>
				</form>
			</section>
	</section>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="login_form/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>