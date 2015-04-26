<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.Math"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function entityCheck() {
		var e = document.getElementById("entity");
		var strEntity = e.options[e.selectedIndex].value;
		if (strEntity === "User") {
			document.getElementById('fields').style.display = 'block';
			document.getElementById('fields2').style.display = 'none';
		} else {
			document.getElementById('fields').style.display = 'none';
			document.getElementById('fields2').style.display = 'block';
		}
	}
</script>

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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de registro</title>
</head>
<body>
	<div class="row titulo">
		<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
			<img id="fotoTitulo" src="img/tarjetas.png"> </img>
		</div>
		<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
			<div class="row">
				<h1 class="textTitulo primeraFila">REGISTRO DE USUARIO</h1>
			</div>
			<div class="row">
				<h1 class="textTitulo segundaFila">PIDE YA TU TARJETA</h1>
			</div>
		</div>

	</div>
	<div class="row usuarioAvatar">
		<div class="col-xs-6 col-md-6 col-lg-6 col-sm-6">
			<p class="usuario">
				<c:out value="${user.nickname}" />
			</p>
		</div>
		<div class="col-xs-6 col-md-6 col-lg-6 col-sm-6">
			<%
				int i = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
				if (i == 1) {
			%>
			<img class="avatar" src="img/user1.png"> </img>
			<%
				} else if (i == 2) {
			%>
			<img class="avatar" src="img/user2.png"> </img>
			<%
				} else if (i == 3) {
			%>
			<img class="avatar" src="img/user3.png"> </img>
			<%
				} else if (i == 4) {
			%>
			<img class="avatar" src="img/user4.png"> </img>
			<%
				}
			%>
		</div>

	</div>


	<div class="container">
		<div class="row">
			<form role="form" method="post" novalidate>
				<div class="col-lg-6">
					<div class="form-group">
						<!-- Selector de entidad para momento más avanzado, de momento solo usuarios -->
						<label for="InputName">Entidad</label> 
						<select	class="form-control" name="entity" id="entity"
							onclick="javascript:entityCheck();">
							<option value="User">Usuario</option>
							<option value="University">Universidad</option>
							<option value="Bank">Banco</option>
							<option value="Stamp">Estampadora</option>
						</select>
					</div>

					<div id="fields">

						<div class="form-group">
							<label for="InputName">Nombre</label>
							<div class="input-group">
								<input type="text" class="form-control" name="name"
									id="InputName" placeholder="Introduce tu nombre" required>
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
						<div class="form-group">
							<label for="InputName">Apellidos</label>
							<div class="input-group">
								<input type="text" class="form-control" name="surname"
									id="InputName" placeholder="Introduce tus apellidos" required>
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
						<div class="form-group">
							<label for="InputName">DNI</label>
							<div class="input-group">
								<input type="text" class="form-control" name="dni"
									id="InputName" placeholder="Introduce tu DNI" required>
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>

						<label for="InputName">Elije tu Universidad</label> <select
							class="form-control" name="university">
							<option value=""></option>
							<c:forEach items="${univs}" var="univ">
								<option vale="${univ.surname}">${univ.name}</option>
							</c:forEach>
						</select> <label for="InputName">Elije tu Banco</label> <select
							class="form-control" name="bank">
							<option value=""></option>
							<c:forEach items="${banks}" var="bank">
								<option vale="${bank.surname}">${bank.name}</option>
							</c:forEach>
						</select>
					</div>
					<div id="fields2" style="display: none">

						<div class="form-group">
							<label for="InputName">Nombre de la entidad</label>
							<div class="input-group">
								<input type="text" class="form-control" name="entityName"
									id="InputName"
									placeholder="Introduce el nombre completo de la entidad"
									required> <span class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
						<div class="form-group">
							<label for="InputName">Abreviatura de la entidad</label>
							<div class="input-group">
								<input type="text" class="form-control" name="entityAb"
									id="InputName"
									placeholder="Introduce la abreviatura de la entidad" required>
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>

					</div>

					<div class="well well-sm">
						<strong id="obligatorio"><span
							class="glyphicon glyphicon-asterisk"></span> Campo Obligatorio</strong>
					</div>
					<input type="submit" name="submit" id="submit"
						value="Haz tu petición" class="btn btn-info pull-right">
				</div>
			</form>

		</div>
	</div>











</body>
</html>