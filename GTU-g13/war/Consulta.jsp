<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/style.css">


<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
<title>Página de consulta</title>

</head>
<body>
	<div class="row titulo">
		<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
			<img id="fotoTitulo" src="img/tarjetas.png"> </img>
		</div>
		<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
			<div class="row">
				<h1 class="textTitulo primeraFila">BIENVENIDO AL</h1>
			</div>
			<div class="row">
				<h1 class="textTitulo segundaFila">SISTEMA DE GESTIÓN DE
					TARJETAS UNIVERSITARIAS</h1>
			</div>
		</div>

	</div>

	<c:if test="${card	!=	null}">
<p class="aceptadasTexto">Estado de la petición</p>
	<table class="table table-hover consulta">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Entidad</th>
			<th>Estado</th>
			<th>Eliminar solicitud</th>
		</tr>

		<tr class="warning">
			<td><c:out value="${card.id}" /></td>
			<td><c:out value="${usuario.name}" /> <c:out value="${usuario.surname}" /></td>
			<td>
				<c:out value="${card.entity}" />		
			</td>
			<td>
				<c:out value="${card.state}" />		
			</td>
			<td>
				<form action="/consulta" method="post">
					<input type="hidden" name="id" value="${card.id}">
					<input type="submit" value="Borrar">
				</form>
			</td>
		</tr>


	</table>
	<p>La solicitud se eliminará cuando el gestor de la página procese su petición</p>
</c:if>
<c:if test="${card	==	null}">
	<p>El usuario no ha realizado ninguna peticion</p>
</c:if>

	<a href="/user">Volver</a>

</body>
</html>