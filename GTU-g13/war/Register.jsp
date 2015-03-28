<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function entityCheck() {
		var e = document.getElementById("entity");
		var strEntity = e.options[e.selectedIndex].value;
		if (strEntity === "User") {
			document.getElementById('fields').style.dsiplay = 'block';
			document.getElementById('fields2').style.display = 'none';
		} else {
			document.getElementById('fields').style.display = 'none';
			document.getElementById('fields2').style.display = 'block';
		}
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de registro</title>
</head>
<body>
	Pagina de registro
	<p>
		Usuario:
		<c:out value="${user.nickname}" />
		<br>
	<form method="post">
		<!-- Selector de entidad para momento más avanzado, de momento solo usuarios -->
		Entidad:<br> <select name="entity" id="entity"
			onclick="javascript:entityCheck();">
			<option value="User">Usuario</option>
			<option value="University">Universidad</option>
			<option value="Bank">Banco</option>
			<option value="Stamp">Estampadora</option>
		</select> <br>
		<div id="fields">
			Nombre:<br>
			<input type="text" name="name"> <br> Apellido:<br>
			<input type="text" name="surname"> <br> DNI:<br>
			<input type="text" name="dni"> <br> Universidad:<br>
			<select name="university">
				<option value=""></option>
				<c:forEach items="${univs}" var="univ">
					<option vale="${univ.surname}">${univ.name}</option>
				</c:forEach>
			</select> <br> Banco:<br>
			<select name="bank">
				<option value=""></option>
				<c:forEach items="${banks}" var="bank">
					<option vale="${bank.surname}">${bank.name}</option>
				</c:forEach>
			</select>
		</div>
		<div id="fields2" style="display:none">
			Nombre de la entidad:<br>
			<input type="text" name="entityName"> <br> 
			Abreviatura:<br>
			<input type="text" name="entityAb"> <br>
		</div>
		<br> <input type="submit">
	</form>
	</p>
</body>
</html>