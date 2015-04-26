<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.Math"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Página de registro</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet" href="css/style.css">
<!-- Bootstrap -->
<link href="css/bootstrap-3.3.4-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript">
	function entityCheck() {
		var e = document.getElementById("entity");
		var strEntity = e.options[e.selectedIndex].value;
		if (strEntity === "User") {
			document.getElementById('fields').style.display = 'block';
			document.getElementById('fields2').style.display = 'none';
			document.getElementById('fotoAvatar').src = "img/user2.png";
		} else {
			document.getElementById('fields').style.display = 'none';
			document.getElementById('fields2').style.display = 'block';
			if (strEntity === "University") {
				document.getElementById('fotoAvatar').src = "img/universidad.png";
			}
			if (strEntity === "Bank"){			
			document.getElementById('fotoAvatar').src = "img/banco.png";
			}
			if (strEntity === "Stamp"){
				document.getElementById('fotoAvatar').src = "img/estampadora.png";
			}
				
		}
	}
	
</script>
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
		<!-- Selector de entidad para momento más avanzado, de momento solo usuarios -->

		<label style="color: #A4A4A4;">ENTIDAD</label> <select class="form-control" name="entity"
			id="entity" onChange="javascript:entityCheck();">
			<option value="User">Usuario</option>
			<option value="University">Universidad</option>
			<option value="Bank">Banco</option>
			<option value="Stamp">Estampadora</option>
		</select> <br>

		<div id="fields">

			<!-- Campo del nombre -->
			<div class="form-group">
				<label>NOMBRE</label>
				<div class="input-group">
					<input class="form-control" placeholder="Introduce tu nombre" type="text" name="name" required> 
					<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			
			<!-- Campo del Apellido -->
			<div class="form-group">
				<label>APELLIDOS</label> 
				<div class="input-group">
					<input class="form-control" placeholder="Introduce tus apellidos" type="text" name="surname" required>
					<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			
			<!--  Campo del DNI -->
			
			<div class="form-group">
			<label> DNI</label>
			<div class="input-group">
			 	<input class="form-control" placeholder="Introduce tu DNI" type="text" name="dni" required> <br>
			 	<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>			
			</div>
			</div>
			
			<!-- Selects de Banco y Universidad -->
			<label style="margin-top:11px; color: #A4A4A4;">Elige tu Universidad</label> 
			<select class="form-control"  name="university" required>
				<option value=""></option>
				<c:forEach items="${univs}" var="univ">
					<option vale="${univ.surname}">${univ.name}</option>
				</c:forEach>
			</select> 
			<label style="margin-top:11px; color: #A4A4A4;">Elige tu Banco</label>
			<select class="form-control" name="bank" required>
				<option value=""></option>
				<c:forEach items="${banks}" var="bank">
					<option vale="${bank.surname}">${bank.name}</option>
				</c:forEach>
			</select>
		</div>
		<div id="fields2" style="display:none;">
			<div class="form-group">
				<label> Nombre de la entidad</label>
				<div class="input-group">
					<input  class="form-control" placeholder="Introduce el nombre completo de tu entidad" type="text" name="entityName" required>
					<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			<div class="form-group">
				<label> Abreviatura </label>  
				<div class="input-group">
					<input  class="form-control" placeholder="Introduce la abreviatura de tu entidad" type="text" name="entityAb" required>
					<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
		</div>
		<input  value="Haz tu petición" class="btn btn-info pull-right" type="submit">
	</form>
	</p>
</body>
</html>