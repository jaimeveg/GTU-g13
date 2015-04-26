<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrador el Sistema</title>
<link rel="stylesheet" href="css/style.css">
<!-- Bootstrap -->
<link href="css/bootstrap-3.3.4-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<div class="row tituloAdmin">
		<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
			<img id="fotoTitulo" src="img/tarjetasAdmin.png"> </img>
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
<a class="logoutAdmin" href="<c:url value="${url}"/>">LOG OUT</a>


<div class="containerAdmin">
<p class="aceptadasTexto">Usuarios</p>
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Borrar</th>
			</tr>

			<c:forEach items="${usuarios}" var="usuario">
				<tr class="warning">
					<td><c:out value="${usuario.id}" /></td>
					<td><c:out value="${usuario.name}" /></td>
					<td>
						<form action="/admin" method="post">
							<input type="hidden" name="id" value="${usuario.id}">
							<input class="btn btn-danger" type="submit" value="Borrar">
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>

<p class="aceptadasTexto">Universidades</p>
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Borrar</th>
			</tr>

			<c:forEach items="${universidades}" var="universidad">
				<tr class="danger">
					<td><c:out value="${universidad.id}" /></td>
					<td><c:out value="${universidad.name}" /></td>
					<td>
						<form action="/admin" method="post">
							<input type="hidden" name="id" value="${universidad.id}">
							<input class="btn btn-danger" type="submit" value="Borrar">
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>
		
<p class="aceptadasTexto">Bancos</p>
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Borrar</th>
			</tr>

			<c:forEach items="${bancos}" var="banco">
				<tr class="success">
					<td><c:out value="${banco.id}" /></td>
					<td><c:out value="${banco.name}" /></td>
					<td>
						<form action="/admin" method="post">
							<input type="hidden" name="id" value="${banco.id}">
							<input  class="btn btn-danger" type="submit" value="Borrar">
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>
		
<p class="aceptadasTexto">Estampadoras</p>
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Borrar</th>
			</tr>

			<c:forEach items="${estampadoras}" var="estampadora">
				<tr class="info">
					<td><c:out value="${estampadora.id}" /></td>
					<td><c:out value="${estampadora.name}" /></td>
					<td>
						<form action="/admin" method="post">
							<input type="hidden" name="id" value="${estampadora.id}">
							<input  class="btn btn-danger" type="submit" value="Borrar">
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>
		
<p class="aceptadasTexto">Peticiones</p>
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Estado</th>
				<th>Entidad</th>
				<th>Borrar</th>
			</tr>

			<c:forEach items="${cards}" var="card">
				<tr class="warning">
					<td><c:out value="${card.id}" /></td>
					<td><c:out value="${card.user}" /></td>
					<td><c:out value="${card.state}" /></td>
					<td><c:out value="${card.entity}" /></td>
					<td>
						<form action="/admin" method="post">
							<input type="hidden" name="cardId" value="${card.id}">
							<input class="btn btn-danger" type="submit" value="Borrar">
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>
</div>
</body>
</html>