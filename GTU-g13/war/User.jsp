<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/style.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>User Page</title>
</head>
<body>
	<div class="row titulo">
		<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
			<a href="/"><img id="fotoTitulo" src="img/tarjetas.png"> </img></a>
		</div>
		<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
			<div class="row">
				<h1 class="textTitulo primeraFila">
					Hola,
					<c:out value="${user.name}" />
				</h1>
			</div>
			<div class="row">
				<h1 class="textTitulo segundaFila">Gestiona tu solicitud</h1>
			</div>
		</div>

	</div>

	<a class="logout" href="<c:url value="${url}"/>">LOG OUT</a>

	<div class="row">
		<p class="texto">¿Aún no has pedido tu tarjeta?</p>
	</div>
	<div class="row" action="/user" role="form">

		<div class="col-lg-5 col-md-5 col-xs-5 col-sm-5">
			<img class="fotoTarjeta" src="img/tarjeta.png"> </img>
		</div>

		<div class="col-lg-6 col-md-6 col-xs-6 col-sm-6 form">

			<form method="post">
				
					<div class="row">
						<input id="monedero" name="monedero" type="checkbox" value="checked" /> ¿Desea
					la funcionalidad de tarjeta monedero? 
					</div>
					<div class="row">
						<input 	type="submit" name="submit" id="submit2" value="Solicitar Tarjeta"
						class="btn btn-info">
					</div>
					<div class="row textoAzul">
						<a href="/modify">Modificar datos de usuario</a>
					</div>
				
			

				<div class="row final">
					<p class="texto">Si ya la tienes...</p>
					<a class="textoAzul" href="/consulta">Consultar estado de peticion</a>
				</div>

				
			</form>



		</div>
	</div>
	<!-- Librería jQuery requerida por los plugins de JavaScript -->
	<script src="http://code.jquery.com/jquery.js"></script>
</body>
</html>