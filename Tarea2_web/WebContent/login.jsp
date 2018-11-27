<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="media/styles.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="media/tbpm.css">
<jsp:include page="WEB-INF/Templates/head.jsp"/>
<title>Login TBPM</title>
</head>
<body>
	<div class="container ">
	<form class="form-signin" action="Login" method="POST">
		<h2 class= "text-center">Inicio Sesion</h2>
		<div class= "form-group">
			<input type="text" class="form-control" name="username" placeholder ="usuario" />		
		</div>
		<div class= "form-group">
			<input type="password" class="form-control" name="password" id="pass" placeholder = "pass" />		
		</div>
		<div class= "form-group">
			<input class="btn btn-primary btn-block" type="submit" value="Ingresar" />
		</div>
	</form>
	</div>

</body>
</html>
