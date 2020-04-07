<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@ include file="Head.jsp"%>
<body>
	<%@ include file="Navbar.jsp"%>
	<div class="container">
		<h1>Esta será la página de Predicciones.</h1>
		Pruebaca
		<c:choose>
			<c:when test="${usuario != null}">
				<div class="row">
					<div class="col-9">En esta columna irán todas las
						predicciones existentes.</div>
					<div class="col-3">
						<p>Logueado como:</p>
						<p>Nombre de usuario: ${usuario.name}</p>
						<p>Correo: ${usuario.email}</p>
						<c:choose>
							<c:when test="${usuario.analist}">
								<p>Rango: Analista</p>
							</c:when>
							<c:otherwise>
								<p>Rango: Usuario</p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<h3>Para visualizar el contenido debes loguearte.</h2>
			</c:otherwise>
		</c:choose>


	</div>
	<%@ include file="Variables.jsp"%>
</body>
</html>