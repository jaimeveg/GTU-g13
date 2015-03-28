<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/style.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>Stamping Page</title>
</head>
<body>
	<div class="row titulo">
		<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
			<a href="/"><img id="fotoTitulo" src="img/tarjetas.png"> </img> </a>
		</div>
		<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
			<div class="row">
				<h1 class="textTitulo primeraFila">Página de consulta de
					solicitudes:</h1>
			</div>
			<div class="row">
				<h1 class="textTitulo segundaFila">Empresa estampadora</h1>
			</div>
		</div>

	</div>

	<a href="<c:url value="${url}"/>">LOG OUT</a>

	<div class="col-md-8 col-xs-8 col-lg-8 col-sm-8 tablas ">

		<p class="aceptadasTexto">PETICIONES PENDIENTES</p>
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Entidad</th>
				<th>Estado</th>
				<th>Aceptar</th>
				<th> Rechazar</th>
			</tr>

			<c:forEach items="${cards}" var="card">
				<tr class="warning">
					<td><c:out value="${card.id}" /></td>
					<td><c:out value="${card.user}" /></td>
					<td><c:out value="${card.entity}" /></td>
					<td><c:out value="${card.state}" /></td>
					<td>
						<form action="/stamp" method="post">
							<input type="hidden" name="id" value="${card.id}">
							<input type="hidden" name="action" value="Accept">
							<input type="submit" value="Aceptar Petición">
						</form>
					</td>
					<td>
						<form action="/stamp" method="post">
							<input type="hidden" name="id" value="${card.id}">
							<input type="hidden" name="action" value="Reject">
							<input type="submit" value="Rechazar Petición">
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>

		<p class="aceptadasTexto">PETICIONES ACEPTADAS</p>
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Apellido</th>

			</tr>

			<c:forEach items="${accepted}" var="accept">

				<tr class="success">
					<td><c:out value="${accept.id}" /></td>
					<td><c:out value="${accept.user}" /></td>
					<td>-</td>
				</tr>
			</c:forEach>

		</table>
		
	</div>
	<!-- Librería jQuery requerida por los plugins de JavaScript -->
	<script src="http://code.jquery.com/jquery.js"></script>

</body>
</html>