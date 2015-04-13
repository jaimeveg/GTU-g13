<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/style.css">

<!-- Latest compiled and minified JavaScript -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>User Page</title>
</head>
<body>
	<div class="row titulo">
		<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
			<a href="/"><img id="fotoTitulo" src="img/tarjetas.png"> </img></a>
		</div>
		<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
			<div class="row">
				<h1 class="textTitulo primeraFila">Disfruta ya de tu tarjeta</h1>
			</div>
			<div class="row">
				<h1 class="textTitulo segundaFila">Completa la solicitud</h1>
			</div>
		</div>

	</div>
	
	<a href="<c:url value="${url}"/>">LOG OUT</a>
	
	<div class="container formulario">
		<div action="/user"  role="form">
			<form role="form" method="post">
				<div class="col-lg-6">

					<div class="form-group">
						<label for="InputName">INTRODUCE TU NOMBRE</label>
						<div class="input-group">
							<input type="text" class="form-control" name="firstname"
								id="InputName" value="<c:url value="${user.name}"/>" required> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="InputName">INTRODUCE TU APELLIDO</label>
						<div class="input-group">
							<input type="text" class="form-control" name="lastname"
								id="InputName" value="<c:url value="${user.surname}"/>" required> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
						
					<div class="form-group">
					<input name="monedero" type="checkbox" value="checked"/> ¿Desea la funcionalidad de tarjeta monedero?
					</div>
					
					<div class="col-lg-6">
						<div class="well well-sm">
							<strong><span class="glyphicon glyphicon-asterisk"></span>
								Campo Obligatorio</strong>
						</div>

					</div>
					<div class="col-lg-6">

						<input style="width: 100%;" type="submit" name="submit"
							id="submit" value="Pedir Tarjeta" class="btn btn-info pull-right">
					</div>
				</div>
			</form>
			<div style="visibility: hidden;" class="col-lg-5 col-md-push-1">
				<div class="col-md-12">
					<div class="alert alert-success">
						<strong><span class="glyphicon glyphicon-ok"></span>
							Success! Message sent.</strong>
					</div>
					<div class="alert alert-danger">
						<span class="glyphicon glyphicon-remove"></span><strong>
							Error! Please check all page inputs.</strong>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Librería jQuery requerida por los plugins de JavaScript -->
	<script src="http://code.jquery.com/jquery.js"></script>
</body>
</html>