<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<br>
	<br>
	<br>
	<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
		<form method="POST" action="LoginServlet">
			<div class="form-group">
				<label for="username">login</label> <input type="text"
					class="form-control" name="username" placeholder="введите логин">
			</div>
			<div class="form-group">
				<label for="password">password</label> <input type="password"
					class="form-control" name="password" placeholder="введите пароль">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

</body>
</html>