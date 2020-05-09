<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="es">
<%@ include file="Head.jsp"%>

<body>
	<%@ include file="Navbar.jsp"%>

	<div class="container">
		<h2>Introduzca sus datos para el registro</h2>
		<c:if test="${mensaje != null}">
			<div class="alert alert-danger" role="alert">${mensaje}</div>
		</c:if>
		<form action="FormRegisterServlet">
			<div class="form-group">
				<label for="emailinput">Correo electrónico</label> <input
					type="email" class="form-control" name="email" id="emailinput"
					aria-describedby="emailHelp" placeholder="Introduzca su email">
			</div>
			<div class="form-group">
				<label for="usernameinput">Nombre de usuario</label> <input
					type="text" class="form-control" name="username" id="usernameinput"
					placeholder="Introduzca su nombre de usuario">
			</div>
			<div class="form-group">
				<label for="passwordinput">Contraseña</label> <input type="password"
					class="form-control" name="password1" id="passwordinput"
					placeholder="Introduzca su contraseña"> <label
					for="passwordinput2">Repetir contraseña</label> <input
					type="password" class="form-control" name="password2"
					id="passwordinput2" placeholder="Repita su contraseña">
			</div>
			<div class="analistClick">
				<input class="form-check-input" type="checkbox" name="analistcheck"
					id="analistcheck" value="isAnalist"> <label
					class="form-check-label" for="analistcheck"> Soy analista </label>
				<input type="submit" value="Registrarse" name="registerButton"
					class="btn btn-outline-dark">
			</div>
		</form>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>