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
			<div class="col-6">
				<img width="500" height="300"
					src="https://image.shutterstock.com/image-photo/raising-hands-participation-600w-676447282.jpg">
			</div>
			<div class="col-6">

				<h2>Informaci�n del ${partido.nombre}</h2>
				

			</div>

		</div>
		<p>${partido.descripcion}</p>
		<P>PONER NUEVO ATRIBUTO DE PARTIDO QUE SEA "FOTO" O ALGO AS�. lA IMAGEN QUE SE MUESTRE SEA SACADA DE LA BBDD.</P>
	</div>
</body>