<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/style.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>University Page</title>
</head>
<body>
	<div class="row titulo">
		<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
			<a href="/"><img id="fotoTitulo" src="img/tarjetas.png"> </img> </a>
		</div>
		<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
			<div class="row">
				<h1 class="textTitulo primeraFila">Página de consulta de solicitudes:</h1>
			</div>
			<div class="row">
				<h1 class="textTitulo segundaFila"> <c:url value="${uni.name}"/></h1>
			</div>
		</div>

	</div>
	
	<a class="logoutAdmin" href="<c:url value="${url}"/>">LOG OUT</a>
	
	<div class="col-md-8 col-xs-8 col-lg-8 col-sm-8 ">
	
		<p class="aceptadasTexto"> PETICIONES PENDIENTES </p>
		<table class="table table-hover">
		<tr>
			<th> ID </th>
			<th> Usuario </th>
			<th> Entidad </th>
			<th> Estado </th>
			<th> Aceptar </th>
			<th> Rechazar</th>
		</tr>
		
		<c:forEach items="${cards}" var="card">
		
		
		<tr class="warning">
			<td><c:out value="${card.id}" /></td>
			<td><c:out value="${card.user}" /></td>
			<td> <c:out value="${card.entity}" /> </td>
			<td> <c:out value="${card.state}" /> </td>
			<td>
				<form action="/university" method="post">
					<input type="hidden" name="id" value="${card.id}">
					<input type="hidden" name="action" value="Accept">
					<input type="submit" value="Aceptar Petición">
				</form>
			</td>
			<td>
				<form action="/university" method="post">
					<input type="hidden" name="id" value="${card.id}">
					<input type="hidden" name="action" value="Reject">
					<input type="submit" value="Rechazar Petición">
				</form>
			</td>
			
		</tr>
		</c:forEach>
		
		</table>

<p class="aceptadasTexto"> PETICIONES RECHAZADAS </p>
		<table class="table table-hover">
		<tr>
			<th> ID </th>
			<th> Nombre </th>
			<th> Apellido </th>
			<th> Entidad </th>
			<th> Estado </th>
			<th> Aceptar </th>
			<th> Rechazar</th>
		</tr>
		
		<c:forEach items="${rejected}" var="reject">
		
			<tr class="danger">
				<td><c:out value="${reject.id}" /></td>
				<td><c:out value="${reject.user}" /></td>
				<td> - </td>
				<td> <c:out value="${reject.entity}" /> </td>
			<td> <c:out value="${reject.state}" /> </td>
			<td>
				<form action="/university" method="post">
					<input type="hidden" name="id" value="${reject.id}">
					<input type="hidden" name="action" value="Accept">
					<input type="submit" value="Aceptar Petición">
				</form>
			</td>
			<td>
				<form action="/university" method="post">
					<input type="hidden" name="id" value="${reject.id}">
					<input type="hidden" name="action" value="Reject">
					<input type="submit" value="Rechazar Petición">
				</form>
			</td>
			</tr>
		</c:forEach>
		
		</table>
		
		<p class="aceptadasTexto"> PETICIONES ACEPTADAS </p>
		<table class="table table-hover">
		<tr>
			<th> ID </th>
			<th> Nombre </th>
			<th> Apellido </th>
		</tr>
		
		<c:forEach items="${accepted}" var="accept">
		
			<tr class="success">
				<td><c:out value="${accept.id}" /></td>
				<td><c:out value="${accept.user}" /></td>
				<td> - </td>
			</tr>
		</c:forEach>
		
		</table>
				
	</div>

</body>
</html>