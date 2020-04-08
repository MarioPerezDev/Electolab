<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@ include file="Head.jsp"%>
<%@ include file="Variables.jsp"%>
<body>
	<%@ include file="Navbar.jsp"%>

	<c:choose>
		<c:when test="${ partidoActivo == 'PSOE'}">
			<li class="nav-item active activo" id="partidoLink">
		</c:when>
		<c:otherwise>
			<li class="nav-item" id="partidoLink">
		</c:otherwise>
	</c:choose>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<img width="500" height="300"
					src="https://image.shutterstock.com/image-photo/law-600w-307415057.jpg">
			</div>
			<div class="col-6">

				<h2>Informaci�n de ${leyi.nombre}</h2>

			</div>

		</div>

		Aqu� iria la descripci�n de la ley ${leyi.descripci�n}
</body>