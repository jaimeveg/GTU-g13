<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Page</title>
</head>
<body>
	This is the bank page

	<br>
	<br>

	<c:forEach items="${cards}" var="card">
		<tr>
			<td><c:out value="${card.user}" /> realiza petición como <c:out
					value="${card.entity}" /></td>
		</tr>
		<br>
		<tr>
			<td>

				<form action="/bank" method="post">
					<input type="hidden" name="id" value="${card.id}"> <input
						type="submit" value="Aceptar Petición">
				</form>
			</td>
		</tr>
		<br>
	</c:forEach>
</body>
</html>