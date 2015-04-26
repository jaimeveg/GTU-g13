<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
<title>GTU</title>
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
	<div class="row">
		<div class="textoAccede">
		<a style="color: #24547c;" href="<c:url value="${url}"/>">REGISTRO</a>
		<a style="color:#377bb5;" href="<c:url value="${urlLogin}"/>">LOG IN</a>
		</div>

	</div>
	<div class="row">
	
		<img src="img/fondo.png" class="imagenFondo">
	</div>
	<div class="row" style="display:none">
		<div class="col-xs-7 col-md-7 col-lg-7 col-sm-7 iconos">

			<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
				<a href="user"><img class="icono" id="iconoEstudiante"
					src="img/estudiante.png"> </img></a>
			</div>

			<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
				<a href="university"><img class="icono" id="iconoUniversidad"
					src="img/universidad.png"> </img></a>
			</div>

			<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
				<a href="bank"><img class="icono" id="iconoBanco"
					src="img/banco.png"> </img></a>
			</div>

			<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
				<a href="stamp"><img class="icono" id="iconoEstampadora"
					src="img/estampadora.png"> </img></a>
			</div>

		</div>
	</div>

	<!-- Librería jQuery requerida por los plugins de JavaScript -->
	<script src="http://code.jquery.com/jquery.js"></script>

</body>
</html>