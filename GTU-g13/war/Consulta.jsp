<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de consulta</title>
</head>
<body>

<c:if test="${card	!=	null}">
<p class="aceptadasTexto">Estado de la petición</p>
	<table class="table table-hover">
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
</c:if>
<c:if test="${card	==	null}">
	<p>El usuario no ha realizado ninguna peticion</p>
</c:if>

	<p>La solicitud se eliminará cuando el gestor de la página procese su petición</p>
	<a href="/user">Volver</a>

</body>
</html>