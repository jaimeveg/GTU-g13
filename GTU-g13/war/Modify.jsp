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
<title>Modificar Perfil</title>
</head>
<body>
<div class="row titulo">
		<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
			<img id="fotoTitulo" src="img/tarjetas.png"> </img>
		</div>
		<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
			<div class="row">
				<h1 class="textTitulo primeraFila">Modifica tus datos</h1>
			</div>
			<div class="row">
				<h1 class="textTitulo segundaFila">PERFIL DE USUARIO</h1>
			</div>
		</div>

	</div>
	<c:if test="${!error}">
	
	<div class="row usuarioAvatar">
		<div class="col-xs-6 col-md-6 col-lg-6 col-sm-6">
			<p class="usuario">
				<c:out value="${usuario.userId}" />
			</p>
		</div>
		<div class="col-xs-6 col-md-6 col-lg-6 col-sm-6">
			<%
				int i = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
				if (i == 1) {
			%>
			<img id="fotoAvatar" class="avatar" src="img/user1.png"> </img>
			<%
				} else if (i == 2) {
			%>
			<img  id="fotoAvatar" class="avatar" src="img/user2.png"> </img>
			<%
				} else if (i == 3) {
			%>
			<img  id="fotoAvatar" class="avatar" src="img/user3.png"> </img>
			<%
				} else if (i == 4) {
			%>
			<img  id="fotoAvatar" class="avatar" src="img/user4.png"> </img>
			<%
				}
			%>
		</div>

	</div>
		
	<form class="formulario" method="post">		
			<div class="form-group">
				<label>NOMBRE</label>
				<div class="input-group">
					<input class="form-control" type="text" name="name" value="${usuario.name}" required> 
					<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			<div class="form-group">
				<label>APELLIDOS</label>
				<div class="input-group">
					<input class="form-control" type="text" name="surname" value="${usuario.surname}" required> 
					<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			<div class="form-group">
				<label>DNI</label>
				<div class="input-group">
					<input class="form-control" type="text" name="dni" value="${usuario.dni}" required> 
					<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			<div class="form-group">
				<label>Address</label>
				<div class="input-group">
					<input class="form-control" type="text" name="address" value="${usuario.address}" required> 
					<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>	
			
			<label style="margin-top:11px; color: #A4A4A4;">Elige tu Universidad</label> 
			<select class="form-control" name="university">
				<option value="${usuario.university}"><c:out value="${usuario.university}" /></option>
				<c:forEach items="${univs}" var="univ">
					<option vale="${univ.surname}">${univ.name}</option>
				</c:forEach>
			</select> 
			<label style="margin-top:11px; color: #A4A4A4;">Elige tu Banco</label>
			<select style="margin-bottom:17px;" class="form-control" name="bank">
				<option value="${usuario.bank}"><c:out value="${usuario.bank}" /></option>
				<c:forEach items="${banks}" var="bank">
					<option vale="${bank.surname}">${bank.name}</option>
				</c:forEach>
			</select>
		
		 <input  class="btn btn-info pull-right" type="submit">
	</form>
	</p>
</c:if>
<c:if test="${error}">
	
	<img src="img/warning.png" class="warningFoto">
</c:if>

<p>
<a  class="volverBtn btn btn-danger pull-left" href="/user">Volver</a>
</p>


</body>
</html>