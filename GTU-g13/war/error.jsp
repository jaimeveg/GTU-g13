<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<!-- Bootstrap -->
<link href="css/bootstrap-3.3.4-dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Error</title>
</head>
<body>
	<div class="row tituloError">
		<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
			<img id="fotoTitulo" src="img/tarjetasError.png"> </img>
		</div>
		<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
			<div class="row">
				<h1 class="textTitulo primeraFila">ERROR</h1>
			</div>
			<div class="row">
				<h1 class="textTitulo segundaFila">ALGO OCURRIÓ</h1>
			</div>
		</div>

	</div>
	
	<div class="col-lg-4">
		<img class="fotoError" src="img/danger.png">
	</div>
	<div class="derechaError col-lg-4">
		<p class="textoError">
			<c:url value="${msg}" />
		</p>
		<a class="btn btn-danger pull-left" href="<c:url value="${url}"/>">Volver</a>
	</div>
</body>
</html>