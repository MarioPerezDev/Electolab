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

	<div class="container">
		<div class="row">
			<div class="col-4 imagenPartido">
				<img src="${partido.logo}">
			</div>
			<div class="col-8 descripcionPartido">
		
				<h2>${partido.nombre}</h2>
				<div class="text-justify">${partido.descripcion}</div>
				
			</div>

		</div>
		<br>
		<footer>
		<br>
		<p>Si desea obtener cualquier tipo de información adicional acceda a la página web oficial del partido a través de este enlace:</p>
		</footer>
	</div>
</body>