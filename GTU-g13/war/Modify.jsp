<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de registro</title>
</head>
<body>
<c:if test="${!error}">
	Pagina de modificación de datos
	<p>
		Usuario:
		<c:out value="${usuario.userId}" />
		<br>
	<form method="post">
		<div id="fields">
			Nombre:<br>
			<input type="text" name="name" value="${usuario.name}"> <br> Apellido:<br>
			<input type="text" name="surname" value="${usuario.surname}"> <br> DNI:<br>
			<input type="text" name="dni" value="${usuario.dni}"> <br> Universidad:<br>
			<select name="university">
				<option value="${usuario.university}"><c:out value="${usuario.university}" /></option>
				<c:forEach items="${univs}" var="univ">
					<option vale="${univ.surname}">${univ.name}</option>
				</c:forEach>
			</select> <br> Banco:<br>
			<select name="bank">
				<option value="${usuario.bank}"><c:out value="${usuario.bank}" /></option>
				<c:forEach items="${banks}" var="bank">
					<option vale="${bank.surname}">${bank.name}</option>
				</c:forEach>
			</select>
		</div>
		<br> <input type="submit">
	</form>
	</p>
</c:if>
<c:if test="${error}">
	<p>El usuario tiene una petición en curso. Para poder cambiar datos primero debe cancelar su solicitud.</p>
</c:if>

<p>
<a href="/user">Volver</a>
</p>


</body>
</html>